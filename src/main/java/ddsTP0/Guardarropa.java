package ddsTP0;

import java.util.ArrayList;


public class Guardarropa {
	ArrayList<Ropa> listaAverificar = null; 

public Guardarropa() {
	this.listaAverificar = new ArrayList<Ropa>();
	
}
public void agregarRopa(Ropa ropa) {
	this.listaAverificar.add(ropa);
}

public ArrayList<Ropa> getRopa(){
	return this.listaAverificar;
}

public boolean contieneTipo(Ropa ropa, ArrayList<Ropa> listaRopa) {

	return listaRopa.stream().anyMatch(p->p.getTypeName().equals(ropa.getTypeName()));
}
public boolean sugerenciaValida()  {
	if (this.listaAverificar != null) {
	return (this.contieneTipo(Ropa.TORSO, this.listaAverificar) &&
	this.contieneTipo(Ropa.PIERNAS, this.listaAverificar) &&
	this.contieneTipo(Ropa.PIES, this.listaAverificar));
	} else {return false;}
}
public boolean sugerenciaValida(ArrayList<Ropa> ropas) {
	if (ropas != null) {
		return (this.contieneTipo(Ropa.TORSO, ropas) &&
		this.contieneTipo(Ropa.PIERNAS, ropas) &&
		this.contieneTipo(Ropa.PIES, ropas));
		} else {return false;}
}
}
