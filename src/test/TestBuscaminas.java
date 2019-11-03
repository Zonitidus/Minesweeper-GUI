package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import exceptions.InvalidBoxException;
import modelo.Buscaminas;
import modelo.Casilla;

class TestBuscaminas {
	
	private Buscaminas buscaminas;
	
	private void setupScenario1() {
		
		Casilla tablero[][] = new Casilla[Buscaminas.FILAS_PRINCIPIANTE][Buscaminas.COLUMNAS_PRINCIPIANTE];
		
		
		for(int i = 0; i < tablero.length; i++) {
			for(int j = 0; j < tablero[i].length; j++) {
				
				tablero[i][j] = new Casilla(Casilla.LIBRE);
			}
		}
		
		tablero[1][1].modificarValor(0);
		tablero[1][1].modificarTipo(Casilla.MINA);
		
		buscaminas = new Buscaminas(Buscaminas.PRINCIPIANTE, tablero);
		
	}
	
	private void setupScenario2() {
		
		Casilla tablero[][] = new Casilla[Buscaminas.FILAS_PRINCIPIANTE][Buscaminas.COLUMNAS_PRINCIPIANTE];
		
		
		for(int i = 0; i < tablero.length; i++) {
			for(int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = new Casilla(Casilla.LIBRE);
			}
		}
			
		tablero[6][7].modificarValor(0);
		tablero[6][7].modificarTipo(Casilla.MINA);
		tablero[6][6].modificarValor(0);
		tablero[6][6].modificarTipo(Casilla.MINA);
		
		buscaminas = new Buscaminas(Buscaminas.PRINCIPIANTE, tablero);
	}
	
	private void setupScenario3(){
		
		Casilla tablero[][] = new Casilla[Buscaminas.FILAS_PRINCIPIANTE][Buscaminas.COLUMNAS_PRINCIPIANTE];
		
		
		for(int i = 0; i < tablero.length; i++) {
			for(int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = new Casilla(Casilla.LIBRE);
			}
		}
			
		tablero[1][7].modificarValor(0);
		tablero[1][7].modificarTipo(Casilla.MINA);
		
		buscaminas = new Buscaminas(Buscaminas.PRINCIPIANTE, tablero);
	}
	
	private void setupScenario4() {
		
		buscaminas = new Buscaminas(Buscaminas.PRINCIPIANTE);
		
		Casilla tablero[][] = new Casilla[Buscaminas.FILAS_PRINCIPIANTE][Buscaminas.COLUMNAS_PRINCIPIANTE];
		
		
		for(int i = 0; i < tablero.length; i++) {
			for(int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = new Casilla(Casilla.LIBRE);
			}
		}
			
		tablero[6][0].modificarValor(0);
		tablero[6][0].modificarTipo(Casilla.MINA);
		tablero[6][1].modificarValor(0);
		tablero[6][1].modificarTipo(Casilla.MINA);
		tablero[7][1].modificarValor(0);
		tablero[7][1].modificarTipo(Casilla.MINA);
		
		buscaminas = new Buscaminas(Buscaminas.PRINCIPIANTE, tablero);
	}
	
	private void setupScenario5() {
		
		buscaminas = new Buscaminas(Buscaminas.PRINCIPIANTE);
		
		Casilla tablero[][] = new Casilla[Buscaminas.FILAS_PRINCIPIANTE][Buscaminas.COLUMNAS_PRINCIPIANTE];
		
		
		for(int i = 0; i < tablero.length; i++) {
			for(int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = new Casilla(Casilla.LIBRE);
			}
		}
			
		tablero[0][3].modificarValor(0);
		tablero[0][3].modificarTipo(Casilla.MINA);
		tablero[0][4].modificarValor(0);
		tablero[0][4].modificarTipo(Casilla.MINA);
		tablero[1][4].modificarValor(0);
		tablero[1][4].modificarTipo(Casilla.MINA);
		tablero[2][2].modificarValor(0);
		tablero[2][2].modificarTipo(Casilla.MINA);
		
		buscaminas = new Buscaminas(Buscaminas.PRINCIPIANTE, tablero);
	}
	
	
	private void setupScenario6() {
		
		try {
			buscaminas = new Buscaminas(Buscaminas.EXPERTO);
		}
		catch(Exception e){
			fail("Imposible que falle"+e.getMessage());
		}
	}
		
