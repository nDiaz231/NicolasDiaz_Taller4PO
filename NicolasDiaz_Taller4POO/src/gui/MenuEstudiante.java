package gui;


import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dominio.*;
import logica.SistemaEspecifico; 
public class MenuEstudiante extends JFrame {
	private Estudiante estudiante;
	private JButton btnMalla = new JButton("Mi malla y notas");
	private JButton btnInscribir = new JButton("Inscripcion");
	private JButton btonProgreso = new JButton("Ver progreso");
	private JButton btnSalir = new JButton("Salir");
	public MenuEstudiante(Estudiante estudiante) {
		super("Potal estudiante");
		this.estudiante = estudiante;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,400);
		setLocationRelativeTo(null);
		
		setLayout(new GridLayout(3,1,10,10));
		
		
		
		
		
		
		
		
		
	}
	
	

}
