import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mupro.mis.robust_mis.config.HibernateUtil;

public class HibernateTest {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        System.out.println("Hibernate connected to postgresql successfully !!");
        tx.commit();
        session.close();
    }
}
