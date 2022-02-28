import java.util.*;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args){
        List<Persona> personas = getPersona();
//        enfoque imperativo (NO)

        /*List<Persona> femeninos = new ArrayList<>();
        for(Persona persona: personas){
            if(persona.getGenero().equals(Genero.FEMENINO)){
                femeninos.add(persona);
            }
        }
        femeninos.forEach(System.out::println);*/

//        enfoque declarativo (SI) - CON STREAM

//        FILTER
        List<Persona> Femen = personas.stream()
                .filter(persona -> persona.getGenero().equals(Genero.FEMENINO))
                .collect(Collectors.toList());
//        Femen.forEach(System.out::println);

//        SORT (ordenar de menor a mayor por defecto y reverse lo contrario, se puede agregar un segundo elemento de comparacion)
        List<Persona> sortPersonas = personas.stream()
                .sorted(Comparator.comparing(Persona::getEdad).thenComparing(Persona::getGenero))
                .collect(Collectors.toList());
//        sortPersonas.forEach(System.out::println);


//        ALL MATCH (booleano para comprobación de que todos pasen la condición)
        boolean allMatchPeronas = personas.stream()
                .allMatch(persona -> persona.getEdad() > 43);
        System.out.println(allMatchPeronas);
//        Any MATCH (booleano para comprobación de que alguno pase la condición)
        boolean anyMatchPeronas = personas.stream()
                .anyMatch(persona -> persona.getEdad() > 43);
        System.out.println(anyMatchPeronas);
//        NONE MATCH (booleano comprobación que sea true si ninguno cumple condición)
        boolean noneMatchPersonas = personas.stream()
                .noneMatch(persona -> persona.getNombre().equals("andres"));
        System.out.println(noneMatchPersonas);

//          MAX (imprime en pantalla la entidad con el máximo valor)
        System.out.println("Max (edad)");
        personas.stream()
                .max(Comparator.comparing(Persona::getEdad))
                .ifPresent(System.out::println);

//          MIN  (imprime en pantalla la entidad con el minimo valor)
        System.out.println("MIN (edad)");
        personas.stream()
                .min(Comparator.comparing(Persona::getEdad))
                .ifPresent(System.out::println);

        System.out.println();
//          GROUP (dividir en grupos por ejemplo por genero
        List<Persona> hombres = new ArrayList<>();
        List<Persona> mujeres = new ArrayList<>();
        Map<Genero, List<Persona>> groupPersonas = personas.stream()
                .collect(Collectors.groupingBy(Persona::getGenero));
        groupPersonas.forEach(((genero, personas1) -> {
//            System.out.println(genero);
//            personas1.forEach(System.out::println);
            personas1.forEach(persona ->{
            if (genero.equals("FEMENINO")){
             mujeres.add(persona);
            }
            hombres.add(persona);
            });
        }));

        mujeres.forEach(System.out::println);
        hombres.forEach(System.out::println);


//        Busqueda de la mujer con mayor edad
        Optional<String> laMujerMayor = personas.stream()
            .filter(persona -> persona.getGenero().equals(Genero.FEMENINO))
            .max(Comparator.comparing(Persona::getEdad))
            .map(Persona::getNombre);

        laMujerMayor.ifPresent(nombre -> System.out.println(nombre));
    }

    private static List<Persona> getPersona(){
        return List.of(
                new Persona("andres", 34, Genero.MASCULINO),
                new Persona("Anaconda", 44, Genero.FEMENINO),
                new Persona("Anabela", 34, Genero.FEMENINO),
                new Persona("zara", 34, Genero.MASCULINO),
                new Persona("Soneira", 20, Genero.FEMENINO),
                new Persona("Rosana", 14, Genero.FEMENINO)
            );
    }
}
