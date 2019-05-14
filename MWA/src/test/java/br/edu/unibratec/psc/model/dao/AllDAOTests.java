package br.edu.unibratec.psc.model.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(
	{
		AutorDAOTest.class, 
		EnderecoDAOTest.class, 
		LivroDAOTest.class, 
		PessoaDAOTest.class 
	}
)
public class AllDAOTests {}