package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloBD
{

	private int countPiedra = 1;
	private int countPapel = 1;
	private int countTijeras = 1;

	public ModeloBD()
	{
	}




	public int resultadoOptimo()
	{
		int total = countPiedra + countPapel + countTijeras;

		int porcentPiedra = countPiedra * 100 / total;
		int porcentPapel = countPapel * 100 / total;
		int porcentTijeras = countTijeras * 100 / total;

		int numRandom = (int) (Math.random() * 101);

		if (numRandom <= porcentPiedra)
		{
			return 1;
		} else if (numRandom > porcentPiedra && numRandom <= (porcentTijeras+porcentPiedra))
		{
			return 0;
		} else
		{
			return 2;

		}
//TERMINAR
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
