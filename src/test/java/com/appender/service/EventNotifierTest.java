package com.appender.service;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import com.appender.domain.MyEvent;
import com.appender.service.EventNotifierService;
import com.appender.service.impl.EventNotifierServiceImpl;

/**
 * Teste de integracao, para executa-lo e necessario que o servico http://localhost:8080/listenMyApp/services/add esteja executando. <br>
 * Executa o teste da classe {@link EventNotifierServiceImpl}.<br>
 * 
 * @author Marco Rojo
 * Data: 30/01/2010
 */
public class EventNotifierTest {

	@Test@Ignore
	public void sendTest() throws Exception{
		EventNotifierService notifier = new EventNotifierServiceImpl();
		final MyEvent event = new MyEvent();
		event.setEnv("PRODUCAO");
		event.setKey("KEY");
		event.setClassName(getClass().getName());
		event.setFileName(getClass().getName().concat(".java"));
		event.setLineNumber("27");
		event.setMessage("message");
		event.setMethodName("sendTest");
		event.setTrace("trace");
		notifier.send(event);
	}
}
