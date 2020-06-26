package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

import Class.*;
import ClassDAO.*;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;


public class GiaovuGUI extends JFrame {
	private JTable table;
	private boolean flag = true;
	private JTable table_1;
	/**
	 * Create the frame.
	 */
	public GiaovuGUI(Giaovu gv) {
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 378);
		setSize(1200,700);
		setTitle("Quản lý sinh viên");
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
		welcomeLabel.setBounds(936, 11, 236, 19);
		headerPanel.add(welcomeLabel);
		welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("QUẢN LÝ SINH VIÊN");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setBounds(460, 15, 321, 44);
		headerPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Đổi mật khẩu");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(1015, 34, 85, 25);
		headerPanel.add(lblNewLabel_2);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.setBounds(0, 70, 1200, 630);
		tabbedPane.setBackground(new Color(44,62,80));
		getContentPane().add(tabbedPane);
		
		JPanel dslopPanel = new JPanel();
		dslopPanel.setBackground(new Color(44,62,80));
		tabbedPane.addTab("Danh sách lớp", null, dslopPanel, null);
		dslopPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chọn lớp");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel.setBounds(62, 42, 95, 30);
		dslopPanel.add(lblNewLabel);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBackground(new Color(44,62,80));
		tablePanel.setBounds(10, 99, 1175, 466);
		dslopPanel.add(tablePanel);
		tablePanel.setLayout(null);
		
		
		JComboBox<String> comboBox = new JComboBox<String>();
		themLop(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!flag)
					tablePanel.removeAll();
				DefaultTableModel model = new DefaultTableModel();
				
				model.addColumn("STT");model.addColumn("MSSV");model.addColumn("Họ và tên");
				model.addColumn("Lớp");model.addColumn("Giới tính");model.addColumn("CMND");
				
				String lopChon =(String) comboBox.getSelectedItem();
				LopDAO l = new LopDAO();
				List<Sinhvien> s = l.layDanhSachSinhvien(lopChon);
				int i = 1;
				for (Sinhvien sv:s)
				{
					model.addRow(new Object[] {i,sv.getMaSV(),sv.getHoTen(),sv.getLop().getMaLop()
							,sv.getGioiTinh(),sv.getCmnd()});
					i++;
				}
				
				JTable table = new JTable(model);
				table.setForeground(Color.WHITE);
				table.setBackground(new Color(44,62,80));
				tablePanel.add(table);
				table.setBounds(10, 11, 1155, 444);
				flag = false;
			}
		});
		
		
		
		((JLabel) comboBox.getRenderer()).setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		comboBox.setForeground(Color.WHITE);
		comboBox.setBackground(new Color(108,122,137));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		comboBox.setBounds(303, 43, 367, 30);
		dslopPanel.add(comboBox);
		
		JButton importButton = new JButton("Import CSV");
		importButton.setForeground(Color.WHITE);
		importButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		importButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		importButton.setBounds(1003, 39, 128, 40);
		importButton.setBackground(new Color(34,67,240));
		dslopPanel.add(importButton);
		
		
		
		
		
		JPanel tkbPanel = new JPanel();
		tkbPanel.setBackground(new Color(44,62,80));
		tabbedPane.addTab("Thời khóa biểu", null, tkbPanel, null);
		tkbPanel.setLayout(null);
		
		JPanel diemPanel = new JPanel();
		diemPanel.setBackground(new Color(44,62,80));
		tabbedPane.addTab("Bảng điểm", null, diemPanel, null);
		diemPanel.setLayout(null);
		
		JPanel yeucauPanel = new JPanel();
		yeucauPanel.setBackground(new Color(44,62,80));
		tabbedPane.addTab("Duyệt yêu cầu", null, yeucauPanel, null);
		yeucauPanel.setLayout(null);
		
	}
	public void themLop(JComboBox<String> j)
	{
		LopDAO lDAO = new LopDAO();
		List<Lop> l = lDAO.layDanhSachLop();
		for (Lop k:l)
		{
			j.addItem(k.getMaLop());
		}
	}
}
