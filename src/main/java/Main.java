import jakarta.persistence.*;
import modelo.entidad.Autor;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factoria = Persistence.createEntityManagerFactory("a3JPA");
        EntityManager em = factoria.createEntityManager();

        Autor autor = new Autor();
        autor.setNombre("Alonso");
        autor.setApellidos(" Fernández Vidal");
        autor.setFechaNacimiento(LocalDate.parse("1990-03-06"));

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(autor);
        et.commit();

        System.out.println("Autor creado");
    }
}
