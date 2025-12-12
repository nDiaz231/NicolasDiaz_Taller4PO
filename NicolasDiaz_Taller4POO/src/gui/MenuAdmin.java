package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

		btnCuenta.addActionListener(e -> crear());
		btnModificar.addActionListener(e -> modificarCuenta());
		btnEliminar.addActionListener(e -> reestablecerContra());
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
	
	private Object reestablecerContra() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object modificarCuenta() {
		// TODO Auto-generated method stub
		return null;
	}

	private void crear() {
		JDialog dialogoRegister= new JDialog(this,"Registrar Estudiante",true);
		dialogoRegister.setSize(350,300);
		dialogoRegister.setLocationRelativeTo(this);
		
		JPanel panelRellenar = new JPanel(new GridLayout(9,2,2,10));
		panelRellenar.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		JLabel labelTipo= new JLabel("Tipo: ");
		JTextField tipo = new JTextField(10);

		JLabel labelNombre= new JLabel("Nombre: ");
		JTextField nombre = new JTextField(10);
		
		JLabel labelRut= new JLabel("rut: ");
		JTextField rut = new JTextField(10);

		
		JLabel labelContraseña= new JLabel("Contraseña: ");
		JTextField contraseña = new JTextField(10);

		
		JLabel labelSemestre= new JLabel("Semestre: ");
		JTextField semestre = new JTextField(10);

		
		JLabel labelCorreo= new JLabel("Correo: ");
		JTextField correo = new JTextField(10);

		
		JLabel labelArea= new JLabel("Area: ");
		JTextField area = new JTextField(10);

		
		//Agregamos componente al panel
		panelRellenar.add(labelTipo);
		panelRellenar.add(tipo);
		
		panelRellenar.add(labelNombre);
		panelRellenar.add(nombre);

		panelRellenar.add(labelRut);
		panelRellenar.add(rut);

		panelRellenar.add(labelContraseña);
		panelRellenar.add(contraseña);

		panelRellenar.add(labelSemestre);
		panelRellenar.add(semestre);

		panelRellenar.add(labelCorreo);
		panelRellenar.add(correo);

		panelRellenar.add(labelArea);
		panelRellenar.add(area);

		JPanel panelBoton=new JPanel();
		JButton btnCrear = new JButton("Crear usuario");
		btnCrear.addActionListener(e -> factoryUsuario(tipo.getText(),nombre.getText(),rut.getText(),contraseña.getText(),semestre.getText(),correo.getText(),area.getText()));
		panelBoton.add(btnCrear);
		
		dialogoRegister.setLayout(new BorderLayout());
		dialogoRegister.add(panelRellenar,BorderLayout.CENTER);
		dialogoRegister.add(btnCrear,BorderLayout.SOUTH);
		
		dialogoRegister.setVisible(true);
	}

	

	private Object factoryUsuario(String tipo, String nombre, String rut, String contraseña, String semestre, String correo,
			String area) {
		
		return null;
	}

	private void salir() throws FileNotFoundException {
		dispose();
		VentanaVerificacion v = new VentanaVerificacion();
		v.setVisible(true);
	}


	
	
}

