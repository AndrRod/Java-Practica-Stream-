public class Persona {
    private final String nombre;
    private final int Edad;
    private final Genero genero;

    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return Edad;
    }
    public Genero getGenero() {
        return genero;
    }
    public Persona(String nombre, int edad, Genero genero) {
        this.nombre = nombre;
        Edad = edad;
        this.genero = genero;
    }
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", Edad=" + Edad +
                ", genero=" + genero +
                '}';
    }
}
