package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Cuenta;

class Test0014 {
	
	//	Creo cuenta 12345 -> 50 €
	//  Creo cuenta 67890 -> 0 €
	
	//	Test 12345
	//	Test 67890
	
	//	Si Retirada > Saldo -> NO
	//	Cuenta añadir <list> Movimientos
	//	Cuenta no puede superar -500
	
	private static Cuenta cta12345;
	private static Cuenta cta67890;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		cta12345 = new Cuenta("12345", "Titular 1", 50); // Cuenta 12345 con saldo inicial de 50€
		cta67890 = new Cuenta("67890", "Titular 2", 0); // Cuenta 67890 con saldo inicial de 0€
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test12345() {
		cta12345.retirar(200);	// 1
		cta12345.ingresar(100);	// 3
		cta12345.retirar(200);	// 6
		
		assertEquals(-250.0, cta12345.getSaldo());
		
		// Prueba de errores, ninguno para esta cuenta
		assertTrue(cta12345.getErrores().isEmpty());
	}
	
	@Test
	void test67890() {
		cta67890.retirar(350);	// 2
		cta67890.retirar(200);	// 4 (fallo)
		cta67890.retirar(150);	// 5
		cta67890.ingresar(50);	// 7
		cta67890.retirar(100);	// 8 (fallo)
		
		assertEquals(-450.0, cta67890.getSaldo());
		
		// Prueba de errores
		assertEquals(2, cta67890.getErrores().size());
		assertEquals("Fondos insuficientes (saldo -350€) en la cuenta 67890 para el reintegro de 200€", cta67890.getErrores().get(0)); // 4
		assertEquals("Fondos insuficientes (saldo -450€) en la cuenta 67890 para el reintegro de 100€", cta67890.getErrores().get(1)); // 8
	}

}
