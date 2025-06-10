package ejemplo;

public class Curso {
    private String nombreCurso;
    private int estudiante; // relacion de agregacion , si no hay estudiante , no tiene sentido el curso

private Curso(String nombreCurso, int estudiante) {
    this.nombreCurso = nombreCurso;
        this.estudiante = estudiante;
}
public Curso(String nombreCurso,String nombre,int edad,String calle,String numero) {

    this.nombreCurso = nombreCurso;
    this.estudiante = new Persona(nombre,edad,new Direccion(calle, numero);
}
}

