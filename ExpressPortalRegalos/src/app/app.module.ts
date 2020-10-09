import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material.module';
import { NgModule } from  '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { HeaderComponent } from './shared/header/header.component';
import { BreadcrumbsComponent } from './shared/breadcrumbs/breadcrumbs.component';
import { PagesComponent } from './pages/pages.component';
import { NopagefoundComponent } from './pages/nopagefound/nopagefound.component';
import { GraficaBienvenidaComponent } from './pages/grafica-bienvenida/grafica-bienvenida.component';
import { CargarArchivoComponent } from './pages/cargar-archivo/cargar-archivo.component';
import { ConsultaCargarArchivoComponent } from './pages/consulta-cargar-archivo/consulta-cargar-archivo.component';
import { HttpClientJsonpModule, HttpClientModule } from '@angular/common/http';
import { ModalComponent } from './modal/modal.component';
import { SegmentosComponent } from './pages/segmentos/segmentos.component';
import { SegmentoComponent } from './pages/segmento/segmento.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HeaderComponent,
    BreadcrumbsComponent,
    PagesComponent,
    NopagefoundComponent,
    GraficaBienvenidaComponent,
    CargarArchivoComponent,
    ConsultaCargarArchivoComponent,
    ModalComponent,
    SegmentosComponent,
    SegmentoComponent

  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MaterialModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    HttpClientJsonpModule      
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [ModalComponent]
})
export class AppModule { }