	private void setupScenario7() {
		
		try {
			buscaminas = new Buscaminas(Buscaminas.INTERMEDIO);
		}
		catch(Exception e){
			fail("Imposible que falle"+e.getMessage());
		}
	}

	private void setupScenario8() {
	
		try {
			buscaminas = new Buscaminas(Buscaminas.PRINCIPIANTE);
		}
		catch(Exception e){
			fail("Imposible que falle"+e.getMessage());
		}
	}
	
	private void setupScenario9() {
		
		Casilla tablero[][] = new Casilla[Buscaminas.FILAS_PRINCIPIANTE][Buscaminas.COLUMNAS_PRINCIPIANTE];
		
		for(int i = 0; i < tablero.length; i++) {
			for(int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = new Casilla(Casilla.LIBRE);
			}
		}
		
		tablero[3][3].modificarValor(0);
		tablero[3][3].modificarTipo(Casilla.MINA);
		tablero[1][1].modificarValor(0);
		tablero[1][1].setSeleccion(true);
		
		buscaminas = new Buscaminas(Buscaminas.PRINCIPIANTE, tablero);
		
	}
	
	private void setupScenario10() {
		
		Casilla tablero[][] = new Casilla[Buscaminas.FILAS_PRINCIPIANTE][Buscaminas.COLUMNAS_PRINCIPIANTE];
		
		for(int i = 0; i < tablero.length; i++) {
			for(int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = new Casilla(Casilla.LIBRE);
				tablero[i][j].setSeleccion(true);
			}
		}
		
		tablero[1][2].modificarValor(0);
		tablero[1][2].modificarTipo(Casilla.MINA);
		
		buscaminas = new Buscaminas(Buscaminas.PRINCIPIANTE, tablero);
		
	}
	
	private void setupScenario11() {
		
		Casilla tablero[][] = new Casilla[Buscaminas.FILAS_INTERMEDIO][Buscaminas.COLUMNAS_INTERMEDIO];
		
		for(int i = 0; i < tablero.length; i++) {
			for(int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = new Casilla(Casilla.LIBRE);
			}
		}
		
		tablero[2][3].modificarValor(0);
		tablero[2][3].modificarTipo(Casilla.MINA);
		tablero[0][1].setSeleccion(true);
		
		buscaminas = new Buscaminas(Buscaminas.INTERMEDIO, tablero);
		
	}
	
	private void setupScenario12() {
		
		Casilla tablero[][] = new Casilla[Buscaminas.FILAS_INTERMEDIO][Buscaminas.COLUMNAS_INTERMEDIO];
		
		for(int i = 0; i < tablero.length; i++) {
			for(int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = new Casilla(Casilla.LIBRE);
				tablero[i][j].setSeleccion(true);
			}
		}
		
		tablero[8][6].modificarValor(0);
		tablero[8][6].modificarTipo(Casilla.MINA);
		
		buscaminas = new Buscaminas(Buscaminas.INTERMEDIO, tablero);
		
	}
	
	private void setupScenario13() {
		
		Casilla tablero[][] = new Casilla[Buscaminas.FILAS_EXPERTO][Buscaminas.COLUMNAS_EXPERTO];;
		
		for(int i = 0; i < tablero.length; i++) {
			for(int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = new Casilla(Casilla.LIBRE);
			}
		}
		
		tablero[12][14].modificarValor(0);
		tablero[12][14].modificarTipo(Casilla.MINA);
		tablero[14][28].setSeleccion(true);
		
		buscaminas = new Buscaminas(Buscaminas.EXPERTO, tablero);
		
	}
	
