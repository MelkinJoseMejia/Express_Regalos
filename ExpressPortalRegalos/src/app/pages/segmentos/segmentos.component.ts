import { Component, OnInit } from '@angular/core';
import { SegmentosService } from '../../../services/segmentos/segmentos.service';
import { SegmentoModel } from '../../models/segmento.model';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-segmentos',
  templateUrl: './segmentos.component.html'
})
export class SegmentosComponent implements OnInit {

  constructor( private segmento: SegmentosService) { }

  segmentos: any[] = [];

  ngOnInit(): void {
    this.segmento.getSegmentos()
    .subscribe( (data: any) => {
      console.log( data );
      this.segmentos = data;
    })
  }

  borrarSegmento( segment: SegmentoModel, i: number){

    Swal.fire({
      title: '¿Está seguro?',
      text: 'Está seguro de eliminar el registro',
      showConfirmButton: true,
      showCancelButton: true
    }).then( resp => {
      if( resp.value){
        this.segmentos.splice(i, 1);
        this.segmento.borrarSegmento( segment.idSegmento).subscribe();
      }
    });
  }
}
