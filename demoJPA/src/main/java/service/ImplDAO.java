package service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ImplDAO implements IDAO{


    @Override
    public <T> List<T> getAll(String nameQuery, Class<T> clazz) {
        EntityManager entityManager = EntityManagerAdmin.getInstance();
        try {
            TypedQuery<T> query = entityManager.createNamedQuery(nameQuery, clazz);
            return query.getResultList();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            entityManager.close();
        }
        return null;
    }

    @Override
    public <T> void insertar(T entity) {
        EntityManager entityManager = EntityManagerAdmin.getInstance();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        finally{
            entityManager.close();
        }

    }

    @Override
    public <T> void actualizar(T entity) {

    }

    @Override
    public <T> void eliminarPorId(Class<T> clazz, Integer id) {
        EntityManager entityManager = EntityManagerAdmin.getInstance();
        try{
            entityManager.getTransaction().begin();
            //buscamos la entidad por su id
            T entity = entityManager.find(clazz, id);
            //si existe, la eliminamos
            if (entity != null) {
                entityManager.remove(entity);
                System.out.println("Entidad eliminada correctamente.");
            }
            else{
                System.out.println("No se encontró entidad con ID: " + id);
            }
            entityManager.getTransaction().commit();
        }
        catch(Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        finally{
            entityManager.close();
        }
    }

    //    @Override
//    public <T> void eliminar(T entity) {
//        EntityManager entityManager = EntityManagerAdmin.getInstance();
//        try{
//            entityManager.getTransaction().begin();
//            entityManager.remove(entityManager.merge(entity));
//            entityManager.getTransaction().commit();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            entityManager.getTransaction().rollback();
//        }
//        finally{
//            entityManager.close();
//        }
//
//    }

    @Override
    public <T> T findById(Class<T> clazz, Integer id) {
        EntityManager entityManager = EntityManagerAdmin.getInstance();
        try{
            T entity = entityManager.find(clazz, id);
            return entity;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            entityManager.close();
        }
        return null;
    }
}
