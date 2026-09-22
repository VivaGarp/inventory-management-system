import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Producto } from '../model/producto.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductoServicio {
  private urlBase = "http://localhost:8080/inventario-app";

  constructor(private clientehttp: HttpClient) { }

  obtenerProductosLista(): Observable<Producto[]>{
    return this.clientehttp.get<Producto[]>(this.urlBase);
  }

  agregarProducto (producto: Producto): Observable<Object>{
    return this.clientehttp.post(this.urlBase, producto);
  }

  obtenerProductoPorId(id: number){
    return this.clientehttp.get<Producto>(`${this.urlBase}/${id}`);
  }

  editarProducto(id: number, producto: Producto): Observable<Object>{
    return this.clientehttp.put(`${this.urlBase}/${id}`, producto);
  }

  eliminarProducto(id: number): Observable<Object>{
    return this.clientehttp.delete(`${this.urlBase}/${id}`);
  }
}