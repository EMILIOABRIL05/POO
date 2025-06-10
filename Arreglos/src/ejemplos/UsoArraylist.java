package ejemplos;

import java.util.ArrayList;

public class UsoArraylist {


    private static void muestras (ArrayList<String> muestra){

        for(String i: muestra){

            System.out.printf("%s ",i);

        }
        System.out.println();
    }



    public static void main(String[] args) {
        ArrayList<String> dias = new ArrayList<>();
        dias.add("Domingo");
        dias.add("");
        muestras(dias);
        System.out.println(dias.toString());
       // dias.add(3,"Miercoles");//No se puede agregar un objeto en cualquier  lugar del arraylist  solamente en los lugares  que pueden
        //existir  dentro de la estructura .Si  no existe el indice 2,mucho menos el 3
        dias.add(2,"Martes");
        muestras(dias);
        dias.add(1,"Lunes");
        muestras(dias);
      dias.remove("Martes");
      muestras(dias);
        System.out.println(dias.size());
        dias.add("Sabado");
        System.out.println(dias.indexOf("Sabado"));
        System.out.println(dias.size());
        dias.remove("Domingo");
        System.out.println(dias.indexOf("Sabado"));
        muestras(dias);



    }
}
