package ClassDAO;

import java.math.BigDecimal;
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
	public boolean kiemTraThamGia(String maLop,String maMon,String maSV)
	{
		Query query = session.createQuery("from Thamgia tg where tg.mon.maMon = :maMon"
				+ " and tg.mon.lopHoc.maLop = :maLop and tg.sv.maSV = :maSV");
		query.setParameter("maMon", maMon);
		query.setParameter("maLop", maLop);
		query.setParameter("maSV", maSV);
		if (query.list().size()>0)
			return true;
		return false;
	}
	
	public boolean soSanhDiem(BigDecimal s)
	{
		BigDecimal zero = new BigDecimal("0");
		BigDecimal ten = new BigDecimal("10");
		if (s.compareTo(zero)<0||s.compareTo(ten)>0)
			return false;
		return true;
	}
	
	public boolean suaDiem(String maLop,String maMon,String maSV,String diemGK,String diemCK,
			String diemKhac,String diemTong)
	{
		if (kiemTraThamGia(maLop, maMon,maSV)==false)
			return false;
		try
		 {
			BigDecimal one = new BigDecimal(Float.parseFloat(diemGK));
			BigDecimal two = new BigDecimal(Float.parseFloat(diemCK));
			BigDecimal three = new BigDecimal(Float.parseFloat(diemKhac));
			BigDecimal four = new BigDecimal(Float.parseFloat(diemTong));
			if (!soSanhDiem(one)||!soSanhDiem(two)||!soSanhDiem(three)||!soSanhDiem(four))
				return false;
			
			Query query = session.createQuery("from Thamgia tg where tg.mon.maMon = :maMon"  
										+" and tg.mon.lopHoc.maLop = :maLop and tg.sv.maSV = :maSV");
			query.setParameter("maMon", maMon);
			query.setParameter("maLop", maLop);
			query.setParameter("maSV", maSV);
			Thamgia tg = (Thamgia) query.getSingleResult();
			tg.setDiemGK(one);tg.setDiemCK(two);tg.setDiemKhac(three);tg.setDiemTong(four);
			Transaction tx = session.beginTransaction();
			session.update(tg);
			tx.commit();
		} 
		catch (Exception e)
		{
			return false;
		}
		return true;
	}
	
	
	public List<Thamgia> layBangDiem(String maMon,String maLop)
	{
		Query query = session.createQuery("from Thamgia tg where tg.mon.maMon = :maMon"
				+ " and tg.mon.lopHoc.maLop = :maLop");
		query.setParameter("maMon", maMon);
		query.setParameter("maLop", maLop);
		if (query.list().size()>0)
		{
			List<Thamgia> tg = query.list();
			return tg;
		}
		else
			return new ArrayList<Thamgia>();
	}
	
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
	
	
	public boolean suaDiemGK(String maLop,String maMon,String maSV,String diemGK)
	{
		if (kiemTraThamGia(maLop, maMon,maSV)==false)
			return false;
		try
		 {
			BigDecimal one = new BigDecimal(Float.parseFloat(diemGK));
			if (!soSanhDiem(one))
				return false;
			
			Query query = session.createQuery("from Thamgia tg where tg.mon.maMon = :maMon"  
										+" and tg.mon.lopHoc.maLop = :maLop and tg.sv.maSV = :maSV");
			query.setParameter("maMon", maMon);
			query.setParameter("maLop", maLop);
			query.setParameter("maSV", maSV);
			Thamgia tg = (Thamgia) query.getSingleResult();
			tg.setDiemGK(one);
			Transaction tx = session.beginTransaction();
			session.update(tg);
			tx.commit();
		} 
		catch (Exception e)
		{
			return false;
		}
		return true;
	}
	
	public boolean suaDiemCK(String maLop,String maMon,String maSV,String diemCK)
	{
		if (kiemTraThamGia(maLop, maMon,maSV)==false)
			return false;
		try
		 {
			BigDecimal one = new BigDecimal(Float.parseFloat(diemCK));
			if (!soSanhDiem(one))
				return false;
			
			Query query = session.createQuery("from Thamgia tg where tg.mon.maMon = :maMon"  
										+" and tg.mon.lopHoc.maLop = :maLop and tg.sv.maSV = :maSV");
			query.setParameter("maMon", maMon);
			query.setParameter("maLop", maLop);
			query.setParameter("maSV", maSV);
			Thamgia tg = (Thamgia) query.getSingleResult();
			tg.setDiemCK(one);
			Transaction tx = session.beginTransaction();
			session.update(tg);
			tx.commit();
		} 
		catch (Exception e)
		{
			return false;
		}
		return true;
	}
	
	public boolean suaDiemKhac(String maLop,String maMon,String maSV,String diemKhac)
	{
		if (kiemTraThamGia(maLop, maMon,maSV)==false)
			return false;
		try
		 {
			BigDecimal one = new BigDecimal(Float.parseFloat(diemKhac));
			if (!soSanhDiem(one))
				return false;
			
			Query query = session.createQuery("from Thamgia tg where tg.mon.maMon = :maMon"  
										+" and tg.mon.lopHoc.maLop = :maLop and tg.sv.maSV = :maSV");
			query.setParameter("maMon", maMon);
			query.setParameter("maLop", maLop);
			query.setParameter("maSV", maSV);
			Thamgia tg = (Thamgia) query.getSingleResult();
			tg.setDiemKhac(one);
			Transaction tx = session.beginTransaction();
			session.update(tg);
			tx.commit();
		} 
		catch (Exception e)
		{
			return false;
		}
		return true;
	}
	
	public boolean suaDiemTong(String maLop,String maMon,String maSV,String diemTong)
	{
		if (kiemTraThamGia(maLop, maMon,maSV)==false)
			return false;
		try
		 {
			BigDecimal one = new BigDecimal(Float.parseFloat(diemTong));
			if (!soSanhDiem(one))
				return false;
			
			Query query = session.createQuery("from Thamgia tg where tg.mon.maMon = :maMon"  
										+" and tg.mon.lopHoc.maLop = :maLop and tg.sv.maSV = :maSV");
			query.setParameter("maMon", maMon);
			query.setParameter("maLop", maLop);
			query.setParameter("maSV", maSV);
			Thamgia tg = (Thamgia) query.getSingleResult();
			tg.setDiemTong(one);
			Transaction tx = session.beginTransaction();
			session.update(tg);
			tx.commit();
		} 
		catch (Exception e)
		{
			return false;
		}
		return true;
	}
}
