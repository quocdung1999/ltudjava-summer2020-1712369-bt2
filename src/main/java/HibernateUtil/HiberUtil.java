package HibernateUtil;
import Class.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/*
 *QLHS
 *
 *@create by Dung -StudentID : 1712369
 *@Date 6/15/2020 - 10:09 AM
 *@Description

 */
public class HiberUtil {
    public static Session session;
    static 
    {
        Configuration con = new Configuration().configure().addAnnotatedClass(Sinhvien.class).
                addAnnotatedClass(Lop.class).addAnnotatedClass(Mon.class).addAnnotatedClass(ThamgiaPK.class)
                .addAnnotatedClass(Thamgia.class).addAnnotatedClass(Giaovu.class);
        SessionFactory sessionFactory = con.buildSessionFactory();
        session = sessionFactory.openSession();
    }
    public static Session getSession()
    {
        return session;
    }
}