	private void setupScenario14() {
		
		Casilla tablero[][] = new Casilla[Buscaminas.FILAS_EXPERTO][Buscaminas.COLUMNAS_EXPERTO];
		
		for(int i = 0; i < tablero.length; i++) {
			for(int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = new Casilla(Casilla.LIBRE);
				tablero[i][j].setSeleccion(true);
			}
		}
		
		tablero[10][17].modificarValor(0);
		tablero[10][17].modificarTipo(Casilla.MINA);
		
		buscaminas = new Buscaminas(Buscaminas.EXPERTO, tablero);
		
	}
	
	private void setupScenario15() {
		
		Casilla tablero[][] = new Casilla[Buscaminas.FILAS_PRINCIPIANTE][Buscaminas.COLUMNAS_PRINCIPIANTE];
		
		for(int i = 0; i < tablero.length; i++) {
			for(int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = new Casilla(Casilla.LIBRE);
			}
		}
		
		tablero[2][2].modificarValor(0);
		tablero[2][2].modificarTipo(Casilla.MINA);
		tablero[1][1].setSeleccion(true);

		
		
		buscaminas = new Buscaminas(Buscaminas.PRINCIPIANTE, tablero);
		
	}
	
	private void setupScenario16() {
		
		buscaminas = new Buscaminas(Buscaminas.PRINCIPIANTE);
		
		buscaminas.resolver();

	}
	
	private void setupScenario17() {
		
		buscaminas = new Buscaminas(Buscaminas.PRINCIPIANTE);
		
		buscaminas.resolver();
		
		if(buscaminas.darCasillas()[2][3].esMina() == true) {
			
			buscaminas.darCasillas()[2][3].modificarTipo(Casilla.LIBRE);
			buscaminas.darCasillas()[2][3].setSeleccion(false);
		}
		else {
			buscaminas.darCasillas()[2][3].setSeleccion(false);
		}
	}
	
	private void setupScenario18() {
		
		buscaminas = new Buscaminas(Buscaminas.INTERMEDIO);
		
		buscaminas.resolver();
	}
	
	private void setupScenario19() {
		
		buscaminas = new Buscaminas(Buscaminas.INTERMEDIO);
		
		buscaminas.resolver();	
		
		if(buscaminas.darCasillas()[8][8].esMina() == true) {
			
			buscaminas.darCasillas()[8][8].modificarTipo(Casilla.LIBRE);
			buscaminas.darCasillas()[8][8].setSeleccion(false);
		}
		else {
			buscaminas.darCasillas()[8][8].setSeleccion(false);
		}
	}
	
	private void setupScenario20() {
		
		buscaminas = new Buscaminas(Buscaminas.EXPERTO);
		
		buscaminas.resolver();
	}
	
	private void setupScenario21() {
		
		buscaminas = new Buscaminas(Buscaminas.EXPERTO);
		
		buscaminas.resolver();	
		
		if(buscaminas.darCasillas()[14][20].esMina()) {
			
			buscaminas.darCasillas()[14][20].modificarTipo(Casilla.LIBRE);
			buscaminas.darCasillas()[14][20].setSeleccion(false);
		}
		else {
			buscaminas.darCasillas()[14][20].setSeleccion(false);
		}
	}
	
	private void setupScenario22() {
		
		setupScenario1();
		
		buscaminas.darCasillas()[0][2].destapar();
	}
	
	@Test
	void testCantidadMinasAlrededor1() {
		
		setupScenario1();
		
		assertTrue(buscaminas.cantidadMinasAlrededor(0, 0) == 1, "Error ---> No cuenta apropiadamente las minas alrededor de la casilla");
	}
	
	@Test
	void testCantidadMinasAlrededor2() {
		
		setupScenario2();
		
		assertTrue(buscaminas.cantidadMinasAlrededor(7, 7) == 2, "Error ---> No cuenta apropiadamente las mians alrededor de la casilla");
	}
	
