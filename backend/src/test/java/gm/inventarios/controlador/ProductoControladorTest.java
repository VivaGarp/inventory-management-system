package gm.inventarios.controlador;

import gm.inventarios.modelo.Producto;
import gm.inventarios.servicio.IProductoServicio;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.NoSuchElementException;

@ExtendWith(MockitoExtension.class)
class ProductoControladorTest {

    @Mock
    private IProductoServicio productoServicio;

    @InjectMocks
    private ProductoControlador productoControlador;

    @Test
    void buscarProductoPorId_debeRetornarProductoCuandoExiste() {
        Integer idProducto = 1;
        Producto productoEsperado = new Producto();

        productoEsperado.setIdProducto(idProducto);
        productoEsperado.setDescripcion("Laptop");
        productoEsperado.setPrecio(15000.0);
        productoEsperado.setExistencia(5);

        when(productoServicio.buscarProductosPorId(idProducto))
                .thenReturn(productoEsperado);

        ResponseEntity<Producto> respuesta =
                productoControlador.buscarProductoPorId(idProducto);

        assertEquals(200, respuesta.getStatusCode().value());
        assertEquals(productoEsperado, respuesta.getBody());
    }

    @Test
    void buscarProductoPorId_debeRetornar404CuandoNoExiste() {
        Integer idProducto = 999999;

        when(productoServicio.buscarProductosPorId(idProducto))
                .thenReturn(null);

        ResponseEntity<Producto> respuesta =
                productoControlador.buscarProductoPorId(idProducto);

        assertEquals(404, respuesta.getStatusCode().value());
    }

    @Test
    void agregarProducto_debeRetornar201CuandoSeGuardaCorrectamente() {
        Producto productoNuevo = new Producto();

        productoNuevo.setDescripcion("Monitor");
        productoNuevo.setPrecio(3500.0);
        productoNuevo.setExistencia(10);

        Producto productoGuardado = new Producto();
        productoGuardado.setIdProducto(20);
        productoGuardado.setDescripcion("Monitor");
        productoGuardado.setPrecio(3500.0);
        productoGuardado.setExistencia(10);

        when(productoServicio.guardarProducto(productoNuevo))
                .thenReturn(productoGuardado);

        ResponseEntity<Producto> respuesta =
                productoControlador.agregarProducto(productoNuevo);

        assertEquals(201, respuesta.getStatusCode().value());
        assertEquals(productoGuardado, respuesta.getBody());
    }

    @Test
    void actualizarProducto_debeRetornar404CuandoNoExiste() {
        Integer idProducto = 999999;
        Producto productoActualizado = new Producto();

        productoActualizado.setDescripcion("Monitor actualizado");
        productoActualizado.setPrecio(4000.0);
        productoActualizado.setExistencia(8);

        when(productoServicio.buscarProductosPorId(idProducto))
                .thenReturn(null);

        ResponseEntity<Producto> respuesta =
            productoControlador.actualizarProducto(idProducto, productoActualizado);

        assertEquals(404, respuesta.getStatusCode().value());
    }

    @Test
    void actualizarProducto_debeRetornar200CuandoExiste() {
        Integer idProducto = 1;
        Producto productoExistente = new Producto();

        productoExistente.setIdProducto(idProducto);
        productoExistente.setDescripcion("Monitor");
        productoExistente.setPrecio(3500.0);
        productoExistente.setExistencia(10);

        Producto productoActualizado = new Producto();

        productoActualizado.setDescripcion("Monitor actualizado");
        productoActualizado.setPrecio(4000.0);
        productoActualizado.setExistencia(8);

        when(productoServicio.buscarProductosPorId(idProducto))
            .thenReturn(productoExistente);
        
        when(productoServicio.guardarProducto(productoActualizado))
            .thenReturn(productoActualizado);

        ResponseEntity<Producto> respuesta =
            productoControlador.actualizarProducto(idProducto, productoActualizado);

        assertEquals(200, respuesta.getStatusCode().value());
        assertEquals(productoActualizado, respuesta.getBody());
        assertEquals(idProducto, productoActualizado.getIdProducto());
    }

    @Test
    void eliminarProducto_debeRetornar204CuandoExiste() {
        Integer idProducto = 1;

        doNothing().when(productoServicio).eliminarProductoPorId(idProducto);

        ResponseEntity<Void> respuesta =
            productoControlador.eliminarProducto(idProducto);

        assertEquals(204, respuesta.getStatusCode().value());
        verify(productoServicio).eliminarProductoPorId(idProducto);
    }

    @Test
    void eliminarProducto_debeRetornar404CuandoNoExiste() {
        Integer idProducto = 999999;

        doThrow(new NoSuchElementException())
                .when(productoServicio)
                .eliminarProductoPorId(idProducto);

        ResponseEntity<Void> respuesta =
            productoControlador.eliminarProducto(idProducto);

        assertEquals(404, respuesta.getStatusCode().value());
    }
}