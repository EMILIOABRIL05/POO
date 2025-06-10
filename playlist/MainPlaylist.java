package playlist;

public class MainPlaylist {

    public static void main(String[] args) {

        Artista ar1 = new Artista("Pedrito", "Rwanda Records");
        Disco ds1 = new Disco(ar1, 2025, "Los Lobos");
        Cancion cs1 = new Cancion("Los Lobos", ar1, 256, ds1);

        Playlist pl1 = new Playlist("Mi Lista");
        pl1.aniadirCancion(cs1);

        System.out.println(ar1.toString());
        System.out.println(ds1.toString());
        System.out.println(cs1.toString());

        System.out.println(pl1.toString());
    }
}