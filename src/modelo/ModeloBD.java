package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloBD
{

	private int countPiedra = 0;
	private int countPapel = 0;
	private int countTijeras = 0;

	public ModeloBD()
	{
	}

	public int resultadoOptimo()
	{
		int[] result = new int[]{ countPiedra, countPapel, countTijeras };

		int resultado = result[0];
		int indice = 0;

		for (int i = 1; i < result.length; i++)
		{
			if (result[i] > resultado)
			{
				indice = i;
			}
		}

		return indice;
	}

	public int getCountPiedra()
	{
		return countPiedra;
	}

	public int getCounPapel()
	{
		return countPapel;
	}

	public int getCountTijeras()
	{
		return countTijeras;
	}

	public void setCountPiedra(int countPiedra)
	{
		this.countPiedra = countPiedra;
	}

	public void setCountPapel(int countpapel)
	{
		this.countPapel = countpapel;
	}

	public void setCountTijeras(int countTijeras)
	{
		this.countTijeras = countTijeras;
	}

}// Fin de la clase
