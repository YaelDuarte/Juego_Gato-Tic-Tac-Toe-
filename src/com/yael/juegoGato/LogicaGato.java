package com.yael.juegoGato;

import java.util.Scanner;

public class LogicaGato {
	Scanner teclado = new Scanner(System.in);
	
	boolean ganador = false;
	int turnoJugador = 0;
	String separador = "=".repeat(60);
	String caracter;
	
	public void rellenarTablero(String[][] tablero) {
		
		if(turnoJugador % 2 == 0) {
			caracter = "X";
			System.out.println("Turno del jugador: X\nTurno Numero: "+turnoJugador);
		}else {
			caracter = "O";
			System.out.println("Turno del jugador: O\nTurno Numero: "+turnoJugador);
		}
		
		
		System.out.print("Ingresa la posicion en la que quieres jugar, Fila (0,1,2): ");
		int posFila = teclado.nextInt();
		if(posFila < 0 || posFila > 2) {
			System.out.println("Esa fila no existe");
			System.out.println(separador);
			return;
		}
		
		System.out.print("Ingresa la posicion en la que quieres jugar, Columna(0,1,2): ");
		int posColumna= teclado.nextInt();
		if(posColumna < 0 || posColumna > 2) {
			System.out.println("Esa columna no existe");
			System.out.println(separador);
			return;
		}
		
		System.out.println(separador);
		
		
		if(tablero[posFila][posColumna].equals("X") || tablero[posFila][posColumna].equals("O")) {
			System.out.println("No puedes tirar en una casilla ya ocupada");
		}else {
			// Recorre el arreglo para poner el caracter
			for(int i=0 ;i < tablero.length; i++) {
				for(int j = 0; j < tablero[i].length; j++) {
					if(i == posFila && j == posColumna) {
						tablero[i][j] = caracter;
					}
				}
			}
			turnoJugador++;
		}
	}
	
	public void mostrarTablero(String[][] tablero) {
			// Muestra el tablero con las jugadas
			for(int i=0 ;i < tablero.length; i++) {
				for(int j = 0; j < tablero[i].length; j++) {
					System.out.print(tablero[i][j]+"\t");
				}
				System.out.println();
			}
			
			System.out.println(separador);
		}
	
	
	public boolean verificarEstadoJuego(String[][] tablero) {
	    if (turnoJugador >= 5) {
	        for (int i = 0; i < tablero.length; i++) {

	            // Filas
	            if (tablero[i][0].equals(caracter) &&
	                tablero[i][1].equals(caracter) &&
	                tablero[i][2].equals(caracter)) {
	                System.out.println("El ganador es: " + caracter);
	                return true;
	            }

	            // Columnas
	            if (tablero[0][i].equals(caracter) &&
	                tablero[1][i].equals(caracter) &&
	                tablero[2][i].equals(caracter)) {
	                System.out.println("El ganador es: " + caracter);
	                return true;
	            }
	        }

	        // Diagonal principal
	        if (tablero[0][0].equals(caracter) &&
	            tablero[1][1].equals(caracter) &&
	            tablero[2][2].equals(caracter)) {
	            System.out.println("El ganador es: " + caracter);
	            return true;
	        }

	        // Diagonal secundaria
	        if (tablero[0][2].equals(caracter) &&
	            tablero[1][1].equals(caracter) &&
	            tablero[2][0].equals(caracter)) {
	            System.out.println("El ganador es: " + caracter);
	            return true;
	        }
	    }

	    // Empate
	    if (turnoJugador == 9) {
	        System.out.println("Juego terminado, hubo empate!");
	        return true;
	    }

	    return false; // El juego continúa
	}

	
}

