package reservasHotel;

public class Doble extends Habitacion {

    private boolean incluyeDesayuno;

    public Doble(int numeroHabitacion, double precioPorDesayuno, boolean incluyeDesayuno) {
        super(numeroHabitacion, precioPorDesayuno);
        this.incluyeDesayuno = incluyeDesayuno;

    }

    public boolean getIncluyeDesayuno() {
        return incluyeDesayuno;
    }

    public void setIncluyeDesayuno(boolean incluyeDesayuno) {
        this.incluyeDesayuno = incluyeDesayuno;
    }

    @Override
    public String getDescripcion() {
        return incluyeDesayuno ? "Habitación doble con desayuno incluido" : "Habitación doble sin desayuno incluido";
    }


}
