package modeloreq.entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "direcciones")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String direccion;
    private String ciudad;
    private int cpostal;
    private String provincia;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
