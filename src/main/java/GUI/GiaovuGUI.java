package GUI;


import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Class.*;
import ClassDAO.*;
import CsvHandler.Csv;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class GiaovuGUI extends JFrame {
	private boolean dslFlag = true;
	private boolean dsl_lopFlag = false;
	private boolean dsl_monFlag = false;
	private boolean tkbFlag = true;
	private boolean tkb_lopFlag = false;
	
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
		welcomeLabel.setBounds(10, 22, 281, 28);
		headerPanel.add(welcomeLabel);
		welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		welcomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_1 = new JLabel("QUẢN LÝ SINH VIÊN");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setBounds(460, 15, 321, 44);
		headerPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Đổi mật khẩu");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(1065, 24, 99, 28);
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
		danhSachLop(dslopPanel, gv);
		
		
		
		// THỜI KHÓA BIỂU
		
		
		JPanel tkbPanel = new JPanel();
		tkbPanel.setBackground(new Color(44,62,80));
		tabbedPane.addTab("Thời khóa biểu", null, tkbPanel, null);
		tkbPanel.setLayout(null);
		thoiKhoaBieu(tkbPanel, gv);
		
		
		
		
		
		
		
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

	
	public void danhSachLop(JPanel dslopPanel, Giaovu gv)
	{
		JLabel lblNewLabel = new JLabel("Chọn lớp");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel.setBounds(10, 72, 95, 30);
		dslopPanel.add(lblNewLabel);
		
		JLabel monChooseLabel = new JLabel("Chọn môn ");
		monChooseLabel.setForeground(Color.WHITE);
		monChooseLabel.setFont(new Font("Times New Roman", Font.BOLD, 23));
		monChooseLabel.setBounds(479, 72, 119, 30);
		dslopPanel.add(monChooseLabel);
		
		JComboBox<String> monBox = new JComboBox<String>();
		monBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (monBox.getItemCount()>0)
				{
					dsl_monFlag = true;
				}
			}
		});
		((JLabel) monBox.getRenderer()).setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		monBox.setForeground(Color.WHITE);
		monBox.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		monBox.setBackground(new Color(108, 122, 137));
		monBox.setBounds(608, 73, 523, 30);
		dslopPanel.add(monBox);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBackground(new Color(44,62,80));
		tablePanel.setBounds(10, 210, 1170, 350);
		dslopPanel.add(tablePanel);
		tablePanel.setLayout(null);
		
		
		JLabel titleLabel = new JLabel("");
		titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBounds(10, 173, 1180, 37);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		dslopPanel.add(titleLabel);
		
		JComboBox<String> lopBox = new JComboBox<String>();
		themLop(lopBox);
		lopBox.setSelectedItem(null);
				
				lopBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (monBox.getItemCount()>0)
							monBox.removeAllItems();
						MonDAO m = new MonDAO();
						String lopChon = (String)lopBox.getSelectedItem();
						List<Mon> mons = m.layDanhSachMon(lopChon);
						for (Mon mon :mons)
						{
							monBox.addItem(mon.getMaMon()+" - "+mon.getTenMon());
						}
						monBox.setSelectedItem(null);
						dsl_lopFlag = true;
						dsl_monFlag = false;
					}
				});
				
				
				
				((JLabel) lopBox.getRenderer()).setHorizontalAlignment(DefaultListCellRenderer.CENTER);
				lopBox.setForeground(Color.WHITE);
				lopBox.setBackground(new Color(108,122,137));
				lopBox.setFont(new Font("Times New Roman", Font.PLAIN, 19));
				lopBox.setBounds(138, 73, 292, 30);
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
										dispose();
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
				importButton.setBounds(1022, 25, 128, 30);
				importButton.setBackground(new Color(34,67,240));
				dslopPanel.add(importButton);
				
				JButton themButton = new JButton("Thêm sinh viên");
				themButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dienThongTinGUI d = new dienThongTinGUI((JFrame)SwingUtilities.
								getWindowAncestor(dslopPanel),gv);
					}
				});
				themButton.setForeground(Color.WHITE);
				themButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
				themButton.setBackground(new Color(34, 67, 240));
				themButton.setBounds(33, 25, 128, 30);
				dslopPanel.add(themButton);
				
				JButton execButton = new JButton("Xem danh sách sinh viên");
				execButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!dslFlag)
						{
							tablePanel.removeAll();
							tablePanel.setLayout(null);
						}
						if (!dsl_lopFlag && !dsl_monFlag)
						{
							JOptionPane.showMessageDialog(null, "Bạn chưa chọn lớp và môn học!");
						}
						else {
							DefaultTableModel model = new DefaultTableModel();
							model.addColumn("STT");model.addColumn("MSSV");model.addColumn("Họ và tên");
							model.addColumn("Giới tính");model.addColumn("CMND");
	
							String lopChon =(String) lopBox.getSelectedItem();
							String monChon = new String();
							if (dsl_monFlag)
							{
								monChon = (String) monBox.getSelectedItem();
							}
														
							Set<Sinhvien> s;
							if (!dsl_monFlag)
							{
								LopDAO l =new LopDAO();
								s = l.layDanhSachSinhvien(lopChon);
								titleLabel.setText("DANH SÁCH LỚP "+ lopChon);
							}
							else
							{
								ThamgiaDAO tg = new ThamgiaDAO();
								s = tg.layDanhSachThamGia(monChon.substring(0, 
										monChon.indexOf("-")).trim(), lopChon);
								titleLabel.setText("DANH SÁCH LỚP "+ lopChon+" - "+
								monChon.substring(0, monChon.indexOf("-")));
							}
							int i = 1;
							for (Sinhvien sv:s)
							{
								model.addRow(new Object[] {i,sv.getMaSV(),sv.getHoTen(),sv.getGioiTinh(),
										sv.getCmnd()});
								i++;
							}
							if (s.size()>0)
							{
								JTable table = new JTable(model){
							         public boolean editCellAt(int row, int column, java.util.EventObject e) {
							             return false;
							          }
							         
							         @Override
							         public Component prepareRenderer(TableCellRenderer renderer, 
							        		 int row, int column) { Component component = 
							        		 super.prepareRenderer(renderer, row, column);
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
								table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
								table.setFillsViewportHeight(true);
								JScrollPane scrollPane = new JScrollPane(table);
								scrollPane.setViewportView(table);
								tablePanel.add(scrollPane);
								scrollPane.setBounds(35,5,1100,345);
						
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
								label.setBounds(35,5,1100,340);
								label.setVerticalAlignment(JLabel.CENTER);
								label.setHorizontalAlignment(JLabel.CENTER);
								label.setFont(new Font("Times New Roman", Font.BOLD, 24));
								label.setForeground(Color.WHITE);
							}
	
							dslFlag = false;
						}
					}
				});
				execButton.setForeground(Color.WHITE);
				execButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
				execButton.setBackground(new Color(34, 67, 240));
				execButton.setBounds(479, 132, 210, 30);
				dslopPanel.add(execButton);
		
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
	
	
	
	public void thoiKhoaBieu(JPanel tkbPanel, Giaovu gv)
	{
		JLabel chooseClassLabel = new JLabel("Chọn lớp");
		chooseClassLabel.setHorizontalAlignment(SwingConstants.CENTER);
		chooseClassLabel.setForeground(Color.WHITE);
		chooseClassLabel.setFont(new Font("Times New Roman", Font.BOLD, 23));
		chooseClassLabel.setBounds(160, 23, 95, 30);
		tkbPanel.add(chooseClassLabel);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBackground(new Color(44,62,80));
		tablePanel.setBounds(10, 177, 1170, 386);
		tkbPanel.add(tablePanel);
		tablePanel.setLayout(null);
		
		
		JLabel titleLabel = new JLabel("");
		titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBounds(10, 129, 1170, 37);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		tkbPanel.add(titleLabel);
		
		JComboBox<String> lopBox = new JComboBox<String>();
		lopBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tkb_lopFlag = true;
			}
		});
		themLop(lopBox);
		lopBox.setSelectedItem(null);
		
		((JLabel) lopBox.getRenderer()).setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		lopBox.setForeground(Color.WHITE);
		lopBox.setBackground(new Color(108,122,137));
		lopBox.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lopBox.setBounds(355, 24, 462, 30);
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
					Csv.danhSachMon(selected);
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								dispose();
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
		tkbPanel.add(importButton);
		
		JButton execButton = new JButton("Xem thời khóa biểu");
		execButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!tkbFlag)
				{
					tablePanel.removeAll();
					tablePanel.setLayout(null);
				}
				if (!tkb_lopFlag)
				{
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn lớp!");
				}
				else
				{
					DefaultTableModel model = new DefaultTableModel();
					
					model.addColumn("STT");model.addColumn("Mã môn");
					model.addColumn("Tên môn");model.addColumn("Phòng");
					
					String lopChon =(String) lopBox.getSelectedItem();
					MonDAO monDAO = new MonDAO();
					List<Mon> mon = monDAO.layDanhSachMon(lopChon);
					int i = 1;
					for (Mon m:mon)
					{
						model.addRow(new Object[] {i,m.getMaMon(),m.getTenMon(),m.getPhong()});
						i++;
					}
					if (mon.size()>0)
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
					             tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().
					            		 width,tableColumn.getPreferredWidth()));
					             
					             return component;
					          }
						};
						table.setForeground(Color.WHITE);
						table.setBackground(new Color(44,62,80));
						table.setFont(new Font("Times New Roman", Font.BOLD, 18));
						table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
						table.setFillsViewportHeight(true);
						JScrollPane scrollPane = new JScrollPane(table);
						scrollPane.setViewportView(table);
						tablePanel.add(scrollPane);
						scrollPane.setBounds(35,20,1100,350);
				
						DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
						centerRenderer.setHorizontalAlignment( JLabel.CENTER );
						int column = table.getColumnModel().getColumnCount();
						
						for (int k=0;k<column;k++)
						{
							table.getColumnModel().getColumn(k).setCellRenderer(centerRenderer);
						}
					}
					else {
						JLabel label = new JLabel("Không có môn học nào");
						
						tablePanel.add(label);
						label.setBounds(35,5,1100,376);
						label.setVerticalAlignment(JLabel.CENTER);
						label.setHorizontalAlignment(JLabel.CENTER);
						label.setFont(new Font("Times New Roman", Font.BOLD, 24));
						label.setForeground(Color.WHITE);
					}
					titleLabel.setText("THỜI KHÓA BIỂU LỚP "+ lopChon);				
					
					tkbFlag = false;
				}
			}
		});
		execButton.setForeground(Color.WHITE);
		execButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		execButton.setBackground(new Color(34, 67, 240));
		execButton.setBounds(514, 88, 169, 30);
		tkbPanel.add(execButton);
	}
}
