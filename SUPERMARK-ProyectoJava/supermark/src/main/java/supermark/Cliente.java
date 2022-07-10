package supermark;

import java.util.ArrayList;

public class Cliente extends Usuario {

	//ATRIBUTOS
	private int idCliente;
	private Domicilio idDomicilio;
	private double descuentoPorcentaje;
	private Carrito carrito;
	private ArrayList<Compra> listaCompra;

	//CONSTRUCTORES
    public Cliente(String nombre, String apellido, String email) {
        super(nombre, apellido, email);
    }
    
    public Cliente(int idUsuario, String nombre, String apellido, String email) {
        super(idUsuario, nombre, apellido, email);
    }
    
    public Cliente(int idUsuario, int idCliente, String nombre, String apellido, String email) {
        super(idUsuario, nombre, apellido, email);
        this.idCliente = idCliente;
    }

    public Cliente(int id, String nombre, String apellido, String correo, Domicilio idDomicilio) {
		super(id, nombre, apellido, correo);
		this.idDomicilio = idDomicilio;
		this.descuentoPorcentaje = 10;
		this.carrito = new Carrito();
		this.listaCompra = new ArrayList<Compra> ();	
	}
    
    //METODOS GET Y SET
    public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public Domicilio getIdDomicilio() {
		return idDomicilio;
	}

	public void setDomicilio(Domicilio idDomicilio) {
		this.idDomicilio = idDomicilio;
	}
	
	public double getDescuentoPorcentaje() {
		return descuentoPorcentaje;
	}

	public void setDescuentoPorcentaje(double descuentoPorcentaje) {
		this.descuentoPorcentaje = descuentoPorcentaje;
	}

	public Carrito getCarrito() {
		return carrito;
	}
	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}
	
	public ArrayList<Compra> getListaCompra() {
		return listaCompra;
	}

	public void setListaCompra(ArrayList<Compra> listaCompra) {
		this.listaCompra = listaCompra;
	}
    
    //METODOS DE LA CLASE 
    public void verCompras(){
        
    }

	public void VerProductosSeleccionados() {
		
		
	}
    
}