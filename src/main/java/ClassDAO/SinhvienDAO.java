package ClassDAO;
import Class.*;
import HibernateUtil.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private Session session = HiberUtil.getSession();
    public SinhvienDAO() {
        sv = new ArrayList<Sinhvien>();
        Query<Sinhvien> query = session.createQuery("from Sinhvien");
        sv = query.list();
    }
    public List<Sinhvien> layDanhSachSV()
    {
        
        return sv;
    }
    public boolean svHopLe(Sinhvien s)
    {
        List <String> gioiTinh = new ArrayList<>();
        gioiTinh.add("Nam");gioiTinh.add("Nữ");
        Query query = session.createQuery("from Sinhvien");
        sv = query.list();
        for (Sinhvien sv1:sv)
        {
        	if (sv1.getMaSV().compareTo(s.getMaSV())==0)
        	{
        		return false;
        	}
        }
        if (s.getMaSV().length()>8||s.getPassword().length()>50||s.getHoTen().length()>50||
        		s.getLop().getMaLop().length()>6||s.getCmnd().length()>12)
        	return false;
        if (!gioiTinh.contains(s.getGioiTinh()))
        	return false;
        
        if (s.getMaSV().trim().isEmpty())
        	return false;
        
        return true;
    }

    public boolean themSinhVien(String maSV, String maLop,String password,String hoTen,String gioiTinh,String cmnd)
    {
    	
    	LopDAO lopDAO = new LopDAO();
    	Lop l = lopDAO.kiemTra(maLop);
    	Sinhvien s = new Sinhvien(maSV,l,password,hoTen,gioiTinh,cmnd);
    	if (l==null||svHopLe(s)==false)
    	{
    		return false;
    	}
    	else {
            Transaction tx = session.beginTransaction();
            Set<Sinhvien> sv = l.getDsSinhvien();
            sv.add(s);
            l.setDsSinhvien(sv);
            session.save(s);
            tx.commit();
            return true;
		}
    }
}
