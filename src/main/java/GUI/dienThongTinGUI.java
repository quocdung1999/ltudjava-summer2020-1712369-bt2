package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class dienThongTinGUI extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public dienThongTinGUI() {
		setResizable(false);
		setTitle("Điền thông tin sinh viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 700);
		contentPane = new JPanel();
		setContentPane(contentPane);
		setLocationRelativeTo(null);
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
		
		JPanel bodyPanel = new JPanel();
		bodyPanel.setBounds(0, 45, 594, 626);
		bodyPanel.setBackground(new Color(44,62,80));
		contentPane.add(bodyPanel);
	}
}
