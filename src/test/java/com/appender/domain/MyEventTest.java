package com.appender.domain;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Teste unitário da classe MyEvent, a qual é responsável por gerar o XML de request para o serviço.<br>
 * 
 * @author Marcelo Menezes
 * Data: 01/02/2010
 */
public class MyEventTest{
	
	static StringBuffer xmlRequest = new StringBuffer();
	
	@BeforeClass
	public static void onTimeSetup() throws Exception {
		System.out.println("onTimeSetup");
		xmlRequest.append("<event>");
		xmlRequest.append("<environment>production</environment>");
		xmlRequest.append("<projectKey>asxcdsa12s5c1s52s</projectKey>");
		xmlRequest.append("<apiVersion>1.1</apiVersion>");
		xmlRequest.append("<clientName>Eclipse</clientName>");
		xmlRequest.append("<clientVersion>3.5</clientVersion>");
		xmlRequest.append("<category>INFO</category>");
		xmlRequest.append("<message>Error trying to load data.</message>");
		xmlRequest.append("<className>org.hibernate.LazyInicializationException</className>");
		xmlRequest.append("<fileName>MyConnection.java</fileName>");
		xmlRequest.append("<lineNumber>15</lineNumber>");
		xmlRequest.append("<methodName>connect()</methodName>");
		xmlRequest.append("<trace>trying to figure ou what is happening</trace>");
		xmlRequest.append("</event>");
	}

	
	@Test
	public void testToXML() throws Exception {
		System.out.println("testToXML");
		
		MyEvent event = new MyEvent();		
		event.setEnv("production");
		event.setKey("asxcdsa12s5c1s52s");
		event.setApiVersion("1.1");
		event.setClientName("Eclipse");
		event.setClientVersion("3.5");
		event.setMessage("Error trying to load data.");
		
		event.setClassName("org.hibernate.LazyInicializationException");
		event.setFileName("MyConnection.java");
		event.setLineNumber("15");
		event.setMethodName("connect()");
		event.setTrace("trying to figure ou what is happening");
		event.setCategory("INFO");

		assertEquals( xmlRequest.toString(), event.toXML().toString() );
		System.out.println(event.toXML());
	}
	
}
