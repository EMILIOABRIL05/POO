package playlist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Playlist {

    private String nombre;
    private List<Cancion> canciones;

    // Constructor que inicializa una playlist con un nombre y una lista vacía de canciones
    public Playlist(String nombre) {
        this.nombre = nombre;
        this.canciones = new ArrayList<>();
    }

    // Obtiene el nombre de la playlist
    public String getNombre() {
        return nombre;
    }

    // Establece el nombre de la playlist
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Obtiene la lista de canciones
    public List<Cancion> getCanciones() {
        return canciones;
    }

    // Establece la lista de canciones
    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    // Añade una canción al final de la playlist verificando que pertenezca a un álbum
    public void aniadirCancion(Cancion cancion) {

        if (cancion.getAlbum() == null) {

            throw new IllegalStateException("La cancion debe pertenecer a un album para ser agregada al playlist");
        }

        if (!cancion.getAlbum().getTrack().contains(cancion)) {

            throw new IllegalArgumentException("La cancion no esta registrada en el album" + cancion.getAlbum().getTitulo());
        }
        canciones.add(cancion);
    }

    // Añade una canción en una posición específica de la playlist
    public void aniadirCancion(int lugar, Cancion cancion) {

        if (cancion.getAlbum() == null && !cancion.getAlbum().getTrack().contains(cancion)) {

            throw new IllegalArgumentException("La cancion no esta registrada en el album" + cancion.getAlbum().getTitulo());
        }

        canciones.add(lugar, cancion);
    }

    // Copia todas las canciones de otra playlist a esta
    public void pasarPlaylist(Playlist otro) {

        for (Cancion cancion : otro.canciones) {

            aniadirCancion(cancion);
        }
    }

    // Obtiene el número de canciones en la playlist
    public int tamanioPlaylist() {

        return this.canciones.size();
    }

    // Verifica si la playlist está vacía
    public boolean playListVacio() {

        return this.canciones.isEmpty();
    }

    // Obtiene una canción en una posición específica
    public Cancion getCancion(int i) {

        return this.canciones.get(i);
    }

    // Reemplaza una canción en una posición específica
    public Cancion setCancion(int i, Cancion cancion) {

        if (cancion.getAlbum() == null && !cancion.getAlbum().getTrack().contains(cancion)) {

            throw new IllegalArgumentException("La cancion no esta registrada en el album" + cancion.getAlbum().getTitulo());
        }

        return this.canciones.set(i, cancion);
    }

    // Verifica si una canción existe en la playlist
    public boolean buscarCancion(Cancion cancion) {

        return this.canciones.contains(cancion);
    }

    // Obtiene la primera posición de una canción en la playlist
    public int lugarCancion(Cancion cancion) {

        return this.canciones.indexOf(cancion);
    }

    // Obtiene la última posición de una canción en la playlist
    public int ultimoLugarCancion(Cancion cancion) {

        return this.canciones.lastIndexOf(cancion);
    }

    // Elimina una canción específica de la playlist
    public boolean borrarCancion(Cancion cancion) {

        return this.canciones.remove(cancion);
    }

    // Elimina una canción en una posición específica
    public Cancion borrarCancion(int i) {

        return this.canciones.remove(i);
    }

    // Elimina todas las canciones de un artista específico
    public void borrarPorArtista(String artista) {

        this.canciones.removeIf(cancion -> cancion.getCantante().getNombre().equals(artista));
    }

    // Elimina todas las canciones de la playlist
    public void limpiarPlayList() {

        this.canciones.clear();
    }

    // Convierte la playlist en un array de canciones
    public Cancion[] playListFija() {

        return this.canciones.toArray(new Cancion[0]);
    }

    // Obtiene una sublista de canciones entre dos posiciones
    public List<Cancion> subPlayList(int inicio, int fin) {

        return this.canciones.subList(inicio, fin);
    }

    // Mezcla aleatoriamente las canciones de la playlist
    public void shuffle() {
        Collections.shuffle(this.canciones);
    }

    // Ordena las canciones alfabéticamente por título
    public void ordenarPorTitulo() {

        this.canciones.sort((a, b) -> a.getTitulo().compareToIgnoreCase(b.getTitulo()));
    }


    // Devuelve una representación en cadena de la playlist incluyendo su nombre y todas las canciones
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Playlist: ").append(nombre).append("\n");
        for (int i = 0; i < canciones.size(); i++) {
            sb.append(i + 1).append(". ").append(canciones.get(i).toString()).append("\n");
        }
        return sb.toString();
    }

}
