package gui;


import java.awt.GridLayout;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dominio.*;
import logica.SistemaEspecifico; 
public class MenuEstudiante extends JFrame {
	
	private Estudiante estudiante;

	
	
	public MenuEstudiante(Estudiante estudiante) {
		super("Estudiante");
		this.estudiante = estudiante;
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
		JPanel panelEstudiante = new JPanel(new GridLayout(4,1,10,10));
		panelEstudiante.add(new JLabel("Nombre: "+ estudiante.getNombre()));
		panelEstudiante.add(new JLabel("Rut: "+ estudiante.getRut()));
		panelEstudiante.add(new JLabel("Carrera: "+ estudiante.getCarrera()));
		panelEstudiante.add(new JLabel("Semestre: "+ estudiante.getSemestre()));

		add(panelEstudiante);

		//Botones
		JPanel panelBoton = new JPanel(new GridLayout(2,2,10,10));
		
		JButton btnMalla = new JButton("Mi malla y notas");
		JButton btnInscribir = new JButton("Inscripcion");
		JButton btonProgreso = new JButton("Ver progreso");
		JButton btnSalir = new JButton("Salir");
		
		btnMalla.addActionListener(e -> verMalla());
		btnInscribir.addActionListener(e -> incripcion());
		btonProgreso.addActionListener(e -> progreso());
		btnSalir.addActionListener(e -> {
			try {
				salir();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		
		panelBoton.add(btnMalla);
		panelBoton.add(btnInscribir);
		panelBoton.add(btonProgreso);
		panelBoton.add(btnSalir);
		add(panelBoton);
		
		
		
	}
	private void salir() throws FileNotFoundException {
		dispose();
		VentanaVerificacion v = new VentanaVerificacion();
		v.setVisible(true);
	}
	private void progreso() {
		
	}
	private Object incripcion() {
		// TODO Auto-generated method stub
		return null;
	}
	private Object verMalla() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
