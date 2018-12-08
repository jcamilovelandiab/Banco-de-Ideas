package edu.eci.pdsw.validator;

import static org.junit.Assert.*;
import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.integers;

import org.junit.Test;

public class TESTTest {

	@Test
	public void test() {
		  qt()
		    .forAll(integers().allPositive()
		          , integers().allPositive())
		    .check((i,j) -> true); 
		  }
}

