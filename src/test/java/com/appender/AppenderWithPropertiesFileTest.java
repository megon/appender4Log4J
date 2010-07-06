package com.appender;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.appender.log4j.MyLog4jAppender;

/**
 * Teste de integracao, para executa-lo e necessario que o servico http://localhost:8080/listenMyApp/services/add esteja executando. <br>
 * Executa o teste da classe {@link MyLog4jAppender}, criando o logger via properties.<br>
 * 
 * @author Marco Rojo
 * Data: 30/01/2010
 */
public class AppenderWithPropertiesFileTest {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Before
	public void startup(){
		PropertyConfigurator.configure(this.getClass().getResource("/log4j.properties"));
	}
	
	@Test @Ignore
	public void infoTest() throws Exception{
		logger.info("teste");
	}
	
	
	@Test @Ignore
	public void errorTest() throws Exception{
		try{
			throw new MyException("Ocorreu um erro");
		}
		catch (Exception ex){
			logger.error(ex.getMessage(), ex);
		}
	}
	

}
