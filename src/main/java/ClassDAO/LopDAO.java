package ClassDAO;
import java.util.ArrayList;
import java.util.List;


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
	public List<Sinhvien> layDanhSachSinhvien(String maLop)
	{
		SinhvienDAO svDAO = new SinhvienDAO();
		List<Sinhvien> sv = new ArrayList<Sinhvien>();
		for (Sinhvien s:svDAO.layDanhSachSV())
		{
			if (s.getLop().getMaLop().compareTo(maLop)==0)
			{
				sv.add(s);
			}

		}
		return sv;
	}
	
}
