package GUI;


import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

import Class.*;
import ClassDAO.*;
import CsvHandler.Csv;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;


import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import GiaovuGUITabs.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GiaovuGUI extends JFrame {
	public static boolean flag = true;
	/**
	 * Create the frame.
	 */
	public GiaovuGUI(Giaovu gv) {
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 378);
		setSize(1200,700);
		setTitle("Phiên bản dành cho giáo vụ");
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBounds(0, 0, 1200, 70);
		getContentPane().add(headerPanel);
		headerPanel.setLayout(null);
		headerPanel.setBackground(new Color(255,140,0));
		
		String name = gv.getUsername();
		JLabel welcomeLabel = new JLabel("Xin chào, "+name);
		welcomeLabel.setForeground(Color.WHITE);
		welcomeLabel.setBounds(10, 11, 253, 19);
		headerPanel.add(welcomeLabel);
		welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		welcomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_1 = new JLabel("QUẢN LÝ SINH VIÊN");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setBounds(460, 15, 321, 44);
		headerPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Đổi mật khẩu");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(32, 36, 85, 25);
		headerPanel.add(lblNewLabel_2);
		
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.setBounds(0, 70, 1200, 630);
		tabbedPane.setBackground(new Color(44,62,80));
		getContentPane().add(tabbedPane);
		
		
		
		//DANH SÁCH LỚP
		
		JPanel dslopPanel = new JPanel();		
		dslopPanel.setBackground(new Color(44,62,80));
		tabbedPane.addTab("Danh sách lớp", null, dslopPanel, null);
		dslopPanel.setLayout(null);
		GiaovuGUITabs.danhSachLop(dslopPanel, gv);
		
		
		
		// THỜI KHÓA BIỂU
		
		
		JPanel tkbPanel = new JPanel();
		tkbPanel.setBackground(new Color(44,62,80));
		tabbedPane.addTab("Thời khóa biểu", null, tkbPanel, null);
		tkbPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chọn lớp");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel.setBounds(67, 28, 95, 30);
		tkbPanel.add(lblNewLabel);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBackground(new Color(44,62,80));
		tablePanel.setBounds(10, 131, 1175, 418);
		tkbPanel.add(tablePanel);
		tablePanel.setLayout(null);
		
		
		JLabel titleLabel = new JLabel("");
		titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBounds(424, 83, 357, 37);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		tkbPanel.add(titleLabel);
		
		JComboBox<String> lopBox = new JComboBox<String>();
		//themLop(lopBox);

		
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
		tkbPanel.add(lopBox);
		
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
				}
			}
		});
		importButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		importButton.setBounds(1003, 25, 128, 30);
		importButton.setBackground(new Color(34,67,240));
		tkbPanel.add(importButton);
		
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
		tkbPanel.add(btnThmSinhVien);
		
		
		
		
		
		
		// ĐIỂM
		
		JPanel diemPanel = new JPanel();
		diemPanel.setBackground(new Color(44,62,80));
		tabbedPane.addTab("Bảng điểm", null, diemPanel, null);
		diemPanel.setLayout(null);
		
		
		
		//YÊU CẦU
		
		JPanel yeucauPanel = new JPanel();
		yeucauPanel.setBackground(new Color(44,62,80));
		tabbedPane.addTab("Duyệt yêu cầu", null, yeucauPanel, null);
		yeucauPanel.setLayout(null);
		
		
		
		
	
		
		
		
		
	}

	
	public static boolean returnFlag()
	{
		return flag;
	}
}
