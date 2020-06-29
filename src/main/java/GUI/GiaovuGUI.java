package GUI;


import java.awt.Color;
import java.awt.Component;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

import Class.*;
import ClassDAO.*;
import CsvHandler.Csv;

import javax.swing.SwingConstants;
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
		GiaovuGUITabs.danhSachLop(dslopPanel, gv);
		
		
	
		
		
		// THỜI KHÓA BIỂU
		
		
		JPanel tkbPanel = new JPanel();
		tkbPanel.setBackground(new Color(44,62,80));
		tabbedPane.addTab("Thời khóa biểu", null, tkbPanel, null);
		tkbPanel.setLayout(null);
		
		
		
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
