package edu.model;

import org.junit.Assert;
import org.junit.Test;

public class PagoValidatorTest {

	@Test
	public void deberiaRealizarPagoSiNumeroTarjetaEs1234567890YCodigoEsEdwin(){
		
		PagoValidator pagoValidator = new PagoValidator();
		
		boolean result = pagoValidator.validarPago("1234567890", "edwin");
		
		Assert.assertEquals(true, result);
	}
}
