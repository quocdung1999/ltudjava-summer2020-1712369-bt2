package ClassDAO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Class.*;
import ClassDAO.*;
import HibernateUtil.HiberUtil;

/*
 *ClassDAO
 *
 *@create by Dung -StudentID : 1712369
 *@Date 6/19/2020 - 10:51 PM
 *@Description

 */
public class ThamgiaDAO {
	Session session = HiberUtil.getSession();
	public Set<Sinhvien> layDanhSachThamGia(String maMon,String maLop)
	{
		Query query = session.createQuery("from Thamgia tg where tg.mon.maMon = :maMon"
				+ " and tg.mon.lopHoc.maLop = :maLop");
		query.setParameter("maMon", maMon);
		query.setParameter("maLop", maLop);
		if (query.list().size()>0)
		{
			List<Thamgia> tg = query.list();
			Set<Sinhvien> result = new HashSet<Sinhvien>();
			for (Thamgia t:tg)
			{
				result.add(t.getSv());
			}
			return result;
		}
		else
			return new HashSet<Sinhvien>();
	}
	//Hàm thêm học sinh mới thêm vào các môn trong lớp
	public void themThamGiaCacMon(Sinhvien sv,Lop lop)
	{
		Set<Mon> mons = lop.getDsMon();
		for (Mon mon:mons)
		{
			ThamgiaPK pk = new ThamgiaPK(sv.getMaSV(), mon.getIDMon());
			Thamgia tg = new Thamgia(pk, sv, mon, true, false, null, null, null, null);
			Transaction tx = session.beginTransaction();
			session.save(tg);
			tx.commit();
		}
	}
	
	//Hàm thêm các học sinh có sẵn trong lớp vào môn vừa thêm
	public void themThamGiaCacSV(Mon mon,Lop lop)
	{
		Set<Sinhvien> s = lop.getDsSinhvien();
		for (Sinhvien sv:s)
		{
			ThamgiaPK pk = new ThamgiaPK(sv.getMaSV(), mon.getIDMon());
			Thamgia tg = new Thamgia(pk, sv, mon, true, false, null, null, null, null);
			Transaction tx = session.beginTransaction();
			session.save(tg);
			tx.commit();
		}
	}
}
