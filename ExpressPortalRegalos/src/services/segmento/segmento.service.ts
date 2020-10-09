import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SegmentoModel } from '../../app/models/segmento.model';

@Injectable({
  providedIn: 'root'
})
export class SegmentoService {

  segmento: any[] = [];

  constructor( private http: HttpClient) { 
    console.log('Service listo');
  }

  getSegmento(id: string){
    return this.http.get( `http://localhost:8080/segmentos/consultarPorId?id=${ id }` );
  }

  crearSegmento(segment: SegmentoModel){

    return this.http.post('http://localhost:8080/segmentos/guardar', segment);

  }

  actualizarSegmento(segment: SegmentoModel){
    return this.http.post('http://localhost:8080/segmentos/actualizar',segment);
  }
}
