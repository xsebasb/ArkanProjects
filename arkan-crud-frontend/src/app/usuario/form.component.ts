import { Component, OnInit } from '@angular/core';
import { Usuario } from './usuario'; 
import { UsuarioService } from '../services/usuario.service';
import {Router, ActivatedRoute} from '@angular/router'
import swal from 'sweetalert2'

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html'
})
export class FormComponent implements OnInit {

  public usuario: Usuario = new Usuario();
  public titulo:string = "Crear Usuario";

  constructor(private usuarioService: UsuarioService,
  private router: Router,
  private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.cargarUsuario()
  }

  cargarUsuario(): void{
    this.activatedRoute.params.subscribe(params => {
      let id = params['id']
      if(id){
        this.usuarioService.getUsuario(id).subscribe( (usuario) => this.usuario = usuario)
      }
    })
  }

  create(): void {
    this.usuarioService.create(this.usuario)
      .subscribe(usuario => {
        this.router.navigate(['/usuarios'])
        swal.fire('Nuevo cliente', `Cliente ${usuario.nombre} creado con éxito!`, 'success')
      }
      );
  }



}
