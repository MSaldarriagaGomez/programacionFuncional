package task;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task2 {
    /*
    a) Calcula el número total de libros en la biblioteca.
    b) Crea una lista de todos los títulos de los libros. //Map
    c) Verifica si la biblioteca contiene al menos un libro de un autor específico.
    d) Encuentra el libro más barato en la biblioteca.
    e) imprime en consola todos los títulos de libros únicos en la biblioteca
    f) Problema: Crea un Map en el que las claves son los géneros de los libros y los valores son la cantidad de libros en cada género. Esto requiere que uses Collectors.groupingBy y Collectors.counting.
    g) Crear una lista de todos los libros publicados antes del año 2000.
    h) Calcular el precio promedio de los libros de "Ciencia Ficción".
    i) Crear una lista de todos los libros de "Historia", ordenados por año de publicación, de más reciente a más antiguo.
    j) Crear un mapa que agrupe los libros por género.
     */

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Book1", "Author1", 1995, "Novel", 19.99),
                new Book("Book2", "Author2", 2005, "Science Fiction", 29.99),
                new Book("Book3", "Author3", 1997, "History", 39.99),
                new Book("Book4", "Author4", 2000, "Novel", 22.99),
                new Book("Book5", "Author5", 2018, "Science Fiction", 33.99),
                new Book("Book6", "Author6", 1999, "History", 21.99),
                new Book("Book7", "Author7", 2021, "Novel", 25.99),
                new Book("Book8", "Author8", 2010, "Science Fiction", 32.99),
                new Book("Book9", "Author9", 1980, "History", 29.99),
                new Book("Book10", "Author10", 1990, "Novel", 9.99),
                new Book("Book11", "Author11", 1998, "Science Fiction", 24.99),
                new Book("Book12", "Author12", 2002, "History", 34.99),
                new Book("Book13", "Author13", 2019, "Novel", 20.99),
                new Book("Book15", "Author14", 2012, "Science Fiction", 30.99),
                new Book("Book15", "Author15", 1996, "History", 23.99),
                new Book("Book15", "Author16", 2020, "Novel", 26.99),
                new Book("Book17", "Author17", 2008, "Science Fiction", 28.99),
                new Book("Book18", "Author18", 1993, "History", 27.99),
                new Book("Book19", "Author19", 2011, "Novel", 29.99),
                new Book("Book20", "Author20", 2003, "Science Fiction", 35.99)
        );
        //TODO: Calcular el total de numero total en la biblioteca
        Long countBooks = books.stream().count();
        System.out.println(countBooks);

        //Crea una lista de todos los títulos de los libros. //Map
        List<String> lista_titulos = books.stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
        System.out.println(lista_titulos);

        //Verifica si la biblioteca contiene al menos un libro de un autor específico.

        Predicate<String> filtro_autores = (book) -> book.equals("Author19");
        boolean test= filtro_autores.test("Author19");
        System.out.println(test);

        //Encuentra el libro más barato en la biblioteca.

        List <Double> precio = books.stream()
                .map(Book::getPrice).sorted()
                .limit(1)
                .collect(Collectors.toList());
        System.out.println(precio);

        //imprime en consola todos los títulos de libros únicos en la biblioteca

        List<String> titulos_unicos = books.stream()
                .map(Book::getTitle).distinct()
                .collect(Collectors.toList());
        System.out.println(titulos_unicos);

        //Problema: Crea un Map en el que las claves son los géneros de los libros y los valores son la cantidad de libros en cada género. Esto requiere que uses Collectors.groupingBy y Collectors.counting.
        Map <String, Long> libros_genero_cant = books.stream()
                .collect(Collectors.groupingBy(Book::getGenre, Collectors.counting()));
        System.out.println(libros_genero_cant);

        //Crear una lista de todos los libros publicados antes del año 2000.
        List<String> libros_2000 = books.stream()
                .filter(book -> book.getYear() < 2000)
                .map(book -> book.getTitle())
                .collect(Collectors.toList());
        System.out.println(libros_2000);

        //Calcular el precio promedio de los libros de "Ciencia Ficción".
        Double precio_promedio = books.stream()
                .filter(book -> book.getGenre().equals("Science Fiction"))
                .collect(Collectors.averagingDouble(Book::getPrice));
        System.out.println(precio_promedio);

       //Crear una lista de todos los libros de "Historia", ordenados por año de publicación, de más reciente a más antiguo.
        List<String> libros_anio = books.stream()
                .filter(book -> book.getGenre().equals("History"))
                .sorted((b1, b2) -> Integer.compare(b2.getYear(), b1.getYear())) // Ordenar de más reciente a más antiguo
                .map(Book::getTitle) // Mapeo a los títulos de los libros
                .collect(Collectors.toList());
        System.out.println(libros_anio);

                //otra solucion
                List<Book> libros_anio_2 = books.stream()
                        .filter(book -> "History".equals(book.getGenre())).sorted(Comparator.comparing(Book::getYear).reversed())
                        .collect(Collectors.toList());
                System.out.println(libros_anio_2);


        //Crear un mapa que agrupe los libros por género.
        Map<String, List<Book>> librosGenero = books.stream()
                .collect(Collectors.groupingBy(Book::getGenre));

        librosGenero.forEach((genero, lista_libros) -> {
            String titulos = lista_libros.stream()
                    .map(Book::getTitle)
                    .collect(Collectors.joining(", ")); //joining une los títulos separandolos por coma
            System.out.println(genero + " = [" + titulos + "]");
        }
    );

        //otra solucion
        Map<String, List<String>> filtroGenero = books.stream()
                .collect(Collectors.groupingBy(Book::getGenre, Collectors.mapping(Book::getTitle, Collectors.toList())));
        System.out.println(filtroGenero);
    }
}
