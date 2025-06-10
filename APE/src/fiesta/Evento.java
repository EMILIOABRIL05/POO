package fiesta;

public class Evento {

    private final String titulo, lugar;
    private final Fecha inicio, fin;
    private final Organizador organizador;
    private Participante p1, p2;

    public Evento(String titulo, Fecha inicio, Fecha fin,
                  Organizador org, String lugar) throws FechaInvalidaException {
        if (fin.isBefore(inicio)) {
            throw new FechaInvalidaException("Fecha fin anterior a inicio");
        }
        this.titulo = titulo;
        this.inicio = inicio;
        this.fin = fin;
        this.organizador = org;
        this.lugar = lugar;
    }

    public String getTitulo() { return titulo; }

    public void inscribir(Participante p) throws Exception {
        if (p1 == null) {
            p1 = p;
        } else if (p2 == null) {
            p2 = p;
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
        if (p1 != null) sb.append("\n  - ").append(p1.getCedula());
        if (p2 != null) sb.append("\n  - ").append(p2.getCedula());
        return sb.toString();
    }
}
