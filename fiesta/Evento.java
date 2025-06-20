package fiesta;

import java.util.ArrayList;

public class Evento {

    private final String titulo, lugar;
    private final Fecha inicio, fin;
    private final Organizador organizador;
    private ArrayList<Participante> participantes;

    public Evento(String titulo, Fecha inicio, Fecha fin,
                  Organizador org, String lugar) throws FechaInvalida {
        if (fin.isBefore(inicio)) {
            throw new FechaInvalida("Fecha fin anterior a inicio");
        }
        this.titulo = titulo;
        this.inicio = inicio;
        this.fin = fin;
        this.organizador = org;
        this.lugar = lugar;
        this.participantes = new ArrayList<>();
    }

    public String getTitulo() { return titulo; }

    public String getNombre() { return titulo; }

    public void inscribir(Participante p) throws Exception {
        if (participantes.size() < 2) {
            participantes.add(p);
        } else {
            throw new Exception("Maximo 2 participantes por evento");
        }
        p.inscribir(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Evento: ").append(titulo)
                .append("\nFechas: ").append(inicio).append(" → ").append(fin)
                .append("\nLugar: ").append(lugar)
                .append("\nOrganizador:\n  ").append(organizador)
                .append("\nParticipantes:");
        for (Participante p : participantes) {
            sb.append("\n  - ").append(p.getCedula());
        }
        return sb.toString();
    }
}