	@Test
	void testCantidadMinasAlrededor3() {
		
		setupScenario3();
		
		assertTrue(buscaminas.cantidadMinasAlrededor(0, 7) == 1, "Error ---> No cuenta apropiadamente las mians alrededor de la casilla");
	}
	
	@Test
	void testCantidadMinasAlrededor4() {
		
		setupScenario4();
		
		assertTrue(buscaminas.cantidadMinasAlrededor(7, 0) == 3, "Error ---> No cuenta apropiadamente las minas alrededor de la casilla");
	}
	
	@Test
	void testCantidadMinasAlrededor5() {
		
		setupScenario5();
		
		assertTrue(buscaminas.cantidadMinasAlrededor(1, 3) == 4, "Error ---> No cuenta apropiadamente las mians alrededor de la casilla");
	}
	
	@Test
	String[] testGenerarMinas1() {
		setupScenario6();
		buscaminas.generarMinas();
		
		String pos1[] = new String[10];
		
		int minas = 0;
		for(int i = 0; i < buscaminas.darCasillas().length; i++) {
			for(int j = 0; j < buscaminas.darCasillas()[i].length; j++) {
				
				try {
					if(buscaminas.darCasillas()[i][j].esMina()) {
						
						if(minas < 10) {
							pos1[i] = i+"-"+j;
						
						}
						
						minas++;
					}
				}
				catch(ArrayIndexOutOfBoundsException e) {
					
					fail(e.getMessage());
				}
			}
		}
		
		//System.out.println(minas/2);
		
		assertTrue(minas/2 == Buscaminas.CANTIDAD_MINAS_EXPERTO, "Error ---> La cantidad de minas no es la esperada.");
		
		return pos1;
	}
	
	@Test
	String[] testGenerarMinas2() {
		setupScenario7();
		
		String pos2[] = new String[10];
		
		buscaminas.generarMinas();
		
		int minas = 0;
		for(int i = 0; i < buscaminas.darCasillas().length; i++) {
			for(int j = 0; j < buscaminas.darCasillas()[i].length; j++) {
				
				try {
					if(buscaminas.darCasillas()[i][j].esMina()) {
						
						if(minas < 10) {
							pos2[i] = i+"-"+j;
						
						}
						
						minas++;
					}
				}
				catch(ArrayIndexOutOfBoundsException e) {
					
					fail(e.getMessage());
				}
			}
		}
		
		//System.out.println(minas/2);

		assertTrue(minas/2 == Buscaminas.CANTIDAD_MINAS_INTERMEDIO, "Error ---> La cantidad de minas no es la esperada.");
		
		return pos2;
	}
	
	@Test
	String[] testGenerarMinas3() {
		setupScenario8();

		String pos3[] = new String[10] ;
		
		buscaminas.generarMinas();
		
		int minas = 0;
		for(int i = 0; i < buscaminas.darCasillas().length; i++) {
			for(int j = 0; j < buscaminas.darCasillas()[i].length; j++) {
				
				try {
					if(buscaminas.darCasillas()[i][j].esMina()) {
						
						if(minas < 10) {
							pos3[i] = i+"-"+j;
						
						}
						
						minas++;
					}
				}
				catch(ArrayIndexOutOfBoundsException e) {
					
					fail(e.getMessage());
				}
			}
		}
		
		//System.out.println(minas/2);
		
		
		assertTrue(minas/2 == Buscaminas.CANTIDAD_MINAS_PRINCIPANTE , "Error ---> La cantidad de minas no es la esperada.");
		return pos3;
	}
	
	@Test
	void AleatoriedadEnLaGeneraciónDeMinas(){

		
	}
	
