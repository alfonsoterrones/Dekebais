package Principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SobreAlfonso extends JFrame {

	private JPanel contentPane;

	public SobreAlfonso() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 425, 190);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);

		JLabel lblJulio = new JLabel("Julio-2016");

		JLabel lblProgramaCreadoPor = new JLabel("Programa creado por Alfonso Terrones Moreno");

		JLabel lblElProgramaCaducara = new JLabel("El programa caducará en 2018.");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(327, Short.MAX_VALUE)
						.addComponent(lblJulio).addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblProgramaCreadoPor)
						.addContainerGap(114, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(lblElProgramaCaducara).addContainerGap(329, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblProgramaCreadoPor)
						.addGap(35).addComponent(lblElProgramaCaducara)
						.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE).addComponent(lblJulio)));
		contentPane.setLayout(gl_contentPane);
	}

}
