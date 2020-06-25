package ClassDAO;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import Class.*;
import HibernateUtil.HiberUtil; 

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
	public List<Sinhvien> layDanhSachSinhvien(String maLop)
	{
		Query query = session.createQuery("from Sinhvien where Sinhvien.lop.maLop = :maLop");
		List<Sinhvien> sv = query.list();
		return sv;
	}
	
}