	@Test
	void testInicializarCasillasLibres1() {
		
		setupScenario6();
		buscaminas.generarMinas();
		buscaminas.inicializarCasillasLibres();
		
		boolean valueError = false;
		
		for(int i = 0; i < buscaminas.darCasillas().length && !valueError; i++) {
			for(int j = 0; j < buscaminas.darCasillas()[0].length && !valueError; j++) {
				
				try {
					
					if(!buscaminas.darCasillas()[i][j].esMina()) {
						if(buscaminas.darCasillas()[i][j].darValor() == -1){
							valueError = true;
						}
					}
				}
				catch(ArrayIndexOutOfBoundsException e){
					
					fail(e.getMessage());
				}
			}
		}
		
		assertTrue(!valueError, "Error ---> Una de las casillas no fue inicializada con éxtio.");
	}
	
	@Test
	void testInicializarCasillasLibres2() {
		
		setupScenario7();
		buscaminas.generarMinas();
		buscaminas.inicializarCasillasLibres();
		
		boolean valueError = false;
		
		for(int i = 0; i < buscaminas.darCasillas().length && !valueError; i++) {
			for(int j = 0; j < buscaminas.darCasillas()[0].length && !valueError; j++) {
				
				try {
					
					if(!buscaminas.darCasillas()[i][j].esMina()) {
						if(buscaminas.darCasillas()[i][j].darValor() == -1){
							valueError = true;
						}
					}
				}
				catch(ArrayIndexOutOfBoundsException e){
					
					fail(e.getMessage());
				}
			}
		}
		
		assertTrue(!valueError, "Error ---> Una de las casillas no fue inicializada con éxtio.");
	}
	
	@Test
	void testInicializarCasillasLibres3() {
		
		setupScenario8();
		buscaminas.generarMinas();
		buscaminas.inicializarCasillasLibres();
		
		boolean valueError = false;
		
		for(int i = 0; i < buscaminas.darCasillas().length && !valueError; i++) {
			for(int j = 0; j < buscaminas.darCasillas()[0].length && !valueError; j++) {
				
				try {
					
					if(!buscaminas.darCasillas()[i][j].esMina()) {
						if(buscaminas.darCasillas()[i][j].darValor() == -1){
							valueError = true;
						}
					}
				}
				catch(ArrayIndexOutOfBoundsException e){
					
					fail(e.getMessage());
				}
			}
		}
		
		assertTrue(!valueError, "Error ---> Una de las casillas no fue inicializada con éxtio.");
	}
	
	@Test
	void testMostrarTablero1(){
		
		setupScenario9();
		String tablero = buscaminas.mostrarTablero();
		
		String x ="   1  2  3  4  5  6  7  8  \n" + 
				"1  -  -  -  -  -  -  -  -  \n" + 
				"2  -  0  -  -  -  -  -  -  \n" + 
				"3  -  -  -  -  -  -  -  -  \n" + 
				"4  -  -  -  -  -  -  -  -  \n" + 
				"5  -  -  -  -  -  -  -  -  \n" + 
				"6  -  -  -  -  -  -  -  -  \n" + 
				"7  -  -  -  -  -  -  -  -  \n" + 
				"8  -  -  -  -  -  -  -  -  " ;
		
		assertTrue(tablero.equals(x), "Error ---> El tablero no se imprime adecuadamente.");
		
		
	}
	
	@Test
	void testMostrarTablero2(){
		
		setupScenario10();
		String tablero = buscaminas.mostrarTablero();
		
		String x = "   1  2  3  4  5  6  7  8  \n" + 
				"1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"2  -1  -1  *  -1  -1  -1  -1  -1  \n" + 
				"3  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"4  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"5  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"6  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"7  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"8  -1  -1  -1  -1  -1  -1  -1  -1  " ;
		
		assertTrue(tablero.equals(x),"Error ---> El tablero no se muestra como debería ser.");
	}
	
	@Test
	void testMostrarTablero3(){
		
		setupScenario11();
		String tablero = buscaminas.mostrarTablero();
		
		String x = "   1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 \n" + 
				"1  -  -1  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
				"2  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
				"3  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
				"4  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
				"5  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
				"6  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
				"7  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
				"8  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
				"9  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
				"10 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
				"11 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
				"12 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
				"13 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
				"14 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
				"15 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
				"16 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  ";
		
		//System.out.println(tablero);
		
		assertTrue(tablero.equals(x),"Error ---> El tablero no se muestra como debería ser.");
	}
	
