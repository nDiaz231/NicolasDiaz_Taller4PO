package gui;
import java.awt.GridLayout;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import dominio.*;
import logica.*;
public class VentanaVerificacion extends JFrame{
	
	private SistemaEspecifico sistema;
	private JTextField user = new JTextField();
	private JTextField contraseña= new JTextField();
	
	private JLabel lblMensaje = new JLabel("");
	
	public VentanaVerificacion() throws FileNotFoundException {
		
		super("Login");
		this.sistema = SistemaEspecifico.getInstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,400);
		setLocationRelativeTo(null);
		
		setLayout(new GridLayout(2,2,10,10));
		
		JPanel form = new JPanel(new GridLayout(2,2,10,10));
		
		form.add(new JLabel("Usuario / Rut"));
		form.add(user);
		
		
		form.add(new JLabel("Constraseña"));
		form.add(contraseña);
		
		add(form);
		add(lblMensaje);
		
		JPanel botonera = new JPanel();
		JButton btnIngresar= new JButton("Ingresar");
		
		btnIngresar.addActionListener(e -> ingresar());
		botonera.add(btnIngresar);
		add(botonera);
		
		
		
		
		
		
	}



	private void ingresar() {
		String usuario = user.getText();
		String contra = contraseña.getText();
		
		
		Object usuarioActual = sistema.verificacion(usuario, contra);
		if (usuarioActual != null) {
			cambiar(usuarioActual,usuario);
			dispose();
			limpiar();
		}
	}



	private void cambiar(Object usuario,String nombre) {
		if(usuario instanceof Estudiante) {
			Estudiante e = sistema.buscarEstudiante(nombre);
			MenuEstudiante menu = new MenuEstudiante(e);
			menu.setVisible(true);
		}else if (usuario instanceof Coordinador) {
			Coordinador c = sistema.buscarCoordinador(nombre);
			MenuCoordinador menu = new MenuCoordinador(c);
			

		
	}else if (usuario instanceof Administrador) {
		Administrador a = sistema.buscarAdmin(nombre);
		MenuAdmin menu = new MenuAdmin(a);
	}
	}


	private void limpiar() {
		user.setText("");
		contraseña.setText("");
		lblMensaje.setText("");
	}
}
