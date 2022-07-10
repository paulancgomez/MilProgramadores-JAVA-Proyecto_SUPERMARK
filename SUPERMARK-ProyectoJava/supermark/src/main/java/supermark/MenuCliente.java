package supermark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MenuCliente {
	
	Scanner leer = new Scanner(System.in);
	
	private Supermercado supermark;
	private Cliente cliente;
	
	private static final String URL_BD = "jdbc:mysql://localhost:3306/supermark";
    private static final String USER = "root";
    private static final String PASS = "41122022";
	
	public MenuCliente(Cliente cliente) throws SQLException{
		
		this.supermark = new Supermercado();
		this.cliente = cliente;
		
		System.out.println("Bienvendo/a " + cliente.getNombre());
		
		System.out.println("\tMENU USUARIO");
		System.out.println("1. SELECCIONAR PRODUCTOS.");
		System.out.println("2. VER CARRITO."); //SELECT idUsuario
		System.out.println("3. AUTORIZAR COMPRA DE CARRITO."); //UPDATE
		System.out.print("Elija: ");
		
		int opcion = leer.nextInt();
		
		switch(opcion) {
			case 1:
				//this.seleccionarProductos();
				break;
			case 2:
				this.verCarrito();
				break;
			case 3:
				//this.autorizarCompraCarrito();
				break;
		}
	}
	
	//CONEXION
	private Statement getStatement(){
		try{
			Connection conn = DriverManager.getConnection(URL_BD, USER, PASS);
	        Statement stm = conn.createStatement();
	        return stm;
	     }catch(SQLException e){
	        System.out.println("No se pudo conectar");
	     }
	     return null;
	}
	
	//AGREGAR PRODUCTOS AL CARRITO
	public void seleccionarProductos() throws SQLException {
		int control = 1;
		int cantidadProdCarrito = 0;
		int stockDisponible;
		
		do {
			System.out.println("SELECCION DE PRODUCTOS");
			supermark.verProductos();
			
			System.out.println("Ingrese el Id del producto que quiere agregar al carrito y la cantidad del mismo");
			
			System.out.print("IdProducto: ");
			int idProducto = leer.nextInt();
			System.out.print("Cantidad: ");
			int cantidad = leer.nextInt();
			
			//No controla que cantidad > Stock
			//String sql1 = "INSERT INTO CarritoxProducto VALUES((SELECT idCarrito FROM Carrito WHERE idCliente = " + cliente.getIdCliente() + "), " + idProducto + ", " + cantidad + ");";
			//stm.executeQuery(sql1);
			
			System.out.println("PRODUCTO AÑADIDO!");
			
			System.out.println("Desea agregar otro producto? 1-SI 0-NO");
			control = leer.nextInt();
			
			//CONTROLO CANTIDAD DE PRODUCTOS DEL CARRITO
			//stm.executeQuery("SELECT count(*) FROM CarritoxProducto WHERE idCarrito = (SELECT idCarrito FROM Carrito WHERE idCliente = " + cliente.getIdCliente() + ");");
			//if(rs.next()) {
				//cantidadProdCarrito = cantidadProdCarrito + rs.getInt("count(*)");
			//}
			
		}while(cantidadProdCarrito <= 30 && control == 1);
	}
	
	//VER CARRITO
	public void verCarrito() {
		
		System.out.println("\nSU CARRITO:");
		Carrito carrito = new Carrito();
		carrito = supermark.getCarrito(cliente.getIdCliente());
		carrito.muestraCarrito();
	}


}