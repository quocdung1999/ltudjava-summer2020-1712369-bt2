package ClassDAO;

import Class.*;
import HibernateUtil.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;


public class GiaovuDAO {
	private List <Giaovu> gv;
	private Session session = HiberUtil.getSession();
	public GiaovuDAO()
	{
		gv = new ArrayList<Giaovu>();
        Query query = session.createQuery("from Giaovu");
        gv = query.list();
	}
	public List<Giaovu> layDanhSachGV()
	{
        return gv;
	}
	public boolean doiMatKhau(Giaovu gv,String oldPass,String newPass)
    {
    	if (gv.getPassword().compareTo(oldPass)!=0)
    		return false;
    	if (newPass.length()>50)
    		return false;
    	gv.setPassword(newPass);
    	Transaction tx = session.beginTransaction();
    	session.update(gv);
    	tx.commit();
    	return true;
    }
}
