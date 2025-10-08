public class Main{
    public static void main(String[] args) {
        // Crear un grupo de estudiantes
        GrupoEstudiantes grupo = new GrupoEstudiantes();

        // Insertar varios estudiantes en el grupo
        grupo.insertarEstudiante(0, "Carlos Pérez");
        grupo.insertarEstudiante(1, "Ana García");
        grupo.insertarEstudiante(2, "Luis Rodríguez");
        grupo.insertarEstudiante(3, "María López");

        // Insertar notas para diferentes materias
        // Las materias están indexadas de 0 a 4
        // 0: Matemáticas, 1: Física, 2: Química, 3: Literatura, 4: Historia

        // Notas para Carlos
        grupo.insertarNotaEstudiante(0, 0, 8.5); // Matemáticas
        grupo.insertarNotaEstudiante(0, 1, 7.0); // Física
        grupo.insertarNotaEstudiante(0, 2, 9.0); // Química

        // Notas para Ana
        grupo.insertarNotaEstudiante(1, 0, 9.5); // Matemáticas
        grupo.insertarNotaEstudiante(1, 1, 8.0); // Física
        grupo.insertarNotaEstudiante(1, 4, 10.0); // Historia

        // Notas para Luis
        grupo.insertarNotaEstudiante(2, 2, 6.5); // Química
        grupo.insertarNotaEstudiante(2, 3, 8.0); // Literatura

        // Notas para María
        grupo.insertarNotaEstudiante(3, 0, 7.5); // Matemáticas
        grupo.insertarNotaEstudiante(3, 3, 9.0); // Literatura
        grupo.insertarNotaEstudiante(3, 4, 8.5); // Historia

        // Modificar una nota
        grupo.modificarNotaEstudiante(0, 1, 7.5); // Cambiar nota de Física para Carlos

        // Eliminar una nota
        grupo.eliminarNotaEstudiante(1, 4); // Eliminar nota de Historia para Ana

        // Mostrar promedio de cada estudiante
        System.out.println("Promedio de Carlos: " + grupo.calcularPromedioEstudiante(0));
        System.out.println("Promedio de Ana: " + grupo.calcularPromedioEstudiante(1));
        System.out.println("Promedio de Luis: " + grupo.calcularPromedioEstudiante(2));
        System.out.println("Promedio de María: " + grupo.calcularPromedioEstudiante(3));

        // Mostrar promedio del grupo
        System.out.println("Promedio del grupo: " + grupo.calcularPromedioGrupo());

        // Modificar nombre de un estudiante
        grupo.modificarEstudiante(2, "Luis Alberto Rodríguez");

        // Eliminar un estudiante
        grupo.eliminarEstudiante(1); // Eliminar a Ana

        // Mostrar promedio del grupo después de los cambios
        System.out.println("Promedio del grupo después de cambios: " + grupo.calcularPromedioGrupo());
    }
}
