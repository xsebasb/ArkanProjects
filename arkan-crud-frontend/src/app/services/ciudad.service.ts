import { Injectable } from '@angular/core';
import { map,Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Ciudad } from '../ciudad/ciudad';

@Injectable({
  providedIn: 'root'
})
export class CiudadService {
  public urlEndPoint: string = 'http://localhost:8080/api/v1/ciudades';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})
  constructor(private http: HttpClient) { }
  getCiudades(): Observable<Ciudad[]> {
    return this.http.get(this.urlEndPoint).pipe(
      map(response => response as Ciudad[])
    );
  }

  create(ciudad: Ciudad) : Observable<Ciudad> {
    return this.http.post<Ciudad>(this.urlEndPoint, ciudad, {headers: this.httpHeaders})
  }
}
