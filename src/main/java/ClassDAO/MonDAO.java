package ClassDAO;

import java.util.*;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import HibernateUtil.*;
import Class.*;


public class MonDAO {
	Session session = HiberUtil.getSession();
	LopDAO l = new LopDAO();
	ThamgiaDAO tg = new ThamgiaDAO();
	public List<Mon> layDanhSachMon(String maLop)
	{
		Query query = session.createQuery("from Mon m where m.lopHoc.maLop = :maLop");
		query.setParameter("maLop", maLop);
		if (query.list().size()>0)
		{
			List<Mon> result = (List<Mon>) query.list();
			return result;
		}
		else
			return new ArrayList<Mon>();
	}
	public boolean monHopLe(Mon m)
	{
		List<Mon> mons = new ArrayList<>();
		Query query = session.createQuery("from Mon");
        mons = query.list();
        for (Mon mon:mons)
        {
        	if (mon.getMaMon().compareTo(m.getMaMon())==0&&
        			mon.getLopHoc().getMaLop().compareTo(m.getLopHoc().getMaLop())==0)
        		return false;
        }
        if (m.getLopHoc().getMaLop().length()>6||
        		m.getPhong().length()>4||m.getTenMon().length()>50||m.getMaMon().length()>10)
        	return false;
        if (m.getMaMon().trim().isEmpty()||m.getLopHoc().getMaLop().trim().isEmpty())
        	return false;
        return true;
	}
	public boolean themMon(String maMon,String maLop,String tenMon,String phong)
	{
		Lop lopHoc = l.kiemTra(maLop);
		Mon m = new Mon(maMon, lopHoc, tenMon, phong);
		if (lopHoc == null||!monHopLe(m))
		{
			return false;
		}
		else
		{
			Transaction tx = session.beginTransaction();		
			Set<Mon> mon = lopHoc.getDsMon();
            mon.add(m);
            lopHoc.setDsMon(mon);
			session.save(m);
			tx.commit();
			if (lopHoc.getDsSinhvien().size()==0)
			{
				//Nothing
			}
			else
			{
				tg.themThamGiaCacSV(m, lopHoc);
			}
			return true;
		}
	}
	
}
