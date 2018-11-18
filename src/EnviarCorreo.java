import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sun.mail.handlers.message_rfc822;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EnviarCorreo {

	private JFrame frmEnviarEmail;
	private JTextField destinotxt;
	private JTextField asuntotxt;
	private JTextField mensajetxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnviarCorreo window = new EnviarCorreo();
					window.frmEnviarEmail.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Correo c = new Correo();
	public EnviarCorreo() {
		initialize();
	}

	public void EnviarEmail() {
		c.setContrasenia("ypbxkkfvdyyelmkf");
		c.setUsuarioCorreo("2995mariana@gmail.com");
		c.setAsunto(asuntotxt.getText());
		c.setMensaje(mensajetxt.getText());
		c.setDestino(destinotxt.getText().trim());
		c.setNombreArchivo("");
		c.setRutaArchivo("");
		Controlador cont = new Controlador();
		if (cont.enviarCorreo(c)) {
			JOptionPane.showMessageDialog(null, "El correo fue enviado correctamente");
		} else {
			JOptionPane.showMessageDialog(null, "Error");
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEnviarEmail = new JFrame();
		frmEnviarEmail.setTitle("Enviar Email");
		frmEnviarEmail.setBounds(100, 100, 450, 300);
		frmEnviarEmail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEnviarEmail.getContentPane().setLayout(null);
		
		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setBounds(25, 27, 70, 15);
		frmEnviarEmail.getContentPane().add(lblDestino);
		
		JLabel lblAsunto = new JLabel("Asunto");
		lblAsunto.setBounds(25, 54, 70, 15);
		frmEnviarEmail.getContentPane().add(lblAsunto);
		
		destinotxt = new JTextField();
		destinotxt.setBounds(101, 25, 307, 19);
		frmEnviarEmail.getContentPane().add(destinotxt);
		destinotxt.setColumns(10);
		
		asuntotxt = new JTextField();
		asuntotxt.setColumns(10);
		asuntotxt.setBounds(101, 52, 307, 19);
		frmEnviarEmail.getContentPane().add(asuntotxt);
		
		mensajetxt = new JTextField();
		mensajetxt.setBounds(25, 81, 383, 148);
		frmEnviarEmail.getContentPane().add(mensajetxt);
		mensajetxt.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnviarEmail();
			}
		});
		btnEnviar.setBounds(291, 241, 117, 25);
		frmEnviarEmail.getContentPane().add(btnEnviar);
	}
}
