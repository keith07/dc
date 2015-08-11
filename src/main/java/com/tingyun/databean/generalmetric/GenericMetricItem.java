package com.tingyun.databean.generalmetric;

import com.fasterxml.jackson.databind.JsonNode;
import com.tingyun.databean.DataBeanConvertor;
import com.tingyun.databean.DataBeanLockException;
import com.tingyun.databean.DefaultDataBeanLockAdaptor;
import com.tingyun.util.Global;

public class GenericMetricItem extends DefaultDataBeanLockAdaptor implements DataBeanConvertor  {
	private MetricKey metricKey;
	//当前采样时间段内该指标的计数。
	private int count;
	//当前采样时间段内该指标的算术和（单位：毫秒）。
	private long sum;
	//独占执行时间和。对于Action，该值为保留扩展用，暂时不需要统计，置0即可（单位：毫秒）。
	private long sumEx;
	//当前采样时间段内该指标的最大值（单位：毫秒）
	private int max;
	//当前采样时间段内该指标的最小值（单位：毫秒）
	private int min;
	//当前采样时间段内该指标的平方和（单位：毫秒2）
	private long sumSquare;
	//探针版本号
	private String version;
	
	public MetricKey getMetricKey() {
		return metricKey;
	}
	public void setMetricKey(MetricKey metricKey) {
		this.metricKey = metricKey;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.count = count;
	}
	public long getSum() {
		return sum;
	}
	public void setSum(long sum) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.sum = sum;
	}
	public long getSumEx() {
		return sumEx;
	}
	public void setSumEx(long sumEx) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.sumEx = sumEx;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.min = min;
	}
	public long getSumSquare() {
		return sumSquare;
	}
	public void setSumSquare(long sumSquare) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.sumSquare = sumSquare;
	}
	public GenericMetricItem(MetricKey metricKey, int count, long sum,
			long sumEx, int max, int min, long sumSquare) {
		super();
		this.metricKey = metricKey;
		this.count = count;
		this.sum = sum;
		this.sumEx = sumEx;
		this.max = max;
		this.min = min;
		this.sumSquare = sumSquare;
	}
	
	public GenericMetricItem() {
		super();
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
			 this.count 	= nodeArray.path(0).asInt();
			 this.sum   	= nodeArray.path(1).asLong();
			 this.sumEx 	= nodeArray.path(2).asLong();
			 this.max   	= nodeArray.path(3).asInt();
			 this.min   	= nodeArray.path(4).asInt();
			 this.sumSquare = nodeArray.path(5).asLong();
		 }
	}
}
