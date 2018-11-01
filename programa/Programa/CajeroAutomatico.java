package Programa;

import javax.swing.JOptionPane;

public class CajeroAutomatico extends Object{
	//Atributos
	private CuentaBancaria accede;
	private AlmacenDeEfectivo almacen;
	private TicketBancario ticket;
	private LugarFisico pertenece;
	private Banco banco;
	private String folio;
	
	//Constructores
	public CajeroAutomatico(){
		accede= new CuentaBancaria();
		almacen= new AlmacenDeEfectivo();
		ticket= new TicketBancario();
		pertenece= new LugarFisico();
		banco= new Banco();
		folio= "";
	}
	
	public CajeroAutomatico(CuentaBancaria accede, AlmacenDeEfectivo almacen, TicketBancario ticket, LugarFisico pertenece, String folio){
		this.accede= accede;
		this.almacen= almacen;
		this.ticket= ticket;
		this.pertenece= pertenece;
		this.folio= folio;
		
	}
	
	public CajeroAutomatico(CajeroAutomatico cajero){
		this(cajero.accede, cajero.almacen, cajero.ticket, cajero.pertenece, cajero.folio);
	}
	
	//Destructor
	public void destruir(){
		accede= null;
		almacen= null;
		ticket= null;
		pertenece= null;
		folio= null;
		System.gc();
	}
	
	//Comportamiento
	public void operarCuenta() {
		String movimiento= "", aux="";
		int bandera=0, bandera1= 0;
		double cantidad= 0;
		if(verificarTarjeta(leerTarjeta())) {//Encuentra la cuenta
			for(int i=0; i<3; i++) {//Verifica la contraseña
				aux= pedirClave();
				if(aux==null) {
					bandera1=2;
					break;
				}
				if(verificarContrasenia(aux)==true) {
					bandera1= 0;
					break;
				}
				else {
					bandera1= 1;
					JOptionPane.showMessageDialog(null, "  \" Clave incorrecta \"");
				}
			}
			//Inicia Menu
			if(bandera1==0) {
				int opcion= menuPrincipal();
				folio= generarFolio();
				switch (opcion) {
					case 1:
						revisarSaldo();
						movimiento= "Consulta de Saldo";
						cantidad= accede.getSaldo();
						break;
						
					case 2:
						do {
							bandera=0;
							cantidad= pedirCantidad();
							if(accede.verificarRetiro(accede.getSaldo(),cantidad)) { 
								bandera=1;
								JOptionPane.showMessageDialog(null, "\" Error, no tiene saldo suficiente \"");
							}
							else if(cantidad==0) {
								bandera=1;
								break;
							}
							else if(cantidad<50) {
								bandera=1;
								JOptionPane.showMessageDialog(null, "\" Error, la cantidad minima de retiro es de 50 \"");
							}
							else if(cantidad%50!=0 && cantidad>50) {
								bandera=1;
								JOptionPane.showMessageDialog(null, "\" Error, solo puede retirar multiplos de 50 \"");
							}
							else if(cantidad>10000) {
								bandera=1;
								JOptionPane.showMessageDialog(null, "\" Error, la cantidad maxima de retiro es de 10,000 \"");
							}
						}while(bandera!=0/*cantidad%50!=0 || (cantidad%50!=0 && cantidad>10000) || cantidad>10000*/);						
						if(bandera!=1) {
							retirarEfectivo((int)cantidad);//Excepcion try - catch
						}
						movimiento= "Retiro de Efectivo";
						break;
						
					case 3:
						bandera= 1;
						break;
						
				}
				if(bandera!=1) {
					ticket.crearTicket(banco.getNombre(), pertenece.getNombre(), accede.protegerNumero(), movimiento, folio, cantidad);
						imprimirTicket();
					banco.guardarMovimiento(folio, movimiento, pertenece.getNombre(), cantidad);
				}
			}
			else if(bandera1==2);
			else {
				JOptionPane.showMessageDialog(null, "\" Excedio el numero maximo de intentos \"");
			}
		}
		else {
			System.err.println("Ingrese una tarjeta valida");
		}
		System.err.println("\nRetire su tarjeta");
		System.out.println("\n\nOPERACION TERMINADA");
	}
	
