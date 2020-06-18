package QLHS;
import HibernateUtil.*;
import Class.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        Lop l = new Lop();
        ThamgiaPK pk = new ThamgiaPK("1712369",1);
        Thamgia t = new Thamgia();
        Set<Thamgia> tg = new HashSet<Thamgia>();
        Mon m = new Mon("CTT001",l,tg,"Nhập môn lập trình","F201");
        Set<Mon> mon = new HashSet<Mon>();
        mon.add(m);
        tg.add(t);
        Sinhvien s = new Sinhvien("1712369",l,tg,"123456",false,
                "Phạm Quốc Dũng","Nam","0218373733");
        Set<Sinhvien> sv = new HashSet<Sinhvien>();
        sv.add(s);

        t.setSv(s); t.setMon(m); t.setId(pk); t.setKhongHoc(false); t.setDuyet(true);
        t.setDiemGK(new BigDecimal("7.5"));t.setDiemCK(new BigDecimal("7.5"));
        t.setDiemKhac(new BigDecimal("0.5"));t.setDiemTong(new BigDecimal("7.5"));

        l.setMaLop("17CTT3");l.setDsSinhvien(sv);l.setDsMon(mon);
        Session session = HiberUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.save(l);
        session.save(s);
        session.save(m);
        session.save(t);
        tx.commit();
    }
}
