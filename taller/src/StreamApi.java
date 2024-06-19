import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApi {

    public static void main(String[] args) {
        List<Empleado> empleados = new ArrayList<>();
        Empleado oscar = new Empleado("Oscar Blacarte", "Systems");
        Empleado liliana = new Empleado("Liliana Castro", "Systems");
        Empleado fernanda = new Empleado("Fernanda Martinez", "Systems");
        Empleado manuel = new Empleado("manuel lopez", "RH");
        Empleado rebeta = new Empleado("Rebeca perez", "RH");
        Empleado oscar2 = new Empleado("Oscar Blacarte", "Systems");
        empleados.add(oscar);
        empleados.add(liliana);
        empleados.add(fernanda);
        empleados.add(manuel);
        empleados.add(rebeta);
        empleados.add(oscar2);

        //stream sobre collections
        List<Empleado> listaFiltrada = empleados.stream()
                //Operadores intermedios
                .filter( empleado -> empleado.getDepartamento().equals("Systems"))
                .sorted((empleado1, empleado2) -> empleado1.getNombre().compareToIgnoreCase(empleado2.getNombre()))
                .distinct()
                //operadores finales
                .collect(Collectors.toList());

        for (Empleado empleado: listaFiltrada) {
            System.out.println(empleado.getNombre());
        }

        //listaFiltrada.forEach(x -> System.out.println(x));


 }
}
