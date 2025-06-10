package pasoValor;

public class AppPasoValor {

    /*public static void modificarPersona(Persona p) {

        //Modificar el parametro interno del objeto p
        p.setNombre("Modificado");

        // Reasignar el estado del objeto p, le cambio el objeto
        p = new Persona("Otro Modificado");
    }*/

    public static void modificarPersona(Persona p) {

        //Modificar el parametro interno del objeto p
        p.setNombre("Modificado");

        // Modificar el objeto direccion que le pertenece a Persona
        p.getDireccion().setCiudad("Modificada");

        // Modificar el objeto direccion cambiando el objeto
        p.setDireccion(new Direccion("Otra Modificada"));

        // Reasignar todo el objeto persona
        p = new Persona("Otra Persona",new Direccion("Otra direccion"));
    }

    public static void modificarEntero(int a) {

        a = 10;
    }

    public static void main(String[] args) {

        Direccion direccion = new Direccion("Mas Original");
        Persona persona = new Persona("Original",direccion);
        int numero = 0;

        System.out.println("Estado de los objetos antes de la modificacion");
        persona.imprimirPersona(); // Original
        System.out.println(numero); // 0

        modificarPersona(persona);
        modificarEntero(numero);

        System.out.println("Estado de los objetos luego de la modificacion");
        persona.imprimirPersona(); // Modificado
        System.out.println(numero); // 10


    }
}
