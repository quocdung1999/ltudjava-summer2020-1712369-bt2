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
