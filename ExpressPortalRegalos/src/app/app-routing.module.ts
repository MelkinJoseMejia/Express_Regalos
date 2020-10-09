import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from "@angular/router";
import { LoginComponent } from './auth/login/login.component';
import { PagesComponent } from './pages/pages.component';
import { NopagefoundComponent } from './pages/nopagefound/nopagefound.component';
import { GraficaBienvenidaComponent } from './pages/grafica-bienvenida/grafica-bienvenida.component';
import { RegisterComponent } from './auth/register/register.component';
import { CargarArchivoComponent } from './pages/cargar-archivo/cargar-archivo.component';
import { ConsultaCargarArchivoComponent } from './pages/consulta-cargar-archivo/consulta-cargar-archivo.component';
import { SegmentosComponent } from './pages/segmentos/segmentos.component';
import { SegmentoComponent } from './pages/segmento/segmento.component';

const routes: Routes=[
  {
    path:'',
    component:PagesComponent,
    children:[
      {path:'nopagefound', component: NopagefoundComponent},
      {path:'grafica-bienvenida', component: GraficaBienvenidaComponent},
      {path:'cargar-archivo', component: CargarArchivoComponent},
      {path:'log-masivo', component: ConsultaCargarArchivoComponent},
      {path:'app-segmentos', component: SegmentosComponent},
      { path: 'app-segmento/:id', component: SegmentoComponent},
      {path:'', redirectTo:'/grafica-bienvenida', pathMatch:'full'}
    ]
  },
   
  {path:'login', component: LoginComponent},
  {path:'register', component: RegisterComponent},

  {path:'**', component: NopagefoundComponent},
];


@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot( routes )
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
