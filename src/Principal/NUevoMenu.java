package Principal;

//import java.applet.Applet;
import java.awt.BorderLayout;
//import java.awt.Color;

import Morosos.MenuMorosos;
//import java.awt.Dimension;

import Pagos.ListaPagos;
import oracle.jdbc.pool.OracleDataSource;

import java.awt.EventQueue;
//import java.awt.Graphics;
import ListarBailarinas.ListarBailarinas;

//import javax.swing.GroupLayout;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import org.apache.log4j.BasicConfigurator;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
//import java.util.logging.Logger;

//import javax.swing.JTable;
//import javax.swing.GroupLayout.Alignment;
//import javax.swing.LayoutStyle.ComponentPlacement;

import AgregarComponente.SwingAgregarCampos;
import Infantil.ListarInfantiles;
//import Morosos.CuotaCinco;
//import Morosos.CuotaCuatro;
//import Morosos.CuotaDos;
//import Morosos.CuotaTres;
//import Morosos.CuotaUno;
//import Morosos.ListarMorosos;
import BorrarComponente.ListarComponenteABorra;
import Editar.ListadoAEditar;
//import ExcelListado.ExcelListado2;
import Arca.Arca;
import ListarMusicos.ListarMusicos;
import Modista.ListadoModista;

public class NUevoMenu extends JFrame {

	// private static String resourceBundleName;
	private Fondo contentPane;

	public static void main(String[] args) {

		try {
			OracleDataSource ds = new OracleDataSource();
			// Cargar el driver de Oracle
			Class.forName("oracle.jdbc.OracleDriver");
			// url de la base de datos a la que vaamos a conectar
			String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:xe";
			String usuario = "DAW1", password = "DAW1";
			// Introducir valores al objeto OracleDataSource
			ds.setURL(BaseDeDatos);
			ds.setUser(usuario);
			ds.setPassword(password);
			// Establecer la conexión
			Connection conexion = ds.getConnection();
			// Comprobar si se ha producido la conexión

			Class.forName("oracle.jdbc.OracleDriver");

			Statement stm = conexion.createStatement();
			Statement stmUpdate = conexion.createStatement();
			ResultSet rset = stm.executeQuery(
					"select NOMBREEMPLE,APELLIDOPRIMERO,APELLIDOSEGUNDO, MAIL,FECHNACIMIENTO ,SALDO, AMIGO	,TELEFONO, CUERPO,	EDAD, MODISTA,COMPONENTE, NUEVO from COMPONENTE order by NOMBREEMPLE");
			String fechaParaPoderAgregar;
			String consulta;

			while (rset.next()) {

				DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				fechaParaPoderAgregar = (rset.getString("FECHNACIMIENTO").substring(8, 10) + "/"
						+ rset.getString("FECHNACIMIENTO").substring(5, 7) + "/"
						+ rset.getString("FECHNACIMIENTO").substring(0, 4));

				LocalDate fechaNac = LocalDate.parse(fechaParaPoderAgregar, fmt);
				LocalDate ahora = LocalDate.now();
				Period periodo = Period.between(fechaNac, ahora);
				
				//UPDATE
				consulta = "UPDATE COMPONENTE SET EDAD=" + periodo.getYears() + " WHERE NOMBREEMPLE='"
						+ rset.getString("NOMBREEMPLE") + "' AND APELLIDOPRIMERO='" + rset.getString("APELLIDOPRIMERO")
						+ "' AND APELLIDOSEGUNDO='" + rset.getString("APELLIDOSEGUNDO") + "'";
				stmUpdate.executeUpdate(consulta);
			}

			stm.close();

		} catch (Exception e) {
			System.out.println("Excepción:" + e);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NUevoMenu frame = new NUevoMenu();
					// frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NUevoMenu() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 579);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnAccion = new JMenu("Componentes");
		menuBar.add(mnAccion);

		JMenuItem mntmListarComponentes = new JMenuItem("Pasados y Presentes");
		mntmListarComponentes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Lista l = new Lista();
			}
		});
		mnAccion.add(mntmListarComponentes);

		JMenu mnEditar = new JMenu("Editar");
		menuBar.add(mnEditar);

		JMenuItem mntmEditarComponente = new JMenuItem("Editar Componente");
		mnEditar.add(mntmEditarComponente);

		JMenuItem mntmAgregarComponente = new JMenuItem("Agregar Componente");
		mnEditar.add(mntmAgregarComponente);
		mntmAgregarComponente.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SwingAgregarCampos a = new SwingAgregarCampos();

			}
		});

		// Nuevooooooooooooooooo
		JMenuItem BorrarComponente = new JMenuItem("Borrar Componente");
		mnEditar.add(BorrarComponente);
		BorrarComponente.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ListarComponenteABorra b = new ListarComponenteABorra();
			}
		});
		mntmEditarComponente.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ListadoAEditar lis = new ListadoAEditar();
			}
		});

		JMenu mnInfantiles = new JMenu("Infantiles");
		menuBar.add(mnInfantiles);

		JMenuItem mntmListarInfantiles_1 = new JMenuItem("Listar infantiles");
		mntmListarInfantiles_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ListarInfantiles l = new ListarInfantiles();
			}
		});
		mnInfantiles.add(mntmListarInfantiles_1);

		JMenuItem mntmOtrosAos = new JMenuItem("Otros a\u00F1os");
		mntmOtrosAos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				OtroAno o = new OtroAno();
			}
		});
		mnAccion.add(mntmOtrosAos);

		JMenuItem mntmComponentes = new JMenuItem("Componentes 2017");
		mntmComponentes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ListarEsteAno este = new ListarEsteAno();
			}
		});
		mnAccion.add(mntmComponentes);
		// Nueoooooooo

		JMenu mnPagos = new JMenu("Pagos");
		menuBar.add(mnPagos);

		JMenuItem mntmPagarCuota_1 = new JMenuItem("Pagar cuota");
		mntmPagarCuota_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ListaPagos lp = new ListaPagos();
			}
		});
		mnPagos.add(mntmPagarCuota_1);

		JMenuItem mntmArca = new JMenuItem("Arca");
		mntmArca.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Arca a = new Arca();
			}
		});
		mnPagos.add(mntmArca);

		JMenu mnMorosos = new JMenu("Morosos");
		mnMorosos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MenuMorosos moro = new MenuMorosos();
			}
		});
		menuBar.add(mnMorosos);

		JMenu mnCuerpo = new JMenu("Cuerpo");
		menuBar.add(mnCuerpo);

		JMenuItem mntmBaile = new JMenuItem("Baile");
		mntmBaile.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ListarBailarinas l = new ListarBailarinas();
			}
		});
		mnCuerpo.add(mntmBaile);

		JMenuItem mntmMsica = new JMenuItem("M\u00FAsica");
		mntmMsica.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ListarMusicos l = new ListarMusicos();
			}
		});
		mnCuerpo.add(mntmMsica);

		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SobreAlfonso alfonso = new SobreAlfonso();
			}
		});

		JMenu mnModista = new JMenu("Modista");
		menuBar.add(mnModista);

		JMenuItem mntmListadoDePersonas = new JMenuItem("Listado de personas con modista");
		mntmListadoDePersonas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ListadoModista l = new ListadoModista();
			}
		});
		mnModista.add(mntmListadoDePersonas);
		menuBar.add(mnSobre);
		contentPane = new Fondo("comparsadk.png");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// CADUCIDADDDDDD!!!!!!!!!
		Calendar cal = Calendar.getInstance();
		if (cal.get(Calendar.YEAR) == 2019) {
			setVisible(false);
		} else {
			setVisible(true);
		}
	}

}
