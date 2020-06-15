package HibernateUtil;
import QLHS.*;
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
    public static SessionFactory sessionFactory = null;
    static 
    {
        Configuration con = new Configuration().configure().addAnnotatedClass(Sinhvien.class);
        sessionFactory = con.buildSessionFactory();
    }
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
