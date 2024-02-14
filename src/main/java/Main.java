import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factoria = Persistence.createEntityManagerFactory("a3JPA");
        EntityManager em = factoria.createEntityManager();
    }
}
