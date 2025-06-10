package playlist;

public class Cancion {

    private final String titulo;
    private final Artista cantante;
    private final Integer duracion;
    private Disco album;

    public Cancion(String titulo, Artista cantante, int duracion, Disco album) {
        this.titulo = titulo;
        this.cantante = cantante;
        this.duracion = duracion;
        this.album = null;

        if (album != null) {
            album.aniadirTrack(this);
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public Artista getCantante() {
        return cantante;
    }

    public int getDuracion() {
        return duracion;
    }

    public Disco getAlbum() {
        return album;
    }

    public void setAlbum(Disco album) {
        this.album = album;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Cancion)) {
            return false;
        }

        Cancion s = (Cancion) obj;
        return this.titulo.equals(s.titulo) &&
                this.cantante.equals(s.cantante) &&
                this.duracion.equals(s.duracion);
    }

    @Override
    public int hashCode() {
        return this.titulo.hashCode() +
                this.cantante.hashCode() +
                this.duracion.hashCode();
    }

    @Override
    public String toString() {
        int minutos = this.duracion / 60, segundos = this.duracion % 60;
        
        String alb = album != null ? "[" + this.album.getTitulo() + "]" : "";
        
        return String.format("%s - %s(%d:%02d)%s", 
        this.cantante.toString(), 
        this.titulo, 
        minutos, 
        segundos, 
        alb
    );
}
}