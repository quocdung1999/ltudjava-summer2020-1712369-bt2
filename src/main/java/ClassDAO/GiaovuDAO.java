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
	}
	public layDanhSachGV()
	{
		Session session = HiberUtil.getSession();
        //Transaction tx = session.beginTransaction();

        Query<Giaovu> query = session.createQuery("from Giaovu");
        gv = query.list();
        //tx.commit();
        session.close();
        return gv;
	}
}
