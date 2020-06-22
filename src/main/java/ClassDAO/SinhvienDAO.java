package ClassDAO;
import Class.*;
import HibernateUtil.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/*
 *ClassDAO
 *
 *@create by Dung -StudentID : 1712369
 *@Date 6/19/2020 - 9:59 PM
 *@Description

 */
public class SinhvienDAO {
    private List<Sinhvien> sv ;

    public SinhvienDAO() {
        sv = new ArrayList<Sinhvien>();
    }
    public List<Sinhvien> layDanhSachSV()
    {
        Session session = HiberUtil.getSession();
        //Transaction tx = session.beginTransaction();

        Query<Sinhvien> query = session.createQuery("from Sinhvien");
        sv = query.list();
        //tx.commit();
        session.close();
        return sv;
    }
    public boolean svTrung(Sinhvien s)
    {
        Session session = HiberUtil.getSession();

        Query query = session.createQuery("from Sinhvien");
        sv = query.list();
        session.close();
        for (Sinhvien sv1:sv)
        {
        	if (sv1.getMaSV().compareTo(s.getMaSV())==0)
        	{
        		return false;
        	}
        }
        return true;
    }
    public void themSinhVien(Sinhvien s)
    {

    }
}
