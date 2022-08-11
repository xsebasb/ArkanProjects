import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usuario } from '../usuario/usuario';
import { map, Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  public urlEndPoint: string = 'http://localhost:8080/api/v1/usuarios';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})
  constructor(private http: HttpClient) { }
  getUsuarios(): Observable<Usuario[]> {
    return this.http.get(this.urlEndPoint).pipe(
      map(response => response as Usuario[])
    );
  }
  
  create(usuario: Usuario) : Observable<Usuario> {
    return this.http.post<Usuario>(this.urlEndPoint, usuario, {headers: this.httpHeaders})
  }

  getUsuario(id): Observable<Usuario>{
    return this.http.get<Usuario>(`${this.urlEndPoint}/${id}`)
  }
}