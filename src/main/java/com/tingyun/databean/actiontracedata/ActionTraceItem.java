package com.tingyun.databean.actiontracedata;

import com.fasterxml.jackson.databind.JsonNode;
import com.tingyun.databean.DataBeanConvertor;
import com.tingyun.databean.DataBeanLockException;
import com.tingyun.databean.DefaultDataBeanLockAdaptor;
import com.tingyun.util.Global;

public class ActionTraceItem extends DefaultDataBeanLockAdaptor implements DataBeanConvertor{
	// trace时间戳
	private int timestamp;
	private String actionMetricName;
	//持续时间
	private int duration;
	// 请求uri
	private String requestUri;
	//trace详细信息
	private String trace;
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
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.duration = duration;
	}
	public String getRequestUri() {
		return requestUri;
	}
	public void setRequestUri(String requestUri) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.requestUri = requestUri;
	}
	public String getTrace() {
		return trace;
	}
	public void setTrace(String trace) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.trace = trace;
	}
	
	public ActionTraceItem() {
		super();
	}
	public ActionTraceItem(int timestamp, String actionMetricName,
			int duration, String requestUri, String trace) {
		super();
		this.timestamp = timestamp;
		this.actionMetricName = actionMetricName;
		this.duration = duration;
		this.requestUri = requestUri;
		this.trace = trace;
	}
	public void parse(JsonNode node, String version) {
		if(Global.PROBE_VERSION.equals(version)){
			parse122(node, version);
		}
		this.version = version;
	}
	private void parse122(JsonNode node, String version) {
		
		 this.timestamp        = node.path(0).asInt();
		 this.actionMetricName = node.path(1).asText();
		 this.duration		   = node.path(2).asInt();
		 this.requestUri	   = node.path(3).asText();
		 this.trace		       = node.path(4).asText();
	}
}
