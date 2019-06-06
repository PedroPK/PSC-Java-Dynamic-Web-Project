package br.edu.unibratec.psc.util;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(
	{
		LombokTest.class, 
		UtilMethodsTest.class 
	}
)
public class AllUtilTests {}
