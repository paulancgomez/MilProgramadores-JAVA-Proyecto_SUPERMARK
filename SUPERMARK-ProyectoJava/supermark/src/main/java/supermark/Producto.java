package supermark;

public class Producto {

	//ATRIBUTOS
    private Long id;
    private String descripcion; 
    private String marca;
    private int cantStock;
    private Double precio;
    private String categoria;

    //CONSTRUCTOR
    public Producto(Long id, String descripcion, String marca, int cantStock, Double precio, String categoria) {
        this.id = id;
        this.descripcion = descripcion;
        this.marca = marca;
        this.cantStock = cantStock;
        this.precio = precio;
        this.categoria = categoria;
    }

    //METODOS GET Y SET
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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


}
