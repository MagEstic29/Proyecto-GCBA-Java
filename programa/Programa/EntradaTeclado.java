package Programa;

import java.util.Scanner;

/**
* @author Gutierrez Beltran Jonathan
*
*
*/
public class EntradaTeclado{
	//Atributos
	private Scanner teclado = new Scanner( System.in );
	
	public int getEntero() {
		return teclado.nextInt();
	}
	
	public long getLong() {
		return teclado.nextLong();
	}
	
	public float getFlotante() {
		return teclado.nextFloat();
	}
	
	public String getCadena() {
		return teclado.nextLine();
	}
	
	public char getCaracter() {
		return teclado.nextLine().charAt(0);
	}
	
	public double getDouble() {
		return teclado.nextDouble();
	}
	
}