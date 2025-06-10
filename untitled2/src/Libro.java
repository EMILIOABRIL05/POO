public class Libro {
    private String titulo,autor, codigo;

    public Libro(String autor,String titulo,String codigo) {
        this.autor = autor;
        this.titulo = titulo;
        this.codigo = codigo;

    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
