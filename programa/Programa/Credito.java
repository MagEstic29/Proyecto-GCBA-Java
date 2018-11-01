package Programa;

import java.awt.Color;

public class Credito extends Tarjeta implements Clasica, Oro, Platino{
	//Atributos
	private int limiteCredito;
	private String tipo;
	private Color color;
	
	//Constructores
	public Credito() {
		super();
		this.limiteCredito = -1000;
		this.tipo= "Clasica";
	}
	
	public Credito(String numero, String operador, String clave, int limiteCredito, String tipo) {
		super(numero,operador,clave);
		this.limiteCredito= limiteCredito;
		this.tipo= tipo;
	}
	
	public Credito(String numero, String operador){
		super(numero,operador);
	}
	
	public Credito(String numero, String operador, String clave){
		super(numero, operador, clave );
		this.limiteCredito = -1000;
	}
	
	public Credito(String numero, String operador, String clave, int tipo){
		super(numero, operador, clave );
		if(tipo==1) { 
			modificarLimiteClasica();
			cambiarColor(Color.RED);
		}
		else if(tipo==2) { 
			limiteOro();
			cambiarColor(Color.GRAY);
		}
		else {
			limitePlatino();
			cambiarColor(Color.BLACK);
		}
	}
	
	//Destructor
	public void destruir(){
		limiteCredito=0;
		System.gc();
	}
	
	//Comportamiento
	public void cambiarTipo(String tipo) {
		this.tipo= tipo;
	}
	
	public boolean verificacionRetiro(int saldo) {
		if(saldo<limiteCredito) {
			if(saldo+limiteCredito>limiteCredito) {
				return false;
			}else {
				return true;	
			}
		}else {
			return false;
		}
	}
	
	public boolean verificacionRetiro(double saldo,double cantidad) {
			if(cantidad+(-saldo+limiteCredito)<0.0) {
				return false;
			}
			else {
				return true;	
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
	public void limitePlatino() {
		cambiarTipo("Platino");
		setLimiteCredito(-7000);
	}

	@Override
	public void limiteOro() {
		cambiarTipo("Oro");
		setLimiteCredito(-5000);
	}

	@Override
	public void modificarLimiteClasica() {
		cambiarTipo("Clasica");
		setLimiteCredito(-2000);		
	}

	@Override
	public boolean seguro() {
		return true;
	}

	@Override
	public boolean asistenciaConsejeria() {
		return true;
	}

	@Override
	public void ascenderAPlatino() {
		System.out.println("Puede ascender a platino");
	}

	@Override
	public double limiteSaldo() {
		return 10000;
	}

	@Override
	public void cambiarColor(Color color) {
		this.color= color;
	}

	//Getter's and Setter's
	public int getLimiteCredito() {
		return limiteCredito;
	}
	
	private void setLimiteCredito(int limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	
	//toString
	@Override
	public String toString() {
		return "Credito [limiteCredito=" + limiteCredito + "]";
	}
		
}
