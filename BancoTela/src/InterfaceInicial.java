import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class InterfaceInicial extends JFrame {

	private JPanel contentPane;
	private JTextField txtDadosDoUsuario;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	private JPasswordField passwordFieldSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		new ConnectionFactory().conectar();

		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceInicial frame = new InterfaceInicial();
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
	public InterfaceInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtDadosDoUsuario = new JTextField();
		txtDadosDoUsuario.setForeground(Color.BLACK);
		txtDadosDoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDadosDoUsuario.setEditable(false);
		txtDadosDoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtDadosDoUsuario.setText("DADOS DO USUARIO\r\n");
		txtDadosDoUsuario.setBounds(206, 50, 151, 20);
		contentPane.add(txtDadosDoUsuario);
		txtDadosDoUsuario.setColumns(10);

		JLabel nomeUsuario = new JLabel("Nome\r\n");
		nomeUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		nomeUsuario.setBounds(116, 135, 46, 14);
		contentPane.add(nomeUsuario);

		JLabel emailUsuario = new JLabel("E-mail");
		emailUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		emailUsuario.setBounds(116, 185, 46, 14);
		contentPane.add(emailUsuario);

		JLabel senhaUsuario = new JLabel("Senha\r\n");
		senhaUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		senhaUsuario.setBounds(116, 233, 46, 14);
		contentPane.add(senhaUsuario);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(172, 134, 264, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(172, 184, 264, 20);
		contentPane.add(textFieldEmail);

		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setBounds(172, 232, 264, 20);
		contentPane.add(passwordFieldSenha);
		
		JButton cadastrarUsuario = new JButton("Cadastrar");
		cadastrarUsuario.setBounds(243, 306, 114, 23);
		contentPane.add(cadastrarUsuario);

		UsuarioDAO dao = new UsuarioDAO();

		cadastrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				Usuario user = new Usuario(textFieldNome.getText(),textFieldEmail.getText(), passwordFieldSenha.getText());

				List<Usuario> lista = new ArrayList<>();

				lista.add(user);

				try {
					dao.insert(user);
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				}

			}
		});


	}
}
