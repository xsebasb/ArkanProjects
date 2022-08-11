import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../services/usuario.service';
import { Usuario } from './usuario';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {
  public max:Number=Math.floor(Math.random() * 100);

  constructor(private usuarioService: UsuarioService, private http: HttpClient) { }
  usuarios: Usuario[];
  ngOnInit() {
    this.usuarioService.getUsuarios().subscribe(
      usuarios => {
        this.usuarios = usuarios;
        console.log(usuarios);
      }
    );

  //   this.http.get('http://localhost:8080/api/v1/usuario/1').subscribe(
  //     usuario => {
  //       console.log(usuario);
  //     }
  //   )
}

}
