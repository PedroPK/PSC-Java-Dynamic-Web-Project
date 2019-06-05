package br.edu.unibratec.psc.testSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.edu.unibratec.psc.util.LombokTest;
import br.edu.unibratec.psc.util.UtilMethodsTest;

@RunWith(Suite.class)
@SuiteClasses(
	{
		LombokTest.class, 
		UtilMethodsTest.class 
	}
)
public class AllUtilTests {}
