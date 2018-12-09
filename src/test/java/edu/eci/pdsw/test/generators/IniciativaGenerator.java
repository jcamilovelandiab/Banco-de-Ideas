package edu.eci.pdsw.test.generators;

import org.quicktheories.core.Gen;
import static org.quicktheories.QuickTheory.qt;
import org.quicktheories.generators.Generate;
import static org.quicktheories.generators.SourceDSL.*;

import edu.eci.pdsw.entities.Area;
import edu.eci.pdsw.entities.Rol;
import edu.eci.pdsw.entities.Usuario;
import edu.eci.pdsw.entities.Iniciativa;

public class IniciativaGenerator {
	
	public static Gen<Iniciativa> iniciativas() {
		return nombres().zip(descripciones(), UsuarioGenerator.usuarios(), 
				(nombre, descripcion, usuario) -> new Iniciativa(nombre, descripcion, usuario));
	}
	
	private static Gen<String> nombres() {
		return strings().betweenCodePoints(97, 122).ofLengthBetween(6, 15).map(x -> { return x +"_prueba"; });
	}
	
	private static Gen<String> descripciones() {
		return strings().betweenCodePoints(97, 122).ofLengthBetween(6, 20);
	}
	
	//public Iniciativa(String nombre, String descripcion, Usuario usuario)
}
