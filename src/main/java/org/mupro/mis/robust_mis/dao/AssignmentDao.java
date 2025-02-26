package org.mupro.mis.robust_mis.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.mupro.mis.robust_mis.config.HibernateUtil;
import org.mupro.mis.robust_mis.models.Assignment;
import org.mupro.mis.robust_mis.models.User;

import java.util.List;

public class AssignmentDao extends GenericDao<Assignment>{
    public AssignmentDao(){
        super(Assignment.class);
    }
    public List<Assignment> findByInstructor(User instructor){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Assignment> query = session.createQuery("from Assignment where instructor = :instrctor", Assignment.class);
            query.setParameter("instructor", instructor);
            return query.list();
        }
    }
}
