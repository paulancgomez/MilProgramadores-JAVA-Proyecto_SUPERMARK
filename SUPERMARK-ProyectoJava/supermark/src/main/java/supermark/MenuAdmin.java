package supermark;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuAdmin {

	Scanner leer = new Scanner(System.in);
	//Conexion conn=new Conexion();
	private String[][] matrizResultado;
	int fila;
	int columna;
	
	private Supermercado supermark;
	private Usuario usuario;
	
	public MenuAdmin(Usuario usuario) throws SQLException{
	
		this.supermark = new Supermercado();
		this.usuario = usuario; 
		
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
			verProductosAdmin();
			break;
		case 2:
			cargarProductoAdmin();
			break;
		case 3:
			modificarProductoAdmin();
			break;
		case 4:
			//VerUsuariosCompras();
			break;
		}
	
	}
	
	public void verProductosAdmin() {
		
		List<Producto> listaProducto = new ArrayList<Producto>();
    	listaProducto = this.supermark.getProductos();
    	
    	for(int i = 0; i < listaProducto.size(); i++){
    		listaProducto.get(i).muestraProducto();
    		System.out.println();
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
		
		verProductosAdmin();
		
		System.out.println("\tESTA POR MODIFICAR UN PRODUCTO");
		System.out.print("Ingrese el Id del producto a modificar: ");
		int idProducto = leer.nextInt();
		
		this.supermark.modificarProducto(idProducto);
		
		System.out.println("PRODUCTO ACTUALIZADO!");
	}
	
}