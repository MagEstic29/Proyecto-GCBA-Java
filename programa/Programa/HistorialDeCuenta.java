package Programa;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Date;

public class HistorialDeCuenta extends Object {
	//Atributos
	private LinkedList<String> historial;
	
	//Constructores
	public HistorialDeCuenta(){
		historial= new LinkedList<>();
	}
	
	public HistorialDeCuenta(LinkedList<String> historial){
		this.historial= historial;
	}
	
	public HistorialDeCuenta(HistorialDeCuenta movimiento){
		this(movimiento.historial);
	}
	
	//Destructor
	public void destruir(){
		historial.clear();
		historial= null;
		System.gc();
	}
	
	//Comportamiento
	public void guardarMovimiento(String cadena) {
		historial.add(cadena);
	}
	
	public void mostrarHistorial() {
		Iterator<String> itera= historial.iterator();
		String aux;
		while(itera.hasNext()!=false) {
			aux= itera.next();
			System.out.println(aux);
		}
	}
	
	public void mostrarMovimiento(Date fecha) {
		
	}
	
	//Getters
	
	//Setter's
	
	//toString
	
}