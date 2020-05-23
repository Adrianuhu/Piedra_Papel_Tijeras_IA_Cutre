package vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import org.jfree.chart.ChartPanel;

import java.text.*;

public class VistaBD extends JFrame
{
	// TextFields
	JTextField t_notaBD = new JTextField(4);


	// Labels
	JLabel l_Titulo = new JLabel("NOTAS");
	JLabel l_BD = new JLabel("Base de Datos");


	// Botones
	public JButton b_Crear = new JButton("Crear");
	public JButton b_Ejecutar = new JButton("Ejecutar");

	// Paneles
	JPanel panCabecera = new JPanel();
	JPanel panNotas = new JPanel();
	ChartPanel Panel;
	
	// RadioButtons
	public ButtonGroup bg_radioB;
	public JRadioButton rb_All;
	public JRadioButton rb_Today;
	

	// Variable
	String bd, entor, lenM;
	double bdn, entorn, lenMn;

	public VistaBD()
	{
		super("Notas Alumnos IES El Torvisco");
		ventana();
		textos();
		etiquetas();
		radioButton();
		paneles();
		componentesApaneles();
		addAFrame();
	}


	public void ventana()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
	}
	

	public void paneles()
	{
		panCabecera.setLayout(new GridLayout(1, 1));
		panNotas.setLayout(new GridLayout(4, 3, 5, 5));
	}
	

	public void addAFrame()
	{
		add(panCabecera, BorderLayout.NORTH);
		add(panNotas, BorderLayout.CENTER);

		//setBounds(new Rectangle(800,350)); OTRA OPCION PARA TAMAÑO CONCRETO
		pack(); // AJUSTA CONTENIDO
		setResizable(false);

	}

	


	public void textos()
	{

		t_notaBD.setFont(new Font("TimesNewRoman", Font.PLAIN, 20));
		t_notaBD.setForeground(Color.BLUE);

	}

	public void etiquetas()
	{
		l_Titulo.setFont(new Font("TimesNewRoman", Font.BOLD, 14));
		l_BD.setFont(new Font("TimesNewRoman", Font.BOLD, 14));
	}

	public void radioButton()
	{
		bg_radioB = new ButtonGroup();
		rb_All = new JRadioButton("All");
		rb_Today = new JRadioButton("Today");
		bg_radioB.add(rb_All);
		bg_radioB.add(rb_Today);
	}
	
	public void componentesApaneles()
	{
		panCabecera.add(l_Titulo);
		panCabecera.add(b_Ejecutar);
		panCabecera.add(b_Crear);
		
		panCabecera.add(rb_All);
		panCabecera.add(rb_Today);
		
		panNotas.add(l_BD);
		panNotas.add(t_notaBD);


	}


}// Fin clase Principal