	@Test
	void testMostrarTablero4(){
		
		setupScenario12();
		String tablero = buscaminas.mostrarTablero();
		
		String x = "   1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 \n" + 
				"1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"2  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"3  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"4  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"5  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"6  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"7  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"8  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"9  -1  -1  -1  -1  -1  -1  *  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"10 -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"11 -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"12 -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"13 -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"14 -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"15 -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"16 -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  ";
		
		//System.out.println(tablero);
		
		assertTrue(tablero.equals(x),"Error ---> El tablero no se muestra como debería ser.");
		
		
	}
	
	@Test
	void testMostrarTablero5(){
		
		setupScenario13();
		String tablero = buscaminas.mostrarTablero();
		
		String x = "   1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 \n" + 
				"1  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
				"2  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
				"3  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
				"4  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
				"5  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
				"6  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
				"7  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
				"8  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
				"9  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
				"10 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
				"11 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
				"12 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
				"13 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
				"14 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n" + 
				"15 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -1  -  \n" + 
				"16 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  ";
		
		//System.out.println(tablero);
		
		assertTrue(tablero.equals(x),"Error ---> El tablero no se muestra como debería ser.");
	}
	
	@Test
	void testMostrarTablero6(){
		
		setupScenario14();
		String tablero = buscaminas.mostrarTablero();
		
		String x = "   1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 \n" + 
				"1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"2  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"3  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"4  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"5  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"6  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"7  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"8  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"9  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"10 -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"11 -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  *  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"12 -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"13 -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"14 -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"15 -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  \n" + 
				"16 -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  -1  ";
		
		
		//System.out.println(tablero);
		
		assertTrue(tablero.equals(x),"Error ---> El tablero no se muestra como debería ser.");
	}
	
	@Test
	void testResolver1() {
		
		setupScenario6();
		
		buscaminas.resolver();
		
		boolean resuelto = true;
		
		for(int i = 0; i < buscaminas.darCasillas().length && resuelto; i++) {
			for(int j = 0; j < buscaminas.darCasillas()[i].length && resuelto; j++) {
				
				if(!buscaminas.darCasillas()[i][j].darSeleccionada()) {
					
					resuelto = false;
				}
			}
		}
		
		assertTrue(resuelto,"Error ---> No todas las casillas fueron destapadas");
		
	}
	
	@Test
	void testResolver2() {
		
		setupScenario7();
		
		buscaminas.resolver();
		
		boolean resuelto = true;
		
		for(int i = 0; i < buscaminas.darCasillas().length && resuelto; i++) {
			for(int j = 0; j < buscaminas.darCasillas()[i].length && resuelto; j++) {
				
				if(!buscaminas.darCasillas()[i][j].darSeleccionada()) {
					
					resuelto = false;
				}
			}
		}
		
		assertTrue(resuelto,"Error ---> No todas las casillas fueron destapadas");
		
	}
	
	@Test
	void testResolver3() {
		
		setupScenario7();
		
		buscaminas.resolver();
		
		boolean resuelto = true;
		
		for(int i = 0; i < buscaminas.darCasillas().length && resuelto; i++) {
			for(int j = 0; j < buscaminas.darCasillas()[i].length && resuelto; j++) {
				
				if(!buscaminas.darCasillas()[i][j].darSeleccionada()) {
					
					resuelto = false;
				}
			}
		}
		
		assertTrue(resuelto,"Error ---> No todas las casillas fueron destapadas");
		
	}
	
	
	@Test
	void testAbrirCasilla1() {
		
		setupScenario15();
		
		assertTrue(buscaminas.abrirCasilla(0, 0), "Error ---> La casilla no se abrió aunque no estuviera seleccionada");	
		
	}
	
