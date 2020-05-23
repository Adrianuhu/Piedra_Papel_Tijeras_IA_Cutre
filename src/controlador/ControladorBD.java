package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import modelo.ModeloBD;
import vista.VistaBD;

public class ControladorBD
{
	private VistaBD vista;
	private ModeloBD modelo;
	private String eleccion;

	public ControladorBD(ModeloBD m, VistaBD v) throws IOException
	{
		modelo = m;
		vista = v;

		acciones();

		iniciar();

	}

	public void acciones()
	{

		vista.jbPiedraUser.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{

				if (jugar("Piedra") == 0)
				{
					System.out.println("EMPATE");
				} else if (jugar("Piedra") == 1)
				{
					vista.jtfLoses.setText(String.valueOf(Integer.valueOf(vista.jtfLoses.getText()) + 1));
				} else
				{
					vista.jtfWins.setText(String.valueOf(Integer.valueOf(vista.jtfWins.getText()) + 1));
				}

			}
		});

		vista.jbPapelUser.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{

				if (jugar("Papel") == 0)
				{
					System.out.println("EMPATE");
				} else if (jugar("Papel") == 1)
				{
					vista.jtfLoses.setText(String.valueOf(Integer.valueOf(vista.jtfLoses.getText()) + 1));
				} else
				{
					vista.jtfWins.setText(String.valueOf(Integer.valueOf(vista.jtfWins.getText()) + 1));
				}

			}
		});

		vista.jbTijerasUser.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{

				if (jugar("Tijeras") == 0)
				{
					System.out.println("EMPATE");
				} else if (jugar("Tijeras") == 1)
				{
					vista.jtfLoses.setText(String.valueOf(Integer.valueOf(vista.jtfLoses.getText()) + 1));
				} else
				{
					vista.jtfWins.setText(String.valueOf(Integer.valueOf(vista.jtfWins.getText()) + 1));
				}

			}
		});

		vista.jbReset.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				vista.jtfWins.setText("0");
				vista.jtfLoses.setText("0");
			}
		});

	}// Fin acciones()

	private int jugar(String eleccionUSER)
	{
		String eleccionIA = null;

		int eleccionNUM = (int) (Math.random() * 3);

		switch (eleccionNUM)
		{
		case 0:
			eleccionIA = "Piedra";
			break;
		case 1:
			eleccionIA = "Papel";
			break;
		case 2:
			eleccionIA = "Tijeras";
			break;

		}

		if (eleccionUSER.equalsIgnoreCase(eleccionIA))
		{
			return 0;
		} else if ((eleccionUSER.equalsIgnoreCase("Piedra") && eleccionIA.equalsIgnoreCase("Papel"))
				|| (eleccionUSER.equalsIgnoreCase("Tijeras") && eleccionIA.equalsIgnoreCase("Piedra"))
				|| (eleccionUSER.equalsIgnoreCase("Papel") && eleccionIA.equalsIgnoreCase("Tijeras")))
		{
			return 1;
		} else
		{
			return 2;
		}

	}

	public void iniciar()
	{
		vista.setLocationRelativeTo(null);
		vista.setVisible(true);
	}
}
