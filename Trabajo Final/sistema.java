
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Clase principal
public class sistema {

    public static void main(String[] args) {
        // Datos de usuarios y sus preferencias
        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Usuario1", Arrays.asList("Acción", "Comedia")),
                new Usuario("Usuario2", Arrays.asList("Drama", "Romance")),
                new Usuario("Usuario3", Arrays.asList("Acción", "Ciencia Ficción"))
        );

        // Películas disponibles
        List<Pelicula> peliculas = Arrays.asList(
                new Pelicula("Pelicula1", Arrays.asList("Acción", "Comedia")),
                new Pelicula("Pelicula2", Arrays.asList("Drama")),
                new Pelicula("Pelicula3", Arrays.asList("Ciencia Ficción", "Acción")),
                new Pelicula("Pelicula4", Arrays.asList("Romance", "Drama"))
        );

        // Generar recomendaciones para cada usuario
        for (Usuario usuario : usuarios) {
            System.out.println("Recomendaciones para " + usuario.getNombre() + ":");
            List<Pelicula> recomendaciones = generarRecomendaciones(usuario, peliculas);
            for (Pelicula pelicula : recomendaciones) {
                System.out.println("- " + pelicula.getTitulo());
            }
        }
    }

    // Método para generar recomendaciones basadas en preferencias
    public static List<Pelicula> generarRecomendaciones(Usuario usuario, List<Pelicula> peliculas) {
        List<Pelicula> recomendaciones = new ArrayList<>();
        for (Pelicula pelicula : peliculas) {
            for (String genero : pelicula.getGeneros()) {
                if (usuario.getPreferencias().contains(genero)) {
                    recomendaciones.add(pelicula);
                    break;
                }
            }
        }
        return recomendaciones;
    }
}

// Clase Usuario
class Usuario {

    private String nombre;
    private List<String> preferencias;

    public Usuario(String nombre, List<String> preferencias) {
        this.nombre = nombre;
        this.preferencias = preferencias;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getPreferencias() {
        return preferencias;
    }
}

// Clase Pelicula
class Pelicula {

    private String titulo;
    private List<String> generos;

    public Pelicula(String titulo, List<String> generos) {
        this.titulo = titulo;
        this.generos = generos;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<String> getGeneros() {
        return generos;
    }
}
