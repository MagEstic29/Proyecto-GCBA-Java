package Programa;

public class Direccion extends Object{
	//Atributos
		private String calle;
		private String numero;
		private String colonia;
		private String delegacion;
		private String estado;
		private String codigoPostal;
		
	//Constructores
	public Direccion(){
		calle= "";
		numero= "";
		colonia= "";
		delegacion= "";
		estado= "";
		codigoPostal= "";
	}
	
	public Direccion(String calle, String numero, String colonia, String delegacion,String estado, String codigoPostal){
		this.calle= calle;
		this.numero= numero;
		this.colonia= colonia;
		this.delegacion= delegacion;
		this.estado= estado;
		this.codigoPostal= codigoPostal;
	}
	
	public Direccion(Direccion direccion){
		this(direccion.calle, direccion.numero, direccion.colonia, direccion.delegacion, direccion.estado, direccion.codigoPostal);
	}
	
	//Destructores
	public void destruir(){
		calle= null;
		numero= null;
		colonia= null;
		delegacion= null;
		estado= null;
		codigoPostal= null;
		System.gc();
	}
	
	//Comportamiento
	public String entregarDireccion() {
		return "Direccion: "+calle+" "+numero+", "+colonia+", "+delegacion;
	}
	
	//Getter's
	public String getCalle(){
		return calle;
	}
	
	public String getNumero(){
		return numero;
	}
	
	public String getColonia(){
		return colonia;
	}
	
	public String getDelegacion(){
		return delegacion;
	}
	
	public String getEstado(){
		return estado;
	}
	
	public String getCodigoPostal(){
		return codigoPostal;
	}
	
	//Setter's
	public void setCalle(String calle){
		this.calle= calle;
	}
	
	public void setNumero(String numero){
		this.numero= numero;
	}
	
	public void setColonia(String colonia){
		this.colonia= colonia;
	}
	
	public void setDelegacion(String delegacion){
		this.delegacion= delegacion;
	}
	
	public void setEstado(String estado){
		this.estado= estado;
	}

	public void setCodigoPostal(String codigoPostal){
		this.codigoPostal= codigoPostal;
	}
	
	//toString
	public String toString(){
		return "Direccion: "+calle+" "+numero+", "+colonia+", "+delegacion+", "+estado+"  C.P: "+codigoPostal+" ";
	}
	
}
