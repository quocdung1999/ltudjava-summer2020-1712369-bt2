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
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.Color;

public class LoginGUI extends JFrame {
	private JTextField usernameText;
	private JTextField passwordText;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
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
		
		passwordText = new JTextField();
		passwordText.setFont(new Font("Times New Roman", Font.BOLD, 14));
		passwordText.setToolTipText("Nhập mật khẩu tại đây");
		passwordText.setColumns(10);
		passwordText.setBounds(127, 77, 368, 34);
		passwordText.setBackground(new Color(108,122,137));
		middlePanel.add(passwordText);
		
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
		topPanel.setBounds(0, 0, 634, 49);
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
				
			}
		});
		
	}
}
