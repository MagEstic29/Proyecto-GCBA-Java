package Programa;

import java.awt.Color;

public class Debito extends Tarjeta{
	//Atributos
	private int limiteDebito;
	private Color color;

	//Constructores
	public Debito() {
		super();
		this.limiteDebito = 0;
		this.color= Color.RED;
	}
	
	public Debito(String numero, String operador){
		super(numero,operador);
	}
	
	
	public Debito(String numero, String operador, String clave){
		super(numero, operador, clave );
		this.limiteDebito = 0;
	}
	public Debito(String numero, String operador, String clave, int limiteDebito){
		super(numero, operador, clave );
		this.limiteDebito = limiteDebito;
	}
	
	//Destructor
	public void destruir(){
		limiteDebito = 0;
		System.gc();
	}
	
	//Comportamiento
	public void cambiarLimite(int cantidad) {
		this.limiteDebito= cantidad;
		
	}
	
	public boolean verificacionRetiro(int saldo) {
		if(saldo<=limiteDebito) {
			return false;
		}else{
			return true;
		}
	}
	
	public boolean verificacionRetiro(double saldo,double cantidad) {
		if(cantidad-saldo>limiteDebito) {
			return true;
		}else{
			return false;
		}
	}	
	
	@Override
	public boolean verificar(String frase) {

		return super.verificar(frase);
	}

	@Override
	public boolean verificar(String frase1, String frase2) {

		return super.verificar(frase1, frase2);
	}

	@Override
	public boolean verificar(String frase1, String frase2, String frase3) {

		return super.verificar(frase1, frase2, frase3);
	}

	@Override
	public void cambiarClave(String nuevo) {
		super.cambiarClave(nuevo);
	}

	@Override
	public String getNumero() {

		return super.getNumero();
	}

	@Override
	public String getOperador() {
		return super.getOperador();
	}

	@Override
	public String getClave() {
		return super.getClave();
	}

	@Override
	public void cambiarColor(Color color) {
		this.color= color;
	}

	//Getter's and Setter's
	public int getLimiteDebito() {
		return limiteDebito;
	}
	
	private void setLimiteDebito(int limiteDebito) {
		this.limiteDebito = limiteDebito;
	}
	
	//toString
	@Override
	public String toString() {
		return "Limite: " + limiteDebito + "]";
	}
	
}
