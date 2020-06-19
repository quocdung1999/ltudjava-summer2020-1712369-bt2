package QLHS;
import HibernateUtil.*;
import Class.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        /*
        Lop l = new Lop("17CTT3");
        ThamgiaPK pk = new ThamgiaPK("1712369",1);
        Mon m = new Mon("CTT001",l,"Nhập môn lập trình","F201");
        Sinhvien s = new Sinhvien("1712369",l,"123456",false,
                "Phạm Quốc Dũng","Nam","0218373733");
        Thamgia t = new Thamgia(pk,s,m,true,false,new BigDecimal("7.5"),
                new BigDecimal("9.0"),new BigDecimal("0"),new BigDecimal("8.5"));
    */
        Session session = HiberUtil.getSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from Mon");
        List<Mon> l = query.list();
        for (Mon k : l)
        {
            Lop tg =k.getLopHoc();
            System.out.println(tg.getMaLop());
        }


        /*session.save(l);
        session.save(m);
        session.save(s);
        session.save(t);
        */
        tx.commit();
        session.close();
    }
}
