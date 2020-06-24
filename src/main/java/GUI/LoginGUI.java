package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

import ClassDAO.*;
import Class.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class LoginGUI extends JFrame {
	private JTextField usernameText;
	private JPasswordField passwordField;
	private GiaovuDAO gvDao = new GiaovuDAO();
	private SinhvienDAO svDao = new SinhvienDAO();
	
	public LoginGUI() {
		setResizable(false);
		getContentPane().setBackground(new Color(44, 62, 80));
		setAlwaysOnTop(true);
		setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 454);
		setTitle("Quản lý sinh viên");
		setLocationRelativeTo(null);
		
		JPanel middlePanel = new JPanel();
		middlePanel.setBounds(55, 140, 540, 150);
		getContentPane().add(middlePanel);
		middlePanel.setLayout(null);
		middlePanel.setBackground(new Color(44,62,80));
		
		JLabel usernameLabel = new JLabel("Tài khoản");
		usernameLabel.setForeground(new Color(255, 255, 255));
		usernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setBounds(10, 20, 88, 35);
		middlePanel.add(usernameLabel);
		
		usernameText = new JTextField();
		usernameText.setForeground(Color.WHITE);
		usernameText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				usernameText.setCaretColor(Color.WHITE);
			}
		});
		usernameText.setFont(new Font("Times New Roman", Font.BOLD, 14));
		usernameText.setToolTipText("Nhập tên tài khoản tại đây");
		usernameText.setBounds(127, 21, 368, 34);
		usernameText.setBackground(new Color(108,122,137));
		usernameLabel.setForeground(new Color(228,241,254));
		middlePanel.add(usernameText);
		usernameText.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Mật khẩu");
		passwordLabel.setForeground(new Color(255, 255, 255));
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		passwordLabel.setBounds(10, 76, 88, 35);
		passwordLabel.setForeground(new Color(228,241,254));
		middlePanel.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.WHITE);
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				passwordField.setCaretColor(Color.WHITE);
			}
		});
		passwordField.setBounds(127, 76, 368, 35);
		passwordField.setBackground(new Color(108,122,137));
		middlePanel.add(passwordField);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBounds(55, 50, 540, 81);
		headerPanel.setBackground(new Color(44,62,80));
		getContentPane().add(headerPanel);
		headerPanel.setLayout(null);
		
		JLabel loginLabel = new JLabel("Đăng nhập");
		loginLabel.setForeground(new Color(255, 255, 255));
		loginLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setBounds(190, 19, 147, 51);
		headerPanel.add(loginLabel);
		
		
		JButton loginButton = new JButton("Đăng nhập");
		loginButton.setBackground(new Color(34,167,240));
		loginButton.setForeground(Color.WHITE);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		buttonPanel.setBounds(55, 301, 540, 73);
		buttonPanel.setBackground(new Color(44,62,80));
		getContentPane().add(buttonPanel);
		loginButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		loginButton.setBounds(205, 11, 116, 33);
		buttonPanel.add(loginButton);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(255, 140, 0));
		topPanel.setBounds(0, 0, 644, 49);
		getContentPane().add(topPanel);
		topPanel.setLayout(null);
		
		JLabel headerLabel = new JLabel("Ứng dụng quản lý sinh viên");
		headerLabel.setForeground(new Color(255, 255, 255));
		headerLabel.setBounds(188, 16, 260, 22);
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setFont(new Font("Consolas", Font.BOLD, 18));
		topPanel.add(headerLabel);
		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkIdentity(usernameText, passwordField);
			}
		});
		usernameText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()== KeyEvent.VK_ENTER)
				{
					checkIdentity(usernameText, passwordField);
				}
			}
		});
		
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()== KeyEvent.VK_ENTER)
				{
					checkIdentity(usernameText, passwordField);
				}
			}
		});
	}
	public void checkIdentity( JTextField usernameText, JPasswordField passwordField)
	{
		String username = usernameText.getText();
		String password = new String (passwordField.getPassword());
		boolean flag = false;
		for (Sinhvien sv : svDao.layDanhSachSV())
		{
			if (sv.getMaSV().compareTo(username)==0 && sv.getPassword().compareTo(password)==0)
			{
				dispose();
				SinhvienGUI svGUI = new SinhvienGUI(sv);
				flag = true;
				break;
			}
		}
		if (!flag)
		{
			for (Giaovu gv : gvDao.layDanhSachGV())
			{
				if (gv.getUsername().compareTo(username)==0 && gv.getPassword().compareTo(password)==0)
				{
					dispose();
					GiaovuGUI gvGUI = new GiaovuGUI(gv);
					flag = true;
					break;
				}
			}
		}
		if (!flag)
		{
			JOptionPane.showMessageDialog(usernameText, "Tài khoản hoặc mật khẩu không đúng! Vui lòng nhập lại!");
		}
	}
}
