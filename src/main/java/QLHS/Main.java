package QLHS;
import ClassDAO.*;
import Class.*;
import GUI.*;
import java.util.Arrays;
import java.util.List;
import java.awt.EventQueue;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
/*
        Lop l = new Lop("17CTT3");
        ThamgiaPK pk = new ThamgiaPK("1712369",1);
        Mon m = new Mon("CTT001",l,"Nhập môn lập trình","F201");
        Sinhvien s = new Sinhvien("1712369",l,"123456",false,
                "Phạm Quốc Dũng","Nam","0218373733");
        Thamgia t = new Thamgia(pk,s,m,true,false,new BigDecimal("7.5"),
                new BigDecimal("9.0"),new BigDecimal("0"),new BigDecimal("8.5"));
    */
public class Main
{
    public static void main( String[] args )
    {
    	/*
        SinhvienDAO svd = new SinhvienDAO();
        for (Sinhvien k : svd.layDanhSachSV())
        {
            System.out.println(k.getMaSV());
        }
        */
        
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI l = new LoginGUI();
					l.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
