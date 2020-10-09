import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class SegmentosService {

  segmentos: any[] = [];

  constructor( private http: HttpClient) { 
    console.log('Service listo');
  }

  getSegmentos(){
      return this.http.get( 'http://localhost:8080/segmentos/consultar' );
  }

  getSegmento(id: string){
    return this.http.get( `http://localhost:8080/segmentos/consultarPorId?id=${ id }` );
  }

  borrarSegmento( id: number){
    return this.http.delete( `http://localhost:8080/segmentos/borrar?idSegmento=${ id }` );
  }
  
}
