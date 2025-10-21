package test;

import model.Orden;
import model.Pizza;
import model.Sucursal;
import service.ImplDAO;

import java.time.LocalDate;
import java.util.List;

public class Main {

    private static final ImplDAO dao = new ImplDAO();

    public static void casoSucursal(){
        Sucursal s = new Sucursal();
        s.setNombre("Sucursal Managua");
        s.setDescripcion("Sucursal Managua, con mucho espacio");
        s.setDireccionActual("Managua, Americas #02");

        dao.insertar(s);

        System.out.println("Sucursal insertada!");
        List<Sucursal> lista = dao.getAll("Sucursal.All", Sucursal.class);
        lista.forEach(System.out::println);
    }

    public static void casoPizza(){
        Pizza z = new Pizza();
        z.setNombre("Pepperoni");
        z.setDescripcion("12 pociones");
        z.setPrecio(230.00);

        dao.insertar(z);

        System.out.println("Pizza insertada!");
        List<Pizza> lista1 = dao.getAll("Pizza.All", Pizza.class);
        lista1.forEach(System.out::println);
    }

    public static void casoPizzaEliminar(){
        dao.eliminarPorId(Pizza.class, 2);
    }

    public static void casoOrden(){
        Orden o = new Orden();
        o.setFechaOrden(LocalDate.now());
        o.setNombreCliente("Mads Mikkelsen");
        o.setTotal(500.00);

        dao.insertar(o);

        System.out.println("Orden insertada!");
        List<Orden> lista = dao.getAll("Orden.All", Orden.class);
        lista.forEach(System.out::println);
    }

    public static void main(String[] args) {
        casoPizzaEliminar();
    }
}

