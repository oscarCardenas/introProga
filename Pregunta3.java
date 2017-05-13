class ClienteBancario{
	public String nombre;
	public int saldo;

	public static ClienteBancario creaCliente(String nombre, int saldo){
		ClienteBancario cliente = new ClienteBancario();
		cliente.nombre=nombre;
		cliente.saldo=saldo;
		return cliente;
	}
}

public class Pregunta3{

	// transferencia: ClienteBancario ClienteBancario int => boolean
	// efecto: Si el cliente1 tiene saldo suficiente debe descontar el monto de su saldo y aumentar el monto al cliente2
	// caso contrario no hace nada
	// restriccion: el monto enviado debe ser positivo
	// ejemplo: 
	// ClienteBancario cliente1 = ClienteBancario.creaCliente("Cliente1",5000);
	// ClienteBancario cliente2 = ClienteBancario.creaCliente("Cliente2",2000);
	// transferencia(cliente1, cliente2, 1000) debe producir true
	public static boolean transferencia(ClienteBancario cliente1, ClienteBancario cliente2, int monto){
		boolean resultado=false;
		if(monto>0 && cliente1.saldo >= monto){
			cliente1.saldo=cliente1.saldo-monto;
			cliente2.saldo=cliente2.saldo+monto;
			resultado=true;
		}
		return resultado;
	}
	
	//Test
	public static void transferenciaTest(){
		ClienteBancario cliente1 = ClienteBancario.creaCliente("Juan Perez", 1000);
		ClienteBancario cliente2 = ClienteBancario.creaCliente("Pedro Gonzales", 3000);
		assert transferencia(cliente1,cliente2,500) == true;
		assert transferencia(cliente1,cliente2,-100) == false;
		assert transferencia(cliente1,cliente2,2000) == false;
		assert transferencia(cliente1,cliente2,500) == true;
		assert transferencia(cliente1,cliente2,500) == false;
	}

	public static void main(String[] args){
		transferenciaTest();
	}
}