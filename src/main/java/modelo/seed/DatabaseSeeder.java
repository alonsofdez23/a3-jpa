package modelo.seed;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import modelo.entidad.Autor;
import modelo.entidad.Editorial;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;

import java.util.Date;

public class DatabaseSeeder {
    public void seeder() {
        // Crear un EntityManagerFactory utilizando la unidad de persistencia llamada "a3JPA"
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("a3JPA");
        // Crear un EntityManager a partir del EntityManagerFactory
        EntityManager em = emf.createEntityManager();
        // Iniciar una transacción para agrupar las operaciones de base de datos
        EntityTransaction transaction = em.getTransaction();

        try {
            // Iniciar la transacción
            transaction.begin();

            // Crear instancias de Autores
            Autor autor1 = new Autor("Rebecca", "Yarros", new Date());
            Autor autor2 = new Autor("John Ronald Reuel", "Tolkien", new Date());
            Autor autor3 = new Autor("Frank", "Miller", new Date());
            // Persistir las instancias de Autores en la base de datos
            em.persist(autor1);
            em.persist(autor2);
            em.persist(autor3);

            // Crear instancias de Editoriales
            Editorial editorial1 = new Editorial("Planeta", "Barcelona");
            Editorial editorial2 = new Editorial("Minotauro", "Madrid");
            // Persistir las instancias de Editoriales en la base de datos
            em.persist(editorial1);
            em.persist(editorial2);

            // Crear instancias de Libros y asignarles autores y editoriales
            Libro libro1 = new Libro("Alas de Sangre", 21.75, autor1, editorial1);
            Libro libro2 = new Libro("Alas de hierro", 22.7, autor1, editorial1);
            Libro libro3 = new Libro("300", 35.4, autor3, editorial2);
            Libro libro4 = new Libro("ESDLA La Comunidad del Anillo", 31.2, autor2, editorial2);
            Libro libro5 = new Libro("ESDLA Las dos Torres", 27.35, autor2, editorial2);
            Libro libro6 = new Libro("ESDLA El Retorno del Rey", 29.9, autor2, editorial2);
            Libro libro7 = new Libro("Batman: El Regreso del Caballero Oscuro", 37.7, autor3, editorial1);
            Libro libro8 = new Libro("Sin City: Ciudad del pecado", 23.0, autor3, editorial2);
            // Persistir libros las instancias de Libros en la base de datos
            em.persist(libro1);
            em.persist(libro2);
            em.persist(libro3);
            em.persist(libro4);
            em.persist(libro5);
            em.persist(libro6);
            em.persist(libro7);
            em.persist(libro8);

            // Crear instancias de Librerías
            Libreria libreria1 = new Libreria("Atlantis Books", "Alan Moore", "Grecia");
            Libreria libreria2 = new Libreria("Otherwise", "Stan Lee", "Roma");
            // Persistir las instancias de Librerías en la base de datos
            em.persist(libreria1);
            em.persist(libreria2);

            // Asignar libros a librerías
            libreria1.getLibros().add(libro1);
            libreria1.getLibros().add(libro2);
            libreria1.getLibros().add(libro3);
            libreria1.getLibros().add(libro4);
            libreria2.getLibros().add(libro5);
            libreria2.getLibros().add(libro6);
            libreria2.getLibros().add(libro7);
            libreria2.getLibros().add(libro8);

            // Confirmar la transacción
            transaction.commit();
        } catch (Exception e) {
            // Manejar excepciones: hacer rollback si la transacción está activa, imprimir la excepción y lanzar una RuntimeException
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            // Cerrar el EntityManager y EntityManagerFactory en la sección finally para la liberación de recursos
            em.close();
            emf.close();
        }
    }
}
