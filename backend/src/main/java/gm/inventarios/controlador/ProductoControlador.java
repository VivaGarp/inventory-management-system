package gm.inventarios.controlador;

import gm.inventarios.modelo.Producto;
import gm.inventarios.servicio.IProductoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inventario-app") // http://localhost:8080/inventario-app
@CrossOrigin(origins = "http://localhost:4200") // Permite solicitudes desde el frontend Angular en desarrollo
public class ProductoControlador {

    private final IProductoServicio productoServicio;

    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);

    public ProductoControlador(IProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    // Listar todos los productos
    @GetMapping
    public List<Producto> listarProductos() {
        List<Producto> productos = productoServicio.listarProductos();
        logger.info("Productos obtenidos: ");
        productos.forEach((producto -> logger.info(producto.toString())));
        return productos;
    }

    // Buscar un producto por ID
    @GetMapping("/{id}")
    public Producto buscarProductoPorId(@PathVariable Integer id) {
        return productoServicio.buscarProductosPorId(id);
    }

    // Agregar un nuevo producto
    @PostMapping
    public Producto agregarProducto(@RequestBody Producto producto) {
        return productoServicio.guardarProducto(producto);
    }

    // Actualizar un producto existente
    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        producto.setIdProducto(id);
        return productoServicio.guardarProducto(producto);
    }

    // Eliminar un producto por ID
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Integer id) {
        productoServicio.eliminarProductoPorId(id);
    }
}

