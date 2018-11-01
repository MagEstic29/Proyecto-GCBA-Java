package Programa;

import java.awt.Color;
import java.sql.Date;
import java.util.Iterator;
import java.util.LinkedList;

public class Banco extends Object{
	//Atributos
	private String nombre;
	private String pais;
	private LinkedList<CuentaBancaria> cuentas;
	private CuentaBancaria auxiliar;
	
	//MODIFICACIONES
	private HistorialDeCuenta movimientos;
	//FIN

	//Constructores
	public Banco(){
		nombre= "Santader S.A de C.V";
		pais= "Mexico";
		cuentas= new LinkedList<>();
		auxiliar= new CuentaBancaria(new Credito("76476345645453", "MasterCard", "1234",1),
				"1234567890876543", "Messi", 0.0);
		cuentas.add(auxiliar);
		auxiliar= new CuentaBancaria(new Credito("76487547589898", "MasterCard", "2255",2),
				"1234567890876545", "Diosito Ayudame", 714.36);
		cuentas.add(auxiliar);
		auxiliar= new CuentaBancaria(new Debito("76490096314234", "MasterCard", "2850",0),
				"1234567890876547", "Lord Penia", 0.0);
		cuentas.add(auxiliar);
		//MODIFICACIONES
		movimientos= new HistorialDeCuenta();
		//FIN
	}
	
	public Banco(String nombre, String pais, LinkedList<CuentaBancaria> cuentas,/*MODIFICACIONES*/HistorialDeCuenta movimientos){
		this.nombre= nombre;
		this.pais= pais;
		this.cuentas= cuentas;

		//MODIFICACIONES
		this.movimientos= movimientos;
		//FIN

	}
	
	public Banco(Banco nuevo) {
		this(nuevo.nombre, nuevo.pais, nuevo.cuentas/*MODIFICaciones*/,nuevo.movimientos);
	}
	
	//Destructor
	public void destruir(){
		nombre= null;
		pais= null;
		cuentas= null;

		//MODIFICACIONES
		movimientos= null;
		//FIN		
		System.gc();
	}
	
	//Comportamiento
	public CuentaBancaria iterarCuentas(String numero, String red) {
		Iterator<CuentaBancaria> itera= cuentas.iterator();
		while(itera.hasNext()!=false) {
			//System.out.println("prueba["+i+"]"+numero);
			auxiliar= itera.next();
			try {
				if(auxiliar.getDebito().getNumero().compareTo(numero)==0 && auxiliar.getDebito().getOperador().compareTo(red)==0) {
					return auxiliar;
				}
				}catch(NullPointerException en) {
					//System.err.println("prueba["+i+"] de Excepcion Debito"+numero);
				}
			try {
				if(auxiliar.getCredito().getNumero().compareTo(numero)==0 && auxiliar.getCredito().getOperador().compareTo(red)==0) {
					return auxiliar;
				}
				}catch(NullPointerException en) {
					//System.err.println("prueba["+i+"] de Excepcion Credito"+numero);
				}	
		}
		
		return null;
	}
	
	public boolean validarTarjeta(Tarjeta tarjeta, String numero) {//UpCasting
			return tarjeta.verificar(numero);//Metodo Poliformico
	}
	
	public void actualizarTarjeta(Object tarjeta) {
		if(tarjeta instanceof Debito) {
			Debito nueva= (Debito)tarjeta;
			nueva.cambiarColor(Color.BLUE);
			auxiliar.setTarjeta(nueva);
		}
		else if(tarjeta instanceof Credito) {
			Credito nueva= (Credito)tarjeta;
			nueva.cambiarColor(Color.BLUE);
			auxiliar.setTarjeta(nueva);
		}
		else{
			
		}
	}
	
	public boolean validarRetiro(Object tarjeta, int saldo) {//DownCasting
		if(tarjeta instanceof Debito) {
			Debito nueva= (Debito)tarjeta;
			return nueva.verificacionRetiro(saldo);//Metodo Poliformico
		}
		else if(tarjeta instanceof Credito) {
			Credito nueva= (Credito)tarjeta;
			return nueva.verificacionRetiro(saldo);//Metodo Poliformico
		}
		return false;
	}
	
	public CuentaBancaria iterarCuentas(String numero) {
		Iterator<CuentaBancaria> itera= cuentas.iterator();
		while(itera.hasNext()!=false) {
			auxiliar= itera.next();
			if(auxiliar.getDebito().getNumero().compareTo(numero)==0) {
				return auxiliar;
			}
		}
		return null;
	}
	
	public void mostrarCuentas() {
		Iterator<CuentaBancaria> itera= cuentas.iterator();
		while(itera.hasNext()!=false) {
			auxiliar= itera.next();
			System.out.println(auxiliar.toString());
		}
		System.out.println("\n");
	}
	//MODIFICIACIONES INICIO

	public void guardarMovimiento(String folio,String operacion,String nombreSucursal,double cantidad) {
		Date dato= new Date(0);
		String cadena="";
		cadena= dato+"\t"+folio+"\t"+nombreSucursal+"\t"+operacion+"\t"+cantidad+" pesos";
		movimientos.guardarMovimiento(cadena);
	}
	
	public void guardarMovimiento(TicketBancario ticket) {
		String cadena="";
		cadena= ticket.getFecha()+"\t"+ticket.getFolio()+"\t"+ticket.getNombreSucursal()+"\t"+ticket.getOperacion()+"\t"+ticket.getCantidad()+" pesos";
		movimientos.guardarMovimiento(cadena);
	}

	public void mostrarMovimientos() {
		movimientos.mostrarHistorial();
	}
	//MODIFICACIONES FIN

	//Getter's
	public String getNombre(){
		return nombre;
	}
	
	public String getPais(){
		return pais;
	}
	
	//Setter's
	public void setNombre(String nombre){
		this.nombre= nombre;
	}
	
	public void setPais(String pais){
		this.pais= pais;
	}
	
	//toString
	public String toString(){
		return "Nombre de banco: "+nombre+"\nLocalidad: "+pais+" ";
	}
	
}
