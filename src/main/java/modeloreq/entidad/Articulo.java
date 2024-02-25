package modeloreq.entidad;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "articulos")
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int ean13;
    private String denominacion;
    private double precio;

    @ManyToMany
    @JoinTable(name = "articulo_pedido",
            joinColumns = @JoinColumn(name = "articulo_id"),
            inverseJoinColumns = @JoinColumn(name = "pedido_id"))
    private List<Pedido> pedidos = new ArrayList<>();
}