	@Test
	void testAbrirCasilla2() {
		
		setupScenario15();
		
		assertTrue(!buscaminas.abrirCasilla(1, 1), "Error ---> La casilla se abrió aunque ya estuviera seleccionada");	
		
	}
	
	@Test
	void testAbrirCasilla3(){
		
		setupScenario15();
		
		assertTrue(buscaminas.abrirCasilla(2, 2), "Error ---> La casilla no se abrió aunque no estuviera seleccionada.");	
		assertTrue(buscaminas.darPerdio(), "Error ---> El estado de perdio no fue modificado.");	
		
	}
	
	@Test
	void testGano1() {
		
		setupScenario16();
		
		assertTrue(buscaminas.gano(), "Error ---> El tablero ya ha sido solucionado y el método no lo percibe");
	}
	
	@Test
	void testGano2() {
		
		setupScenario17();
		
		assertTrue(!buscaminas.gano(), "Error ---> El tablero no ha sido solucionado y el método indica que sí");
	}
	
	@Test
	void testGano3() {
		
		setupScenario18();
		
		assertTrue(buscaminas.gano(), "Error ---> El tablero ya ha sido solucionado y el método no lo percibe");
	}
	
	@Test
	void testGano4() {
		
		setupScenario19();
		
		assertTrue(!buscaminas.gano(), "Error ---> El tablero no ha sido solucionado y el método indica que sí");
	}
	
	@Test
	void testGano5() {
		
		setupScenario20();
		
		assertTrue(buscaminas.gano(), "Error ---> El tablero ya ha sido solucionado y el método no lo percibe");
	}
	
	@Test
	void testGano6() {
		
		setupScenario21();
		
		assertTrue(!buscaminas.gano(), "Error ---> El tablero no ha sido solucionado y el método indica que sí");
	}
	
	@Test
	void testDarPista() {
		
		setupScenario22();
		
		boolean encontro = false;
		
		String pos = "";
		int ii = 0;
		int jj = 0;
		
		for(int i = 0; i < buscaminas.darCasillas().length && !encontro; i++) {
			for(int j = 0; j < buscaminas.darCasillas()[i].length && !encontro; j++) {
				
				if(!buscaminas.darCasillas()[i][j].esMina()) {
					
					pos = "Pista: ["+(i+1)+","+(j+1)+"]";
					
					
					buscaminas.abrirCasilla(i, j);
					ii = i;
					jj = j;
					
					encontro = true;
				}
			}
		}
		
		String hint = buscaminas.darPista();
		
		assertTrue(buscaminas.darCasillas()[ii][jj].darSeleccionada(),"Error ---> No abre la que tenía que abrir real.");
		
		assertTrue(buscaminas.darCasillas()[ii][jj].darValor() != 0, "Error ---> Abre una casilla con valor cero.");
	}
	
	@Test
	void testRowVerifier1() {
		
		setupScenario6();
		
		boolean one = false;
		boolean two = false;
		boolean three = false;
		
		try {
			
			one = buscaminas.rowVerifier(-1);
		}
		catch(InvalidBoxException e){
			
			one = false;
		}
		
		try {
			
			two = buscaminas.rowVerifier(0);
		}
		catch(InvalidBoxException e){
			
			two = false;
		}

		try {
	
			three = buscaminas.rowVerifier(98);
		}
		catch(InvalidBoxException e){
	
			three = false;
		}
	
		assertTrue(!one,"Error ---> No valida adecuadamete si la casilla existe.");
		assertTrue(two,"Error ---> No valida adecuadamete si la casilla existe.");
		assertTrue(!three,"Error ---> No valida adecuadamete si la casilla existe.");
		
	}
	
