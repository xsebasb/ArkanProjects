import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { UsuarioComponent } from './usuario/usuario.component';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes} from '@angular/router';
import { FormsModule } from '@angular/forms'
import { UsuarioService } from './services/usuario.service';
import { FormComponent } from './usuario/form.component';
import { CiudadComponent } from './ciudad/ciudad.component';
import { CiudadService } from './services/ciudad.service';

const routes: Routes = [
  {path: '', redirectTo: '/usuarios', pathMatch: 'full'},
  {path: 'usuarios', component: UsuarioComponent},
  {path: 'usuario/form', component: FormComponent},
  { path: 'usuarios/form/:id', component: FormComponent },
  { path: 'ciudad/form', component: CiudadComponent }

];


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    UsuarioComponent,
    FormComponent,
    CiudadComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [UsuarioService, CiudadService],
  bootstrap: [AppComponent]
})
export class AppModule { }
