package supermark;

import java.util.ArrayList;

public class Carrito {
	
	//ATRIBUTOS
	private ArrayList<Producto> listaProductos;
	
	//CONSTRUCTORES
	public Carrito() {	
		this.listaProductos = new ArrayList<Producto>();
	}
	
	//METODOS DE LA CLASE
	public void agregaProducto(Producto producto) {
		this.listaProductos.add(producto);
	}
	
	public void muestraCarrito() {
		
		for (int i = 0; i < this.listaProductos.size() ; i++) {		
			listaProductos.get(i).muestraProductoCliente();
			System.out.println();
		}
		
	}

}
