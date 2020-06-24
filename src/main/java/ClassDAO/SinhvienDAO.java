package ClassDAO;
import Class.*;
import HibernateUtil.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
        Session session = HiberUtil.getSession();
        Query<Sinhvien> query = session.createQuery("from Sinhvien");
        sv = query.list();
    }
    public List<Sinhvien> layDanhSachSV()
    {
        
        return sv;
    }
    public boolean svHopLe(Sinhvien s)
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
        if (s.getPassword().length()>50||s.getHoTen().length()>50||
        		s.getLop().getMaLop().length()>6||s.getCmnd().length()>12)
        	return false;
        return true;
    }
    public void themSinhVien(Sinhvien s)
    {
    	if (svHopLe(s)==false)
    	{
    		JOptionPane.showMessageDialog(null, "Thông tin không hợp lệ. Hãy thử lại");
    	}
    	else {
    		Session session = HiberUtil.getSession();
            Transaction tx = session.beginTransaction();
            session.save(s);
            tx.commit();
            session.close();
		}
    	
    }
}
