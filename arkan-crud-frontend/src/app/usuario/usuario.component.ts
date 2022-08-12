import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../services/usuario.service';
import { Usuario } from './usuario';
import swal from 'sweetalert2';
import { tap } from 'rxjs/operators';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

  constructor(private usuarioService: UsuarioService) { }
  usuarios: Usuario[];
  ngOnInit() {
    this.usuarioService.getUsuarios().subscribe(
      usuarios => {
        this.usuarios = usuarios;
      }
    );

}
delete(usuario: Usuario): void {
  swal({
    title: 'Está seguro?',
    text: `¿Seguro que desea eliminar al cliente ${usuario.nombre} ${usuario.apellido}?`,
    type: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Si, eliminar!',
    cancelButtonText: 'No, cancelar!',
    confirmButtonClass: 'btn btn-success',
    cancelButtonClass: 'btn btn-danger',
    buttonsStyling: false,
    reverseButtons: true
  }).then((result) => {
    if (result.value) {

      this.usuarioService.delete(usuario.id).subscribe(
        () => {
          this.usuarios = this.usuarios.filter(cli => cli !== usuario)
          swal(
            'Cliente Eliminado!',
            `Cliente ${usuario.nombre} eliminado con éxito.`,
            'success'
          )
        }
      )

    }
  });
}

}
