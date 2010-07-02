package com.appender.domain.assembler;

import java.util.Properties;

import org.apache.log4j.spi.LoggingEvent;

import com.appender.domain.MyEvent;

/**
 * Responsavel por criar um objeto MyEvent a partir de um Logging4jEvent
 * 
 * @author Marco Rojo
 * Data: 30/01/2010
 */
public class MyEventAssembler {

	/**
	 * Cria um objeto MyEvent a partir de um LoggingEvent. 
	 * @param env ambiente onde foi gerado o evento.
	 * @param key chave do cliente.
	 * @param loggingEvent evento gerado pelo log4j. 
	 * @return
	 */
	public MyEvent createMyEvent(final String env, final String key, final LoggingEvent loggingEvent) throws Exception{
		final Properties prop = new Properties();
		final MyEvent myEvent = new MyEvent();
		
		prop.load(getClass().getResourceAsStream("/conf.properties"));
		
		myEvent.setEnv(env);
		myEvent.setKey(key);
		myEvent.setApiVersion(prop.getProperty("API_VERSION"));
		myEvent.setClientName(prop.getProperty("CLIENT_NAME"));
		myEvent.setClientVersion(prop.getProperty("CLIENT_VERSION"));
		myEvent.setMessage(loggingEvent.getMessage().toString());
		myEvent.setClassName(loggingEvent.getLocationInformation().getClassName());
		myEvent.setFileName(loggingEvent.getLocationInformation().getFileName());
		myEvent.setLineNumber(loggingEvent.getLocationInformation().getLineNumber());
		myEvent.setMethodName(loggingEvent.getLocationInformation().getMethodName().replaceAll("<", "").replaceAll(">", ""));
		myEvent.setCategory(loggingEvent.getLevel().toString());
		
		if (loggingEvent.getThrowableInformation()!= null){
			StringBuilder loggingTrace = new StringBuilder();
			for(String stack : loggingEvent.getThrowableStrRep()){
				loggingTrace.append(stack);
				loggingTrace.append(System.getProperty("line.separator"));
			}
			myEvent.setTrace(loggingTrace.toString());
		}
		return myEvent;
	}
}
