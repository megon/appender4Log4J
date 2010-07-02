package com.appender.domain;

import java.io.Serializable;

/**
 * Responsavel por encapsular as informacoes relevantes de um evento gerado pelo appender do log4j.
 * 
 * @author Marco Rojo
 * Data: 29/01/2010
 */
public class MyEvent implements Serializable{
	
	private static final long serialVersionUID = 1195118723590476669L;
	
	private String env;
	private String key;
	private String apiVersion;
	private String clientName;
	private String clientVersion;
	private String category;
	private String message;
	private String className;
	private String fileName;
	private String lineNumber;
	private String methodName;
	private String trace;
	
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getTrace() {
		return trace;
	}

	public void setTrace(String trace) {
		this.trace = trace;
	}
	
	
	
	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientVersion() {
		return clientVersion;
	}

	public void setClientVersion(String clientVersion) {
		this.clientVersion = clientVersion;
	}
	
	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String toXML(){
		
		final StringBuffer xml = new StringBuffer();
		xml.append("<event>");
		xml.append("<environment>");
		xml.append(getEnv());
		xml.append("</environment>");
		xml.append("<projectKey>");
		xml.append(getKey());
		xml.append("</projectKey>");
		xml.append("<apiVersion>");
		xml.append(getApiVersion());
		xml.append("</apiVersion>");
		xml.append("<clientName>");
		xml.append(getClientName());
		xml.append("</clientName>");
		xml.append("<clientVersion>");
		xml.append(getClientVersion());
		xml.append("</clientVersion>");
		xml.append("<category>");
		xml.append(getCategory());
		xml.append("</category>");
		xml.append("<message>");
		xml.append(getMessage());
		xml.append("</message>");
		xml.append("<className>");
		xml.append(getClassName());
		xml.append("</className>");
		xml.append("<fileName>");
		xml.append(getFileName());
		xml.append("</fileName>");
		xml.append("<lineNumber>");
		xml.append(getLineNumber());
		xml.append("</lineNumber>");
		xml.append("<methodName>");
		xml.append(getMethodName());
		xml.append("</methodName>");
		xml.append("<trace>");
		xml.append(getTrace());
		xml.append("</trace>");
		xml.append("</event>");

		return xml.toString();
	}
	
}
