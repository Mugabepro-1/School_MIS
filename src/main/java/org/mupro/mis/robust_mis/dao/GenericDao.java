package org.mupro.mis.robust_mis.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mupro.mis.robust_mis.config.HibernateUtil;

import java.util.List;

public abstract class GenericDao<T> {
    private final Class<T> entityClass;

    public GenericDao(Class<T> entityClass){
        this.entityClass = entityClass;
    }

    public void save(T entity){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            session.persist(entity);
            tx.commit();
        }catch (Exception e){
            if(tx != null) tx.rollback();
            System.out.println(e.getMessage());
        }
    }
    public void delete(T entity){
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            session.remove(entity);
            tx.commit();
        }catch (Exception e){
            if(tx != null) tx.rollback();
            System.out.println(e.getMessage());
        }
    }

    public T findByID(int id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.get(entityClass, id);
        }
    }

    public List<T> findAl(){
        try(Session session  = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("FROM " + entityClass.getSimpleName()).list();
        }
    }
}
