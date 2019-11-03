package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import modelo.Buscaminas;
import modelo.Casilla;;

class TestCasilla {

	private Casilla casilla;
	
	private void setupescenario1() {

		casilla = new Casilla(Casilla.MINA);

	}
	
	private void setupescenario2() {
		
		casilla = new Casilla(Casilla.LIBRE);
	}
	
	private void setupescenario3() {
		
		casilla = new Casilla(Casilla.MINA);
		casilla.destapar();
	}
	
	private void setupescenario4() {

		casilla = new Casilla(Casilla.LIBRE);
		casilla.destapar();

	}
	
	
	@Test
	void testEsMina1() {
		setupescenario1();
		assertTrue(casilla.esMina(), "Error ---> La casilla no es marcada como una mina aunque lo sea.");
	}
	
	@Test
	void testEsMina2() {
		setupescenario2();
		assertTrue(!casilla.esMina(), "Error ---> La casilla es marcada como una mina aunque no lo sea.");
	}
	
	@Test
	void testMostrarValorCasilla1() {
		setupescenario1();
		assertTrue(casilla.mostrarValorCasilla().equals("-"), "Error ---> El valor de la casilla no es escondido cuando no ha sido seleccionada.");		
	}
	
	@Test
	void testMostrarValorCasilla2() {
		setupescenario2();
		assertTrue(casilla.mostrarValorCasilla().equals("-"), "Error ---> El valor de la casilla no es escondido cuando no ha sido seleccionada.");

	}
	
	@Test
	void testMostrarValorCasilla3() {
		
		setupescenario3();
		
		assertTrue(casilla.mostrarValorCasilla().equals("*"), "Error ---> El valor de la casilla no se cambia por el símbolo de mina aunque haya sido seleccionada. .");
	}
	
	@Test
	void testMostrarValorCasilla4() {
		
		setupescenario4();
		
		assertTrue(casilla.mostrarValorCasilla().equals("-1"), "Error ---> El valor de la casilla no es el correcto.");
	}
	
	
	
	@Test
	void testDestapar1() {
		setupescenario1();
		
		assertTrue(!casilla.darSeleccionada(), "Error ---> La casilla no debía estar seleccionada.");
		
	}
	
	@Test
	void testDestapar2() {
		
		setupescenario3();
		
		assertTrue(casilla.darSeleccionada(), "Error ---> La casilla debía estar seleccionada.");
	}
	
	
	@Test
	void testModificarValor() {
		
		setupescenario1();
		int x = casilla.darValor() ;
		
		casilla.modificarValor(-469846232);
		
		int y = casilla.darValor(); 
		
		assertTrue(y == -469846232 ,"Error ---> El valor no se modificó adecuadamente.");
		assertTrue(x != y,"Error ---> El valor no se modificó .");
	}
}
