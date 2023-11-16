package repaso1;

import java.util.Arrays;
import java.util.Scanner;

public class ExamenInventado {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		// Variables
		String nombre = "";
		String[] player = new String[4];
		String[] pc = new String[4];
		int saldo = 15, opcion = 0, aapuesta = 0, sumPl = 0, sumPc = 0;

		instrucciones();
		do {
			System.out.print("Digame su alias: ");
			nombre = teclado.next();
		} while (!nombreBien(nombre));
		System.out.println();
		System.out.println("Muy bien!!, Bienvenido Jugador: " + nombre);
		do {
			opcion = 0; 
			aapuesta = 0;
			sumPl = 0;
			sumPc = 0;
			System.out.println("Su saldo es de " + saldo + "€");
			rellenarBoleto(player);
			rellenarBoleto(pc);
			System.out.println();
			System.out.print("Tus cartas son: ");
			verBoleto(player);
			System.out.println();
			System.out.println("Okey");
			opcionesSiNo();
			opcion = teclado.nextInt();
			do {
				switch (opcion) {
				case 1:
					System.out.println();
					System.out.println("De acuerdo, has elegido que ganas");
					System.out.println();
					aapuesta = apuesta(saldo, aapuesta);
					saldo-=aapuesta;
					System.out.println();
					System.out.print("Las cartas del PC son: ");
					verBoleto(pc);
					sumPl = sumarBoleto(player, sumPl, sumPc);
					sumPc = sumarBoletoPc(pc, sumPl, sumPc);
					System.out.println();
					System.out.println("La suma de tu boleto es: "+sumPl);
					System.out.println();
					System.out.println("La suma del boleto del PC es: "+sumPc);
					if(sumPl>sumPc) {
						System.out.println();
						System.out.println("Has ganado");
						aapuesta = aapuesta*2;
						saldo += aapuesta;
						System.out.println("Tu saldo actual es de "+saldo+"€");
					}
					break;
				case 2:
					System.out.println();
					System.out.println("De acuerdo, has elegido que pierdes");
					System.out.println();
					System.out.print("Las cartas del PC son: ");
					verBoleto(pc);
					break;
				default:
					System.err.println("ERROR!!");
					System.out.println("Esa opción no está disponible, elija otra: ");
					break;
				}
			} while (opcion > 2);
		}while(saldo>0);
		System.out.println();
		System.out.println("LO SENTIMOS");
		System.out.println("PERO USTED HA PERDIDO TODO SU DINERO");
		teclado.close();
	}

	public static int sumarBoletoPc(String[] pc, int sumPl, int sumPc) {
		int suma = 0;
		for(int i = 0;i<pc.length;i++) {
			if(pc[i]=="AS") suma+=1;
			else if(pc[i]=="DOS") suma+=2;
			else if(pc[i]=="TRES") suma+=3;
			else if(pc[i]=="CUATRO") suma+=4;
			else if(pc[i]=="CINCO") suma+=5;
			else if(pc[i]=="SEIS") suma+=6;
			else if(pc[i]=="SIETE") suma+=7;
			else if(pc[i]=="OCHO") suma+=8;
			else if(pc[i]=="NUEVE") suma+=9;
			else if(pc[i]=="SOTA") suma+=10;
			else if(pc[i]=="CABALLO") suma+=11;
			else if(pc[i]=="REY") suma+=12;
		}
		return suma;
	}

	public static int sumarBoleto(String[] player, int sum, int sumPc) {
		int suma = 0;
		for(int i = 0;i<player.length;i++) {
			if(player[i]=="AS") suma+=1;
			else if(player[i]=="DOS") suma+=2;
			else if(player[i]=="TRES") suma+=3;
			else if(player[i]=="CUATRO") suma+=4;
			else if(player[i]=="CINCO") suma+=5;
			else if(player[i]=="SEIS") suma+=6;
			else if(player[i]=="SIETE") suma+=7;
			else if(player[i]=="OCHO") suma+=8;
			else if(player[i]=="NUEVE") suma+=9;
			else if(player[i]=="SOTA") suma+=10;
			else if(player[i]=="CABALLO") suma+=11;
			else if(player[i]=="REY") suma+=12;
		}
		return suma;
	}

	public static int apuesta(int saldo, int apuesta) {
		Scanner teclado = new Scanner(System.in);
		do {
			System.out.print("Cuanto deseas apostar a que ganas: ");
			apuesta = teclado.nextInt();
		} while (apuesta > saldo || apuesta < 0);
		System.out.println();
		System.out.println("Has apostado "+apuesta+"€");
		System.out.println();
		System.out.println("La apuesta es X2 por cada € apostado");
		return apuesta;
	}

	public static void opcionesSiNo() {
		System.out.println();
		System.out.println("Una vez vistas tus cartas....");
		try {
			Thread.sleep(1300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("¿Crees que ganas al PC?");
		System.out.println("Opciones: ");
		System.out.println("1º) SI");
		System.out.println("2º) NO");
		System.out.println();
		System.out.print("Que opción eliges: ");
	}

	public static void verBoleto(String[] player) {
		System.out.print("[");
		for (int i = 0; i < player.length; i++) {
			if (i == (player.length - 1)) {
				System.out.print(player[i]);
			} else {
				System.out.print(player[i] + ", ");
			}
		}
		System.out.println("]");
	}

	public static void rellenarBoleto(String[] player) {
		int numero = 0;
		for (int i = 0; i < player.length; i++) {
			numero = (int) (1 + Math.random() * 12);
			if (numero == 1)
				player[i] = "AS";
			else if (numero == 2)
				player[i] = "DOS";
			else if (numero == 3)
				player[i] = "TRES";
			else if (numero == 4)
				player[i] = "CUATRO";
			else if (numero == 5)
				player[i] = "CINCO";
			else if (numero == 6)
				player[i] = "SEIS";
			else if (numero == 7)
				player[i] = "SIETE";
			else if (numero == 8)
				player[i] = "OCHO";
			else if (numero == 9)
				player[i] = "NUEVE";
			else if (numero == 10)
				player[i] = "SOTA";
			else if (numero == 11)
				player[i] = "CABALLO";
			else if (numero == 12)
				player[i] = "REY";
		}
	}

	public static boolean nombreBien(String nombre) {
		return nombre.matches("^[J]{1}+[A-Z a-z]{4}+[0-9]{1}+$");
	}

	public static void instrucciones() {
		System.out.println("JUEGO BARAJA");
		System.out.println("Instrucciones:");
		System.out.println("Su alias es una J, las 4 primeras letras de tu nombre y un número del 0 al 9");
		System.out.println("Suerte!!!");
		System.out.println();
	}
}
