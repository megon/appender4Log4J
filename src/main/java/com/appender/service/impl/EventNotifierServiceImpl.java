package com.appender.service.impl;

import java.util.Properties;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.appender.domain.MyEvent;
import com.appender.service.EventNotifierService;
import com.appender.service.EventNotifierException;

public class EventNotifierServiceImpl implements EventNotifierService {
	
	@Override
	public void send(final MyEvent event) throws EventNotifierException{
		sendPostHttp(event.toXML());
	}
	
	private void sendPostHttp(final String event) throws EventNotifierException{
			final HttpClient client = new DefaultHttpClient();
			final Properties prop = new Properties();
			final HttpResponse response;
			
			try{
				prop.load(getClass().getResourceAsStream("/conf.properties"));
				
				final HttpPost post = new HttpPost(prop.getProperty("URL"));
				final StringEntity entity = new StringEntity(event);
				entity.setContentType("application/xml");
				post.setEntity(entity);
				
				response = client.execute(post);
			}
			catch (Exception ex){
				throw new EventNotifierException(HttpStatus.SC_BAD_REQUEST, ex.getMessage());
			}
			finally{
				client.getConnectionManager().shutdown();
			}
			if (response.getStatusLine().getStatusCode()!= HttpStatus.SC_OK){
				throw new EventNotifierException(response.getStatusLine().getStatusCode(), response.getStatusLine().toString());
			}

	}
	

}
