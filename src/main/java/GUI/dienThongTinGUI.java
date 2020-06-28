package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Class.*;
import ClassDAO.*;
import org.w3c.dom.events.MouseEvent;

import javassist.expr.Instanceof;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import javax.swing.JComboBox;

public class dienThongTinGUI extends JFrame implements FocusListener{

	private JPanel contentPane;
	private JPanel bodyPanel = new JPanel();
	private JTextField idText;
	private JTextField passText;
	private JTextField nameText;
	private JTextField classText;
	private JTextField cmndText;
	/**
	 * Create the frame.
	 */
	public dienThongTinGUI() {
		setResizable(false);
		setTitle("Điền thông tin sinh viên");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 700);
		contentPane = new JPanel();
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setVisible(true);
		contentPane.setLayout(null);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBounds(0, 0, 594, 46);
		contentPane.add(headerPanel);
		headerPanel.setLayout(null);
		headerPanel.setBackground(new Color(255,140,0));
		
		JLabel headerLabel = new JLabel("ĐIỀN THÔNG TIN SINH VIÊN");
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setForeground(Color.WHITE);
		headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		headerLabel.setBounds(130, 0, 357, 44);
		headerPanel.add(headerLabel);
		
		
		bodyPanel.setBounds(0, 45, 594, 626);
		bodyPanel.setBackground(new Color(44,62,80));
		contentPane.add(bodyPanel);
		bodyPanel.setLayout(null);
		
		JLabel idLabel = new JLabel("Mã số sinh viên");
		idLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		idLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		idLabel.setForeground(Color.WHITE);
		idLabel.setBounds(41, 50, 134, 27);
		bodyPanel.add(idLabel);
		
		JLabel passLabel = new JLabel("Mật khẩu");
		passLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		passLabel.setForeground(Color.WHITE);
		passLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		passLabel.setBounds(41, 130, 134, 27);
		bodyPanel.add(passLabel);
		
		JLabel nameLabel = new JLabel("Họ và tên");
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		nameLabel.setBounds(41, 210, 134, 27);
		bodyPanel.add(nameLabel);
		
		JLabel classLabel = new JLabel("Lớp");
		classLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		classLabel.setForeground(Color.WHITE);
		classLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		classLabel.setBounds(41, 290, 134, 27);
		bodyPanel.add(classLabel);
		
		JLabel sexLabel = new JLabel("Giới tính");
		sexLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		sexLabel.setForeground(Color.WHITE);
		sexLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		sexLabel.setBounds(41, 370, 134, 27);
		bodyPanel.add(sexLabel);
		
		JLabel cmndLabel = new JLabel("Chứng minh nhân dân");
		cmndLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		cmndLabel.setForeground(Color.WHITE);
		cmndLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		cmndLabel.setBounds(2, 450, 173, 27);
		bodyPanel.add(cmndLabel);
		
		passText = new JTextField();
		passText.setForeground(Color.WHITE);
		passText.setFont(new Font("Times New Roman", Font.BOLD, 16));
		passText.setBackground(new Color(108,122,137));
		passText.setBounds(229, 130, 273, 25);
		bodyPanel.add(passText);
		passText.setColumns(10);
		passText.addFocusListener(this);
		
		idText = new JTextField();
		idText.setForeground(Color.WHITE);
		idText.setFont(new Font("Times New Roman", Font.BOLD, 16));
		idText.setColumns(10);
		idText.setBackground(new Color(108, 122, 137));
		idText.setBounds(229, 50, 273, 25);
		bodyPanel.add(idText);
		idText.addFocusListener(this);
		
		nameText = new JTextField();
		nameText.setForeground(Color.WHITE);
		nameText.setFont(new Font("Times New Roman", Font.BOLD, 16));
		nameText.setColumns(10);
		nameText.setBackground(new Color(108, 122, 137));
		nameText.setBounds(229, 210, 273, 25);
		bodyPanel.add(nameText);
		nameText.addFocusListener(this);
		
		classText = new JTextField();
		classText.setForeground(Color.WHITE);
		classText.setFont(new Font("Times New Roman", Font.BOLD, 16));
		classText.setColumns(10);
		classText.setBackground(new Color(108, 122, 137));
		classText.setBounds(229, 290, 273, 25);
		bodyPanel.add(classText);
		classText.addFocusListener(this);
		
		cmndText = new JTextField();
		cmndText.setForeground(Color.WHITE);
		cmndText.setFont(new Font("Times New Roman", Font.BOLD, 16));
		cmndText.setColumns(10);
		cmndText.setBackground(new Color(108, 122, 137));
		cmndText.setBounds(229, 452, 273, 25);
		bodyPanel.add(cmndText);
		cmndText.addFocusListener(this);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 16));
		comboBox.setBounds(229, 370, 93, 25);
		comboBox.addItem("Nam");comboBox.addItem("Nữ");
		bodyPanel.add(comboBox);
		
		JButton addButton = new JButton("Thêm sinh viên");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SinhvienDAO svDAO = new SinhvienDAO();
				LopDAO lopDAO = new LopDAO();
				Lop l = lopDAO.kiemTra(classText.getText());
				Sinhvien s = new Sinhvien(idText.getText(),l,passText.getText(),false,nameText.getText(),
						(String)comboBox.getSelectedItem(),cmndText.getText());
				svDAO.themSinhVien(s);
			}
		});
		addButton.setForeground(Color.WHITE);
		addButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		addButton.setBackground(new Color(34, 167, 240));
		addButton.setBounds(229, 541, 125, 33);
		bodyPanel.add(addButton);
		
		
	}
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		for (Component c:bodyPanel.getComponents())
		{
			if (c instanceof JTextField )
			{
				((JTextField) c).setCaretColor(Color.WHITE);
			}
		}
		
	}
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
}



