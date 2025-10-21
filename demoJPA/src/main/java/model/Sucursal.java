package model;

// Importamos las anotaciones necesarias de JPA (Jakarta Persistence API)
import jakarta.persistence.*;

/**
 * La clase Sucursal representa una entidad persistente dentro del sistema.
 *
 * Una entidad (Entity) es una clase del modelo de negocio que se mapea directamente
 * a una tabla en la base de datos. En este caso, la clase Sucursal se asocia
 * con la tabla "sucursal".
 *
 * Esta clase forma parte del modelo de datos (capa Model) y actúa como un
 * objeto de tipo ORM (Object-Relational Mapping), es decir, un objeto Java
 * que se vincula con registros de una tabla en la base de datos.
 */
@Entity  // Indica que esta clase es una entidad JPA (se guarda como tabla en la base de datos)
@Table(name = "sucursal") // Asocia esta clase con la tabla llamada "sucursal"

// --- Definición de consultas nombradas (Named Queries) ---
// Estas consultas se definen aquí para poder reutilizarlas en el código
// sin tener que escribir la consulta manualmente cada vez.
@NamedQueries({
        @NamedQuery(
                name = "Sucursal.All",                   // Nombre con el que se invoca desde el DAO
                query = "SELECT e FROM Sucursal e"       // Consulta JPQL: obtiene todas las sucursales
        )
})
public class Sucursal {

    // --- Atributos mapeados a columnas de la base de datos ---

    @Id // Indica que este atributo será la clave primaria (Primary Key)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_completo", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;

    @Column(name = "direccion_actual", length = 100)
    private String direccionActual;


    //Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getDireccionActual() {
        return direccionActual;
    }

    public void setDireccionActual(String direccionActual) {
        this.direccionActual = direccionActual;
    }

    // --- Método toString() ---
    // Se sobreescribe para mostrar el contenido de la entidad en formato legible,
    // útil al imprimir objetos en consola o en logs.
    @Override
    public String toString() {
        return "Sucursal{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", direccionActual='" + direccionActual + '\'' +
                '}';
    }
}