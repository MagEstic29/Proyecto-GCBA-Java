package Programa;

public class LugarFisico extends Object {
	//Atributos
	private String nombre;
	private Direccion direccion;
	
	//Constructores
	public LugarFisico(){
		nombre= "Plaza Delta";
		direccion= new Direccion();
	}
	
	public LugarFisico(String nombre,Direccion direccion){
		this.nombre= nombre;
		this.direccion= direccion;
	}
	
	public LugarFisico(LugarFisico local){
		this(local.nombre, local.direccion);
	}
	
	//Destructores
	public void destruir(){
		nombre= null;
		direccion= null;
		System.gc();
	}
	
	//Comportamiento
	public Direccion tomarDireccion() {
		return direccion;
	}
	
	public void cambiarNombre(String nuevo) {
		nombre= nuevo;
	}
	
	//Getter's
	public String getNombre(){
		return nombre;
	}
	
	//Setter's
	public void setNombre(String nombre){
		this.nombre= nombre;
	}
	
	//toString
	public String toString(){
		return "Sucursal: "+nombre+" \nCalle: "+direccion.getCalle()+"\tNumero: "+direccion.getNumero()+"\nColonia: "+direccion.getColonia()+"\nDelegacion: "
				+direccion.getDelegacion()+"\nEstado: "+direccion.getEstado();
	}
	
}
