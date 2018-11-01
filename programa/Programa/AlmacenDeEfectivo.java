package Programa;

public class AlmacenDeEfectivo extends Object{
	//Atributos
	private int cantidad;
	private int limite;
	
	//Constructores
	public AlmacenDeEfectivo(){
		cantidad= 2000000;
		limite= 5000000;
	}
	
	public AlmacenDeEfectivo(int cantidad, int limite){
		this.cantidad= cantidad;
		this.limite= limite;
	}
	
	public AlmacenDeEfectivo(AlmacenDeEfectivo almacen){
		this(almacen.cantidad, almacen.limite);
	}
	
	//Destructor
	public void destruir(){
		cantidad= 0;
		limite= 0;
		System.gc();
	}
	
	//Comportamiento
	public void tomarEfectivo(int monto) {
		cantidad-= monto;
	}
	
	public void tomarEfectivo(double monto) {
		cantidad-= monto;
	}
	
	public void llenarAlmacen() {
		setCantidad(1000000);
	}
	
	public void llenarAlmacen(int monto) {
		cantidad+= monto;
	}
	
	//Getters
	
	public int getCantidad(){
		return cantidad;
	}
	
	public int getLimite(){
		return limite;
	}
		
	//Setter's
	
	public void setCantidad(int cantidad){
		this.cantidad= cantidad;
	}
	
		public void setLimite(int limite){
		this.limite= limite;
	}
	
	//toString
	public String toString(){
		return "Almacen actualmente con "+cantidad+" de "+limite+" ";
	}
	
}
