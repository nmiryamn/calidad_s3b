package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Cuenta;

class CuentaTest {

	static Cuenta cta;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		cta = new Cuenta("12345","Miryam", 20);	// Ingreso 20 antes de la ejecución de cada test
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testIngreso() {
		cta.ingresar(25);
		assertEquals(45.0, cta.getSaldo());
	}

	@Test
	void testReintegro() {
		cta.retirar(20);
		assertEquals(0.0, cta.getSaldo());
	}
	
	@Test
	void testMovimiento() {
		cta.ingresar(25);
		assertEquals(1, cta.getMovimientos().size());
		assertEquals(25.0, cta.getMovimientos().get(0).getImporte());
	}

}
