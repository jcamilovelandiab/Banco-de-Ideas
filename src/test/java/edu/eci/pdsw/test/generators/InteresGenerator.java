package edu.eci.pdsw.test.generators;

import org.quicktheories.core.Gen;
import static org.quicktheories.QuickTheory.qt;
import org.quicktheories.generators.Generate;
import static org.quicktheories.generators.SourceDSL.*;

import edu.eci.pdsw.entities.Area;
import edu.eci.pdsw.entities.Rol;
import edu.eci.pdsw.entities.Usuario;
import edu.eci.pdsw.entities.Comentario;
import edu.eci.pdsw.entities.Iniciativa;
import edu.eci.pdsw.entities.Interes;


public class InteresGenerator {
	
	public static Gen<Interes> intereses() {
		return intenciones().zip(descripciones(), UsuarioGenerator.usuarios(), 
				(intencion, descripcion,  interesado) -> new Interes(intencion, descripcion, interesado));
	}
	
	private static Gen<String> intenciones() {
		return strings().betweenCodePoints(97, 122).ofLengthBetween(6, 20);
	}
	
	private static Gen<String> descripciones() {
		return strings().betweenCodePoints(97, 122).ofLengthBetween(6, 20);
	}
	//public Interes(String intencion,String descripcion, Boolean trabajo, Usuario interesado)
	
}
