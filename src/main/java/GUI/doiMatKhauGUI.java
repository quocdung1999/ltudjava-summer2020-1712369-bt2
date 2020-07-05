package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Class.Giaovu;
import Class.Sinhvien;
import ClassDAO.GiaovuDAO;
import ClassDAO.SinhvienDAO;

public class doiMatKhauGUI extends JFrame implements FocusListener {

	private JPanel contentPane;
	private JPanel bodyPanel = new JPanel();
	private JTextField oldPassText;
	private JTextField newPassText;
	private JTextField confirmText;
	/**
	 * Create the frame.
	 */
	public doiMatKhauGUI(Object o, boolean isSinhVien) {
		setResizable(false);
		setTitle("Đổi mật khẩu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 450);
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
		
		JLabel headerLabel = new JLabel("ĐỔI MẬT KHẨU");
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setForeground(Color.WHITE);
		headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		headerLabel.setBounds(130, 0, 357, 44);
		headerPanel.add(headerLabel);
		
		
		bodyPanel.setBounds(0, 45, 594, 378);
		bodyPanel.setBackground(new Color(44,62,80));
		contentPane.add(bodyPanel);
		bodyPanel.setLayout(null);
		
		JLabel oldPassLabel = new JLabel("Mật khẩu hiện tại");
		oldPassLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		oldPassLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		oldPassLabel.setForeground(Color.WHITE);
		oldPassLabel.setBounds(41, 50, 134, 27);
		bodyPanel.add(oldPassLabel);
		
		JLabel newPassLabel = new JLabel("Mật khẩu mới");
		newPassLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		newPassLabel.setForeground(Color.WHITE);
		newPassLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		newPassLabel.setBounds(41, 130, 134, 27);
		bodyPanel.add(newPassLabel);
		
		JLabel confirmLabel = new JLabel("Nhập lại mật khẩu ");
		confirmLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		confirmLabel.setForeground(Color.WHITE);
		confirmLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		confirmLabel.setBounds(22, 209, 153, 27);
		bodyPanel.add(confirmLabel);
		
		newPassText = new JTextField();
		newPassText.setForeground(Color.WHITE);
		newPassText.setFont(new Font("Times New Roman", Font.BOLD, 16));
		newPassText.setBackground(new Color(108,122,137));
		newPassText.setBounds(229, 130, 273, 25);
		bodyPanel.add(newPassText);
		newPassText.setColumns(10);
		newPassText.addFocusListener(this);
		
		oldPassText = new JTextField();
		oldPassText.setForeground(Color.WHITE);
		oldPassText.setFont(new Font("Times New Roman", Font.BOLD, 16));
		oldPassText.setColumns(10);
		oldPassText.setBackground(new Color(108, 122, 137));
		oldPassText.setBounds(229, 50, 273, 25);
		bodyPanel.add(oldPassText);
		oldPassText.addFocusListener(this);
		
		confirmText = new JTextField();
		confirmText.setForeground(Color.WHITE);
		confirmText.setFont(new Font("Times New Roman", Font.BOLD, 16));
		confirmText.setColumns(10);
		confirmText.setBackground(new Color(108, 122, 137));
		confirmText.setBounds(229, 210, 273, 25);
		bodyPanel.add(confirmText);
		confirmText.addFocusListener(this);
		
		JButton execButton = new JButton("Đổi mật khẩu");
		execButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (newPassText.getText().compareTo(confirmText.getText())!=0)
				{
					JOptionPane.showMessageDialog(null, "Mật khẩu xác nhận không trùng khớp với mật khẩu mới!");
				}
				else
				{
					if (newPassText.getText().compareTo(oldPassText.getText())==0)
						JOptionPane.showMessageDialog(null, "Mật khẩu mới trùng với mật khẩu cũ!");
					else
					{
						if (isSinhVien)
						{
							SinhvienDAO sv = new SinhvienDAO();
							if(!sv.doiMatKhau((Sinhvien) o, oldPassText.getText(), newPassText.getText()))
							{
								JOptionPane.showMessageDialog(null, "Mật khẩu không hợp lệ!");
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công!");
								dispose();
							}
						}
						else
						{
							GiaovuDAO gv = new GiaovuDAO();
							if(!gv.doiMatKhau((Giaovu) o, oldPassText.getText(), newPassText.getText()))
							{
								JOptionPane.showMessageDialog(null, "Mật khẩu không hợp lệ!");
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công!");
							}	
						}
					}
				}
			}
		});
		execButton.setForeground(Color.WHITE);
		execButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		execButton.setBackground(new Color(34, 167, 240));
		execButton.setBounds(229, 288, 125, 33);
		bodyPanel.add(execButton);
		

		
		
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
