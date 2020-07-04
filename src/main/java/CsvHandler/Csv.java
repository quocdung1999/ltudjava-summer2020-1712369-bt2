package CsvHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import Class.*;
import ClassDAO.*;
import HibernateUtil.*;

public class Csv {
	public static void danhSachSinhVien(File f)
	{
		List <List<String>> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f),
				StandardCharsets.UTF_8)))
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
					JOptionPane.showMessageDialog(null, "Dòng thứ "+(i+1)+" của file thiếu thông tin");
				}
				else if (records.get(i).size()>6)
				{
					JOptionPane.showMessageDialog(null, "Dòng thứ "+(i+1)+" của file thừa thông tin");
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
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f),
				StandardCharsets.UTF_8)))
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
					JOptionPane.showMessageDialog(null, "Dòng thứ "+(i+1)+" của file thiếu thông tin");
				}
				else if (records.get(i).size()>4)
				{
					JOptionPane.showMessageDialog(null, "Dòng thứ "+(i+1)+" của file thừa thông tin");
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
	public static void bangDiem(File f)
	{
		ThamgiaDAO tgs = new ThamgiaDAO();
		
		
		List <List<String>> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f),
				StandardCharsets.UTF_8)))
		{
			String line;
			while ((line=br.readLine()) != null)
			{
				String[] values = line.split(",");
				records.add(Arrays.asList(values));
			}
			Set<Sinhvien> sv = new HashSet<Sinhvien>();
			int row = records.size();
			ThamgiaDAO tg = new ThamgiaDAO();
			for (int i = 1;i<row;i++)
			{
				
				if (records.get(i).size()<7)
				{
					JOptionPane.showMessageDialog(null, "Dòng thứ "+(i+1)+" của file thiếu thông tin");
				}
				else if (records.get(i).size()>7)
				{
					JOptionPane.showMessageDialog(null, "Dòng thứ "+(i+1)+" của file thừa thông tin");
				}
				
				else 
				{
					if (!tg.suaDiem(records.get(i).get(0), records.get(i).get(1), records.get(i).get(2), 
							records.get(i).get(3), records.get(i).get(4), records.get(i).get(5), 
							records.get(i).get(6)))
					{
						JOptionPane.showMessageDialog(null, "Thông tin ở dòng thứ "+(i+1)+" không hợp lệ");
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
