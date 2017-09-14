package Editar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oracle.jdbc.pool.OracleDataSource;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ElegirQueEditar extends JFrame {

	private JPanel contentPane;



	public ElegirQueEditar(String componente) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNombre = new JButton("Nombre");
		btnNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarNombre nom=new EditarNombre(componente);
			}
		});
		
		JButton btnPrimerApellido = new JButton("Primer Apellido");
		btnPrimerApellido.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				EditarApellidoUno ape =new EditarApellidoUno(componente);
			}
		});
		
		JButton btnSegundoApellido = new JButton("Segundo Apellido");
		btnSegundoApellido.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				EditarApellidoDos dos=new EditarApellidoDos(componente);
			}
		});
		
		JButton btnCuerpo = new JButton("Cuerpo");
		btnCuerpo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			 EditarCuerpo cuerpo=new EditarCuerpo(componente);
			}
		});
		
		JButton btnCorreo_1 = new JButton("Correo");
		btnCorreo_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				EditarCorreo correo=new EditarCorreo(componente);
			}
		});
		
		JButton btnTelefono = new JButton("Telefono");
		btnTelefono.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				EditarTelefono tele=new EditarTelefono(componente);
			}
		});
		
		JButton btnSexo = new JButton("Sexo");
		btnSexo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				EditarSexo sex=new EditarSexo(componente);
			}
		});
		btnSexo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnAmigo = new JButton("Amigo");
		btnAmigo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				EditarAmigo ami = new EditarAmigo(componente);
			}
		});
		
		JButton btnSaldo = new JButton("Saldo");
		btnSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarSaldo saldo=new EditarSaldo(componente);
			}
		});
		
		JButton btnModista = new JButton("Modista");
		btnModista.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				EditarModista modis=new EditarModista(componente);
			}
		});
		
		JButton btnComponente = new JButton("Componente");
		btnComponente.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				EditarParticipacion par=new EditarParticipacion(componente);
			}
		});
		
		

		
		 //CONEXION------------------------------------------
		 //CONEXION--------------------------------------------
		setVisible(true);
		
		JButton btnFechaDeNacimiento = new JButton("Fecha de Nacimiento");
		btnFechaDeNacimiento.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				EditarFechaNa fechana=new EditarFechaNa(componente);
			}
		});
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				EditarNuevo nuevo=new EditarNuevo(componente);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnComponente)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnFechaDeNacimiento))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSexo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAmigo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSaldo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnModista))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCuerpo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCorreo_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnTelefono)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNuevo))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNombre)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnPrimerApellido)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSegundoApellido)))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNombre)
						.addComponent(btnPrimerApellido)
						.addComponent(btnSegundoApellido))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnCuerpo)
								.addComponent(btnCorreo_1))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnTelefono)
								.addComponent(btnNuevo))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSexo)
						.addComponent(btnAmigo)
						.addComponent(btnSaldo)
						.addComponent(btnModista))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnComponente)
						.addComponent(btnFechaDeNacimiento))
					.addContainerGap(104, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
}
