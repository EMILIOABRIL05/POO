package fiesta;

public class Fecha {

    private int dia;
    private int mes;
    private int anio;

    public Fecha(int dia, int mes, int anio) throws FechaInvalidaException {

        if (anio < 2024 || anio > 2026) {
            throw new FechaInvalidaException(
                    "Anio incorrecto: " + anio + ". Debe estar entre 2024 y 2026.");
        }
        this.anio = anio;

        if (mes < 1 || mes > 12) {
            throw new FechaInvalidaException(
                    "Mes incorrecto: " + mes + ". Debe estar entre 1 y 12.");
        }
        this.mes = mes;

        int maxDia;
        switch (mes) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                maxDia = 31;
                break;
            case 4: case 6: case 9: case 11:
                maxDia = 30;
                break;
            case 2:
                maxDia = 28;
                break;
            default:
                // Nunca ocurre porque ya validamos mes
                maxDia = 31;
                break;
        }
        if (dia < 1 || dia > maxDia) {
            throw new FechaInvalidaException(
                    String.format("Dia incorrecto: %d. Para mes %d el dia debe estar entre 1 y %d.", dia, mes, maxDia)
            );
        }
        this.dia = dia;
    }


    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {

        return String.format("%d/%d/%d",this.dia,this.mes,this.anio);
    }
}
