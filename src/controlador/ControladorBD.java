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

	public ControladorBD(ModeloBD m, VistaBD v) throws IOException
	{
		modelo = m;
		vista = v;

		acciones();

		iniciar();

	}

	public void nuevaVentana() throws IOException
	{
		VistaBD vista2 = new VistaBD();
		ModeloBD modelo = new ModeloBD();

		ControladorBD control = new ControladorBD(modelo, vista2);

		vista2.setLocation(800, 500);

	}

	public void acciones()
	{

		vista.rb_Today.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					modelo.proceder("Today");
					funcion();
				} catch (IOException e1)
				{
					e1.printStackTrace();
				}

			}
		});

		vista.rb_All.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					modelo.proceder("All");
					funcion();
				} catch (IOException e1)
				{
					e1.printStackTrace();
				}

			}
		});

		vista.b_Crear.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					nuevaVentana();
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

	}// Fin acciones()

	private void funcion() throws IOException
	{
		DefaultXYDataset dataset = new DefaultXYDataset();

		double[][] resultados = new double[][]
		{ tiempo(), temperatura() };

		dataset.addSeries("Temperaturas", resultados);

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.BLUE);
		renderer.setSeriesStroke(0, new BasicStroke(2));

		// dataset.addSeries("ie", new double[][] {{ 2007, 2008, 2009, 2010, 2011, 2012,
		// 2013, 2014, 2015, 2016, 2017 }, { 67.7, 63.1, 60.2, 50.6, 41.1, 31.8, 27.6,
		// 20.4, 17.3, 12.3, 8.1 }});
		// renderer.setSeriesPaint(1, Color.BLUE);
		// renderer.setSeriesStroke(1, new BasicStroke(2));

		JFreeChart chart = ChartFactory.createXYLineChart("Temperaturas", "Segundos", "Temperatura", dataset);
		chart.getXYPlot().getRangeAxis().setRange(0, 60);
		((NumberAxis) chart.getXYPlot().getRangeAxis()).setNumberFormatOverride(new DecimalFormat("#'ºC'"));
		chart.getXYPlot().setRenderer(renderer);

		BufferedImage image = chart.createBufferedImage(1000, 400);
		ImageIO.write(image, "png", new File("xy-chart.png"));

		ChartPanel Panel = new ChartPanel(chart);

		vista.getContentPane().add(Panel, BorderLayout.SOUTH);
		vista.pack();
	}

	private void cargarDatos()
	{

		ArrayList<ModeloBD> lista = modelo.getListaTemperatura();

		System.out.println("asdf");

		for (ModeloBD al : lista)
		{
			System.out
					.println(String.valueOf(al.getTiempo().getSeconds() + "   " + String.valueOf(al.getTemperatura())));
		}

	}

	private double[] tiempo()
	{
		double[] lista = new double[modelo.getListaTemperatura().size()];

		for (int i = 0; i < modelo.getListaTemperatura().size(); i++)
		{
			lista[i] = Double.valueOf(modelo.getListaTemperatura().get(i).getTiempo().getSeconds());
		}

		return lista;
	}

	private double[] temperatura()
	{
		double[] lista = new double[modelo.getListaTemperatura().size()];

		for (int i = 0; i < modelo.getListaTemperatura().size(); i++)
		{
			lista[i] = modelo.getListaTemperatura().get(i).getTemperatura();
		}

		return lista;
	}

	public void iniciar()
	{
		vista.setLocationRelativeTo(null);
		vista.setVisible(true);
	}
}
