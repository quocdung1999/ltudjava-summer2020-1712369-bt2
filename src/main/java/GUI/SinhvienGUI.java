package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import Class.*;
import ClassDAO.MonDAO;
import ClassDAO.ThamgiaDAO;
import HibernateUtil.HiberUtil;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import org.hibernate.query.Query;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SinhvienGUI extends JFrame {

	//private boolean diemFlag = true;

	/**
	 * Create the frame.
	 */
	private boolean yeucau_yeucauFlag = false;
	private boolean yeucauFlag = true;
	public SinhvienGUI(Sinhvien sv) {
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 378);
		setSize(1200,700);
		setTitle("Phiên bản dành cho sinh viên");
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBounds(0, 0, 1200, 70);
		getContentPane().add(headerPanel);
		headerPanel.setLayout(null);
		headerPanel.setBackground(new Color(255,140,0));
		
		String name = sv.getHoTen();
		JLabel welcomeLabel = new JLabel("Xin chào, "+name);
		welcomeLabel.setForeground(Color.WHITE);
		welcomeLabel.setBounds(10, 22, 281, 28);
		headerPanel.add(welcomeLabel);
		welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		welcomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_1 = new JLabel("QUẢN LÝ HỌC TẬP");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setBounds(460, 15, 321, 44);
		headerPanel.add(lblNewLabel_1);
		
		JButton doiMatKhauButton = new JButton("Đổi mật khẩu");
		doiMatKhauButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doiMatKhauGUI d = new doiMatKhauGUI(sv, true);
			}
		});
		doiMatKhauButton.setForeground(Color.WHITE);
		doiMatKhauButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		doiMatKhauButton.setBackground(new Color(34, 67, 240));
		doiMatKhauButton.setBounds(932, 22, 139, 30);
		headerPanel.add(doiMatKhauButton);
		
		JButton dangXuatButton = new JButton("Đăng xuất");
		dangXuatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginGUI l = new LoginGUI();
			}
		});
		dangXuatButton.setForeground(Color.WHITE);
		dangXuatButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		dangXuatButton.setBackground(new Color(34, 67, 240));
		dangXuatButton.setBounds(1078, 22, 112, 30);
		headerPanel.add(dangXuatButton);
		
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.setBounds(0, 70, 1200, 603);
		tabbedPane.setBackground(new Color(44,62,80));
		getContentPane().add(tabbedPane);
		
		
		JPanel thongtinPanel = new JPanel();		
		thongtinPanel.setBackground(new Color(44,62,80));
		tabbedPane.addTab("Thông tin cá nhân", null, thongtinPanel, null);
		thongtinPanel.setLayout(null);
		thongTin(thongtinPanel, sv);
		
		
		
		JPanel diemPanel = new JPanel();		
		diemPanel.setBackground(new Color(44,62,80));
		tabbedPane.addTab("Bảng điểm", null, diemPanel, null);
		diemPanel.setLayout(null);
		bangDiem(diemPanel, sv);
		
		JPanel yeuCauPanel = new JPanel();		
		yeuCauPanel.setBackground(new Color(44,62,80));
		tabbedPane.addTab("Đề nghị", null, yeuCauPanel, null);
		yeuCauPanel.setLayout(null);
		
		yeuCau(yeuCauPanel, sv);
		
		
		
		

	}
	public void thongTin(JPanel thongtinPanel,Sinhvien sv)
	{
		JLabel lblThngTinC = new JLabel("THÔNG TIN CÁ NHÂN CỦA SINH VIÊN");
		lblThngTinC.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngTinC.setForeground(Color.WHITE);
		lblThngTinC.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblThngTinC.setBounds(10, 59, 1180, 51);
		thongtinPanel.add(lblThngTinC);
		
		JLabel idLabel = new JLabel("Mã số sinh viên");
		idLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		idLabel.setForeground(Color.WHITE);
		idLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		idLabel.setBounds(215, 155, 134, 27);
		thongtinPanel.add(idLabel);
		
		JLabel nameLabel = new JLabel("Họ và tên");
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		nameLabel.setBounds(215, 225, 134, 27);
		thongtinPanel.add(nameLabel);
		
		JLabel classLabel = new JLabel("Lớp");
		classLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		classLabel.setForeground(Color.WHITE);
		classLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		classLabel.setBounds(215, 305, 134, 27);
		thongtinPanel.add(classLabel);
		
		JLabel sexLabel = new JLabel("Giới tính");
		sexLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		sexLabel.setForeground(Color.WHITE);
		sexLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		sexLabel.setBounds(215, 375, 134, 27);
		thongtinPanel.add(sexLabel);
		
		JLabel cmndLabel = new JLabel("Chứng minh nhân dân");
		cmndLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		cmndLabel.setForeground(Color.WHITE);
		cmndLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		cmndLabel.setBounds(154, 455, 195, 27);
		thongtinPanel.add(cmndLabel);
		
		JLabel idText = new JLabel("");
		idText.setHorizontalAlignment(SwingConstants.LEFT);
		idText.setForeground(Color.WHITE);
		idText.setFont(new Font("Times New Roman", Font.BOLD, 20));
		idText.setBounds(454, 155, 366, 27);
		thongtinPanel.add(idText);
		
		JLabel nameText = new JLabel("");
		nameText.setHorizontalAlignment(SwingConstants.LEFT);
		nameText.setForeground(Color.WHITE);
		nameText.setFont(new Font("Times New Roman", Font.BOLD, 20));
		nameText.setBounds(454, 225, 366, 27);
		thongtinPanel.add(nameText);
		
		JLabel classText = new JLabel("");
		classText.setHorizontalAlignment(SwingConstants.LEFT);
		classText.setForeground(Color.WHITE);
		classText.setFont(new Font("Times New Roman", Font.BOLD, 20));
		classText.setBounds(454, 305, 366, 27);
		thongtinPanel.add(classText);
		
		JLabel sexText = new JLabel("");
		sexText.setHorizontalAlignment(SwingConstants.LEFT);
		sexText.setForeground(Color.WHITE);
		sexText.setFont(new Font("Times New Roman", Font.BOLD, 20));
		sexText.setBounds(454, 375, 366, 27);
		thongtinPanel.add(sexText);
		
		JLabel cmndText = new JLabel("");
		cmndText.setHorizontalAlignment(SwingConstants.LEFT);
		cmndText.setForeground(Color.WHITE);
		cmndText.setFont(new Font("Times New Roman", Font.BOLD, 20));
		cmndText.setBounds(454, 455, 366, 27);
		thongtinPanel.add(cmndText);
		
		idText.setText(sv.getMaSV());
		nameText.setText(sv.getHoTen());
		classText.setText(sv.getLop().getMaLop());
		sexText.setText(sv.getGioiTinh());
		cmndText.setText(sv.getCmnd());
	}
	
	public void bangDiem(JPanel diemPanel,Sinhvien sv)
	{
		JLabel titleLabel = new JLabel("BẢNG ĐIỂM SINH VIÊN");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("Cambria", Font.BOLD, 26));
		titleLabel.setBounds(10, 32, 1180, 45);
		diemPanel.add(titleLabel);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBackground(new Color(44,62,80));
		tablePanel.setBounds(15, 122, 1170, 442);
		diemPanel.add(tablePanel);
		tablePanel.setLayout(null);
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("STT");model.addColumn("Mã lớp");model.addColumn("Mã môn");
		model.addColumn("Điểm giữa kì");model.addColumn("Điểm cuối kì");
		model.addColumn("Điểm khác");model.addColumn("Điểm tống");model.addColumn("Kết quả");
		int i = 1;
		ThamgiaDAO tg = new ThamgiaDAO();
		for (Thamgia t:tg.layMonThamGia(sv.getMaSV()))
		{
			if (t.isDuyet()==true)
			{
				model.addRow(new Object[] {i,t.getMon().getLopHoc().getMaLop(),t.getMon().getMaMon(),
						(t.getDiemGK()!=null)?t.getDiemGK():"-",(t.getDiemCK()!=null)?t.getDiemCK():"-",
								(t.getDiemKhac()!=null)?t.getDiemKhac():"-",
										(t.getDiemTong()!=null)?t.getDiemTong():"-",
						(t.getDiemTong()!=null)?(t.getDiemTong().compareTo(new BigDecimal("5"))>=0?
								"Đậu":"Rớt"):"-"});
				i++;
			}
		}
		if (i>1)
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
			scrollPane.setBounds(35,5,1100,437);
	
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			int column = table.getColumnModel().getColumnCount();
			
			for (int k=0;k<column;k++)
			{
				table.getColumnModel().getColumn(k).setCellRenderer(centerRenderer);
			}
		}
		else
		{
			JLabel label = new JLabel("Không có môn học");
			
			tablePanel.add(label);
			label.setBounds(35,5,1100,437);
			label.setVerticalAlignment(JLabel.CENTER);
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setFont(new Font("Times New Roman", Font.BOLD, 24));
			label.setForeground(Color.WHITE);
		}
	}
	public void yeuCau(JPanel yeuCauPanel,Sinhvien sv)
	{
		JLabel lblNewLabel = new JLabel("Loại yêu cầu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(148, 46, 201, 35);
		yeuCauPanel.add(lblNewLabel);
		
		JLabel titleLabel = new JLabel("");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		titleLabel.setBounds(10, 165, 1180, 37);
		yeuCauPanel.add(titleLabel);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(null);
		tablePanel.setBackground(new Color(44, 62, 80));
		tablePanel.setBounds(15, 209, 1170, 355);
		yeuCauPanel.add(tablePanel);
		
		JComboBox<String> yeucauBox = new JComboBox<String>();
		yeucauBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yeucau_yeucauFlag = true;
			}
		});
		yeucauBox.setForeground(Color.WHITE);
		yeucauBox.setFont(new Font("Times New Roman", Font.BOLD, 19));
		yeucauBox.setBackground(new Color(108, 122, 137));
		yeucauBox.setBounds(369, 47, 500, 35);
		yeucauBox.addItem("Xin phép rút môn học");
		yeucauBox.addItem("Xin phép đăng kí môn học");
		yeuCauPanel.add(yeucauBox);
		
		JButton execButton = new JButton("Xem danh sách môn");
		execButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!yeucau_yeucauFlag)
				{
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn loại yêu cầu!");
				}
				else
				{
					if (!yeucauFlag)
					{
						tablePanel.removeAll();
						tablePanel.setLayout(null);
					}
					ThamgiaDAO tg = new ThamgiaDAO();
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("STT");model.addColumn("Lớp");model.addColumn("Mã môn");
					model.addColumn("Tên môn");model.addColumn("Xác nhận");
					int i = 1;
					if (yeucauBox.getSelectedIndex()==0)
					{
						List<Thamgia> tgs = tg.layMonThamGia(sv.getMaSV());
						
						if (tgs.size()>0)
						{	
							for (Thamgia t:tgs)
							{
								
								model.addRow(new Object[] {i,t.getMon().getLopHoc().getMaLop(),
										t.getMon().getMaMon(),t.getMon().getTenMon(),"Rút môn"});
							}
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
							table.addMouseListener(new java.awt.event.MouseAdapter() {
								@Override
								 public void mouseClicked(java.awt.event.MouseEvent evt) {
								    int row = table.rowAtPoint(evt.getPoint());
								    int col = table.columnAtPoint(evt.getPoint());
								    if (row >= 0 && col == 4) {
								    	tg.yeuCauRutMon(tgs.get(row));
										JOptionPane.showMessageDialog(null, "Gửi yêu cầu thành công");
								    	model.removeRow(row);
								    }
								 }
								});
							table.setForeground(Color.WHITE);
							table.setBackground(new Color(44,62,80));
							table.setFont(new Font("Times New Roman", Font.BOLD, 18));
							table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
							table.setFillsViewportHeight(true);
							JScrollPane scrollPane = new JScrollPane(table);
							scrollPane.setViewportView(table);
							tablePanel.add(scrollPane);
							scrollPane.setBounds(35,5,1100,350);
					
							DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
							centerRenderer.setHorizontalAlignment( JLabel.CENTER );
							int column = table.getColumnModel().getColumnCount();
							
							for (int k=0;k<column;k++)
							{
								table.getColumnModel().getColumn(k).setCellRenderer(centerRenderer);
							}
						}
						else
						{
							JLabel label = new JLabel("Không tham gia môn học nào");						
							tablePanel.add(label);
							label.setBounds(35,5,1100,350);
							label.setVerticalAlignment(JLabel.CENTER);
							label.setHorizontalAlignment(JLabel.CENTER);
							label.setFont(new Font("Times New Roman", Font.BOLD, 24));
							label.setForeground(Color.WHITE);
						}
					}
					else
					{
						MonDAO mDAO = new MonDAO();
						List<Mon> mons = mDAO.layMonKhongThamGia(sv);
						if (mons.size()>0)
						{
							for (Mon mon:mons)
							{
								model.addRow(new Object[] {i,mon.getLopHoc().getMaLop(),
										mon.getMaMon(),mon.getTenMon(),"Đăng ký"});
							}
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
							
							table.addMouseListener(new java.awt.event.MouseAdapter() {
								@Override
								 public void mouseClicked(java.awt.event.MouseEvent evt) {
								    int row = table.rowAtPoint(evt.getPoint());
								    int col = table.columnAtPoint(evt.getPoint());
								    if (row >= 0 && col == 4) {
								    	tg.yeuCauThamGia((String)model.getValueAt(row, 1), 
								    			(String)model.getValueAt(row, 2), sv);
										JOptionPane.showMessageDialog(null, "Gửi yêu cầu thành công");
								    	model.removeRow(row);
								    }
								 }
								});
							table.setForeground(Color.WHITE);
							table.setBackground(new Color(44,62,80));
							table.setFont(new Font("Times New Roman", Font.BOLD, 18));
							table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
							table.setFillsViewportHeight(true);
							JScrollPane scrollPane = new JScrollPane(table);
							scrollPane.setViewportView(table);
							tablePanel.add(scrollPane);
							scrollPane.setBounds(35,5,1100,350);
					
							DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
							centerRenderer.setHorizontalAlignment( JLabel.CENTER );
							int column = table.getColumnModel().getColumnCount();
							
							for (int k=0;k<column;k++)
							{
								table.getColumnModel().getColumn(k).setCellRenderer(centerRenderer);
							}
						}
						else
						{
							JLabel label = new JLabel("Không có môn nào");						
							tablePanel.add(label);
							label.setBounds(35,5,1100,350);
							label.setVerticalAlignment(JLabel.CENTER);
							label.setHorizontalAlignment(JLabel.CENTER);
							label.setFont(new Font("Times New Roman", Font.BOLD, 24));
							label.setForeground(Color.WHITE);
						}
					}
					yeucauFlag = false;
				}
			}
		});
		execButton.setForeground(Color.WHITE);
		execButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		execButton.setBackground(new Color(34, 67, 240));
		execButton.setBounds(521, 118, 199, 30);
		yeuCauPanel.add(execButton);
		
		
	}
	
	
}





