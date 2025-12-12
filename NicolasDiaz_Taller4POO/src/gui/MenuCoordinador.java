package gui;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dominio.Coordinador;

public class MenuCoordinador extends JFrame {
	private Coordinador coordinador;

	public MenuCoordinador(Coordinador coordinador){
		super("Coordinador");
		this.coordinador = coordinador;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,400);
		setLocationRelativeTo(null);
		
		setLayout(new GridLayout(3,1,10,10));
		//Titulo
		JPanel panelTitulo = new JPanel(new GridLayout(1,1,10,10));
		JLabel lblTitulo = new JLabel("Bienvenido");
		panelTitulo.add(lblTitulo);
		add(panelTitulo);
		//Estudiante panel
		JPanel panelCoordinador = new JPanel(new GridLayout(4,1,10,10));
		panelCoordinador.add(new JLabel("Usuario: "+ coordinador.getNombre()));
		panelCoordinador.add(new JLabel("Area: "+ coordinador.getInfo()));

		add(panelCoordinador);
		JPanel panelBoton = new JPanel(new GridLayout(2,2,10,10));
		
		JButton btnCertificado = new JButton("Gestion de certificados");
		JButton btnMetrica = new JButton("Panel metricas");
		JButton btonEstudiante = new JButton("Gestion Estudiante");
		JButton btnSalir = new JButton("Salir");
		
		btnCertificado.addActionListener(e -> certificados());
		btnMetrica.addActionListener(e -> metricas());
		btonEstudiante.addActionListener(e -> gestionEstudiante());
		btnSalir.addActionListener(e -> {
			try {
				salir();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		
		panelBoton.add(btnCertificado);
		panelBoton.add(btnMetrica);
		panelBoton.add(btonEstudiante);
		panelBoton.add(btnSalir);
		add(panelBoton);
		
		
	}
	private void salir() throws FileNotFoundException {
		dispose();
		VentanaVerificacion v = new VentanaVerificacion();
		v.setVisible(true);
	}

	private Object gestionEstudiante() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object metricas() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object certificados() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
