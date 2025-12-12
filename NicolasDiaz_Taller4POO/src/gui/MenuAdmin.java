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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dominio.*;
import logica.SistemaEspecifico;
import logica.TipoFactory;

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

	private void modificarCuenta() {
		JDialog dialogoRegister= new JDialog(this,"Modificar Usuario",true);
		dialogoRegister.setSize(450,550);
		dialogoRegister.setLocationRelativeTo(this);
		
		JPanel panelRellenar = new JPanel(new GridLayout(9,2,2,10));
		panelRellenar.setBorder(BorderFactory.createEmptyBorder(9,10,10,10));
		
		
		JLabel labelIdentificador= new JLabel("Identificador (Rut o nombre): ");
		JTextField identificador = new JTextField(10);
		
		JLabel labelNombre= new JLabel("Nuevo Nombre: ");
		JTextField nombre = new JTextField(10);
		


		
		JLabel labelContraseña= new JLabel("Nueva Contraseña: ");
		JTextField contraseña = new JTextField(10);

		
		JLabel labelCarrera= new JLabel("Nueva Carrera (Solo si eres estudiante): ");
		JTextField carrera = new JTextField(10);
		
		JLabel labelSemestre= new JLabel("Nuevo Semestre (Solo si eres estudiante): ");
		JTextField semestre = new JTextField(10);

		
		JLabel labelCorreo= new JLabel("Nuevo Correo (Solo si eres estudiante): ");
		JTextField correo = new JTextField(10);

		
		JLabel labelArea= new JLabel("Nueva Area (Solo si eres Coordinador): ");
		JTextField area = new JTextField(10);
		
		//Agregamos componente al panel
		panelRellenar.add(labelIdentificador);
		panelRellenar.add(identificador);
		



				panelRellenar.add(labelContraseña);
				panelRellenar.add(contraseña);

				panelRellenar.add(labelCarrera);
				panelRellenar.add(carrera);
				
				panelRellenar.add(labelSemestre);
				panelRellenar.add(semestre);

				panelRellenar.add(labelCorreo);
				panelRellenar.add(correo);

				panelRellenar.add(labelArea);
				panelRellenar.add(area);

				JPanel panelBoton=new JPanel();
				JButton btnCrear = new JButton("Modificar usuario");
				btnCrear.addActionListener(e -> cambiar(identificador.getText(),nombre.getText(),contraseña.getText(),carrera.getText(),semestre.getText(),correo.getText(),area.getText(),dialogoRegister));
				panelBoton.add(btnCrear);
				
				dialogoRegister.setLayout(new BorderLayout());
				dialogoRegister.add(new JLabel("Dejar en blanco los que no quiera modificar "),BorderLayout.NORTH);	
				dialogoRegister.add(panelRellenar,BorderLayout.CENTER);
				dialogoRegister.add(btnCrear,BorderLayout.SOUTH);
				
				dialogoRegister.setVisible(true);
	}

	private void cambiar(String identificador,String nombre, String contraseña, String carrera, String semestre, String correo, String area,
			JDialog dialogoRegister) {
		try {
			SistemaEspecifico sistema = SistemaEspecifico.getInstance();
			Usuario u = sistema.buscarUsuario(identificador);
			if(u == null) {
				JOptionPane.showMessageDialog(dialogoRegister,"Error","Identificador erroneo",JOptionPane.INFORMATION_MESSAGE);
				dialogoRegister.dispose();
			}
			
			if (!contraseña.isEmpty()) {
				u.setConstraseña(contraseña);
			if(!nombre.isEmpty()) {
				u.setNombre(nombre);
			}
			}
			if(u.estudiante()) {
				Estudiante estudiante = u.esteEstudiante();
				if(!carrera.isEmpty() ) {
					estudiante.setCarrera(carrera);
				}
				if(!semestre.isEmpty()) {
					int sem = 0;
					sem = Integer.parseInt(semestre);
					estudiante.setSemestre(sem);
				}
				
			}else if (u.coordinador()) {
				Coordinador coordinador = u.esteCoordinador();
				if(!area.isEmpty()) {
					coordinador.setInfo(area);
				}
			}
			
			JOptionPane.showMessageDialog(dialogoRegister,"Usuario Modificado con exito"," Exito",JOptionPane.INFORMATION_MESSAGE);
			dialogoRegister.dispose();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void crear() {
		JDialog dialogoRegister= new JDialog(this,"Registrar Usuario",true);
		dialogoRegister.setSize(350,300);
		dialogoRegister.setLocationRelativeTo(this);
		
		JPanel panelRellenar = new JPanel(new GridLayout(9,2,2,10));
		panelRellenar.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		JLabel labelTipo= new JLabel("Tipo: ");
		JTextField tipo = new JTextField(10);

		JLabel labelNombre= new JLabel("Nombre: ");
		JTextField nombre = new JTextField(10);
		
		JLabel labelRut= new JLabel("rut(Solo si eres estudiante): ");
		JTextField rut = new JTextField(10);

		
		JLabel labelContraseña= new JLabel("Contraseña: ");
		JTextField contraseña = new JTextField(10);

		
		JLabel labelCarrera= new JLabel("Carrera (Solo si eres estudiante): ");
		JTextField carrera = new JTextField(10);
		
		JLabel labelSemestre= new JLabel("Semestre (Solo si eres estudiante): ");
		JTextField semestre = new JTextField(10);

		
		JLabel labelCorreo= new JLabel("Correo (Solo si eres estudiante): ");
		JTextField correo = new JTextField(10);

		
		JLabel labelArea= new JLabel("Area (Solo si eres Coordinador): ");
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

		panelRellenar.add(labelCarrera);
		panelRellenar.add(carrera);
		
		panelRellenar.add(labelSemestre);
		panelRellenar.add(semestre);

		panelRellenar.add(labelCorreo);
		panelRellenar.add(correo);

		panelRellenar.add(labelArea);
		panelRellenar.add(area);

		JPanel panelBoton=new JPanel();
		JButton btnCrear = new JButton("Crear usuario");
		btnCrear.addActionListener(e -> factoryUsuario(tipo.getText(),nombre.getText(),contraseña.getText(),carrera.getText(),semestre.getText(),correo.getText(),area.getText(),rut.getText(),dialogoRegister));
		panelBoton.add(btnCrear);
		
		dialogoRegister.setLayout(new BorderLayout());
		dialogoRegister.add(panelRellenar,BorderLayout.CENTER);
		dialogoRegister.add(btnCrear,BorderLayout.SOUTH);
		
		dialogoRegister.setVisible(true);
	}

	

	private void factoryUsuario(String tipo,String nombre,String contraseña,String carrera, String semestre , String correo,String area ,String rut,JDialog dialogoRegister) {
		int semestre1=0;
		if(!semestre.isEmpty()) {
		semestre1 = Integer.parseInt(semestre);}
		Usuario usuarioNuevo= TipoFactory.crearUsuario( tipo, nombre, contraseña, carrera,  semestre1 ,  correo, area , rut);
		try {
			SistemaEspecifico sistema=SistemaEspecifico.getInstance();
			sistema.agregarUsuario(usuarioNuevo);
			JOptionPane.showMessageDialog(dialogoRegister,"Usuario Registrado","Exito",JOptionPane.INFORMATION_MESSAGE);
			dialogoRegister.dispose();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void salir() throws FileNotFoundException {
		dispose();
		VentanaVerificacion v = new VentanaVerificacion();
		v.setVisible(true);
	}


	
	
}

