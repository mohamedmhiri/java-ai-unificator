package tn.insat;

import java.awt.EventQueue;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class swing{

	private JFrame frame;
	private JPanel contentPane;
	private JTextField Exp1;
	private JTextField Exp2;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swing window = new swing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public swing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
			
		JLabel exp1 = new JLabel("expression 1 :");
		exp1.setBounds(47, 104, 100, 14);
		contentPane.add(exp1);
		
		JLabel exp2 = new JLabel("expression 2:");
		exp2.setBounds(47, 150, 100, 14);
		contentPane.add(exp2);
		
		Exp1 = new JTextField();
		Exp1.setBounds(200, 104, 150, 14);
		contentPane.add(Exp1);
		Exp1.setColumns(10);
		
		Exp2 = new JTextField();
		Exp2 .setBounds(200, 150, 150, 14);
		contentPane.add(Exp2 );
		Exp2 .setColumns(10);
		
		
		JButton DemarrerUnification = new JButton("Demarrer Unification");
		DemarrerUnification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String expression1 =Exp1.getText();
				String expression2 =Exp2.getText();
				
			
				
				List<String> expr1=new ArrayList<String>();
				List<String> expr2=new ArrayList<String>();
				expr1.add(expression1);
				expr2.add(expression2);
			Unification u=new Unification();
String ch=u.unifier(expr1,expr2);
System.out.println(ch);
Frame frame2 = new Frame(ch);

				frame.dispose();
				frame2.setVisible(true);
							}
		});
		DemarrerUnification.setBounds(266, 227, 158, 23);
		contentPane.add(DemarrerUnification);
		
	}
}
