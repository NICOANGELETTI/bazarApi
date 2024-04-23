
package nicoangeletti.bazar.dto;


import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class ClaseDTO {
    
    
    private Long codigo_venta;
    private int total;
    private int cantidad_productos;
    private String nombre_cliente;
    private String apellido_cliente;

    public ClaseDTO(Long codigo_venta, int total, int cantidad_productos, String nombre_cliente, String apellido_cliente) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cantidad_productos = cantidad_productos;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
    }

    public ClaseDTO() {
    }
    
    
    
}
