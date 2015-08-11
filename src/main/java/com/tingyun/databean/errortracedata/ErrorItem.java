package com.tingyun.databean.errortracedata;

import com.fasterxml.jackson.databind.JsonNode;
import com.tingyun.databean.DataBeanConvertor;
import com.tingyun.databean.DataBeanLockException;
import com.tingyun.databean.DefaultDataBeanLockAdaptor;
import com.tingyun.util.Global;


public class ErrorItem extends DefaultDataBeanLockAdaptor implements DataBeanConvertor{
	//时间戳
	private int timestamp;
	//关联的actionname
	private String actionMetricName;
	//http状态吗
	private int httpStatus;
	//异常类名
	private String exceptionClassName;
	//异常信息
	private String errorMessage;
	//错误次数
	private int errorCount;
	//请求url
	private String requestUrl;
	//错误参数信息
	private String params;
	
	private String version;
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public int getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(int timestamp) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.timestamp = timestamp;
	}
	public String getActionMetricName() {
		return actionMetricName;
	}
	public void setActionMetricName(String actionMetricName) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.actionMetricName = actionMetricName;
	}
	public int getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(int httpStatus) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.httpStatus = httpStatus;
	}
	public String getExceptionClassName() {
		return exceptionClassName;
	}
	public void setExceptionClassName(String exceptionClassName) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.exceptionClassName = exceptionClassName;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.errorMessage = errorMessage;
	}
	public int getErrorCount() {
		return errorCount;
	}
	public void setErrorCount(int errorCount) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.errorCount = errorCount;
	}
	public String getRequestUrl() {
		return requestUrl;
	}
	public void setRequestUrl(String requestUrl) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.requestUrl = requestUrl;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.params = params;
	}
	public ErrorItem(int timestamp, String actionMetricName, int httpStatus,
			String exceptionClassName, String errorMessage, int errorCount,
			String requestUrl, String params) {
		super();
		this.timestamp = timestamp;
		this.actionMetricName = actionMetricName;
		this.httpStatus = httpStatus;
		this.exceptionClassName = exceptionClassName;
		this.errorMessage = errorMessage;
		this.errorCount = errorCount;
		this.requestUrl = requestUrl;
		this.params = params;
	}
	
	public ErrorItem() {
		super();
	}
	public void parse(JsonNode node, String version) {
		if(Global.PROBE_VERSION.equals(version)){
			parse122(node, version);
		}
		this.version = version;
	}
	private void parse122(JsonNode node, String version) {
		this.timestamp = node.path(0).asInt();
		this.actionMetricName = node.path(1).asText();
		this.httpStatus = node.path(2).asInt();
		this.exceptionClassName = node.path(3).asText();
		this.errorMessage = node.path(4).asText();
		this.errorCount = node.path(5).asInt();
		this.requestUrl = node.path(6).asText();
		this.params = node.path(7).asText();
	}
}
