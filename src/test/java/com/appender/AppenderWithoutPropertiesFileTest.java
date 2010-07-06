package com.appender;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.appender.log4j.MyLog4jAppender;

/**
 * Teste de integracao, para executa-lo e necessario que o servico http://localhost:8080/listenMyApp/services/add esteja executando. <br>
 * Executa o teste da classe {@link MyLog4jAppender}, criando o logger via programacao.<br>
 * 
 * @author Marco Rojo
 * Data: 30/01/2010
 */
public class AppenderWithoutPropertiesFileTest {
	
	private final Logger logger = Logger.getRootLogger();
	
	@Before
	public void startup(){
		logger.setLevel(Level.INFO);
		
		MyLog4jAppender appender = new MyLog4jAppender();
		appender.setName("myAppender");
		appender.setEnv("producao");
		appender.setKey("1234");
		
		logger.addAppender(appender);
	}
	
	@Test @Ignore
	public void infoTest() throws Exception{
		logger.info("infoTest");
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
