import jakarta.persistence.*;
import modelo.entidad.Autor;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;
import modelo.seed.DatabaseSeeder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("a3JPA");
        EntityManager em = emf.createEntityManager();

        // Ejecutamos la semilla para insertar registros
        DatabaseSeeder dbs = new DatabaseSeeder();
        dbs.seeder();

        // Consulta 1: Mostrar todos los libros dados de alta, con su editorial y su autor
        System.out.println("====================================================");
        System.out.println("=========== Libros con editorial y autor ===========");
        System.out.println("====================================================");
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
        for (Libro libro : libros) {
            System.out.println("Libro: " + libro.getTitulo() +
                    ", Editorial: " + libro.getEditorial().getNombre() +
                    ", Autor: " + libro.getAutor().getNombre() + " " + libro.getAutor().getApellidos());
        }

        // Consulta 2: Mostrar todos los autores dados de alta, con sus libros asociados
        System.out.println("====================================================");
        System.out.println("=============== Autores y sus libros ===============");
        System.out.println("====================================================");
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a", Autor.class).getResultList();
        for (Autor autor : autores) {
            System.out.println("Autor: " + autor.getNombre() + " " + autor.getApellidos());
            for (Libro libro : autor.getLibros()) {
                System.out.println("   -> Libro: " + libro.getTitulo());
            }
        }

        // Consulta 3: Mostrar todas las librerías, con solamente sus libros asociados
        System.out.println("====================================================");
        System.out.println("============== Librerías y sus libros ==============");
        System.out.println("====================================================");
        List<Libreria> librerias = em.createQuery("SELECT l FROM Libreria l", Libreria.class).getResultList();
        for (Libreria libreria : librerias) {
            System.out.println("Librería: " + libreria.getNombre());
            for (Libro libro : libreria.getLibros()) {
                System.out.println("   -> Libro: " + libro.getTitulo());
            }

        }

        // Consulta 4: Mostrar todos los libros dados de alta, y en la librería en la que están
        System.out.println("====================================================");
        System.out.println("========== Libros y librerías donde están ==========");
        System.out.println("====================================================");
        List<Libro> librosConLibrerias = em.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
        for (Libro libro : librosConLibrerias) {
            System.out.println("Libro: " + libro.getTitulo());
            for (Libreria libreria : libro.getLibrerias()) {
                System.out.println("   -> Librería: " + libreria.getNombre());
            }
        }

        // Requerimiento 2
//        EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("req2");
//        EntityManager em2 = emf2.createEntityManager();
//        EntityTransaction transaction2 = em2.getTransaction();
    }
}
