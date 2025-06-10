import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Juan", "123456789", 25, "Calle 123");
        Cliente cliente2 = new Cliente("Joel", "123456789", 25, "Calle 123");

        List<Cliente> clientes = new ArrayList<Cliente>();

        clientes.add(cliente1);
        clientes.add(cliente2);

      //recorrer por indice
        for(int i =0;i < clientes.size();i++){


            System.out.println("prueba :"+ clientes.get(i).getNombre());

        }


        //recorrer elemento por elemento
        // for each por cada uno
        //  en este caso c es la variable auxiliar, puede tener cualquier nombre
        // lo que quiere decir es que por cada c que este dentro de la lista clientes
        for(Cliente c: clientes){

            
            System.out.println("prueba :"+ c.getNombre());


        }



    }
}
