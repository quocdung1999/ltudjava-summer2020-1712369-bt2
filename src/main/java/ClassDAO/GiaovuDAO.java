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
	public GiaovuDAO()
	{
		gv = new ArrayList<Giaovu>();
		Session session = HiberUtil.getSession();
        Query query = session.createQuery("from Giaovu");
        gv = query.list();
	}
	public List<Giaovu> layDanhSachGV()
	{
        return gv;
	}
}
