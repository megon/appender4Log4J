package com.appender.log4j;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;

import com.appender.domain.assembler.MyEventAssembler;
import com.appender.service.EventNotifierException;
import com.appender.service.EventNotifierService;
import com.appender.service.impl.EventNotifierServiceImpl;

public class MyLog4jAppender extends AppenderSkeleton {
	
	private final Logger logger = Logger.getLogger(getClass());

	private String key;
	private String env;
	private EventNotifierService notifier;
	
	public MyLog4jAppender(EventNotifierService eventNotifier){
		notifier = eventNotifier;
	}
	
	public MyLog4jAppender(){
		notifier = new EventNotifierServiceImpl();
	}
	
	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean requiresLayout() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void append(final LoggingEvent event) {
		MyEventAssembler assembler = new MyEventAssembler();
		try{
			if (event.getClass().getName() != getClass().getName()){
				if (event.getMessage().getClass() != EventNotifierException.class){
					notifier.send(assembler.createMyEvent(env, key, event));
				}
			}
		}
		catch (Exception ex){
			logger.error(ex);
		}
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	

}
