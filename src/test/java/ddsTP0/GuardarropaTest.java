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
		Ropa calza =Ropa.PIERNAS;
		Ropa pulsera =Ropa.ACCESORIOS;
		Guardarropa guardarropa = new Guardarropa();
		guardarropa.agregarRopa(remera);
		guardarropa.agregarRopa(zapatilla);
		guardarropa.agregarRopa(pantalon);
		guardarropa.agregarRopa(chupin);
		guardarropa.agregarRopa(calza);
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
}