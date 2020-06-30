package GiaovuGUITabs;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import Class.Giaovu;
import Class.Lop;
import Class.Sinhvien;
import ClassDAO.LopDAO;
import CsvHandler.Csv;
import GUI.*;

public class GiaovuGUITabs {
	public static void danhSachLop(JPanel dslopPanel, Giaovu gv)
	{
		JLabel lblNewLabel = new JLabel("Chọn lớp");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel.setBounds(67, 28, 95, 30);
		dslopPanel.add(lblNewLabel);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBackground(new Color(44,62,80));
		tablePanel.setBounds(10, 131, 1175, 418);
		dslopPanel.add(tablePanel);
		tablePanel.setLayout(null);
		
		
		JLabel titleLabel = new JLabel("");
		titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBounds(424, 83, 357, 37);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		dslopPanel.add(titleLabel);
		
		JComboBox<String> lopBox = new JComboBox<String>();
		themLop(lopBox);

		
		lopBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!GiaovuGUI.flag)
				{
					tablePanel.removeAll();
					tablePanel.setLayout(null);
				}
				DefaultTableModel model = new DefaultTableModel();
				
				model.addColumn("STT");model.addColumn("MSSV");model.addColumn("Họ và tên");
				model.addColumn("Giới tính");model.addColumn("CMND");
				
				String lopChon =(String) lopBox.getSelectedItem();
				LopDAO l =new LopDAO();
				Set<Sinhvien> s = l.layDanhSachSinhvien(lopChon);
				int i = 1;
				for (Sinhvien sv:s)
				{
					model.addRow(new Object[] {i,sv.getMaSV(),sv.getHoTen(),sv.getGioiTinh(),sv.getCmnd()});
					i++;
				}
				if (s.size()>0)
				{
					JTable table = new JTable(model){
				         public boolean editCellAt(int row, int column, java.util.EventObject e) {
				             return false;
				          }
				         
				         @Override
				         public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				             Component component = super.prepareRenderer(renderer, row, column);
				             int rendererWidth = component.getPreferredSize().width;
				             TableColumn tableColumn = getColumnModel().getColumn(column);
				             tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width,
				            		 tableColumn.getPreferredWidth()));
				             return component;
				          }
					};
					table.setForeground(Color.WHITE);
					table.setBackground(new Color(44,62,80));
					table.setFont(new Font("Times New Roman", Font.BOLD, 18));
					table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					table.setFillsViewportHeight(true);
					JScrollPane scrollPane = new JScrollPane(table);
					scrollPane.setViewportView(table);
					tablePanel.add(scrollPane);
					scrollPane.setBounds(40,25,1103,380);
			
					DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
					centerRenderer.setHorizontalAlignment( JLabel.CENTER );
					int column = table.getColumnModel().getColumnCount();
					
					for (int k=0;k<column;k++)
					{
						table.getColumnModel().getColumn(k).setCellRenderer(centerRenderer);
					}
				}
				else {
					JLabel label = new JLabel("Không có sinh viên nào");
					
					tablePanel.add(label);
					label.setBounds(40,25,1103,500);
					label.setVerticalAlignment(JLabel.NORTH);
					label.setHorizontalAlignment(JLabel.CENTER);
					label.setFont(new Font("Times New Roman", Font.BOLD, 24));
					label.setForeground(Color.WHITE);
				}
				titleLabel.setText("DANH SÁCH LỚP "+ lopChon);
				
				
				GiaovuGUI.flag = false;
			}
		});
		
		
		
		((JLabel) lopBox.getRenderer()).setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		lopBox.setForeground(Color.WHITE);
		lopBox.setBackground(new Color(108,122,137));
		lopBox.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lopBox.setBounds(306, 29, 367, 30);
		dslopPanel.add(lopBox);
		
		JButton importButton = new JButton("Import CSV");
		importButton.setForeground(Color.WHITE);
		importButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser j = new JFileChooser("C:");
				FileNameExtensionFilter f = new FileNameExtensionFilter("CSV Files","csv");
				j.setFileFilter(f);
				int result = j.showOpenDialog(importButton);
				if (result == JFileChooser.APPROVE_OPTION)
				{
					File selected = j.getSelectedFile();
					Csv.danhSachSinhVien(selected);
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								SwingUtilities.getWindowAncestor(dslopPanel).dispose();
								GiaovuGUI g = new GiaovuGUI(gv);
							}
							catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});
		importButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		importButton.setBounds(1003, 25, 128, 30);
		importButton.setBackground(new Color(34,67,240));
		dslopPanel.add(importButton);
		
		JButton btnThmSinhVien = new JButton("Thêm sinh viên");
		btnThmSinhVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dienThongTinGUI d = new dienThongTinGUI(
						(JFrame)SwingUtilities.getWindowAncestor(dslopPanel),gv);
			}
		});
		btnThmSinhVien.setForeground(Color.WHITE);
		btnThmSinhVien.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnThmSinhVien.setBackground(new Color(34, 67, 240));
		btnThmSinhVien.setBounds(859, 25, 128, 30);
		dslopPanel.add(btnThmSinhVien);
		
		
	}
	
	public static void themLop(JComboBox<String> j)
	{
		if (j.getItemCount()>0)
			j.removeAllItems();
		LopDAO l =new LopDAO();
		List<Lop> lop = l.layDanhSachLop();
		for (Lop k:lop)
		{
			j.addItem(k.getMaLop());
		}
	}
	
	
	
}
