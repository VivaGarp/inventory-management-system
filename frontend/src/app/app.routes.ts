import { Routes } from '@angular/router';
import { ProductoLista } from './producto-lista/producto-lista';
import { AgregarProducto } from './agregar-producto/agregar-producto';
import { EditarProducto } from './editar-producto/editar-producto';

export const routes: Routes = [
    {path: 'productos', component: ProductoLista}, // http://localhost:4200/productos
    {path: '', redirectTo: 'productos', pathMatch: 'full'},
    {path: 'agregar-producto', component: AgregarProducto}, // http://localhost:4200/agregar-producto
    {path: 'editar-producto/:id', component: EditarProducto}
];
