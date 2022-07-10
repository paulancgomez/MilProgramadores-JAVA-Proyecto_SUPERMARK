package supermark;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuAdmin {

	Scanner leer = new Scanner(System.in);
	
	private Supermercado supermark;
	private Cliente cliente;
	
	public MenuAdmin(Cliente cliente) throws SQLException{
	
		this.supermark = new Supermercado();
		this.cliente = cliente;
		
		System.out.println("\tMENU ADMINISTRADOR");
		System.out.println("1. VER LISTADO DE PRODUCTOS");
		System.out.println("2. CARGAR PRODUCTOS A LA APLICACIÓN");
		System.out.println("3. MODIFICAR LOS DATOS DE LOS PRODUCTOS CARGADOS");
		System.out.println("4. VER TODOS LOS USUARIOS QUE REALIZARON UNA COMPRA");
		System.out.println("5. VER LISTADO DE PRODUCTOS SELECCIONADOS POR EL USUARIO");
		System.out.print("Elija: ");
		
		int opcion = leer.nextInt();
		
		switch(opcion) {
		
			case 1:
				supermark.verProductos();
				break;
			case 2:
				cargarProductoAdmin();
				break;
			case 3:
				modificarProductoAdmin();
				break;
			case 4:
				//verUsuariosCompras();
				break;
			case 5:
				Carrito carrito = new Carrito();
				carrito = supermark.getCarrito(cliente.getIdCliente());
				System.out.println("CARRITO DEL CLIENTE: " + cliente.getNombre() + " " + cliente.getApellido());
				carrito.muestraCarrito();
				break;
		}
	
	}
	
    public void cargarProductoAdmin() throws SQLException{
		
		System.out.println("\tESTA POR AGREGAR UN PRODUCTO");
		
		System.out.println("INGRESE LA DESCRIPCION DEL PRODUCTO: ");
		String descripcion = leer.next();
		System.out.println("INGRESE LA MARCA: ");
		String marca = leer.next();
		System.out.println("INGRESE EL STOCK: ");
		int cantStock = leer.nextInt();
		System.out.println("INGRESE EL PRECIO:");
		Double precio = leer.nextDouble();
		System.out.println("INGRESE LA CATEGORIA (GALLETAS, BEBIDAS, CARNES): ");
		String categoria = leer.next();
		
		Producto nuevoProducto = new Producto(descripcion, marca, cantStock, precio, categoria);
		nuevoProducto.toString();
		this.supermark.guardarNuevoProducto(nuevoProducto);
		
		System.out.println("PRODUCTO AGREGADO CON EXITO!");
	}
    
    
    public void modificarProductoAdmin() throws SQLException {	
		
		supermark.verProductos();
		
		System.out.println("\tESTA POR MODIFICAR UN PRODUCTO");
		System.out.print("Ingrese el Id del producto a modificar: ");
		int idProducto = leer.nextInt();
		
		this.supermark.modificarProducto(idProducto);
		
		System.out.println("PRODUCTO ACTUALIZADO!");
	}
	
}