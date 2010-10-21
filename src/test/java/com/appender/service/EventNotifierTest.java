package com.appender.service;

import org.junit.Ignore;
import org.junit.Test;

import com.appender.domain.MyEvent;
import com.appender.service.EventNotifierService;
import com.appender.service.impl.EventNotifierServiceImpl;

/**
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
