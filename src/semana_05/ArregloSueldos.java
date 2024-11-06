package semana_05;

public class ArregloSueldos {
	
	private double sueldo[] = { 2400.5, 800.4, 1500.2, 1000.3, 4700.1, 600.0, 3300.8, 2600.6, 5100.9, 2000.7};
	
	//un constructos que no haga nada
	public ArregloSueldos(){}
	
	
	//un metodo tamanio que retorne la cantidad de elemntos del arreglo
	public int tamanio(){
		return sueldo.length;
	}
	
	//UN METODO QUE RECIBA UNA POSICION Y RETORNE EL SUELDO REGISTRADO EN DICHA POSICION
	public double obtener(int i){
		return sueldo[i];
	}
	//UN METODO SueldoPromedio que retorne el promedio de odos los sueldos.
	public double sueldoPromedio(){
		double sueldoAcum=0.0;
		for (int i = 0; i < sueldo.length; i++) //recorrdio ascendente
		{      sueldoAcum+=sueldo[i];
		}
		return sueldoAcum/tamanio();
	}
	
	//Un método sueldoMayor que retorne el mayor de todos los sueldos.
	
	public double sueldoMayor(){
		double sueldoMay=sueldo[0];
		for (int i = 0; i < sueldo.length; i++) {
		    if (sueldo[i]>sueldoMay) {
				sueldoMay=sueldo[i];
			}  
		}
		return sueldoMay;
	}
	
	//Un método sueldoMayor que retorne el menor de todos los sueldos
	public double sueldoMenor(){
		double sueldoMen=sueldo[0];
		for (int i = 0; i < sueldo.length; i++) {
		    if (sueldo[i]<sueldoMen) {
				sueldoMen=sueldo[i];
			}  
		}
		return sueldoMen;
	}
	
	/*Un método cantMayoresSueldoPromedio que retorne la cantidad de empleados cuyo
	sueldo es mayor o igual al sueldo promedio*/
	
	public int cantMayoresSueldoPromedio(){
		int cantSueldoMayProm=0; //contador de sueldo
		    for (int i = 0; i < tamanio(); i++) {
				if (sueldo[i] >= sueldoPromedio()) {
					cantSueldoMayProm++;
				}
			}
		return cantSueldoMayProm; 
	}
	
	/* Un método cantMenoresSueldoPromedio que retorne la cantidad de empleados cuyo
	sueldo es menor al sueldo promedio*/
	
	public int cantMenoresSueldoPromedio(){
		int cantSueldoMenorProm=0; //contador de sueldo
		    for (int i = 0; i < tamanio(); i++) {
				if (sueldo[i] < sueldoPromedio()) {
					cantSueldoMenorProm++;
				}
			}
		return cantSueldoMenorProm; 
	}
	
	/* Un método posSegundoSueldoMayorAlMinimo que retorne la posición del segundo sueldo
	mayor a 850.0. En caso no exista retorne -1. */
	
	public int posSegundoSueldoMayorAlMinimo (){
		int contSueldo=0;
		for (int i = 0; i < sueldo.length; i++) //recorrido ascendente
		{
			if(sueldo[i]>850)
				contSueldo++;
			if (contSueldo==2) 
				return i;	
		}
		return -1;
	}
	
	/*Un método posUltimoSueldoMenorAlMinimo que retorne la posición del último sueldo
      menor a 850.0. En caso no exista retorne -1.*/

	public int posUltimoSueldoMenorAlMinimo (){
		for (int i = tamanio()-1; i >=0; i--) //recorrido descendente
		{
			if(sueldo[i]<850) 
				return i;	
		}
		return -1;
	}
	
	/*Un método generarSueldos que remplace los sueldos actuales por otros aleatorios
     comprendidos en el rango de 799.9 a 4999.9 (con una cifra decimal).*/
	public void generar(){
		for (int i = 0; i < sueldo.length; i++) {
			sueldo[i]=aleatorio(799.9, 4999.9);
		}
	} 
	
	
	//metodo privado que genere aleatorio
	private double aleatorio(double min , double max){
		return (double)((max-min+1)* Math.random())+min;
	}
}
