package variablesCondiciones;

import java.util.Scanner;

public class ActividadRepaso {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("******************************");
		System.out.println("CÁLCULO DE NOMINA:");
		System.out.println("******************************");
		
		System.out.println("1) Programador Junior");
		System.out.println("2) Programador Senior");
		System.out.println("3) Jefe de Proyecto");
		
		System.out.println("Introduzca el cargo del empleado: ");
		int cargo = teclado.nextInt();
		
		//Declaramos las variables principales
		double sueldo=0;
		double extra=0;
		double irpf=0;
		
		//Elegir el cargo del usuario
		switch(cargo) {
		case 1: sueldo = 950;
		break;
		case 2: sueldo = 1200;
		break;
		case 3: sueldo = 1600;
		break;
		default: System.out.println("No existe esa opción");
		break;
		}
		System.out.println("¿Cuántos días ha viaja para visitar clientes?");
		int viajes = teclado.nextInt();
		
		extra = viajes*30;
		
		System.out.println("¿Estado civil? (1 - Soltero, 2 - Casado): ");
		int estado = teclado.nextInt();
		
		//Elegir el estado civil del usuario
		switch(estado) {
		case 1: irpf = 0.25;
		break;
		case 2: irpf = 0.20;
		break;
		default: System.out.println("Esa opción no existe");
		break;
		}
		
		//Variable de sueldo bruto para ahorrar código en líneas posteriores
		double bruto = sueldo+extra;
		
		//Variable de bruto bruto para ahorrar código en líneas posteriores
		double neto = bruto - (bruto*irpf);
		
		System.out.println("----------------------");
		System.out.println("Sueldo base: "+sueldo+ " €");
		System.out.println("Dietas ("+viajes+") "+extra+" €");
		System.out.println("-----------------------");
		
		System.out.println("");
		System.out.println("------------------------");
		System.out.println("Sueldo bruto: "+bruto+" €");
		System.out.println("------------------------");
		System.out.println("");
		
		System.out.println("------------------------");
		System.out.println("Sueldo neto: "+neto+" €");
		
		teclado.close();
		}

}
