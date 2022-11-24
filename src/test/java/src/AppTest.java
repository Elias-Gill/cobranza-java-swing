package src;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import src.mediador.*;
import src.bankServer.regsYcomprobs.DatosComprobante;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	/**
	 * Rigorous Test :-)
	 *
	 * @throws Exception
	 */
	@Test
	public void shouldAnswerWithTrue() throws Exception {
		Mediador med = new Mediador();
		med.IniciarSesion("elias", 5223084);
		ArrayList<DatosComprobante> res = med.getRegistrosCuenta();

		System.out.println(res.toString());
		for (DatosComprobante i : res) {
			System.out.println(i.concepto + "  " + i.monto);
		}

		assertTrue(true);
	}
}
