package supermark;

public class Producto {

	//ATRIBUTOS
    private int id;
    private String descripcion; 
    private String marca;
    private int cantStock;
    private Double precio;
    private String categoria;

    //CONSTRUCTOR
    public Producto(int id, String descripcion, String marca, int cantStock, Double precio, String categoria) {
        this.id = id;
        this.descripcion = descripcion;
        this.marca = marca;
        this.cantStock = cantStock;
        this.precio = precio;
        this.categoria = categoria;
    }
    
    public Producto(String descripcion, String marca, int cantStock, Double precio, String categoria) {
        this.descripcion = descripcion;
        this.marca = marca;
        this.cantStock = cantStock;
        this.precio = precio;
        this.categoria = categoria;
    }

    //METODOS GET Y SET
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMarca() {
        return this.marca;
    }
	
    public void setMarca(String marca) {
        this.marca = marca;
    }
	
	public int getCantStock() {
		return cantStock;
	}
	
	public void setCantStock(int cantStock) {
		this.cantStock = cantStock;
	}
    
    public Double getPrecio() {
        return this.precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setTipo(String categoria) {
        this.categoria = categoria;
    }

    //METODOS DE LA CLASE
  	public void muestraProducto() {
  		System.out.println("****************************");
  		System.out.println("\tPRODUCTO");
  		System.out.println("Id: " + id);
  		System.out.println("Descripcion: " + descripcion);
  		System.out.println("Marca: " + marca);
  		System.out.println("Stock: " + cantStock);
  		System.out.println("Precio: " + precio);
  		System.out.println("Categoria " + categoria);
  	}

}
