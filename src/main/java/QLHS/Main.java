package QLHS;
import HibernateUtil.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        Sinhvien s = new Sinhvien("1712310","Đặng Thành Duy","Nam","0218373733");
        Session session = HiberUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(s);
        tx.commit();
    }
}
