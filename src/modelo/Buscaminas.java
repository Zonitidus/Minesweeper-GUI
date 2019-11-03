/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad Icesi (Cali - Colombia)
 * Propuesta de solución laboratorio Unidad 5
 * @author Camilo Barrios - camilo.barrios@correo.icesi.edu.co
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */


package modelo;

import exceptions.InvalidBoxException;

public class Buscaminas {


	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Es una constante utilizada para indicar la cantidad de filas en el nivel principiante
	 */
	public static final int FILAS_PRINCIPIANTE = 8;

	/**
	 * Es una constante utilizada para indicar la cantidad de filas en el nivel intermedio
	 */
	public static final int FILAS_INTERMEDIO = 16;

	/**
	 * Es una constante utilizada para indicar la cantidad de filas en el nivel experto
	 */
	public static final int FILAS_EXPERTO = 16;

	/**
	 * Es una constante utilizada para indicar la cantidad de columnas en el nivel principiante
	 */
	public static final int COLUMNAS_PRINCIPIANTE = 8;

	/**
	 * Es una constante utilizada para indicar la cantidad de columnas en el nivel intermedio
	 */
	public static final int COLUMNAS_INTERMEDIO = 16;

	/**
	 * Es una constante utilizada para indicar la cantidad de columnas en el nivel experto
	 */
	public static final int COLUMNAS_EXPERTO = 30;

	/**
	 * Es una constante utilizada para saber la dificultad del juego, representa el nivel principiante
	 */
	public static final int PRINCIPIANTE = 1;

	/**
	 * Es una constante utilizada para saber la dificultad del juego, representa el nivel intermedio
	 */
	public static final int INTERMEDIO = 2;

	/**
	 * Es una constante utilizada para saber la dificultad del juego, representa el nivel experto
	 */
	public static final int EXPERTO = 3;

	/**
	 * Es una constante utilizada para saber la cantidad de minas en nivel principiante
	 */
	public static final int CANTIDAD_MINAS_PRINCIPANTE = 10;

	/**
	 * Es una constante utilizada para saber la cantidad de minas en nivel intermedio
	 */
	public static final int CANTIDAD_MINAS_INTERMEDIO = 40;

	/**
	 * Es una constante utilizada para saber la cantidad de minas en nivel experto
	 */
	public static final int CANTIDAD_MINAS_EXPERTO = 99;

	// -----------------------------------------------------------------
	// Atributos y relaciones
	// -----------------------------------------------------------------

	/**
	 * Relacion que tiene la matriz de casillas
	 */
	private Casilla[][] casillas;

	/**
	 * Atributo que representa el nivel del juego <Solo puede tomar valores PRINCIPIANTE, INTERMEDIO, EXPERTO>
	 */
	private int nivel;

	/**
	 * Atributo que tiene la cantidad de minas en el tablero
	 */
	private int cantidadMinas;

	/**
	 * Atributo que representa si el usuario perdio al abrir una mina
	 */
	private boolean perdio;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructo de la clase Buscaminas
	 * @param nivel - el nivel seleccionado por el usuario
	 */
	public Buscaminas(int nivel) {
		this.nivel = nivel;
		perdio = false;
		inicializarPartida();

	}
	
	public Buscaminas(int nivel, Casilla[][] board) {
		
		this.nivel = nivel;
		perdio = false;
		this.casillas = board;
	}

	// -----------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------

	
	public int darNivel() {
		return nivel;
	}
	
