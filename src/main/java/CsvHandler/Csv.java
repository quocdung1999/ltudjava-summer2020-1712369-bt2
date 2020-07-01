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
			for (int i = 1;i<row;i++)
			{
				if (records.get(i).size()<6)
				{
					JOptionPane.showMessageDialog(null, "Dòng thứ "+i+" của file thiếu thông tin");
				}
				else if (records.get(i).size()>6)
				{
					JOptionPane.showMessageDialog(null, "Dòng thứ "+i+" của file thừa thông tin");
				}
				else if( !s.themSinhVien(records.get(i).get(0).trim(), records.get(i).get(1).trim(), records.get(i).get(2).trim(), 
						records.get(i).get(3).trim(), records.get(i).get(4).trim(), records.get(i).get(5).trim()))
				{
					JOptionPane.showMessageDialog(null, "Thông tin của sinh viên có mã số "
							+records.get(i).get(0)+" không hợp lệ");

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
	
	
	public static void danhSachMon(File f)
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
			MonDAO m = new MonDAO();
			for (int i = 1;i<row;i++)
			{
				if (records.get(i).size()<4)
				{
					JOptionPane.showMessageDialog(null, "Dòng thứ "+i+" của file thiếu thông tin");
				}
				else if (records.get(i).size()>4)
				{
					JOptionPane.showMessageDialog(null, "Dòng thứ "+i+" của file thừa thông tin");
				}
				
				else if(!m.themMon(records.get(i).get(0).trim(), records.get(i).get(1).trim(),
						records.get(i).get(2).trim(), records.get(i).get(3).trim()))
				{
					JOptionPane.showMessageDialog(null, "Thông tin của môn có mã số "+records.get(i).get(0)
							+" thuộc lớp "+records.get(i).get(1)+" không hợp lệ!");
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
