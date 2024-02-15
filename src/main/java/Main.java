import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import modelo.entidad.Autor;
import modelo.seed.DatabaseSeeder;

import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Ejecutamos la semilla para insertar registros
        DatabaseSeeder dbs = new DatabaseSeeder();
        dbs.seeder();

        System.out.println("Autor creado");
    }
}