	private boolean verificarTarjeta(String numero, String operador) {
		accede= banco.iterarCuentas(numero, operador);
		if(accede== null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	private boolean verificarTarjeta(Tarjeta tarjeta) {
		accede= banco.iterarCuentas(tarjeta.getNumero(), tarjeta.getOperador());
		if(accede== null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	//Modificaciones
	private boolean verificarTarjetaCredito(Credito credito) {
		accede= banco.iterarCuentas(credito.getNumero(), credito.getOperador());
		if(accede== null) {
			return false;
		}
		else {
			return true;
		}
	}
	private boolean verificarTarjeta(String[] auxiliar) {
		accede= banco.iterarCuentas(auxiliar[0],auxiliar[1]);
		if(accede== null) {
			return false;
		}
		else {
			return true;
		}
	}
	//fin
	
	private boolean verificarCuenta(String cuenta) {
	/*CuentaBancaria auxiliar;
		auxiliar= banco.iterarCuentas(cuenta);*/
		if(accede== null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	private boolean verificarContrasenia(String clave) {
		if(accede.getTarjeta() instanceof Debito) {
			Debito tarjetaDebito= (Debito)accede.getTarjeta();
		try {
			if(clave.compareTo(tarjetaDebito.getClave())==0) {
				return true;
			}
			}catch(NullPointerException en) {
				//System.err.println("Excepcion Credito en Cajero Automatico");
			}
		}
		if(accede.getTarjeta() instanceof Credito) {
			Credito tarjetaCredito= (Credito)accede.getTarjeta();
		try {
			if(clave.compareTo(tarjetaCredito.getClave())==0) {
				return true;
			}
			}catch(NullPointerException en) {
				//System.err.println("Excepcion Credito en Cajero Automatico");
			}
		}
			return false;
	}
	
	private void revisarSaldo() {
		String mensaje= "Su saldo actual es de:  \n             $"+accede.getSaldo()+" ";
		JOptionPane.showMessageDialog(null, mensaje);
	}

	private void retirarEfectivo(int cantidad) {
		almacen.tomarEfectivo(cantidad);
		accede.reducirSaldo(cantidad);
	}
	
	private void imprimirTicket() {
		try {
			int aux= Integer.parseInt(JOptionPane.showInputDialog("¿Desea imprimir ticket?\n"
					+ "1) Si\n2) No\n"));
			if(aux==1)System.out.println("\n"+ticket.toString());
			}catch(Exception e) {}
	}
	
	private void imprimirTicket(TicketBancario recibo) {
		try {
		int aux= Integer.parseInt(JOptionPane.showInputDialog("¿Desea imprimir ticket?\n"
				+ "1) Si\n2) No\n"));
		if(aux==1)System.out.println("\n"+recibo.toString());
		}catch(Exception e) {}
	}
	
	private String generarFolio() {
		int aux;
		String auxiliar="";
		for(int i=0; i<8; i++) {
			aux= (int)(Math.random()*10);
			auxiliar += aux;
		}
		return auxiliar;
	}
	
	private Tarjeta leerTarjeta() {
		try {
			String numero=JOptionPane.showInputDialog("Ingrese su numero de tarjeta");
			return new Credito(numero, "MasterCard");
		}catch(Exception e) {
			return null;
		}		
	}
	
	private String pedirClave() {
		String numero=JOptionPane.showInputDialog("Ingrese su PIN");
		return numero;
	}
	
	private int menuPrincipal() {
		try {
			int numero=Integer.parseInt(JOptionPane.showInputDialog(
					"   ** Menu de Cajero **\n\n"+
					"1) Consultar Saldo\n"+
					"2) Retirar Efectivo\n\n"+
					"3) Salir"));
			return numero;
		}catch(Exception e) {
			return 3;
		}
		
	}
	
	private int pedirCantidad() {
		try {
			int numero=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el monto a retirar"));
			return numero;
		}catch(Exception e) {
			return 0;
		}
		
	}
	
	//Getters
	public String getFolio(){
		return folio;
	}
	//Setter's
	public void setFolio(String folio){
		this.folio= folio;
	}
	
	//toString
	
	
}
