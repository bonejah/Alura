import { Component, Input, OnInit, ViewEncapsulation, ElementRef } from '@angular/core';

@Component({
    moduleId: module.id,
    selector: 'painel',
    templateUrl: './painel.component.html',
    styleUrls: ['./spainel.component.css'],
    encapsulation: ViewEncapsulation.Emulated
})
export class PainelComponent implements OnInit {
    @Input() titulo: string;
    elemento: ElementRef;

    constructor(elemento: ElementRef) {
        this.elemento = elemento;
    }

    ngOnInit() {
        this.titulo = this.titulo.length > 7 
        ? this.titulo.substring(0, 7) + '...' 
        : this.titulo; 
    }

    fadeOut(cb) {
        $(this.elemento.nativeElement).fadeOut(cb);
    }
}