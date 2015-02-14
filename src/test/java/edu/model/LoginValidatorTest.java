package edu.model;


import org.junit.Assert;
import org.junit.Test;

public class LoginValidatorTest {
	
	@Test
	public void deberiaDejarloEntrarSiElUsuarioEsJohanaElPasswordEs12345(){
		//arrange
		LoginValidator loginValidator = new LoginValidator();
		//act
		boolean result=loginValidator.validar("johana", "12345");
		//assert
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void deberiaDejarloEntrarSiElUsuarioEsHernandoElPasswordEs12345678(){
		//arrange
		LoginValidator loginValidator = new LoginValidator();
		//act
		boolean result=loginValidator.validar("hernando", "12345678");
		//assert
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void deberiaDejarloEntrarSiElUsuarioEsJorgeElPasswordEs54321(){
		//arrange
		LoginValidator loginValidator = new LoginValidator();
		//act
		boolean result=loginValidator.validar("jorge", "54321");
		//assert
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void deberiaDejarloEntrarSiElUsuarioEsEdwinElPasswordEs87654321(){
		//arrange
		LoginValidator loginValidator = new LoginValidator();
		//act
		boolean result=loginValidator.validar("edwin", "87654321");
		//assert
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void deberiaNoDejarloEntrarSiElUsuarioEsEdwinyElPasswordEs1234567(){
		//arrange
		LoginValidator loginValidator = new LoginValidator();
		//act
		boolean result=loginValidator.validar("edwin", "1234567");
		//assert
		Assert.assertEquals(false, result);
	}
	
	@Test
	public void deberiaNoDejarloEntrarSiElUsuarioEsHernandoyElPasswordEs1234567890(){
		//arrange
		LoginValidator loginValidator = new LoginValidator();
		//act
		boolean result=loginValidator.validar("hernando", "1234567890");
		//assert
		Assert.assertEquals(false, result);
	}
	
	

}
