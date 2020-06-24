package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagConstraints;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Class.Giaovu;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import java.awt.Font;


public class GiaovuGUI extends JFrame {
	/**
	 * Create the frame.
	 */
	public GiaovuGUI(Giaovu gv) {
		setVisible(true);
		setSize(695,449);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 378);
		setSize(800,450);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBounds(0, 0, 784, 36);
		getContentPane().add(headerPanel);
		headerPanel.setLayout(null);
		
		String name = gv.getUsername();
		JLabel welcomeLabel = new JLabel(name);
		welcomeLabel.setBounds(655, 11, 119, 19);
		headerPanel.add(welcomeLabel);
		welcomeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		
	}
}
