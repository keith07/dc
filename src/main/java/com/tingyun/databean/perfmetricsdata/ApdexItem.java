package com.tingyun.databean.perfmetricsdata;

import com.fasterxml.jackson.databind.JsonNode;
import com.tingyun.databean.DataBeanConvertor;
import com.tingyun.databean.DataBeanLockException;
import com.tingyun.databean.DefaultDataBeanLockAdaptor;
import com.tingyun.databean.generalmetric.MetricKey;
import com.tingyun.util.Global;



public class ApdexItem extends DefaultDataBeanLockAdaptor implements DataBeanConvertor{
	private MetricKey metricKey;
	//Apdex满意数
	private int satisfiedCount;
	// Apdex可忍受数
	private int toleratingCount;
	// Apdex无法忍受数
	private int frustratedCount;
	//Apdex可忍受阈值，单位：毫秒
	private int apdexT;
	//探针版本号
	private String version;
	public MetricKey getMetricKey() {
		return metricKey;
	}
	public void setMetricKey(MetricKey metricKey) {
		this.metricKey = metricKey;
	}
	public int getSatisfiedCount() {
		return satisfiedCount;
	}
	public void setSatisfiedCount(int satisfiedCount) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.satisfiedCount = satisfiedCount;
	}
	public int getToleratingCount() {
		return toleratingCount;
	}
	public void setToleratingCount(int toleratingCount) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.toleratingCount = toleratingCount;
	}
	public int getFrustratedCount() {
		return frustratedCount;
	}
	public void setFrustratedCount(int frustratedCount) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.frustratedCount = frustratedCount;
	}
	public int getApdexT() {
		return apdexT;
	}
	public void setApdexT(int apdexT) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.apdexT = apdexT;
	}
	public ApdexItem() {
		super();
	}
	public ApdexItem(MetricKey metricKey, int satisfiedCount,
			int toleratingCount, int frustratedCount, int apdexT) {
		super();
		this.metricKey = metricKey;
		this.satisfiedCount = satisfiedCount;
		this.toleratingCount = toleratingCount;
		this.frustratedCount = frustratedCount;
		this.apdexT = apdexT;
	}
	public void parse(JsonNode node, String version) {
		if(Global.PROBE_VERSION.equals(version)){
			parse122(node, version);
		}
		this.version = version;
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
			 
			 this.satisfiedCount = nodeArray.path(0).asInt();
			 this.toleratingCount = nodeArray.path(1).asInt();
			 this.frustratedCount = nodeArray.path(2).asInt();
			 this.apdexT = nodeArray.path(3).asInt();
		 }
	}
	
}
