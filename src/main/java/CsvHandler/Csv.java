package CsvHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import Class.*;
import ClassDAO.*;
import HibernateUtil.*;

public class Csv {
	private Session session = HiberUtil.getSession(); 
	public static void danhSachSinhVien(File f)
	{
		List <List<String>> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(f)))
		{
			String line;
			while ((line=br.readLine()) != null)
			{
				String[] values = line.split(",");
				records.add(Arrays.asList(values));
			}
			
			int row = records.size();
			SinhvienDAO s = new SinhvienDAO();
			boolean flag = true;
			for (int i = 1;i<row;i++)
			{
				if(!s.themSinhVien(records.get(i).get(0).trim(), records.get(i).get(1).trim(), records.get(i).get(2).trim(), 
						records.get(i).get(3).trim(), records.get(i).get(4).trim(), records.get(i).get(5).trim()))
				{
					if (flag)
					{
						JOptionPane.showMessageDialog(null, "Có thông tin sinh viên không hợp lệ!\n"
							+ "và sẽ không được lưu!");
						flag = false;
					}
				}
			}
			JOptionPane.showMessageDialog(null, "File đã được xử lý xong!");
		} 
		
		catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
}
