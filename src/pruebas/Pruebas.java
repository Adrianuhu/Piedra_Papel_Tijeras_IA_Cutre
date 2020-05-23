package pruebas;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Pruebas
{

	  public static void main(String[] args) throws Exception {
	 
	        
	       double [][] matriz = new double[][] {{ 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017 }, { 25, 29.1, 32.1, 32.9, 31.9, 25.5, 20.1, 18.4, 15.3, 11.4, 9.5 }};
	        
	     int [] asdf = new int [3];
	     for (int i = 0; i < asdf.length; i++)
		{
			asdf[2]=2;
		}
	       
	       System.out.println(matriz[0][3]);
	    }
}
