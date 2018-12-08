package edu.eci.pdsw.test.generators;

import org.quicktheories.core.Gen;
import static org.quicktheories.QuickTheory.qt;
import org.quicktheories.generators.Generate;
import static org.quicktheories.generators.SourceDSL.*;

import edu.eci.pdsw.entities.Area;

public class AreaGenerator {

	public static Gen<Area> areas() {
		return nombres().zip(descripciones(), 
				(nombre, descripcion) -> new Area(nombre, descripcion));
	}
	
	private static Gen<String> nombres() {
		return strings().betweenCodePoints(97, 122).ofLengthBetween(6, 20);
	}
	
	private static Gen<String> descripciones() {
		return strings().betweenCodePoints(97, 122).ofLengthBetween(6, 20);
	}
}
