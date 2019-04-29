package ddsTP0;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class Guardarropa {
	ArrayList<Ropa> listaRopa = null; 

public Guardarropa() {
	this.listaRopa = new ArrayList<Ropa>();
	
}
public void agregarRopa(Ropa ropa) {
	this.listaRopa.add(ropa);
}

public ArrayList<Ropa> getRopa(){
	return this.listaRopa;
}

public boolean contieneTipo(Ropa ropa, ArrayList<Ropa> listaRopa) {

	return listaRopa.stream().anyMatch(p->p.getTypeName().equals(ropa.getTypeName()));
}
public boolean sugerenciaValida()  {
	if (this.listaRopa != null) {
	return (this.contieneTipo(Ropa.TORSO, this.listaRopa) &&
	this.contieneTipo(Ropa.PIERNAS, this.listaRopa) &&
	this.contieneTipo(Ropa.PIES, this.listaRopa));
	} else {return false;}
}
public boolean sugerenciaValida(ArrayList<Ropa> ropas) {
	if (ropas != null) {
		return (this.contieneTipo(Ropa.TORSO, ropas) &&
		this.contieneTipo(Ropa.PIERNAS, ropas) &&
		this.contieneTipo(Ropa.PIES, ropas));
		} else {return false;}
}
public ArrayList<ArrayList<Ropa>> sugerencia() throws SugerenciaInvalidaException {
	if(!this.sugerenciaValida()) {
		throw new SugerenciaInvalidaException();
	}
	ArrayList<Ropa> listaTorso =  new ArrayList<Ropa>(); 
	listaTorso =  this.listaRopa.stream().filter(r->r.getTypeName().equals(Ropa.TORSO.getTypeName())).collect(Collectors.toCollection(ArrayList::new));
	ArrayList<Ropa> listaPie =  new ArrayList<Ropa>(); 
	listaPie =  this.listaRopa.stream().filter(r->r.getTypeName().equals(Ropa.PIES.getTypeName())).collect(Collectors.toCollection(ArrayList::new));
	ArrayList<Ropa> listaPierna =  new ArrayList<Ropa>();
	listaPierna = this.listaRopa.stream().filter(r->r.getTypeName().equals(Ropa.PIERNAS.getTypeName())).collect(Collectors.toCollection(ArrayList::new));
	
	ArrayList<ArrayList<Ropa>> sugerencias = new ArrayList<ArrayList<Ropa>>();
	ArrayList<Ropa> sugerencia = new ArrayList<Ropa>();
	
	for(int i=0;i<listaTorso.size();i++) {
		Ropa torso = listaTorso.get(i);
		for(int j=0;j<listaPie.size();j++) {
			Ropa pie = listaPie.get(j);
			for(int k=0;k<listaPierna.size();k++) {
				Ropa pierna = listaPierna.get(k);
				sugerencia.add(torso);
				sugerencia.add(pie);
				sugerencia.add(pierna);
				sugerencias.add(sugerencia);
				sugerencia.clear();
			}
		}
	}
	
	return sugerencias;
	
}

}
