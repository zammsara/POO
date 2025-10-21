package model;

import jakarta.persistence.*;


@Entity
@Table(name="Pizza")
@NamedQueries(
        {
                @NamedQuery(name="Pizza.All",
                        query = "select e from Pizza e")
        }
)

public class Pizza extends BaseEntity {

    private String nombre;
    private String descripcion;
    private Double precio;

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + super.getId() +
                ", estado='" + super.getEstado() + '\'' +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                '}';
    }
}
