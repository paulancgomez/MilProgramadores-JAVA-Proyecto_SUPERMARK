package supermark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Supermercado {
    
	Scanner leer = new Scanner(System.in);
	
    private static final String URL_BD = "jdbc:mysql://localhost:3306/supermark";
    private static final String USER = "root";
    private static final String PASS = "41122022";
    
    //ATRIBUTOS
    private int horaApertura;
    private int horaCierre;
    
    //CONSTRUCTOR POR DEFECTO
    public Supermercado() {
		super();
		this.horaApertura = 800; //08:00
		this.horaCierre = 2000;  //20:00
	}
    
    //CONSTRUCTOR COMUN
    public Supermercado(int horaApertura, int horaCierre) {
		super();
		this.horaApertura = horaApertura;
		this.horaCierre = horaCierre;
	}

    //METODOS GET Y SET
	public int getHoraApertura() {
		return horaApertura;
	}

	public void setHoraApertura(int horaApertura) {
		this.horaApertura = horaApertura;
	}

	public int getHoraCierre() {
		return horaCierre;
	}

	public void setHoraCierre(int horaCierre) {
		this.horaCierre = horaCierre;
	}

	//METODOS DE LA CLASE
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

    //DEVUELVE LA LISTA DE PRODUCTOS
    public List<Producto> getProductos(){
        List<Producto> listaProducto = new ArrayList<Producto>();
        Statement stm = this.getStatement();
        try{
            ResultSet rs = stm.executeQuery("SELECT * FROM Producto");
            while(rs.next()){
                Producto unProducto = new Producto(rs.getInt("idProducto"), rs.getString("descripcion"), rs.getString("marca"), rs.getInt("cantStock"), rs.getDouble("precio"), rs.getString("categoria"));
                listaProducto.add(unProducto);
            }
            stm.close();
            return listaProducto;
        }catch(SQLException e){
            System.out.println(e.getLocalizedMessage());
        }
        return listaProducto;
    }

    //CARGA UN PRODUCTO EN LA BASE DE DATOS
    public void guardarNuevoProducto(Producto nuevoProducto) throws SQLException{
        Statement stm = getStatement();
        stm.executeUpdate("INSERT INTO Producto(descripcion, marca, cantStock, precio, categoria) VALUE ('" + nuevoProducto.getDescripcion() + "','" + nuevoProducto.getMarca() + "'," + nuevoProducto.getCantStock() + "," + nuevoProducto.getPrecio() + ",'"+ nuevoProducto.getCategoria()+"')");
        stm.close();
    }

    //MODIFICA UN PRODUCTO EN LA BASE DE DATOS
    public void modificarProducto(int idProducto) throws SQLException {	
		
    	int stock = 0, precio = 0; 
		int respuesta;
		
		Statement stm = this.getStatement();
		
		System.out.print("Desea modificar el stock? 1-SI 0-NO: ");
		respuesta = leer.nextInt();
		if(respuesta == 1) {
			System.out.print("Ingrese nuevo stock: ");
			stock = leer.nextInt();
			stm.executeUpdate("UPDATE Producto SET cantStock = "+ stock +" WHERE (idProducto = " + idProducto + ");");
		}
		
		System.out.print("Desea modificar el precio? 1-SI 0-NO: ");
		respuesta = leer.nextInt();
		if(respuesta == 1) {
			System.out.print("Ingrese nuevo precio: ");
			precio = leer.nextInt();
			stm.executeUpdate("UPDATE Producto SET precio = "+ precio +" WHERE (idProducto = " + idProducto + ");");
		}

	}

    
    public Boolean isAdmin(Usuario usuario) {
        Statement stm = getStatement();

        try{
            ResultSet rs = stm.executeQuery("SELECT isAdmin FROM Usuario WHERE email='"+usuario.getEmail()+"'");
            if(rs.next()){
                return rs.getBoolean(1);
            }
        }catch(SQLException e){
            System.out.println(e.getLocalizedMessage());
        }
 
        return false;
    }



}