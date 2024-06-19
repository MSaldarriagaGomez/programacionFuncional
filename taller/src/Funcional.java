import java.time.LocalDateTime;
import java.util.function.*;

public class Funcional {

    public static void main(String[] args) {
        //Suplier -> no recibe ningun parametro pero me devuelve un objecto.
        //se utiliza cuando se necesita crear algo.
        //(argumentos) -> {el cuerpo de la lambda}
        Supplier<LocalDateTime> time = () -> LocalDateTime.now();
        String localDateTime = time.get().toString();


        //Consumer -> Recibe un argumento y no retorna nada.
        Consumer<String>  consumer = (x) -> System.out.println(x);
        consumer.accept(localDateTime);


        //Funtion -> me recibe un argumento y me retorna algo!
        Function<String, Integer> funtion = (x) -> x.length();
        Integer size = funtion.apply(localDateTime);


        //Reecibe dos argumentos y retorna algo
        BiFunction<Integer, Integer, Integer> biFunction = (x, y) -> x+y;
        Integer suma = biFunction.apply(1,2);


        //Recibe un argumento y retorna un booleano
        Predicate<String> predicate = (x) -> x.equals("Mateo");
        boolean test = predicate.test("Mateo");

    }
}
