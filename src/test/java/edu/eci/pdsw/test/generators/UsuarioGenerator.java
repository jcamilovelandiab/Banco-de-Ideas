package edu.eci.pdsw.test.generators;

import org.quicktheories.core.Gen;
import static org.quicktheories.QuickTheory.qt;
import org.quicktheories.generators.Generate;
import static org.quicktheories.generators.SourceDSL.*;

import edu.eci.pdsw.entities.Area;
import edu.eci.pdsw.entities.Rol;
import edu.eci.pdsw.entities.Usuario;

public class UsuarioGenerator {
	
	public static Gen<Usuario> usuarios() {
		return nombres().zip(correos(), 
				(nombre, correo) -> new Usuario(nombre, correo));
	}
	
	private static Gen<String> nombres() {
		return strings().betweenCodePoints(97, 122).ofLengthBetween(6, 20);
	}
	
	private static Gen<String> correos() {
		return strings().betweenCodePoints(97, 122).ofLengthBetween(6, 20).map(x -> { return x +"prueba@mail.escuelaing.edu.co"; });
	}
	
	//public Usuario(String nombre, String correo,Area area, Rol tipo)
	
}
