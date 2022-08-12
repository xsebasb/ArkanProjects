import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CiudadService } from '../services/ciudad.service';
import { Ciudad } from './ciudad';
import swal from 'sweetalert2';
@Component({
  selector: 'app-ciudad',
  templateUrl: './ciudad.component.html',
  styleUrls: ['./ciudad.component.css']
})
export class CiudadComponent implements OnInit {
  public ciudad: Ciudad = new Ciudad();
  ciudades: Ciudad[];
  constructor(
    private ciudadService: CiudadService,
    private router: Router,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.ciudadService.getCiudades().subscribe(
      ciudades => {
        this.ciudades = ciudades;
      }
    );
  }
  create(): void {
      this.ciudadService.create(this.ciudad)
        .subscribe(ciudad => {
          this.router.navigate(['/usuarios'])
          swal('Nueva ciudad', `Ciudad ${ciudad.nombre_ciudad} creado con éxito!`, 'success')
        }
        );
        console.log(this.ciudad);
    }

}