	@Test
	void testRowVerifier2() {
		
		setupScenario7();
		
		boolean one = false;
		boolean two = false;
		boolean three = false;
		
		try {
			
			one = buscaminas.rowVerifier(-1);
		}
		catch(InvalidBoxException e){
			
			one = false;
		}
		
		try {
			
			two = buscaminas.rowVerifier(0);
		}
		catch(InvalidBoxException e){
			
			two = false;
		}

		try {
	
			three = buscaminas.rowVerifier(98);
		}
		catch(InvalidBoxException e){
	
			three = false;
		}
	
		assertTrue(!one,"Error ---> No valida adecuadamete si la casilla existe.");
		assertTrue(two,"Error ---> No valida adecuadamete si la casilla existe.");
		assertTrue(!three,"Error ---> No valida adecuadamete si la casilla existe.");
		
	}
	
	@Test
	void testRowVerifier3() {
		
		setupScenario8();

		boolean one = false;
		boolean two = false;
		boolean three = false;
		
		try {
			
			one = buscaminas.rowVerifier(-1);
		}
		catch(InvalidBoxException e){
			
			one = false;
		}
		
		try {
			
			two = buscaminas.rowVerifier(0);
		}
		catch(InvalidBoxException e){
			
			two = false;
		}

		try {
	
			three = buscaminas.rowVerifier(98);
		}
		catch(InvalidBoxException e){
	
			three = false;
		}
	
		assertTrue(!one,"Error ---> No valida adecuadamete si la casilla existe.");
		assertTrue(two,"Error ---> No valida adecuadamete si la casilla existe.");
		assertTrue(!three,"Error ---> No valida adecuadamete si la casilla existe.");
		
	}
	
	@Test
	void testColumnsVerifier1() {
		
		setupScenario6();
		
		boolean one = false;
		boolean two = false;
		boolean three = false;
		
		try {
			
			one = buscaminas.columnVerifier(-1);
		}
		catch(InvalidBoxException e){
			
			one = false;
		}
		
		try {
			
			two = buscaminas.columnVerifier(0);
		}
		catch(InvalidBoxException e){
			
			two = false;
		}

		try {
	
			three = buscaminas.columnVerifier(98);
		}
		catch(InvalidBoxException e){
	
			three = false;
		}
	
		assertTrue(!one,"Error ---> No valida adecuadamete si la casilla existe.");
		assertTrue(two,"Error ---> No valida adecuadamete si la casilla existe.");
		assertTrue(!three,"Error ---> No valida adecuadamete si la casilla existe.");
		
	}
	
	@Test
	void testColumnsVerifier2() {
		
		setupScenario7();
		
		boolean one = false;
		boolean two = false;
		boolean three = false;
		
		try {
			
			one = buscaminas.columnVerifier(-1);
		}
		catch(InvalidBoxException e){
			
			one = false;
		}
		
		try {
			
			two = buscaminas.columnVerifier(0);
		}
		catch(InvalidBoxException e){
			
			two = false;
		}

		try {
	
			three = buscaminas.columnVerifier(98);
		}
		catch(InvalidBoxException e){
	
			three = false;
	
		}
	
		assertTrue(!one,"Error ---> No valida adecuadamete si la casilla existe.");
		assertTrue(two,"Error ---> No valida adecuadamete si la casilla existe.");
		assertTrue(!three,"Error ---> No valida adecuadamete si la casilla existe.");
		
	}
	
	@Test
	void testColumnsVerifier3() {
		
		setupScenario8();

		boolean one = false;
		boolean two = false;
		boolean three = false;
		
		try {
			
			one = buscaminas.columnVerifier(-1);
		}
		catch(InvalidBoxException e){
			
			one = false;
		}
		
		try {
			
			two = buscaminas.columnVerifier(0);
		}
		catch(InvalidBoxException e){
			
			two = false;
		}

		try {
	
			three = buscaminas.columnVerifier(98);
		}
		catch(InvalidBoxException e){
	
			three = false;
		}
	
		assertTrue(!one,"Error ---> No valida adecuadamete si la casilla existe.");
		assertTrue(two,"Error ---> No valida adecuadamete si la casilla existe.");
		assertTrue(!three,"Error ---> No valida adecuadamete si la casilla existe.");
		
	}
	

}
