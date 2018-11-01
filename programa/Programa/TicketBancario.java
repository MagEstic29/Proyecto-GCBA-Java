package Programa;

import java.util.Date;

public class TicketBancario extends Object{
	//Atributos
	private String folio;
	private String operacion;
	private Date fecha;
	private double cantidad;
	private String nombreSucursal;
	private String numeroCuenta;
	private String nombreBanco;
	
	//Constructores
	public TicketBancario(){
		folio= "";
		operacion= "";
		nombreSucursal= "";
		numeroCuenta= "";
		nombreBanco= "";
		cantidad= 0;
		fecha= new Date();
	}
	
	public TicketBancario(String folio,String operacion,String nombreSucursal,String numeroCuenta, String nombreBanco, double cantidad){
		this.nombreSucursal= nombreSucursal;
		this.numeroCuenta= numeroCuenta;
		this.cantidad= cantidad;
		this.nombreBanco= nombreBanco;
		this.operacion= operacion;
		this.folio= folio;
	}
	
	public TicketBancario(TicketBancario papel){
		this(papel.folio, papel.operacion, papel.nombreSucursal, papel.numeroCuenta, papel.nombreBanco, papel.cantidad);
	}
	
	//Destructor
	public void destruir(){
		nombreSucursal= null;
		numeroCuenta= null;
		cantidad= 0;
		nombreBanco= null;
		operacion= null;
		fecha= null;
		folio= null;
		System.gc();
	}
	
	//Comportamiento
	public void crearTicket(String banco, String sucursal, String numero, String movimiento, String serial, double cantidad) {
		setNombreBanco(banco);
		setNombreSucursal(sucursal);
		setNumeroCuenta(numero);
		setOperacion(movimiento);
		setFolio(serial);
		setCantidad(cantidad);
		fecha= new Date();
	}
	
	public void crearTicket(String banco, String sucursal, String movimiento, String serial, double cantidad) {
		setNombreBanco(banco);
		setNombreSucursal(sucursal);
		setOperacion(movimiento);
		setFolio(serial);
		setCantidad(cantidad);
		fecha= new Date();
	}
	
	//Getters
	public String getNombreSucursal(){
		return nombreSucursal;
	}
	
	public String getNumeroCuenta(){
		return numeroCuenta;
	}
	
	public double getCantidad(){
		return cantidad;
	}
	
	public String getNombreBanco(){
		return nombreBanco;
	}

	public String getOperacion(){
		return operacion;
	}
	public String getFolio(){
		return folio;
	}
	
	public Date getFecha() {
		return fecha;
	}
		//Setter's
	public void setNombreSucursal(String nombreSucursal){
		this.nombreSucursal= nombreSucursal;
	}
	
	public void setNumeroCuenta(String numeroCuenta){
		this.numeroCuenta= numeroCuenta;
	}
	
	public void setCantidad(double cantidad){
		this.cantidad= cantidad;
	}
	
	public void setNombreBanco(String nombreBanco){
		this.nombreBanco= nombreBanco;
	}
	
	public void setOperacion(String operacion){
		this.operacion= operacion;
	}
	
	public void setFolio(String folio){
		this.folio= folio;
	}
	
	//toString
	public String toString(){
		return "\t"+nombreBanco+"\nSucursal: "+nombreSucursal+"\nFecha y hora: "+fecha+"\nNumero de folio: "+folio+"\nMovimiento: "+operacion
		+"\nNumero de cuenta: "+numeroCuenta+"\n\nCantidad: "+cantidad+" Pesos";
	}
	
}
