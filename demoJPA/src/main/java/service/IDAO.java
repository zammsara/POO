package service;

import java.util.List;


/**
 * Interfaz genérica IDAO que define las operaciones básicas de acceso a datos (CRUD).
 *
 * En este proyecto, IDAO se utiliza junto con la clase ImplDAO (implementación genérica),
 * lo que permite realizar las operaciones de base de datos sobre cualquier entidad,
 * como Pizza, Producto, Orden o Sucursal, sin tener que crear un DAO distinto para cada una.
 *
 * Gracias al uso de tipos genéricos (<T>), esta interfaz puede trabajar con cualquier clase
 * de modelo, manteniendo un diseño flexible, reutilizable y fácil de mantener.
 *
 * Su función principal es establecer un contrato que ImplDAO implementa, garantizando que
 * siempre existan los métodos esenciales:
 *
 *  - getAll: obtiene una lista de objetos según una consulta nombrada (nameQuery).
 *  - insertar: guarda una nueva entidad en la base de datos.
 *  - actualizar: modifica una entidad existente.
 *  - eliminar: elimina una entidad existente.
 *  - findById: busca una entidad por su identificador único.
 *
 * Ejemplo de uso:
 *  - En el main, se crea una instancia de ImplDAO a través de la interfaz IDAO.
 *  - Luego se puede llamar a dao.insert(), dao.getAll(), etc., usando cualquier entidad,
 *    como Pizza, Producto o Orden.
 */

public interface IDAO {

    <T> List getAll(String nameQuery,Class<T> clazz);

    //Metodo para insertar
    <T> void insertar(T entity);

    //Metodo para actualizar
    <T> void actualizar(T entity);

    //Metodo para eliminar por id
    <T> void eliminarPorId(Class<T> clazz, Integer id);

    //Metodo para eliminar
    //<T> void eliminar(T entity);

    //Metodo para buscar por id
    <T> T findById(Class<T> clazz,Integer id);
}
