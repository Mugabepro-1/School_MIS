package org.mupro.mis.robust_mis.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.mupro.mis.robust_mis.config.HibernateUtil;
import org.mupro.mis.robust_mis.models.Assignment;
import org.mupro.mis.robust_mis.models.Submission;
import org.mupro.mis.robust_mis.models.User;

import java.util.List;

public class SubmissionDao extends GenericDao<Submission>{
    public SubmissionDao(){
        super(Submission.class);
    }
    public List<Submission> findByStudent(User student){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Submission> query = session.createQuery("from Submission where student = :student", Submission.class);
            query.setParameter("student", student);
            return query.list();
        }
    }

    public List<Submission> findByAssignment(Assignment assignment){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<Submission> query = session.createQuery("from Submission where assignment = :assignment", Submission.class);
            query.setParameter("assignment", assignment);
            return query.list();
        }
    }
}
