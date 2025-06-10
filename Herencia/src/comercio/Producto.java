package comercio;

public class Producto {
    // Atributos
    private String idProducto;
    private String nombreProducto;
    private double precio;
    private double precioUnitario;
    private int stock;

    // Constructor
    public Producto(String idProducto, String nombreProducto, double precio, double precioUnitario, int stock) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
    }

    // Getters y Setters
    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // Método para actualizar el stock
    public void actualizarStock(int cantidad) {
        if (this.stock >= cantidad) {
            this.stock -= cantidad;
        }
    }

    // Método toString para mostrar información del producto
    @Override
    public String toString() {
        return String.format("ID: %s - %s - Precio: $%.2f - Stock: %d",
                idProducto, nombreProducto, precioUnitario, stock);
    }
}