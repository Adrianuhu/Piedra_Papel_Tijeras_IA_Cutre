package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloBD
{

	private double temperatura;

	private java.util.Date tiempo = new java.util.Date();
	private java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String currentTime = sdf.format(tiempo);

	private ArrayList<ModeloBD> listaTemperaturas;

	public ModeloBD()
	{
	}

	public ModeloBD(java.util.Date tiempo, double temperatura)
	{
		super();
		this.tiempo = tiempo;
		this.temperatura = temperatura;
	}

	public void proceder(String opcion)
	{
		ResultSet resultado;

		try
		{
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/temperaturas_duron?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "falso123");
			Statement textoSql = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			if (opcion.equalsIgnoreCase("Today"))
			{

				resultado = textoSql.executeQuery(
						"select tiempo, avg(temperatura)'temperatura' from temperaturas_duron.temperaturas where day(tiempo) like day(current_date()) group by hour(tiempo)");
			} else if (opcion.equalsIgnoreCase("All"))
			{
				resultado = textoSql.executeQuery("select tiempo, temperatura from temperaturas_duron.temperaturas");
			}

			else
			{
				resultado = textoSql.executeQuery("select tiempo, temperatura from temperaturas");
			}

			if (resultado.next())
			{
				listaTemperaturas = new ArrayList<>();

				java.util.Date tiempoV = new java.util.Date();

				double temperaturaV;

				resultado.absolute(0);
				while (resultado.next())
				{
					tiempoV = resultado.getTimestamp("tiempo");
					temperaturaV = resultado.getDouble("temperatura");

					ModeloBD obj = new ModeloBD(tiempoV, temperaturaV);

					listaTemperaturas.add(obj);
				}
			}

		} // Fin try
		catch (Exception e)
		{
			System.out.println(e);
		}

	}// Fin de proceder()

	public java.util.Date getTiempo()
	{
		return tiempo;
	}

	public double getTemperatura()
	{
		return temperatura;
	}

	public ArrayList<ModeloBD> getListaTemperatura()
	{
		return listaTemperaturas;
	}

}// Fin de la clase
