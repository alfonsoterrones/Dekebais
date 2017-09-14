package Pagos;

import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.TreeSet;

import javax.swing.*;

import oracle.jdbc.pool.OracleDataSource;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import Principal.Fondo;
import java.awt.Color;
import java.awt.Font;

public class CuantoAPagado extends JFrame {
	String nombreapellido;
	String componente;
	private JTextField textField;
	private Fondo contentPane;

	public CuantoAPagado(String nombre, String apellido) {
		super("Componentes");
		setSize(550, 378);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);
		setLocation(600, 400);

		contentPane = new Fondo("dinero2.png");
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		textField = new JTextField();
		textField.setColumns(10);

		JButton btnPagar = new JButton("Pagar");

		JLabel lblcuantoVaA = new JLabel("\u00BFCuanto va a pagar?");
		lblcuantoVaA.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblcuantoVaA.setForeground(Color.BLACK);

		JRadioButton rdbtnPago = new JRadioButton("1\u00BA Pago");

		JRadioButton rdbtnPago_1 = new JRadioButton("2\u00BA Pago");

		JRadioButton rdbtnPago_2 = new JRadioButton("3\u00BA Pago");

		JRadioButton rdbtnPago_3 = new JRadioButton("4\u00BA Pago");

		JRadioButton rdbtnPago_4 = new JRadioButton("5\u00BA Pago");

		JRadioButton rdbtnAdmision = new JRadioButton("Admision");

		btnPagar.addMouseListener(new MouseAdapter() {
			// ------------PULSAR BOTON-------------------------------------------------
			@Override
			public void mousePressed(MouseEvent e) {
				float superDinero;

				// --------------------PASAMOS DE STRING A FLOAT EL DINERO-------------

				String dinero = textField.getText();
				superDinero = Float.parseFloat(dinero);

				if (rdbtnPago.getSelectedObjects() != null) {
					InsertarPago insertarPago = new InsertarPago(nombre, apellido, superDinero, "primero");
				} else {
					if (rdbtnPago_1.getSelectedObjects() != null) {
						InsertarPago insertarPago = new InsertarPago(nombre, apellido, superDinero, "segundo");

					} else {
						if (rdbtnPago_2.getSelectedObjects() != null) {
							InsertarPago insertarPago = new InsertarPago(nombre, apellido, superDinero, "tercero");

						} else {
							if (rdbtnPago_3.getSelectedObjects() != null) {
								InsertarPago insertarPago = new InsertarPago(nombre, apellido, superDinero, "cuarto");

							} else {
								if (rdbtnPago_4.getSelectedObjects() != null) {
									InsertarPago insertarPago = new InsertarPago(nombre, apellido, superDinero,
											"quinto");

								} else {
									if (rdbtnAdmision.getSelectedObjects() != null) {
										InsertarPago insertarPago = new InsertarPago(nombre, apellido, superDinero,
												"admisión");

									}
								}
							}
						}
					}

				}

				setVisible(false);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblcuantoVaA).addGap(49)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 73,
												GroupLayout.PREFERRED_SIZE)
										.addGap(46))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnPagar, GroupLayout.PREFERRED_SIZE, 125,
												GroupLayout.PREFERRED_SIZE)
										.addGap(92)))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(rdbtnPago_3)
								.addComponent(rdbtnPago_2).addComponent(rdbtnPago_1).addComponent(rdbtnPago)
								.addComponent(rdbtnPago_4).addComponent(rdbtnAdmision))
						.addContainerGap(22, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblcuantoVaA)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnPago))
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(rdbtnPago_1)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(rdbtnPago_2)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(rdbtnPago_3)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnPagar, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup().addComponent(rdbtnPago_4)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(rdbtnAdmision)))
						.addContainerGap(136, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

		setVisible(true);

	}

	public String MandarComponenteAMostrarDatosComponentes() {
		return componente;
	}
}
