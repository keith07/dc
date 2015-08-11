package com.tingyun.databean.perfmetricsdata;

import com.fasterxml.jackson.databind.JsonNode;
import com.tingyun.databean.DataBeanConvertor;
import com.tingyun.databean.DataBeanLockException;
import com.tingyun.databean.DefaultDataBeanLockAdaptor;
import com.tingyun.databean.generalmetric.MetricKey;
import com.tingyun.util.Global;


public class ErrorCounterItem extends DefaultDataBeanLockAdaptor implements DataBeanConvertor{
	private MetricKey metricKey;
	//错误数量
	private int errorCount;
	//探针版本号
	private String version;
	public MetricKey getMetricKey() {
		return metricKey;
	}
	public void setMetricKey(MetricKey metricKey) {
		this.metricKey = metricKey;
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
	public ErrorCounterItem(MetricKey metricKey, int errorCount) {
		super();
		this.metricKey = metricKey;
		this.errorCount = errorCount;
	}
	public void parse(JsonNode node, String version) {
		if(Global.PROBE_VERSION.equals(version)){
			parse122(node, version);
		}
		this.version = version;
	}
	
	public ErrorCounterItem() {
		super();
	}
	private void parse122(JsonNode node, String version) {
		 
		 JsonNode node1 = node.path(0);
		 if(node1.isInt()){
			 this.metricKey = new MetricKey(node1.asInt(), 0, null, null);
		 }else if(node1.isObject()){
			 String metricName = node1.path("name").asText();
			 int metricParentId = 0;
			 String metricParentName = null;					
			 JsonNode parent = node1.path("parent");
			if(parent != null) {
				if(parent.isInt()) {
					metricParentId = parent.asInt();
				} else {
					metricParentName = parent.asText();
				}
			}
			metricKey = new MetricKey(0, metricParentId, metricName, metricParentName);
		 }
		 
		 if(node.path(1).isArray()){
			 JsonNode nodeArray = node.path(1);
			 this.errorCount = nodeArray.path(0).asInt();
		 }
	}
}
