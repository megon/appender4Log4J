package com.appender;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.appender.log4j.MyLog4jAppender;
import com.appender.service.EventNotifierService;
import com.appender.service.impl.EventNotifierServiceImpl;

/**
 * @author Marco Rojo
 * Data: 30/01/2010
 */
@RunWith(MockitoJUnitRunner.class)
public class AppenderWithoutPropertiesFileTest {
	
	private final Logger logger = Logger.getRootLogger();
	
	@Mock
	private final EventNotifierService notifier = new EventNotifierServiceImpl();
	
	@Before
	public void startup(){
		logger.setLevel(Level.INFO);
		
		MyLog4jAppender appender = new MyLog4jAppender(notifier);
		appender.setName("myAppender");
		appender.setEnv("PRD");
		appender.setKey("1234");
		
		logger.addAppender(appender);
	}
	
	@Test
	public void infoTest() throws Exception{
		logger.info("infoTest");
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
