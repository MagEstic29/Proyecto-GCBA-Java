package Programa;

public class CuentaBancaria extends Object {
	//Atributos
	private Tarjeta tarjeta;
	private String numero;
	private String nombre;
	private double saldo;
	
	//Constructores
	public CuentaBancaria(){
		numero= "";
		nombre= "";
		saldo= 0;
		tarjeta= new Debito();
	}

	public CuentaBancaria(Object tarjeta,String numero, String nombre, double saldo) {
		this.numero= numero;
		this.nombre= nombre;
		this.saldo= saldo;
		//MODIFICACIONES
		establecerTipo(tarjeta);
		//FIN
	}
	
	//Destructor
	public void destruir(){
		tarjeta= null;
		numero= null;
		nombre= null;
		System.gc();
	}
	
	//Comportamiento	
	public void reducirSaldo(int monto) {
		saldo -= monto;
	}
	
	public String protegerNumero() {
		String auxiliar= "";
		int i= numero.length();
		for(int j=0; j<i-4; j++) {
			auxiliar+= "*";
		}
		auxiliar+= (numero.substring(i-4, i));
		return auxiliar;
	}
	
	//Modificaciones
	public boolean verificarRetiro(double saldo,double cantidad) {
		if(tarjeta instanceof Debito) {
			Debito tarjetaDebito= (Debito)tarjeta;
			try {
				if(tarjetaDebito.verificacionRetiro(saldo,cantidad)) {
					return true;
				}else {
					return false;
				}
				}catch(NullPointerException en) {
					//System.err.println("prueba["+i+"] de Excepcion Credito"+numero);
				}
		}
		if(tarjeta instanceof Credito) {
			Credito tarjetaCredito= (Credito)tarjeta;
			try {
				if(tarjetaCredito.verificacionRetiro(saldo,cantidad)) {
					return true;
				}else {
					return false;
				}
				}catch(NullPointerException en) {
					//System.err.println("prueba["+i+"] de Excepcion Credito"+numero);
				}
		}
		return false;
	}
	public boolean verificarRetiro(int cantidad) {
		if(tarjeta instanceof Debito) {
			Debito tarjetaDebito= (Debito)tarjeta;
			try {
				if(tarjetaDebito.verificacionRetiro(cantidad)) {
					return true;
				}else {
					return false;
				}
				}catch(NullPointerException en) {
					//System.err.println("prueba["+i+"] de Excepcion Credito"+numero);
				}
		}
		if(tarjeta instanceof Credito) {
			Credito tarjetaCredito= (Credito)tarjeta;
			try {
				if(tarjetaCredito.verificacionRetiro(cantidad)) {
					return true;
				}else {
					return false;
				}
				}catch(NullPointerException en) {
					//System.err.println("prueba["+i+"] de Excepcion Credito"+numero);
				}
		}
		return false;
	}
	
	public void verificarSeguro() {//DownCasting
		if(tarjeta instanceof Credito) {
			((Credito) tarjeta).seguro();
		}
	}
	
	public void establecerTipo(Object o) {
		if(o instanceof Tarjeta) {
			this.tarjeta= (Tarjeta)o;
		}
		else {
			System.out.println("Tarjeta no es instancia de Credito ni Debito");
		}
	}
	
	//Fin
	
	//Getters	
	public String getNumero(){
		return numero;
	}
	
	public double getSaldo(){
		return saldo;
	}
	
	public String getNombreCliente(){
		return nombre;
	}
	
	public Tarjeta getTarjeta() {
		return tarjeta;
	}
	
	//MODIFICACIONES
	public Credito getCredito() {
		if(tarjeta instanceof Credito) {
			Credito tarjetaCredito= (Credito)tarjeta;
			return tarjetaCredito;
		}
		return null;
	}

	public Debito getDebito() {
		if(tarjeta instanceof Debito) {
			Debito tarjetaDebito= (Debito)tarjeta;
			return tarjetaDebito;
		}
		return null;
	}	
	//FIN

	//Setter's	
	private void setNumero(String numero){
		this.numero= numero;
	}
	
	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta= tarjeta;
	}
	
	private void setSaldo(double saldo){
		this.saldo= saldo;
	}
	
	private void setNombre(String nombre){
		this.nombre= nombre;
	}
	
	//toString
	public String toString(){
		return "Nombre del cliente: "+nombre+"\nNumero de cliente: "+numero+"\nSaldo: "+saldo+" pesos\n";
	}
	
}
