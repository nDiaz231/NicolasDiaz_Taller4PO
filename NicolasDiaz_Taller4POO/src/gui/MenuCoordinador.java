package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
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

	private Object metricas() {
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
		btnGenerarReporte.addActionListener(e -> generarReporte(dialogoRegister));

		
		dialogoRegister.setLayout(new BorderLayout());
		dialogoRegister.add(new JLabel("Seleccione opción "),BorderLayout.NORTH);	
		dialogoRegister.add(panelBoton,BorderLayout.CENTER);
		
		dialogoRegister.setVisible(true);
		
		
		
	}
	private Object generarReporte(JDialog dialogoRegister) {
		// TODO Auto-generated method stub
		return null;
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
			
			JPanel panelRellenar = new JPanel(new GridLayout(3,2,2,10));
			panelRellenar.setBorder(BorderFactory.createEmptyBorder(9,10,10,10));
			
			JLabel labelNombre = new JLabel("Nombre acutal : "+c.getNombre() );
			JTextField nombre = new JTextField(10);
			
			JLabel labelDescripcion = new JLabel("Descripcion acutal : "+c.getDescripcion() );
			JTextField descripcion = new JTextField(10);
			
			JLabel labelRequisitos = new JLabel("Requisitos acutal : "+c.getRequisitos() );
			JTextField requisitos = new JTextField(10);
			
			JLabel labelAños = new JLabel("Requisitos acutal : "+c.getAñosValidez() );
			JTextField años = new JTextField(10);
			
			panelRellenar.add(labelNombre);
			panelRellenar.add(nombre);
			
			panelRellenar.add(labelDescripcion);
			panelRellenar.add(descripcion);
			
			panelRellenar.add(labelNombre);
			panelRellenar.add(nombre);
			
			panelRellenar.add(labelRequisitos);
			panelRellenar.add(requisitos);
			
			panelRellenar.add(labelAños);
			panelRellenar.add(años);
			
			
			
			
			
			
			JPanel panelBoton=new JPanel();
			JButton btnModificar = new JButton("Modificar Linea de certificado");
			
			panelBoton.add(btnModificar);
			
			dialogoEditar.setLayout(new BorderLayout());
			dialogoEditar.add(new JLabel("Dejar en blanco los que no quiera modificar "),BorderLayout.NORTH);	
			dialogoEditar.add(panelRellenar);
			dialogoEditar.add(panelBoton,BorderLayout.CENTER);
			
			dialogoEditar.setVisible(true);
			
		
			
			
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	}
	


