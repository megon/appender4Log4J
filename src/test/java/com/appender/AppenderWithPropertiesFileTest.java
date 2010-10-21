package com.appender;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

/**
 * Teste de integracao.<br>
 * Para roda-lo precisa que o www.listentomyapp.com/go esteja no ar.<br>
 * Caso nao queira executar esses testes, adicionar @Ignore nos mesmos.<br><br>
 * Para realizar esse teste deve-se editar o arquivo src/test/resource/log4j.properties
 * para configurar corretamente a userKey esperada no ListenToMyApp.
 * @author Marco Rojo
 * Data: 30/01/2010
 */
public class AppenderWithPropertiesFileTest {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Before
	public void startup(){
		PropertyConfigurator.configure(this.getClass().getResource("/log4j.properties"));
	}
	
	@Test
	public void infoTest() throws Exception{
		logger.info("teste");
	}
	
	
	@Test
	public void errorTest() throws Exception{
		try{
			throw new MyException("Ocorreu um erro");
		}
		catch (Exception ex){
			logger.error(ex.getMessage(), ex);
		}
	}
	

}
