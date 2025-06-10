package biblioteca;

public class Libro {

    private String isbn;
    private String nombre;
    private String autor;
    private int edicion;
    private String tipoEdicion;
    private String editorial;
    private double precioAlquiler;

    public Libro() {
    }

    public Libro(String isbn, String nombre, String autor, int edicion,
                 String tipoEdicion, String editorial, double precioAlquiler) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.autor = autor;
        this.edicion = edicion;
        this.tipoEdicion = tipoEdicion;
        this.editorial = editorial;
        this.precioAlquiler = precioAlquiler;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public String getTipoEdicion() {
        return tipoEdicion;
    }

    public void setTipoEdicion(String tipoEdicion) {
        this.tipoEdicion = tipoEdicion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }
    public void mostrarLibro() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Nombre: " + nombre);
        System.out.println("Autor: " + autor);
        System.out.println("Edición: " + edicion);
        System.out.println("Tipo de Edición: " + tipoEdicion);
        System.out.println("Editorial: " + editorial);
        System.out.println("Precio de Alquiler: " + precioAlquiler);
    }

}
