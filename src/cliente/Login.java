package cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField usuario;
	private JPasswordField senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		//--
//		Image img = new ImageIcon("/lib/background.png").getImage(); 
//		getContentPane().add(comp, constraints);
		//--
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("USU\u00C1RIO:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(53, 73, 60, 14);
		contentPane.add(lblNome);
		
		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setBounds(53, 123, 60, 14);
		contentPane.add(lblSenha);
		
		JButton btnVerificarUsuario = new JButton("VERIFICAR USUARIO");
		btnVerificarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Main cliente = new Main();
				String textoUsuario = usuario.getText();
				char[] senhaGet = senha.getPassword();


//				System.out.println(textoUsuario);
				try {
//					cliente.verifica("adm");
					Main cliente = new Main();
					cliente.verifica(textoUsuario, senhaGet);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnVerificarUsuario.setBounds(53, 183, 165, 23);
		contentPane.add(btnVerificarUsuario);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancelar.setBounds(279, 183, 103, 23);
		contentPane.add(btnCancelar);
		
		usuario = new JTextField();
		usuario.setBounds(123, 70, 259, 20);
		contentPane.add(usuario);
		usuario.setColumns(10);
		
		senha = new JPasswordField();
		senha.setBounds(125, 120, 257, 20);
		contentPane.add(senha);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/lib/bg.png")));
		label.setBounds(0, 0, 434, 261);
		contentPane.add(label);
	}
}
