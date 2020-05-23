package MVC;

import modelo.*;
import vista.*;

import java.io.IOException;

import controlador.*;

public class BD_MVC_Principal
{
	public static void main(String[] args) throws IOException
	{
		ModeloBD miModelo = new ModeloBD();
		VistaBD miVista = new VistaBD();
		ControladorBD miControlador = new ControladorBD(miModelo,miVista);
		
	}
}

