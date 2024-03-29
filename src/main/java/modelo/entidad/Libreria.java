package modelo.entidad;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "librerias")
public class Libreria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String nombreDueno;
    private String direccion;

    // Relación muchos a muchos con la clase Libro. Esto significa que una librería puede tener varios libros
    // asociados y, a su vez, un libro puede estar asociado a varias librerías.
    @ManyToMany(cascade = CascadeType.ALL)
    // Especifica la tabla de unión que se creará en la base de datos para manejar la relación muchos a muchos.
    // name = "libreria_libro" especifica el nombre de la tabla de unión.
    // joinColumns y inverseJoinColumns especifican los nombres de las columnas que representan las claves foráneas
    // en la tabla de unión.
    @JoinTable(name = "libreria_libro",
            joinColumns = @JoinColumn(name = "libreria_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_id"))
    private List<Libro> libros = new ArrayList<>();

    public Libreria() {
    }

    public Libreria(String nombre, String nombreDueno, String direccion) {
        this.nombre = nombre;
        this.nombreDueno = nombreDueno;
        this.direccion = direccion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreDueno() {
        return nombreDueno;
    }

    public void setNombreDueno(String nombreDueno) {
        this.nombreDueno = nombreDueno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Libreria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nombreDueno='" + nombreDueno + '\'' +
                ", direccion='" + direccion + '\'' +
                ", libros=" + libros +
                '}';
    }
}
