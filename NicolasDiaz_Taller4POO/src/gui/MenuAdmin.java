package gui;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dominio.Administrador;

public class MenuAdmin extends JFrame{
	private Administrador admin;

	public MenuAdmin(Administrador admin) throws HeadlessException {
		super("Administrador");
		this.admin = admin;
		
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
		JPanel panelAdmin = new JPanel(new GridLayout(4,1,10,10));
		panelAdmin.add(new JLabel("Usuario: "+ admin.getNombre()));

		add(panelAdmin);
		JPanel panelBoton = new JPanel(new GridLayout(2,2,10,10));
		
		JButton btnCuenta = new JButton("Crear Cuentas");
		JButton btnModificar = new JButton("Modificar Cuentas");
		JButton btnEliminar = new JButton("Eliminar Cuentas");
		JButton btonReestablecer = new JButton("Reestablecer Contraseña");
		JButton btnSalir = new JButton("Salir");

		btnCuenta.addActionListener(e -> certificados());
		btnModificar.addActionListener(e -> metricas());
		btnEliminar.addActionListener(e -> gestionEstudiante());
		btnSalir.addActionListener(e -> {
			try {
				salir();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		
		panelBoton.add(btnCuenta);
		panelBoton.add(btnModificar);
		panelBoton.add(btnEliminar);
		panelBoton.add(btnSalir);
		add(panelBoton);
		
		
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
	private void salir() throws FileNotFoundException {
		dispose();
		VentanaVerificacion v = new VentanaVerificacion();
		v.setVisible(true);
	}


	
	
}

