package ddsTP0;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class GuardarropaTest {
	@Test 
	public void testGuardarropaIncorrecto()  {
		Guardarropa guarda = new Guardarropa();
		Ropa remera = Ropa.TORSO;
		Ropa zapatilla = Ropa.PIES;
		guarda.agregarRopa(remera);
		guarda.agregarRopa(zapatilla);
		Assert.assertFalse(guarda.sugerenciaValida());
	}
	@Test
	public void testGuardarropaOk() {
		Ropa remera = Ropa.TORSO;
		Ropa zapatilla = Ropa.PIES;
		Ropa pantalon = Ropa.PIERNAS;
		Guardarropa guardarropa = new Guardarropa();
		guardarropa.agregarRopa(remera);
		guardarropa.agregarRopa(zapatilla);
		guardarropa.agregarRopa(pantalon);
		Assert.assertEquals(3,guardarropa.getRopa().size());
		Assert.assertTrue( guardarropa.contieneTipo(Ropa.PIERNAS, guardarropa.getRopa()));
		Assert.assertTrue( guardarropa.sugerenciaValida());

	}
	
	@Test 
	public void testMuchasPrendasOk() {
		Ropa remera = Ropa.TORSO;
		Ropa zapatilla = Ropa.PIES;
		Ropa pantalon = Ropa.PIERNAS;
		Ropa chupin = Ropa.PIERNAS;
		Ropa pulsera =Ropa.ACCESORIOS;
		Guardarropa guardarropa = new Guardarropa();
		guardarropa.agregarRopa(remera);
		guardarropa.agregarRopa(zapatilla);
		guardarropa.agregarRopa(pantalon);
		guardarropa.agregarRopa(chupin);
		guardarropa.agregarRopa(pulsera);
		Assert.assertTrue( guardarropa.sugerenciaValida());
	}
	@Test
	public void testListaPasadaPorParametro() {
		Ropa remera = Ropa.TORSO;
		Ropa zapatilla = Ropa.PIES;
		Ropa pantalon = Ropa.PIERNAS;
		ArrayList<Ropa> conjunto= new ArrayList<Ropa>();
		conjunto.add(remera);
		conjunto.add(zapatilla);
		conjunto.add(pantalon);
		Guardarropa guardarropa = new Guardarropa();
		Assert.assertTrue( guardarropa.sugerenciaValida(conjunto));
		
		
	}
	
	@Test
	public void testSugerenciasSon8() throws SugerenciaInvalidaException {
		Ropa remera = Ropa.TORSO;
		Ropa musculosa = Ropa.TORSO;
		Ropa zapato = Ropa.PIES;
		Ropa sandalia = Ropa.PIES;
		Ropa jogging = Ropa.PIERNAS;
		Ropa jeans = Ropa.PIERNAS;
		Guardarropa guardarropa = new Guardarropa();
		guardarropa.agregarRopa(remera);
		guardarropa.agregarRopa(musculosa);
		guardarropa.agregarRopa(zapato);
		guardarropa.agregarRopa(jogging);
		guardarropa.agregarRopa(jeans);
		guardarropa.agregarRopa(sandalia);
		Assert.assertEquals(8, guardarropa.sugerencia().size());
		

	}
	@Test (expected= SugerenciaInvalidaException.class)
	public void testSinSugerencia() throws SugerenciaInvalidaException {
		Guardarropa guardarropa = new Guardarropa();
		Ropa remera = Ropa.TORSO;
		guardarropa.agregarRopa(remera);
		guardarropa.sugerencia();
	}
}