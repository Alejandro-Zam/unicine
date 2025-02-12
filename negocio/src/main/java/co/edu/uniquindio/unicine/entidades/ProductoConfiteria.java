package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class ProductoConfiteria implements Serializable {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(unique = true, nullable = false)
    private String nombre;

    @Column (nullable = false)
    private Integer precio;

    @Column (nullable = true, length = 50)
    private String extras;



    @Column(nullable = false)
    private String imagen_producto;

    //Relaciones

    @ToString.Exclude
    @OneToMany(mappedBy = "productoConfiteria")
    private List<CompraConfiteria> comprasConfiteria;

    @Builder

    public ProductoConfiteria(String nombre, Integer precio, String extras, String imagen_producto) {
        this.nombre = nombre;
        this.precio = precio;
        this.extras = extras;
        this.imagen_producto = imagen_producto;
    }
}
