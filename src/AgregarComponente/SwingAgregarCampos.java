package AgregarComponente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;

public class SwingAgregarCampos extends JFrame {

	JRadioButton rdbtnBaile = new JRadioButton("Baile");
	JRadioButton rdbtnMsica = new JRadioButton("M\u00FAsica");

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_9;

	public SwingAgregarCampos() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 484, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);

		JLabel lblNombre = new JLabel("Nombre");

		JLabel lblPrimerApeliido = new JLabel("Primer Apeliido");

		JLabel lblSegundoApellido = new JLabel("Segundo Apellido");

		JLabel lblMail = new JLabel("Mail");

		JLabel lblSaldo = new JLabel("Saldo");

		JLabel lblAmigo = new JLabel("Amigo");

		JLabel lblFechaNacddmmaaaa = new JLabel("Fecha Nac (dd-mm-aaaa)");

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		JLabel lblTelefono = new JLabel("Telefono");

		textField_9 = new JTextField();
		textField_9.setColumns(10);

		JLabel lblCuerpo = new JLabel("Cuerpo");

		JLabel lblSexo = new JLabel("Sexo");

		JRadioButton rdbtnHombre = new JRadioButton("Hombre");

		JRadioButton rdbtnMujer = new JRadioButton("Mujer");

		JRadioButton ModistaNo = new JRadioButton("No");

		JRadioButton ModistaSi = new JRadioButton("Si");

		JRadioButton NuevoSi = new JRadioButton("Si");

		JRadioButton NuevoNo = new JRadioButton("No");

		JLabel lblModista = new JLabel("Modista");

		JLabel lblNuevo = new JLabel("Nuevo");

		JLabel lblApuntado = new JLabel("Apuntado");

		JRadioButton rdbtnSi = new JRadioButton("Si");

		JRadioButton rdbtnNo = new JRadioButton("No");

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			// CLic Raton------------------------------------------------------------
			@Override
			public void mousePressed(MouseEvent e) {
				if (rdbtnSi.getSelectedObjects() != null) {
					if (rdbtnBaile.getSelectedObjects() != null && NuevoSi.getSelectedObjects() != null
							&& rdbtnHombre.getSelectedObjects() != null && ModistaSi.getSelectedObjects() != null) {
						InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
								textField_1.getText(), textField_2.getText(), textField_3.getText(),
								textField_4.getText(), textField_5.getText(), textField_6.getText(),
								textField_7.getText(), textField_9.getText(), "Baile", "Si", "Hombre", "Si", "Si");
					} else {
						if (rdbtnBaile.getSelectedObjects() != null && NuevoSi.getSelectedObjects() != null
								&& rdbtnHombre.getSelectedObjects() != null && ModistaNo.getSelectedObjects() != null) {
							InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
									textField_1.getText(), textField_2.getText(), textField_3.getText(),
									textField_4.getText(), textField_5.getText(), textField_6.getText(),
									textField_7.getText(), textField_9.getText(), "Baile", "Si", "Hombre", "No", "Si");
						} else {
							if (rdbtnBaile.getSelectedObjects() != null && NuevoSi.getSelectedObjects() != null
									&& rdbtnMujer.getSelectedObjects() != null
									&& ModistaSi.getSelectedObjects() != null) {
								InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
										textField_1.getText(), textField_2.getText(), textField_3.getText(),
										textField_4.getText(), textField_5.getText(), textField_6.getText(),
										textField_7.getText(), textField_9.getText(), "Baile", "Si", "Mujer", "Si",
										"Si");

							} else {
								if (rdbtnBaile.getSelectedObjects() != null && NuevoSi.getSelectedObjects() != null
										&& rdbtnMujer.getSelectedObjects() != null
										&& ModistaNo.getSelectedObjects() != null) {
									InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
											textField_1.getText(), textField_2.getText(), textField_3.getText(),
											textField_4.getText(), textField_5.getText(), textField_6.getText(),
											textField_7.getText(), textField_9.getText(), "Baile", "Si", "Mujer", "No",
											"Si");
								} else {
									if (rdbtnBaile.getSelectedObjects() != null && NuevoNo.getSelectedObjects() != null
											&& rdbtnHombre.getSelectedObjects() != null
											&& ModistaSi.getSelectedObjects() != null) {
										InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
												textField_1.getText(), textField_2.getText(), textField_3.getText(),
												textField_4.getText(), textField_5.getText(), textField_6.getText(),
												textField_7.getText(), textField_9.getText(), "Baile", "No", "Hombre",
												"Si", "Si");
									} else {
										if (rdbtnBaile.getSelectedObjects() != null
												&& NuevoNo.getSelectedObjects() != null
												&& rdbtnHombre.getSelectedObjects() != null
												&& ModistaNo.getSelectedObjects() != null) {
											InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
													textField_1.getText(), textField_2.getText(), textField_3.getText(),
													textField_4.getText(), textField_5.getText(), textField_6.getText(),
													textField_7.getText(), textField_9.getText(), "Baile", "No",
													"Hombre", "No", "Si");
										} else {
											if (rdbtnBaile.getSelectedObjects() != null
													&& NuevoNo.getSelectedObjects() != null
													&& rdbtnMujer.getSelectedObjects() != null
													&& ModistaSi.getSelectedObjects() != null) {
												InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
														textField_1.getText(), textField_2.getText(),
														textField_3.getText(), textField_4.getText(),
														textField_5.getText(), textField_6.getText(),
														textField_7.getText(), textField_9.getText(), "Baile", "No",
														"Mujer", "Si", "Si");
											} else {
												if (rdbtnBaile.getSelectedObjects() != null
														&& NuevoNo.getSelectedObjects() != null
														&& rdbtnMujer.getSelectedObjects() != null
														&& ModistaNo.getSelectedObjects() != null) {
													InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
															textField_1.getText(), textField_2.getText(),
															textField_3.getText(), textField_4.getText(),
															textField_5.getText(), textField_6.getText(),
															textField_7.getText(), textField_9.getText(), "Baile", "No",
															"Mujer", "No", "Si");
												} else {
													if (rdbtnMsica.getSelectedObjects() != null
															&& NuevoSi.getSelectedObjects() != null
															&& rdbtnHombre.getSelectedObjects() != null
															&& ModistaSi.getSelectedObjects() != null) {
														InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																textField_1.getText(), textField_2.getText(),
																textField_3.getText(), textField_4.getText(),
																textField_5.getText(), textField_6.getText(),
																textField_7.getText(), textField_9.getText(), "Musica",
																"Si", "Hombre", "Si", "Si");
													} else {
														if (rdbtnMsica.getSelectedObjects() != null
																&& NuevoSi.getSelectedObjects() != null
																&& rdbtnHombre.getSelectedObjects() != null
																&& ModistaNo.getSelectedObjects() != null) {
															InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																	textField_1.getText(), textField_2.getText(),
																	textField_3.getText(), textField_4.getText(),
																	textField_5.getText(), textField_6.getText(),
																	textField_7.getText(), textField_9.getText(),
																	"Musica", "Si", "Hombre", "No", "Si");
														} else {
															if (rdbtnMsica.getSelectedObjects() != null
																	&& NuevoSi.getSelectedObjects() != null
																	&& rdbtnMujer.getSelectedObjects() != null
																	&& ModistaSi.getSelectedObjects() != null) {
																InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																		textField_1.getText(), textField_2.getText(),
																		textField_3.getText(), textField_4.getText(),
																		textField_5.getText(), textField_6.getText(),
																		textField_7.getText(), textField_9.getText(),
																		"Musica", "Si", "Mujer", "Si", "Si");
															} else {
																if (rdbtnMsica.getSelectedObjects() != null
																		&& NuevoSi.getSelectedObjects() != null
																		&& rdbtnMujer.getSelectedObjects() != null
																		&& ModistaNo.getSelectedObjects() != null) {
																	InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																			textField_1.getText(),
																			textField_2.getText(),
																			textField_3.getText(),
																			textField_4.getText(),
																			textField_5.getText(),
																			textField_6.getText(),
																			textField_7.getText(),
																			textField_9.getText(), "Musica", "Si",
																			"Mujer", "No", "Si");
																} else {
																	if (rdbtnMsica.getSelectedObjects() != null
																			&& NuevoNo.getSelectedObjects() != null
																			&& rdbtnHombre.getSelectedObjects() != null
																			&& ModistaSi.getSelectedObjects() != null) {
																		InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																				textField_1.getText(),
																				textField_2.getText(),
																				textField_3.getText(),
																				textField_4.getText(),
																				textField_5.getText(),
																				textField_6.getText(),
																				textField_7.getText(),
																				textField_9.getText(), "Musica", "No",
																				"Hombre", "Si", "Si");
																	} else {
																		if (rdbtnMsica.getSelectedObjects() != null
																				&& NuevoNo.getSelectedObjects() != null
																				&& rdbtnHombre
																						.getSelectedObjects() != null
																				&& ModistaNo
																						.getSelectedObjects() != null) {
																			InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																					textField_1.getText(),
																					textField_2.getText(),
																					textField_3.getText(),
																					textField_4.getText(),
																					textField_5.getText(),
																					textField_6.getText(),
																					textField_7.getText(),
																					textField_9.getText(), "Musica",
																					"No", "Hombre", "No", "Si");
																		} else {
																			if (rdbtnMsica.getSelectedObjects() != null
																					&& NuevoNo
																							.getSelectedObjects() != null
																					&& rdbtnMujer
																							.getSelectedObjects() != null
																					&& ModistaSi
																							.getSelectedObjects() != null) {
																				InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																						textField_1.getText(),
																						textField_2.getText(),
																						textField_3.getText(),
																						textField_4.getText(),
																						textField_5.getText(),
																						textField_6.getText(),
																						textField_7.getText(),
																						textField_9.getText(), "Musica",
																						"No", "Mujer", "Si", "Si");
																			} else {
																				if (rdbtnMsica
																						.getSelectedObjects() != null
																						&& NuevoNo
																								.getSelectedObjects() != null
																						&& rdbtnMujer
																								.getSelectedObjects() != null
																						&& ModistaNo
																								.getSelectedObjects() != null) {
																					InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																							textField_1.getText(),
																							textField_2.getText(),
																							textField_3.getText(),
																							textField_4.getText(),
																							textField_5.getText(),
																							textField_6.getText(),
																							textField_7.getText(),
																							textField_9.getText(),
																							"Musica", "No", "Mujer",
																							"No", "Si");
																				} else {
																					if (rdbtnMsica
																							.getSelectedObjects() == null
																							&& rdbtnBaile
																									.getSelectedObjects() == null
																							&& NuevoSi
																									.getSelectedObjects() != null
																							&& rdbtnHombre
																									.getSelectedObjects() != null
																							&& ModistaSi
																									.getSelectedObjects() != null) {
																						InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																								textField_1.getText(),
																								textField_2.getText(),
																								textField_3.getText(),
																								textField_4.getText(),
																								textField_5.getText(),
																								textField_6.getText(),
																								textField_7.getText(),
																								textField_9.getText(),
																								"Otro", "Si", "Hombre",
																								"Si", "Si");
																					} else {
																						if (rdbtnMsica
																								.getSelectedObjects() == null
																								&& rdbtnBaile
																										.getSelectedObjects() == null
																								&& NuevoSi
																										.getSelectedObjects() != null
																								&& rdbtnHombre
																										.getSelectedObjects() != null
																								&& ModistaNo
																										.getSelectedObjects() != null) {
																							InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																									textField_1
																											.getText(),
																									textField_2
																											.getText(),
																									textField_3
																											.getText(),
																									textField_4
																											.getText(),
																									textField_5
																											.getText(),
																									textField_6
																											.getText(),
																									textField_7
																											.getText(),
																									textField_9
																											.getText(),
																									"Otro", "Si",
																									"Hombre", "No",
																									"Si");
																						} else {
																							if (rdbtnMsica
																									.getSelectedObjects() == null
																									&& rdbtnBaile
																											.getSelectedObjects() == null
																									&& NuevoSi
																											.getSelectedObjects() != null
																									&& rdbtnMujer
																											.getSelectedObjects() != null
																									&& ModistaSi
																											.getSelectedObjects() != null) {
																								InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																										textField_1
																												.getText(),
																										textField_2
																												.getText(),
																										textField_3
																												.getText(),
																										textField_4
																												.getText(),
																										textField_5
																												.getText(),
																										textField_6
																												.getText(),
																										textField_7
																												.getText(),
																										textField_9
																												.getText(),
																										"Otro", "Si",
																										"Mujer", "Si",
																										"Si");
																							} else {
																								if (rdbtnMsica
																										.getSelectedObjects() == null
																										&& rdbtnBaile
																												.getSelectedObjects() == null
																										&& NuevoSi
																												.getSelectedObjects() != null
																										&& rdbtnMujer
																												.getSelectedObjects() != null
																										&& ModistaNo
																												.getSelectedObjects() != null) {
																									InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																											textField_1
																													.getText(),
																											textField_2
																													.getText(),
																											textField_3
																													.getText(),
																											textField_4
																													.getText(),
																											textField_5
																													.getText(),
																											textField_6
																													.getText(),
																											textField_7
																													.getText(),
																											textField_9
																													.getText(),
																											"Otro",
																											"Si",
																											"Mujer",
																											"No", "Si");
																								} else {
																									if (rdbtnMsica
																											.getSelectedObjects() == null
																											&& rdbtnBaile
																													.getSelectedObjects() == null
																											&& NuevoNo
																													.getSelectedObjects() != null
																											&& rdbtnHombre
																													.getSelectedObjects() != null
																											&& ModistaSi
																													.getSelectedObjects() != null) {
																										InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																												textField_1
																														.getText(),
																												textField_2
																														.getText(),
																												textField_3
																														.getText(),
																												textField_4
																														.getText(),
																												textField_5
																														.getText(),
																												textField_6
																														.getText(),
																												textField_7
																														.getText(),
																												textField_9
																														.getText(),
																												"Otro",
																												"No",
																												"Hombre",
																												"Si",
																												"Si");
																									} else {
																										if (rdbtnMsica
																												.getSelectedObjects() == null
																												&& rdbtnBaile
																														.getSelectedObjects() == null
																												&& NuevoNo
																														.getSelectedObjects() != null
																												&& rdbtnHombre
																														.getSelectedObjects() != null
																												&& ModistaNo
																														.getSelectedObjects() != null) {
																											InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																													textField_1
																															.getText(),
																													textField_2
																															.getText(),
																													textField_3
																															.getText(),
																													textField_4
																															.getText(),
																													textField_5
																															.getText(),
																													textField_6
																															.getText(),
																													textField_7
																															.getText(),
																													textField_9
																															.getText(),
																													"Otro",
																													"No",
																													"Hombre",
																													"No",
																													"Si");
																										} else {
																											if (rdbtnMsica
																													.getSelectedObjects() == null
																													&& rdbtnBaile
																															.getSelectedObjects() == null
																													&& NuevoSi
																															.getSelectedObjects() != null
																													&& rdbtnMujer
																															.getSelectedObjects() != null
																													&& ModistaSi
																															.getSelectedObjects() != null) {
																												InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																														textField_1
																																.getText(),
																														textField_2
																																.getText(),
																														textField_3
																																.getText(),
																														textField_4
																																.getText(),
																														textField_5
																																.getText(),
																														textField_6
																																.getText(),
																														textField_7
																																.getText(),
																														textField_9
																																.getText(),
																														"Otro",
																														"Si",
																														"Mujer",
																														"Si",
																														"Si");
																											} else {
																												if (rdbtnMsica
																														.getSelectedObjects() == null
																														&& rdbtnBaile
																																.getSelectedObjects() == null
																														&& NuevoSi
																																.getSelectedObjects() != null
																														&& rdbtnMujer
																																.getSelectedObjects() != null
																														&& ModistaNo
																																.getSelectedObjects() != null) {
																													InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																															textField_1
																																	.getText(),
																															textField_2
																																	.getText(),
																															textField_3
																																	.getText(),
																															textField_4
																																	.getText(),
																															textField_5
																																	.getText(),
																															textField_6
																																	.getText(),
																															textField_7
																																	.getText(),
																															textField_9
																																	.getText(),
																															"Otro",
																															"Si",
																															"Mujer",
																															"No",
																															"Si");
																												}

																											}

																										}

																									}

																								}

																							}

																						}

																					}
																				}

																			}

																		}

																	}

																}

															}

														}

													}

												}

											}
										}

									}
								}
							}

						}

					}

				} else {
					if (rdbtnSi.getSelectedObjects() == null) {
						if (rdbtnBaile.getSelectedObjects() != null && NuevoSi.getSelectedObjects() != null
								&& rdbtnHombre.getSelectedObjects() != null && ModistaSi.getSelectedObjects() != null) {
							InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
									textField_1.getText(), textField_2.getText(), textField_3.getText(),
									textField_4.getText(), textField_5.getText(), textField_6.getText(),
									textField_7.getText(), textField_9.getText(), "Baile", "Si", "Hombre", "Si", "No");
						} else {
							if (rdbtnBaile.getSelectedObjects() != null && NuevoSi.getSelectedObjects() != null
									&& rdbtnHombre.getSelectedObjects() != null
									&& ModistaNo.getSelectedObjects() != null) {
								InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
										textField_1.getText(), textField_2.getText(), textField_3.getText(),
										textField_4.getText(), textField_5.getText(), textField_6.getText(),
										textField_7.getText(), textField_9.getText(), "Baile", "Si", "Hombre", "No",
										"No");
							} else {
								if (rdbtnBaile.getSelectedObjects() != null && NuevoSi.getSelectedObjects() != null
										&& rdbtnMujer.getSelectedObjects() != null
										&& ModistaSi.getSelectedObjects() != null) {
									InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
											textField_1.getText(), textField_2.getText(), textField_3.getText(),
											textField_4.getText(), textField_5.getText(), textField_6.getText(),
											textField_7.getText(), textField_9.getText(), "Baile", "Si", "Mujer", "Si",
											"No");

								} else {
									if (rdbtnBaile.getSelectedObjects() != null && NuevoSi.getSelectedObjects() != null
											&& rdbtnMujer.getSelectedObjects() != null
											&& ModistaNo.getSelectedObjects() != null) {
										InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
												textField_1.getText(), textField_2.getText(), textField_3.getText(),
												textField_4.getText(), textField_5.getText(), textField_6.getText(),
												textField_7.getText(), textField_9.getText(), "Baile", "Si", "Mujer",
												"No", "No");
									} else {
										if (rdbtnBaile.getSelectedObjects() != null
												&& NuevoNo.getSelectedObjects() != null
												&& rdbtnHombre.getSelectedObjects() != null
												&& ModistaSi.getSelectedObjects() != null) {
											InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
													textField_1.getText(), textField_2.getText(), textField_3.getText(),
													textField_4.getText(), textField_5.getText(), textField_6.getText(),
													textField_7.getText(), textField_9.getText(), "Baile", "No",
													"Hombre", "Si", "No");
										} else {
											if (rdbtnBaile.getSelectedObjects() != null
													&& NuevoNo.getSelectedObjects() != null
													&& rdbtnHombre.getSelectedObjects() != null
													&& ModistaNo.getSelectedObjects() != null) {
												InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
														textField_1.getText(), textField_2.getText(),
														textField_3.getText(), textField_4.getText(),
														textField_5.getText(), textField_6.getText(),
														textField_7.getText(), textField_9.getText(), "Baile", "No",
														"Hombre", "No", "No");
											} else {
												if (rdbtnBaile.getSelectedObjects() != null
														&& NuevoNo.getSelectedObjects() != null
														&& rdbtnMujer.getSelectedObjects() != null
														&& ModistaSi.getSelectedObjects() != null) {
													InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
															textField_1.getText(), textField_2.getText(),
															textField_3.getText(), textField_4.getText(),
															textField_5.getText(), textField_6.getText(),
															textField_7.getText(), textField_9.getText(), "Baile", "No",
															"Mujer", "Si", "No");
												} else {
													if (rdbtnBaile.getSelectedObjects() != null
															&& NuevoNo.getSelectedObjects() != null
															&& rdbtnMujer.getSelectedObjects() != null
															&& ModistaNo.getSelectedObjects() != null) {
														InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																textField_1.getText(), textField_2.getText(),
																textField_3.getText(), textField_4.getText(),
																textField_5.getText(), textField_6.getText(),
																textField_7.getText(), textField_9.getText(), "Baile",
																"No", "Mujer", "No", "No");
													} else {
														if (rdbtnMsica.getSelectedObjects() != null
																&& NuevoSi.getSelectedObjects() != null
																&& rdbtnHombre.getSelectedObjects() != null
																&& ModistaSi.getSelectedObjects() != null) {
															InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																	textField_1.getText(), textField_2.getText(),
																	textField_3.getText(), textField_4.getText(),
																	textField_5.getText(), textField_6.getText(),
																	textField_7.getText(), textField_9.getText(),
																	"Musica", "Si", "Hombre", "Si", "No");
														} else {
															if (rdbtnMsica.getSelectedObjects() != null
																	&& NuevoSi.getSelectedObjects() != null
																	&& rdbtnHombre.getSelectedObjects() != null
																	&& ModistaNo.getSelectedObjects() != null) {
																InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																		textField_1.getText(), textField_2.getText(),
																		textField_3.getText(), textField_4.getText(),
																		textField_5.getText(), textField_6.getText(),
																		textField_7.getText(), textField_9.getText(),
																		"Musica", "Si", "Hombre", "No", "No");
															} else {
																if (rdbtnMsica.getSelectedObjects() != null
																		&& NuevoSi.getSelectedObjects() != null
																		&& rdbtnMujer.getSelectedObjects() != null
																		&& ModistaSi.getSelectedObjects() != null) {
																	InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																			textField_1.getText(),
																			textField_2.getText(),
																			textField_3.getText(),
																			textField_4.getText(),
																			textField_5.getText(),
																			textField_6.getText(),
																			textField_7.getText(),
																			textField_9.getText(), "Musica", "Si",
																			"Mujer", "Si", "No");
																} else {
																	if (rdbtnMsica.getSelectedObjects() != null
																			&& NuevoSi.getSelectedObjects() != null
																			&& rdbtnMujer.getSelectedObjects() != null
																			&& ModistaNo.getSelectedObjects() != null) {
																		InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																				textField_1.getText(),
																				textField_2.getText(),
																				textField_3.getText(),
																				textField_4.getText(),
																				textField_5.getText(),
																				textField_6.getText(),
																				textField_7.getText(),
																				textField_9.getText(), "Musica", "Si",
																				"Mujer", "No", "No");
																	} else {
																		if (rdbtnMsica.getSelectedObjects() != null
																				&& NuevoNo.getSelectedObjects() != null
																				&& rdbtnHombre
																						.getSelectedObjects() != null
																				&& ModistaSi
																						.getSelectedObjects() != null) {
																			InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																					textField_1.getText(),
																					textField_2.getText(),
																					textField_3.getText(),
																					textField_4.getText(),
																					textField_5.getText(),
																					textField_6.getText(),
																					textField_7.getText(),
																					textField_9.getText(), "Musica",
																					"No", "Hombre", "Si", "No");
																		} else {
																			if (rdbtnMsica.getSelectedObjects() != null
																					&& NuevoNo
																							.getSelectedObjects() != null
																					&& rdbtnHombre
																							.getSelectedObjects() != null
																					&& ModistaNo
																							.getSelectedObjects() != null) {
																				InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																						textField_1.getText(),
																						textField_2.getText(),
																						textField_3.getText(),
																						textField_4.getText(),
																						textField_5.getText(),
																						textField_6.getText(),
																						textField_7.getText(),
																						textField_9.getText(), "Musica",
																						"No", "Hombre", "No", "No");
																			} else {
																				if (rdbtnMsica
																						.getSelectedObjects() != null
																						&& NuevoNo
																								.getSelectedObjects() != null
																						&& rdbtnMujer
																								.getSelectedObjects() != null
																						&& ModistaSi
																								.getSelectedObjects() != null) {
																					InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																							textField_1.getText(),
																							textField_2.getText(),
																							textField_3.getText(),
																							textField_4.getText(),
																							textField_5.getText(),
																							textField_6.getText(),
																							textField_7.getText(),
																							textField_9.getText(),
																							"Musica", "No", "Mujer",
																							"Si", "No");
																				} else {
																					if (rdbtnMsica
																							.getSelectedObjects() != null
																							&& NuevoNo
																									.getSelectedObjects() != null
																							&& rdbtnMujer
																									.getSelectedObjects() != null
																							&& ModistaNo
																									.getSelectedObjects() != null) {
																						InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																								textField_1.getText(),
																								textField_2.getText(),
																								textField_3.getText(),
																								textField_4.getText(),
																								textField_5.getText(),
																								textField_6.getText(),
																								textField_7.getText(),
																								textField_9.getText(),
																								"Musica", "No", "Mujer",
																								"No", "No");
																					} else {
																						if (rdbtnMsica
																								.getSelectedObjects() == null
																								&& rdbtnBaile
																										.getSelectedObjects() == null
																								&& NuevoSi
																										.getSelectedObjects() != null
																								&& rdbtnHombre
																										.getSelectedObjects() != null
																								&& ModistaSi
																										.getSelectedObjects() != null) {
																							InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																									textField_1
																											.getText(),
																									textField_2
																											.getText(),
																									textField_3
																											.getText(),
																									textField_4
																											.getText(),
																									textField_5
																											.getText(),
																									textField_6
																											.getText(),
																									textField_7
																											.getText(),
																									textField_9
																											.getText(),
																									"Otro", "Si",
																									"Hombre", "Si",
																									"No");
																						} else {
																							if (rdbtnMsica
																									.getSelectedObjects() == null
																									&& rdbtnBaile
																											.getSelectedObjects() == null
																									&& NuevoSi
																											.getSelectedObjects() != null
																									&& rdbtnHombre
																											.getSelectedObjects() != null
																									&& ModistaNo
																											.getSelectedObjects() != null) {
																								InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																										textField_1
																												.getText(),
																										textField_2
																												.getText(),
																										textField_3
																												.getText(),
																										textField_4
																												.getText(),
																										textField_5
																												.getText(),
																										textField_6
																												.getText(),
																										textField_7
																												.getText(),
																										textField_9
																												.getText(),
																										"Otro", "Si",
																										"Hombre", "No",
																										"No");
																							} else {
																								if (rdbtnMsica
																										.getSelectedObjects() == null
																										&& rdbtnBaile
																												.getSelectedObjects() == null
																										&& NuevoSi
																												.getSelectedObjects() != null
																										&& rdbtnMujer
																												.getSelectedObjects() != null
																										&& ModistaSi
																												.getSelectedObjects() != null) {
																									InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																											textField_1
																													.getText(),
																											textField_2
																													.getText(),
																											textField_3
																													.getText(),
																											textField_4
																													.getText(),
																											textField_5
																													.getText(),
																											textField_6
																													.getText(),
																											textField_7
																													.getText(),
																											textField_9
																													.getText(),
																											"Otro",
																											"Si",
																											"Mujer",
																											"Si", "No");
																								} else {
																									if (rdbtnMsica
																											.getSelectedObjects() == null
																											&& rdbtnBaile
																													.getSelectedObjects() == null
																											&& NuevoSi
																													.getSelectedObjects() != null
																											&& rdbtnMujer
																													.getSelectedObjects() != null
																											&& ModistaNo
																													.getSelectedObjects() != null) {
																										InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																												textField_1
																														.getText(),
																												textField_2
																														.getText(),
																												textField_3
																														.getText(),
																												textField_4
																														.getText(),
																												textField_5
																														.getText(),
																												textField_6
																														.getText(),
																												textField_7
																														.getText(),
																												textField_9
																														.getText(),
																												"Otro",
																												"Si",
																												"Mujer",
																												"No",
																												"No");
																									} else {
																										if (rdbtnMsica
																												.getSelectedObjects() == null
																												&& rdbtnBaile
																														.getSelectedObjects() == null
																												&& NuevoNo
																														.getSelectedObjects() != null
																												&& rdbtnHombre
																														.getSelectedObjects() != null
																												&& ModistaSi
																														.getSelectedObjects() != null) {
																											InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																													textField_1
																															.getText(),
																													textField_2
																															.getText(),
																													textField_3
																															.getText(),
																													textField_4
																															.getText(),
																													textField_5
																															.getText(),
																													textField_6
																															.getText(),
																													textField_7
																															.getText(),
																													textField_9
																															.getText(),
																													"Otro",
																													"No",
																													"Hombre",
																													"Si",
																													"No");
																										} else {
																											if (rdbtnMsica
																													.getSelectedObjects() == null
																													&& rdbtnBaile
																															.getSelectedObjects() == null
																													&& NuevoNo
																															.getSelectedObjects() != null
																													&& rdbtnHombre
																															.getSelectedObjects() != null
																													&& ModistaNo
																															.getSelectedObjects() != null) {
																												InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																														textField_1
																																.getText(),
																														textField_2
																																.getText(),
																														textField_3
																																.getText(),
																														textField_4
																																.getText(),
																														textField_5
																																.getText(),
																														textField_6
																																.getText(),
																														textField_7
																																.getText(),
																														textField_9
																																.getText(),
																														"Otro",
																														"No",
																														"Hombre",
																														"No",
																														"No");
																											} else {
																												if (rdbtnMsica
																														.getSelectedObjects() == null
																														&& rdbtnBaile
																																.getSelectedObjects() == null
																														&& NuevoSi
																																.getSelectedObjects() != null
																														&& rdbtnMujer
																																.getSelectedObjects() != null
																														&& ModistaSi
																																.getSelectedObjects() != null) {
																													InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																															textField_1
																																	.getText(),
																															textField_2
																																	.getText(),
																															textField_3
																																	.getText(),
																															textField_4
																																	.getText(),
																															textField_5
																																	.getText(),
																															textField_6
																																	.getText(),
																															textField_7
																																	.getText(),
																															textField_9
																																	.getText(),
																															"Otro",
																															"Si",
																															"Mujer",
																															"Si",
																															"No");
																												} else {
																													if (rdbtnMsica
																															.getSelectedObjects() == null
																															&& rdbtnBaile
																																	.getSelectedObjects() == null
																															&& NuevoSi
																																	.getSelectedObjects() != null
																															&& rdbtnMujer
																																	.getSelectedObjects() != null
																															&& ModistaNo
																																	.getSelectedObjects() != null) {
																														InsertarComponenteEnLaBaseDeDatos m = new InsertarComponenteEnLaBaseDeDatos(
																																textField_1
																																		.getText(),
																																textField_2
																																		.getText(),
																																textField_3
																																		.getText(),
																																textField_4
																																		.getText(),
																																textField_5
																																		.getText(),
																																textField_6
																																		.getText(),
																																textField_7
																																		.getText(),
																																textField_9
																																		.getText(),
																																"Otro",
																																"Si",
																																"Mujer",
																																"No",
																																"No");
																													}

																												}

																											}

																										}

																									}

																								}

																							}

																						}
																					}

																				}

																			}

																		}

																	}

																}

															}

														}

													}

												}
											}

										}
									}
								}

							}

						}

					}
				}

				setVisible(false);
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblNombre)
								.addComponent(lblPrimerApeliido).addComponent(lblSegundoApellido).addComponent(lblMail)
								.addComponent(lblSaldo).addComponent(lblFechaNacddmmaaaa).addComponent(lblCuerpo)
								.addComponent(lblSexo).addComponent(lblModista).addComponent(lblNuevo)
								.addComponent(lblTelefono).addComponent(lblAmigo))
						.addPreferredGap(ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAceptar)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(rdbtnBaile).addComponent(NuevoSi).addComponent(rdbtnSi)
												.addComponent(rdbtnHombre).addComponent(ModistaSi))
										.addGap(44)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(ModistaNo).addComponent(rdbtnMujer)
																.addComponent(rdbtnNo)))
												.addComponent(NuevoNo).addComponent(rdbtnMsica)))
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(19))
				.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblApuntado).addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(36)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNombre).addComponent(
						textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblPrimerApeliido)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblSegundoApellido)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblMail).addComponent(
						textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblFechaNacddmmaaaa)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblSaldo).addComponent(
						textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(10))
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblAmigo)
								.addPreferredGap(ComponentPlacement.UNRELATED)))
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefono))
				.addGap(11)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblCuerpo)
						.addComponent(rdbtnMsica).addComponent(rdbtnBaile))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(NuevoSi)
						.addComponent(NuevoNo).addComponent(lblNuevo))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblSexo)
						.addComponent(rdbtnMujer).addComponent(rdbtnHombre))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(ModistaNo)
						.addComponent(lblModista).addComponent(ModistaSi))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblApuntado)
						.addComponent(rdbtnSi).addComponent(rdbtnNo))
				.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE).addComponent(btnAceptar)
				.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}
}
