package logica;

import java.io.FileNotFoundException;
import gui.*;
public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		SistemaEspecifico sistema = SistemaEspecifico.getInstance();
		VentanaVerificacion login = new VentanaVerificacion();
		login.setVisible(true);
	}
}
