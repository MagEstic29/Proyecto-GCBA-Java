package Programa;

import java.awt.Color;

public abstract class Tarjeta extends Object{
	//Atributos
	private String numero;
	private String operador;
	private String clave;
	
	//Constructores
	public Tarjeta(){
		numero= "";
		operador= "MasterCard";
		clave= "";
	}
	
	public Tarjeta(String numero, String operador){
		this.numero= numero;
		this.operador= operador;
		this.clave= "";
	}
	
	public Tarjeta(String numero, String operador, String clave){
		this.numero= numero;
		this.operador= operador;
		this.clave= clave;
	}
	
	public Tarjeta(Tarjeta plastico){
		this(plastico.numero, plastico.operador, plastico.clave);
	}
	
	//Destructor
	public void destruir(){
		numero= null;
		operador= null;
		clave= null;
		System.gc();
	}
	
	//Comportamiento
	public abstract void cambiarColor(Color cambio);
	
	public boolean verificar(String frase) {
		if(frase.compareTo(numero)==0 || frase.compareTo(clave)==0 || frase.compareTo(operador)==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verificar(String frase1, String frase2) {
		if(verificar(frase1)&verificar(frase2)== true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verificar(String frase1, String frase2, String frase3) {
		if(verificar(frase1, frase2)&verificar(frase3)==true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void cambiarClave(String nuevo) {
		setClave(nuevo);
	}
	
	//Getter's
	public String getNumero(){
		return numero;
	}
	
	public String getOperador(){
		return operador;
	}
	
	public String getClave() {
		return clave;
	}
	
	//Setter's
	private void setNumero(String numero){
		this.numero= numero;
	}
	
	private void setOperador(String operador){
		this.operador= operador;
	}
	
	private void setClave(String clave) {
		this.clave= clave;
	}
	
	//toString
	public String toString(){
		return "Numero de Tarjeta: "+numero+"\nOperador: "+operador+" ";
	}
	
}
