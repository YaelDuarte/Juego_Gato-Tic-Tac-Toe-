package com.yael.juegoGato;
public class Principal {
	
	
	public static void main(String[] args) {
		LogicaGato funciones = new LogicaGato();
		String[][] tablero = new String[3][3];
		
		// Inicializamos el tablero
		for(int i=0 ;i < tablero.length; i++) {
			for(int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = "-";
			}
		}
		
		System.out.println("\tBienvenido al juego del Gato (Tic-Tac-Toe)");
		System.out.println();
		do {
			funciones.rellenarTablero(tablero);
			funciones.mostrarTablero(tablero);
		}while(!funciones.verificarEstadoJuego(tablero));
		
	}
}
