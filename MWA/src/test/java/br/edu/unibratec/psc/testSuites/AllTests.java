package br.edu.unibratec.psc.testSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.edu.unibratec.psc.model.dao.AllDAOTests;
import br.edu.unibratec.psc.model.entity.AllEntityTests;
import br.edu.unibratec.psc.model.entity.json.AllJsonTests;
import br.edu.unibratec.tests.selenium.AllSeleniumTests;

@RunWith(Suite.class)
@SuiteClasses(
	{
		AllDAOTests			.class,
		AllEntityTests		.class,
		AllJsonTests		.class,
		AllSeleniumTests	.class
	}
)
public class AllTests {}