import { Component, OnInit } from '@angular/core';
import { Usuario } from './usuario';
import { UsuarioService } from '../services/usuario.service';
import {Router, ActivatedRoute} from '@angular/router'
import swal from 'sweetalert2'
import { Ciudad } from '../ciudad/ciudad';
import { CiudadService } from '../services/ciudad.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html'
})
export class FormComponent implements OnInit {

  public usuario: Usuario = new Usuario();
  public ciudad: Ciudad = new Ciudad();
  public titulo:string = "Crear Usuario";

  constructor(
  private usuarioService: UsuarioService,
  private ciudadService: CiudadService,
  private router: Router,
  private activatedRoute: ActivatedRoute) { }
  ciudades: Ciudad[];
  errores: string[];
  ngOnInit() {
    this.cargarUsuario();
    this.ciudadService.getCiudades().subscribe(
      ciudades => {
        this.ciudades = ciudades;
      }
    );
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
  this.usuario.ciudad = this.ciudad;
    this.usuarioService.create(this.usuario)
      .subscribe(usuario => {
        this.router.navigate(['/usuarios'])
        swal('Nuevo cliente', `Cliente ${usuario.nombre} creado con éxito!`, 'success')
      }
      );
      console.log(this.usuario);
  }

  update(): void {
    this.usuarioService.update(this.usuario)
      .subscribe(
        json => {
          this.router.navigate(['/usuarios']);
          swal('Cliente Actualizado', `${json.mensaje}: ${json.usuario.nombre}`, 'success');
        },
        err => {
          this.errores = err.error.errors as string[];
          console.error('Código del error desde el backend: ' + err.status);
          console.error(err.error.errors);
        }
      )
      console.log(this.usuario);
  }

}
