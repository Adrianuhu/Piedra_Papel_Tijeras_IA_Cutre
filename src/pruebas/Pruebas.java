package pruebas;

public class Pruebas
{
	private int countPiedra = 20;
	private int countPapel = 30;
	private int countTijeras = 40;

	public static void main(String[] args) throws Exception
	{
		int dinero = 0;
		int eleccionNUM = (int) (Math.random() * 3);

		
		
		System.out.println(dinero);

	}

	public int resultadoOptimo()
	{
		int[] result = new int[]
		{ countPiedra, countPapel, countTijeras };

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

}
