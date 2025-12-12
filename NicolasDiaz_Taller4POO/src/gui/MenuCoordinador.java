package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
		//coordinador panel
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

	private void metricas() {
		JDialog dialogoRegister= new JDialog(this,"Panel metricas",true);
		
		dialogoRegister.setSize(450,500);
		dialogoRegister.setLocationRelativeTo(this);
		
		JPanel panelRellenar = new JPanel(new GridLayout(2,2,2,10));
		panelRellenar.setBorder(BorderFactory.createEmptyBorder(9,10,10,10));
		
		
		JPanel panelBoton=new JPanel();
		JButton btnEstadisticas = new JButton("Estadisticas de estudiante que pasaron la linea de certificacion");
		JButton btnAnalisis= new JButton("Analisis de asignaturas criticas");
		panelBoton.add(btnEstadisticas);
		panelBoton.add(btnAnalisis);
		btnEstadisticas.addActionListener(e -> estadisticas(dialogoRegister));
		btnAnalisis.addActionListener(e -> analisis());

		
		dialogoRegister.setLayout(new BorderLayout());
		dialogoRegister.add(new JLabel("Seleccione opción "),BorderLayout.NORTH);	
		dialogoRegister.add(panelBoton,BorderLayout.CENTER);
		
		dialogoRegister.setVisible(true);
		
		
		
	}

	
	
	
	
	
	
	private void estadisticas(JDialog dialogoRegister) {
		try {
			SistemaEspecifico sistema = SistemaEspecifico.getInstance();
			ArrayList<Certificacion> certificaciones = sistema.getCertificaciones();
			
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	private Object analisis() {
		// TODO Auto-generated method stub
		return null;
	}
	private void certificados() {
		JDialog dialogoRegister= new JDialog(this,"Gestion Certificados",true);
		
		dialogoRegister.setSize(250,300);
		dialogoRegister.setLocationRelativeTo(this);
		
		JPanel panelRellenar = new JPanel(new GridLayout(1,2,2,10));
		panelRellenar.setBorder(BorderFactory.createEmptyBorder(9,10,10,10));
		
		
		JPanel panelBoton=new JPanel();
		JButton btnModificar = new JButton("Modificar Linea de certificado");
		JButton btnGenerarReporte= new JButton("Crear Reporte");
		panelBoton.add(btnModificar);
		panelBoton.add(btnGenerarReporte);
		btnModificar.addActionListener(e -> modificar());
		btnGenerarReporte.addActionListener(e -> {
			try {
				generarReporte(dialogoRegister);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		
		dialogoRegister.setLayout(new BorderLayout());
		dialogoRegister.add(new JLabel("Seleccione opción "),BorderLayout.NORTH);	
		dialogoRegister.add(panelBoton,BorderLayout.CENTER);
		
		dialogoRegister.setVisible(true);
		
		
		
	}
	
	
	private void generarReporte(JDialog dialogoRegister) throws IOException {
		
		SistemaEspecifico sistema;
		try {
			sistema = SistemaEspecifico.getInstance();
			//Crearemos el registro con cada alumno que tenga un 100 en el registro
			ArrayList<Usuario> usuarios = sistema.getUsuario();
			//Generamos reporte
			try (FileWriter writer = new FileWriter("reportes.txt")) {
				writer.write("\n");
				writer.write("---Reporte---");
				writer.write("\n");
				
				for (Usuario u: usuarios) {
					if(u.estudiante()) {
						Estudiante e = u.esteEstudiante();
						for(Registro r : e.getInscripcion()) {
							if(r.getProgreso() == 100) {
								writer.write("\n");
								writer.write("Paso la linea de certificacion:" + e.getNombre());
								writer.write("\n");
								writer.write("Fecha :" +r.getFechaDeRegistro() );
							}
						}
					}
				
					}
					

				}
			JOptionPane.showMessageDialog(this,"Exito","Reporte creado",JOptionPane.INFORMATION_MESSAGE);
			dialogoRegister.dispose();
		
		
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	private void modificar( ) {
		JDialog dialogoRegister= new JDialog(this,"Modificar Linea de certificación",true);
		dialogoRegister.setSize(450,550);
		dialogoRegister.setLocationRelativeTo(this);
		
		JPanel panelRellenar = new JPanel(new GridLayout(2,2,2,10));
		panelRellenar.setBorder(BorderFactory.createEmptyBorder(9,10,10,10));
		
		//Creamos nuestras componentes 

		JLabel labelCertificacion= new JLabel("Ingrese ID de la certificación: ");
		JTextField certificacion = new JTextField(10);
		
	

		
		//Agregamos componente al panel

		panelRellenar.add(labelCertificacion);
		panelRellenar.add(certificacion);

				
				JPanel panelBoton=new JPanel();
				JButton btnCrear = new JButton("Cambiar");
				btnCrear.addActionListener(e -> cambiarLinea(certificacion.getText()));
				panelBoton.add(btnCrear);
				
				dialogoRegister.setLayout(new BorderLayout());
				dialogoRegister.add(panelRellenar,BorderLayout.CENTER);
				dialogoRegister.add(btnCrear,BorderLayout.SOUTH);
				
				dialogoRegister.setVisible(true);
	}
	private void cambiarLinea(String certificacion) {
		
		try {
			SistemaEspecifico sistema = SistemaEspecifico.getInstance();
			Certificacion c = sistema.buscarCertificacion(certificacion);
			if (c == null) {
				JOptionPane.showMessageDialog(this,"Error","Identificador erroneo",JOptionPane.INFORMATION_MESSAGE);
				return;}
				
			JDialog dialogoEditar= new JDialog(this,"Editanto: "+c.getNombre(),true);
			
		
			dialogoEditar.setSize(400,300);
			dialogoEditar.setLocationRelativeTo(this);
			
			JPanel panelRellenar = new JPanel(new GridLayout(4,2,2,10));
			panelRellenar.setBorder(BorderFactory.createEmptyBorder(9,10,10,10));
			
			JLabel labelNombre = new JLabel("Nombre acutal : \n"+c.getNombre() );
			JTextField nombre = new JTextField(10);
			
			JLabel labelDescripcion = new JLabel("Descripcion acutal : \n"+c.getDescripcion() );
			JTextField descripcion = new JTextField(10);
			
			JLabel labelRequisitos = new JLabel("Requisitos acutales : \n"+c.getRequisitos() );
			JTextField requisitos = new JTextField(10);
			
			JLabel labelAños = new JLabel("Años de validacion acutales : \n"+c.getAñosValidez() );
			JTextField años = new JTextField(10);
			
			panelRellenar.add(labelNombre);
			panelRellenar.add(nombre);
			
			panelRellenar.add(labelDescripcion);
			panelRellenar.add(descripcion);

			panelRellenar.add(labelRequisitos);
			panelRellenar.add(requisitos);
			
			panelRellenar.add(labelAños);
			panelRellenar.add(años);
			
			
			
			
			
			
			JPanel panelBoton=new JPanel();
			JButton btnModificar = new JButton("Modificar Linea de certificado");
			//Llamamos al metodoo
			btnModificar.addActionListener(e -> modificarLinea(nombre.getText(),descripcion.getText(),requisitos.getText(),años.getText(),c,dialogoEditar));
			
			panelBoton.add(btnModificar);
			
			dialogoEditar.setLayout(new BorderLayout());
			dialogoEditar.add(new JLabel("Dejar en blanco los que no quiera modificar "),BorderLayout.NORTH);	
			dialogoEditar.add(panelRellenar);
			dialogoEditar.add(panelBoton,BorderLayout.SOUTH);
			
			dialogoEditar.setVisible(true);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	//Cambios las lineas dependiendo si esta vacio o no el textField
	private void modificarLinea(String nombre, String descripcion, String requisitos, String años, Certificacion c, JDialog dialogoEditar) {
		if(!nombre.isEmpty()) {
			c.setNombre(nombre);
		}
		if(!descripcion.isEmpty()) {
			c.setDescripcion(descripcion);
		}
		if(!requisitos.isEmpty()) {
			int requisito =0 ;
			requisito = Integer.parseInt(requisitos);
			c.setRequisitos(requisito);
		}
		if(!años.isEmpty()) {
			int año =0 ;
			año = Integer.parseInt(años);
			c.setAñosValidez(año);
		}
		
		JOptionPane.showMessageDialog(this,"exito","Modificado correctamente",JOptionPane.INFORMATION_MESSAGE);
		dialogoEditar.dispose();

	}
	

	}
	