	/**
	 * Se encarga de inicializar los atributos y relaciones de la clase buscaminas a partir del nivel elegido por el usuario
	 */
	private void inicializarPartida() {
		
		switch(nivel) {
			case PRINCIPIANTE:
				cantidadMinas = CANTIDAD_MINAS_PRINCIPANTE;
				casillas = new Casilla[FILAS_PRINCIPIANTE][COLUMNAS_PRINCIPIANTE];
				break;
			case INTERMEDIO:
				cantidadMinas = CANTIDAD_MINAS_INTERMEDIO;
				casillas = new Casilla[FILAS_INTERMEDIO][COLUMNAS_INTERMEDIO];
				break;
			case EXPERTO:
				cantidadMinas = CANTIDAD_MINAS_EXPERTO;
				casillas = new Casilla[FILAS_EXPERTO][COLUMNAS_EXPERTO]; 
				break;
		}
		
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				casillas[i][j] = new Casilla(Casilla.LIBRE);
			}
		}
		
		generarMinas();
		inicializarCasillasLibres();
	}

	/**
	 * Metodo que se encarga de inicializar todas las casillas que no son minas
	 */
	public void inicializarCasillasLibres() {
		
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				
				if(!casillas[i][j].esMina()) {
					casillas[i][j].modificarValor(cantidadMinasAlrededor(i,j));
				}
			}
		}
	}


	/**
	 * Metodo que permite contar la cantidad de minas que tiene alrededor una casillas
	 * @param i - La fila de la matriz
	 * @param j - la columna de la matriz
	 * @return int - La cantidad de minas que tiene alrededor la casilla [i][j]
	 */
	public int cantidadMinasAlrededor(int fil, int col) {

		int count = 0;
        int x = 1;
        for( int i = fil - x; i <= fil + x; i++ ){
        
            for( int j = col - x; j <= col + 1; j++ ){
            
                if( i >= 0 && i < casillas.length && j >= 0 && j < casillas[0].length ){
                
                    if( casillas[i][j].esMina()){
                    
                        count++;
                    }
                }
            }
        }
        return count;
	}

	/**
	 * Método que se encarga de generar aleatoriomente las minas
	 */
	public void generarMinas() {

		if(nivel == PRINCIPIANTE) {
			
			for (int i = 0; i < CANTIDAD_MINAS_PRINCIPANTE; i++){
				
				int x = 0;
				int y = 0;

				do {
					//while(casillas[x][y].esMina()) {
						x = (int)(Math.random()*FILAS_PRINCIPIANTE);
						y = (int)(Math.random()*COLUMNAS_PRINCIPIANTE);
					//}
				}
				while(casillas[x][y].darValor() == 0);
					
				casillas[x][y].modificarValor(0);
				casillas[x][y].modificarTipo(Casilla.MINA);
			}
				
		}
		else if (nivel == INTERMEDIO) {
		
			for (int i = 0; i < CANTIDAD_MINAS_INTERMEDIO; i++){
				
				int x = 0;
				int y = 0;

				do {
					
					//while(casillas[x][y].esMina()) {
						
						x = (int)(Math.random()*FILAS_INTERMEDIO);
						y = (int)(Math.random()*COLUMNAS_INTERMEDIO);
					//}
				}
				while(casillas[x][y].darValor() == 0);
					
				casillas[x][y].modificarValor(0);
				casillas[x][y].modificarTipo(Casilla.MINA);
			}
			
		}
		else{
			
			for (int i = 0; i < CANTIDAD_MINAS_EXPERTO; i++){
				
				int x = 0;
				int y = 0;

				do {
					//while(casillas[x][y].esMina()) {
						x = (int)(Math.random()*FILAS_EXPERTO);
						y = (int)(Math.random()*COLUMNAS_EXPERTO);
					//}
				}
				while(casillas[x][y].darValor() == 0);
					
				casillas[x][y].modificarValor(0);
				casillas[x][y].modificarTipo(Casilla.MINA);
			}
			
		}
	}

	public int darMinas() {
		return cantidadMinas;
	}
	
	/**
	 * Metodo que se encarga de convertir el tablero a un String para poder verlo en pantalla
	 * @return String - El tablero en formato String
	 */
	public String mostrarTablero() {
		String umg = "   ";
		
		for(int i = 0; i < casillas[0].length; i++) {
			
			if(i < 9) {
				umg+= (i+1)+"  ";
			}
			else {
				umg+= (i+1)+  " ";
			}
		}

		for (int i = 0; i < casillas.length; i++) {
			
			if(i < 9) {
				umg+="\n"+(i+1)+"  ";
			}
			else {
				umg+="\n"+(i+1)+" ";
			}
			
			for (int j = 0; j < casillas[i].length; j++) {

				umg+=casillas[i][j].mostrarValorCasilla()+"  ";
			}
		}

		return umg;
	}


	/**
	 * Metodo que se encarga de marcar todas las casillas como destapadas
	 */
	public void resolver() {

		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[0].length; j++) {
				casillas[i][j].destapar();
			}
		}
	}

	/**
	 * Metodo dar del atributo casillas
	 * @return la relacion casillas
	 */
	public Casilla[][] darCasillas(){
		return casillas;
	}


	/**
	 * Este metodo se encargaa de abrir una casilla
	 * Si se abre una casilla de tipo Mina, se marca que el jugador perdio el juego.
	 * @param i - la fila donde esta la casilla 
	 * @param j - la columna donde esta la casilla
	 * @return boolean - true si fue posible destaparla, false en caso contrario
	 */
	public boolean abrirCasilla(int fil, int col) {
		
		boolean abrir = false;
		
		if(!casillas[fil][col].darSeleccionada()) {
			casillas[fil][col].destapar();
			abrir = true;
			
			if(casillas[fil][col].esMina()) {
				perdio = true;
			}
		}
		
		return abrir;
	}


	/**
	 * Metodo que se encarga de revisar si el jugador gano el juego
	 * @return boolean - true si gano el juego, false en caso contrario
	 */
	public boolean gano() {
		
		boolean gano = true; 
		
		for(int i = 0; i < casillas.length && gano; i++) {
			for(int j = 0; j < casillas[i].length && gano; j++) {
				
				if(!casillas[i][j].esMina() && !casillas[i][j].darSeleccionada()){
					gano = false;
				}
			}
		}
		
		return gano;
	}


	/**
	 * Metodo que se encarga de abrir la primera casilla que no sea una Mina y cuyo valor sea Mayor que 0
	 * @return String, Mensaje de la Casilla que marco abierta, En caso de no haber casillas posibles para dar una pista, retorna el mensaje no hay pistas para dar
	 */
	public String darPista() {
		
		String hint = "-";
		
		boolean yet = false;
		
		for(int i = 0; i < casillas.length && !yet; i++) {
			for(int j = 0; j < casillas[i].length && !yet ; j++) {
				if(!casillas[i][j].esMina() && !casillas[i][j].darSeleccionada() && casillas[i][j].darValor() > 0) {
					
					casillas[i][j].destapar();
					yet= true;
					
					hint = (i+1)+","+(j+1) ;
				}
			}
		}
		
		return hint;
	}
	
	/***
	 * Metodo dar del atributo perdio
	 * @return boolean el atributo
	 */
	public boolean darPerdio(){
		return perdio;
	}
	
	public boolean rowVerifier(int i) throws InvalidBoxException {
		
		boolean understandablehaveagreatday = true;
		
		if(i > casillas.length-1 || i < 0 ) {
			understandablehaveagreatday = false;
			throw new InvalidBoxException("Fila inválida.");
		}
		
		return understandablehaveagreatday;
	}

	public boolean columnVerifier(int j) throws InvalidBoxException {
		
		boolean understandablehaveagreatday = true;
		
		if(j > casillas.length-1 || j < 0 ) {
			
			understandablehaveagreatday = false;
			throw new InvalidBoxException("Columna inválida.");
		}
		
		return understandablehaveagreatday;
	}
	
	public void wipeBoard() {
		
		for(int i = 0; i < casillas.length; i++) {
			for(int j = 0; j < casillas[i].length; j++) {
				
				casillas[i][j].modificarTipo(Casilla.LIBRE);
			}
			
		}
	}
	
	
}