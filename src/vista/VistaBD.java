package vista;

import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;

import javax.swing.*;

import org.jfree.chart.ChartPanel;

import java.text.*;

public class VistaBD extends JFrame
{
	// JTextField
	public JTextField jtfWins = new JTextField();
	public JTextField jtfLoses = new JTextField();

	// Botones
	public JButton jbReset = new JButton("RESET");
	public JButton jbCambioUser = new JButton("USER");
	public JButton jbPiedraUser = new JButton("");
	public JButton jbPapelUser = new JButton("");
	public JButton jbTijerasUser = new JButton("");

	public JButton jbPiedraUserIA = new JButton("");
	public JButton jbPapelUserIA = new JButton("");
	public JButton jbTijerasUserIA = new JButton("");

	// Paneles
	JPanel panHeader = new JPanel();
	JPanel panBody = new JPanel();

	// Imagenes
	ImageIcon imgPiedra = new ImageIcon(".\\src\\images\\piedra.png");
	Icon imagenPiedra = new ImageIcon(imgPiedra.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
	Icon laImagenPiedra = imagenPiedra;

	ImageIcon imgPapel = new ImageIcon(".\\src\\images\\papel.png");
	Icon imagenPapel = new ImageIcon(imgPapel.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
	Icon laImagenPapel = imagenPapel;

	ImageIcon imgTijeras = new ImageIcon(".\\src\\images\\tijeras.png");
	Icon imagenTijeras = new ImageIcon(imgTijeras.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
	Icon laImagenTijeras = imagenTijeras;

	ImageIcon imgOculto = new ImageIcon(".\\src\\images\\oculto.png");
	Icon imagenOculto = new ImageIcon(imgOculto.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
	Icon laImagenOculto = imagenOculto;

	public VistaBD()
	{
		super("Notas Alumnos IES El Torvisco");
		ventana();
		botones();
		etiquetas();
		paneles();
		componentesApaneles();
		addAFrame();
	}

	public void ventana()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

	}

	public void botones()
	{

		jbPiedraUser.setIcon(laImagenPiedra);
		jbPapelUser.setIcon(laImagenPapel);
		jbTijerasUser.setIcon(laImagenTijeras);
		jbPiedraUserIA.setIcon(laImagenOculto);
		jbPapelUserIA.setIcon(laImagenOculto);
		jbTijerasUserIA.setIcon(laImagenOculto);

		jbPapelUserIA.setEnabled(false);
		jbPiedraUserIA.setEnabled(false);
		jbTijerasUserIA.setEnabled(false);

		jbPiedraUser.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		jbPapelUser.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		jbTijerasUser.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		jbPiedraUserIA.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		jbPapelUserIA.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		jbTijerasUserIA.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

	}

	public void ganador(JButton boton)
	{
		boton.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
	}

	public void perdedor(JButton boton)
	{
		boton.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
	}

	public void empatador(JButton boton)
	{
		boton.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
	}

	public void reset()
	{
		jbPiedraUser.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		jbPapelUser.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		jbTijerasUser.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		jbPiedraUserIA.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		jbPapelUserIA.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		jbTijerasUserIA.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		jbPiedraUserIA.setIcon(laImagenOculto);
		jbPapelUserIA.setIcon(laImagenOculto);
		jbTijerasUserIA.setIcon(laImagenOculto);
	}

	public void desvelarPiedra()
	{
		jbPiedraUserIA.setIcon(laImagenPiedra);
	}

	public void desvelarPapel()
	{
		jbPapelUserIA.setIcon(laImagenPapel);
	}

	public void desvelarTijeras()
	{
		jbTijerasUserIA.setIcon(laImagenTijeras);
	}

	public void sumarContador(JTextField texto)
	{
		texto.setText(String.valueOf(Integer.valueOf(texto.getText()) + 1));

	}

	public void paneles()
	{
		panHeader.setLayout(new GridLayout(1, 4, 20, 30));
		panBody.setLayout(new GridLayout(2, 3, 10, 20));
	}

	public void addAFrame()
	{
		add(panHeader, BorderLayout.NORTH);
		add(panBody, BorderLayout.CENTER);

		pack(); // AJUSTA CONTENIDO
		setResizable(false);

	}

	public void etiquetas()
	{

		jtfWins.setFont(new Font("Calibri", Font.BOLD, 20));
		jtfWins.setForeground(Color.WHITE);
		jtfWins.setBackground(Color.GREEN);
		jtfWins.setText("0");
		jtfWins.setEditable(false);
		jtfWins.setHorizontalAlignment(JTextField.CENTER);

		jtfLoses.setFont(new Font("Calibri", Font.BOLD, 20));
		jtfLoses.setForeground(Color.WHITE);
		jtfLoses.setBackground(Color.RED);
		jtfLoses.setText("0");
		jtfLoses.setEditable(false);
		jtfLoses.setHorizontalAlignment(JTextField.CENTER);
	}

	public void componentesApaneles()
	{
		panHeader.add(jtfWins);
		panHeader.add(jbReset);
		panHeader.add(jbCambioUser);
		panHeader.add(jtfLoses);

		panBody.add(jbPiedraUser);
		panBody.add(jbPapelUser);
		panBody.add(jbTijerasUser);

		panBody.add(jbPiedraUserIA);
		panBody.add(jbPapelUserIA);
		panBody.add(jbTijerasUserIA);

	}

}// Fin clase Principal
