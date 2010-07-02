package com.appender.service;

import com.appender.domain.MyEvent;

/**
 * Servico responsavel por enviar uma notificacao de erro ao sistema XXXX.
 * 
 * @author Marco Rojo
 * Data: 29/01/2010
 */
//TODO Atualizar nome do sistema
public interface EventNotifierService  {
	
	/**
	 * Recebe um evento de erro e o envia para o sistema XXXX. 
	 * 
	 * @param loggingEvent evento de erro gerado pelo sistema.
	 */
	//TODO Atualizar nome do sistema
	void send(MyEvent event) throws EventNotifierException;

}
