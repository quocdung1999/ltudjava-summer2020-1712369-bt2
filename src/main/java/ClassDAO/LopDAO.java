package ClassDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Class.*;
import HibernateUtil.HiberUtil;
import javassist.expr.NewArray; 

public class LopDAO {
	private List<Lop> l;
	private Session session = HiberUtil.getSession();
	public LopDAO()
	{
		l = new ArrayList<Lop>();
        Query<Lop> query = session.createQuery("from Lop");
        l = query.list();
	}
	public List<Lop> layDanhSachLop()
	{
		return l;
	}
	public Lop kiemTra(String maLop)
	{
		if (maLop.length()>6)
			{
				return null;
			}
			
		Query query = session.createQuery("from Lop where maLop = :maLop");
		query.setParameter("maLop", maLop);
		if (query.list().size()==0)
		{
			Transaction tx = session.beginTransaction();
			Lop l = new Lop(maLop);
            session.save(l);
            tx.commit();
			return l;
		}
		return (Lop)query.getSingleResult();
	}
	public Set<Sinhvien> layDanhSachSinhvien(String maLop)
	{
		Query query = session.createQuery("from Lop where maLop = :maLop ");
		query.setParameter("maLop", maLop);
		Lop lop =(Lop)query.getSingleResult();
		return lop.getDsSinhvien();
	}
	
}
