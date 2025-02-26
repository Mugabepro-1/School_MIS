package org.mupro.mis.robust_mis.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.mupro.mis.robust_mis.config.HibernateUtil;
import org.mupro.mis.robust_mis.models.User;

public class UserDao extends GenericDao<User>{
    public UserDao(){
        super(User.class);
    }
    public User findByEmail(String email){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<User> query = session.createQuery("from User where email = :email", User.class);
            query.setParameter("email", email);
            return query.uniqueResult();
        }
    }

    public User findByRole(User.Role role){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<User> query = session.createQuery("from User where role = :role", User.class);
            query.setParameter("role", role);
            return (User) query.list();
        }
    }
}
