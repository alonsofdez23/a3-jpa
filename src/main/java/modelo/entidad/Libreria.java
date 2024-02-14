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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "libreria_libro",
            joinColumns = @JoinColumn(name = "libreria_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_id"))
    private List<Libro> libros = new ArrayList<>();

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
