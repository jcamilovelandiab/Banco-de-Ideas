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

public class ComentarioGenerator {
	public static Gen<Comentario> comentarios() {
		return contenidos().zip(UsuarioGenerator.usuarios(), 
				(contenido, autor) -> new Comentario(contenido,autor));
	}
	
	private static Gen<String> contenidos() {
		return strings().betweenCodePoints(97, 122).ofLengthBetween(6, 20).map(x -> { return x +"_prueba"; });
	}
	
	//public Comentario(String contenido, Usuario autor)
	
}
