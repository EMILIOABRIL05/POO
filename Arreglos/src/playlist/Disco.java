package playlist;

import java.util.List;
import java.util.ArrayList;

public class Disco {

    private final String titulo;
    private final int anio;
    private final Artista artista;
    //Lista privada de canciones que pertenecen al disco implementado
    private List<Cancion> track = new ArrayList<>();

  
    public Disco(Artista artista, int anio, String titulo) {
 
        this.artista = artista;
        this.anio = anio;
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnio() {
        return anio;
    }

    public Artista getArtista() {
        return artista;
    }

    public List<Cancion> getTrack() {
        return track;
    }

    public void setTrack(List<Cancion> track) {
        this.track = track;
    }

    public void aniadirTrack(Cancion cancion) {
        if (cancion.getAlbum() != null && cancion.getAlbum() != this) {
            throw new IllegalStateException("La cancion ya pertenece a otro disco:" + cancion.getAlbum().getTitulo());
        }
        track.add(cancion);
        cancion.setAlbum(this);
    }

    @Override
    public String toString() {
        return String.format("%s(%d), por %s", this.titulo, this.anio, this.artista.getNombre());
    }
}