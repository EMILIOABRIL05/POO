package casting;

public class AppCast {
    public static void main(String[] args) {

        //  Definicion tradiciconal del objeto , independiente de la asociacion
        Progenitor pr1 = new Progenitor(" Uno");
        Hijo hj1 = new Hijo("Dos", 2);
        System.out.println(pr1.toString());
        pr1.metodo();
        System.out.println(hj1.toString());
        hj1.metodo();
        //upcasting:  define  una clase superior  con todas las caracteristicas de la inferior
        //Superclase nombre= new Subclase();
        Progenitor pr2 = new Hijo("Tres", 3); //genera una caja donde hay una caja de especializacion

        pr2.metodo(); //
        // Downcasting:  Una superclase que tiene caracteristicas de subclase, se trata como subclase
        // Suclase nombre =(Subclase)superclase con atributos extendidos

        Hijo hj2 = (Hijo) pr2; //se convierte de algo muy general a algo especifico
        hj2.metodo();
        System.out.println(hj2.getClass());
    }

}
