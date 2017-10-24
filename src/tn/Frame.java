package tn.insat;


	
	import java.awt.BorderLayout;

	import java.awt.EventQueue;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.util.ArrayList;
	import java.util.List;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JTextArea;
	import javax.swing.JTextField;
	import javax.swing.border.EmptyBorder;

	public class Frame extends JFrame {

		private JPanel contentPane;
		private String resultat;
		private JTextField resultatRecherche;
		/**
		 * Launch the application.
		 */
		/*public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Frame2 frame = new Frame2();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}*/

		/**
		 * Create the frame.
		 */
		public Frame(String resultat) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100,100, 559, 332);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			this.resultat=resultat;
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblLeResultatDe = new JLabel("Le resultat d'unification : ");
			lblLeResultatDe.setBounds(24, 44, 180, 14);
			contentPane.add(lblLeResultatDe);
			
			resultatRecherche = new JTextField();
			resultatRecherche.setBounds(190, 41, 500, 20);
			contentPane.add(resultatRecherche);
			resultatRecherche.setColumns(10);
			
			if (resultat.equals("echec")) {
				resultatRecherche.setText("unification impossible");
			}
			else {
				resultatRecherche.setText("resultat d unification est: "+resultat);
			}
			
			JButton btnNewButton = new JButton("R\u00E9essayer");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Frame.this.dispose();
					swing frame1 = new swing();
					
					frame1.main(null);
				}
			});
			btnNewButton.setBounds(268, 234, 139, 23);
			contentPane.add(btnNewButton);
			
		}
	}


