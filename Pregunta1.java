public class Pregunta1{

	// esBisiesto: int => boolean
	// efecto: verifca si el año enviado es bisiesto
	// restricciones:
	// Si es menor a 100 verificar si es multiplo de 4
	// Si es menor a 400 verificar si es multiplo de 4 y no de 100
	// Si es mayor o igual a 400 verificar si es multiplo de 4 y de 400
	// ejemplo: esBisiesto(1700) debe no producir false
	public static boolean esBisiesto(int anio){
		boolean bisiesto=false;
		int condicion1=4;
		int condicion2=100;
		int condicion3=400;

		if(anio<100 && anio%condicion1==0){
			bisiesto = true;
		} else if(anio<400 && anio%condicion1==0 && anio%condicion2!=0){
			bisiesto = true;
		}else if(anio%condicion1==0 && anio%condicion3==0){
			bisiesto = true;
		}
		return bisiesto;
	}

	public static void esBisiestoTest(){
		assert esBisiesto(1700) == false;
		assert esBisiesto(1800) == false;
		assert esBisiesto(400) == true;
		assert esBisiesto(2000) == true;
		assert esBisiesto(8) == true;
		assert esBisiesto(200) == false;
	}

	public static void main(String[] args){
		esBisiestoTest();
	}
}