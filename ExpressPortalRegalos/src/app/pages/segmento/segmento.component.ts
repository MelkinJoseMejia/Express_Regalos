import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { SegmentoService } from '../../../services/segmento/segmento.service';
import { SegmentoModel } from '../../models/segmento.model';
import Swal from 'sweetalert2';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-segmento',
  templateUrl: './segmento.component.html'
})
export class SegmentoComponent implements OnInit {

  constructor( private activatedRoute: ActivatedRoute,
    private segmentoService: SegmentoService) { }

  segmentos: any[] = [];

  segment = new SegmentoModel();

  ngOnInit(): void {
    
    const id = this.activatedRoute.snapshot.paramMap.get('id');

    if( id !== 'nuevo'){
        this.segmentoService.getSegmento( id )
        .subscribe( (resp: SegmentoModel) =>{
          console.log(resp);
          this.segment = resp;
        });
    }
  }

  guardar( form:NgForm ){

    if( form.invalid){
      console.log('Formulario Inválido');
      return;
    }

    Swal.fire({
      title: 'Espere',
      text: 'Guardando Información',
      allowOutsideClick:false
    });
    Swal.showLoading();

    let peticion: Observable<any>;

    if( this.segment.idSegmento){
      peticion = this.segmentoService.actualizarSegmento(this.segment);
    }else{
      peticion = this.segmentoService.crearSegmento(this.segment);
    }

    peticion.subscribe( resp => {
      Swal.fire({
          title: this.segment.nombreSegmento,
          text: 'Registro actualizado'
      });
    });


  }

}
