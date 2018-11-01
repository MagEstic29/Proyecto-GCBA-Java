package Programa;

public class EjecutorDeCajeroAutomatico {

	public static void main(String[] args) {
		CajeroAutomatico cajero= new CajeroAutomatico();
		cajero.operarCuenta();
		cajero= null;
		System.gc();
	}
}