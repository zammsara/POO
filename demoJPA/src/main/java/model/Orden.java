package model;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;

@Entity
@Table(name = "orden")
@NamedQueries({
        @NamedQuery(name = "Orden.All",
                query = "select e from Orden e")
        }
)
public class Orden extends BaseEntity {

    @UuidGenerator
    @Column(name = "codigo_orden", unique = true, nullable = false)
    public String codigoOrden;

    @Column(name = "nombre_Cliente",  nullable = false, length = 100)
    private String nombreCliente;

    private LocalDate fechaOrden;

    private double total;

    //Getters y Setters
    public String getCodigoOrden() {
        return codigoOrden;
    }

    public void setCodigoOrden(String codigoOrden) {
        this.codigoOrden = codigoOrden;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public LocalDate getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(LocalDate fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Orden{" +
                "id=" + super.getId() +
                "codigoOrden='" + codigoOrden + '\'' +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", fechaOrden=" + fechaOrden +
                ", total=" + total +
                '}';
    }
}
