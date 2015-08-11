package com.tingyun.databean.sqltracedata;

import com.fasterxml.jackson.databind.JsonNode;
import com.tingyun.databean.DataBeanConvertor;
import com.tingyun.databean.DataBeanLock;
import com.tingyun.databean.DataBeanLockException;
import com.tingyun.databean.DefaultDataBeanLockAdaptor;
import com.tingyun.util.Global;

public class SqlTraceItem extends DefaultDataBeanLockAdaptor implements DataBeanConvertor ,DataBeanLock {
	private String version;
	
	//Trace开始时间。EPOCH时间戳（单位：秒）。如果该SQL执行了多次，则取执行最慢的那次的开始时间。
	private long    sqlTraceTimeInSeconds;
	//Action名称
	private String   actionRootMetricName;
	//对应SQL指标名称
	private String   metricName;
	//Action请求URI
	private String   requestUri;
	//若用户配置了SQL混淆，则为混淆后的SQL
	private String   sqlObfuscated;
	//本周期内本应用该SQL调用次数
	private long 	  callCount;
	//本周期内本应用该SQL执行总时间
	private long    sumPerf;
	//本周期内本应用该SQL执行时间最大值
	private long 	  maxPerf;
	//本周期内本应用该SQL执行时间最小值
	private long  	  minPerf;
	//自定义参数
	private String   sqlParams;
	
	
	
	public long getSqlTraceTimeInSeconds() {
		return sqlTraceTimeInSeconds;
	}
	public void setSqlTraceTimeInSeconds(long sqlTraceTimeInSeconds) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.sqlTraceTimeInSeconds = sqlTraceTimeInSeconds;
	}
	public String getActionRootMetricName() {
		return actionRootMetricName;
	}
	public void setActionRootMetricName(String actionRootMetricName) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.actionRootMetricName = actionRootMetricName;
	}
	public String getMetricName() {
		return metricName;
	}
	public void setMetricName(String metricName) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.metricName = metricName;
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
	public String getSqlObfuscated() {
		return sqlObfuscated;
	}
	public void setSqlObfuscated(String sqlObfuscated) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.sqlObfuscated = sqlObfuscated;
	}
	public long getCallCount() {
		return callCount;
	}
	public void setCallCount(long callCount) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.callCount = callCount;
	}
	public long getSumPerf() {
		return sumPerf;
	}
	public void setSumPerf(long sumPerf) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.sumPerf = sumPerf;
	}
	public long getMaxPerf() {
		return maxPerf;
	}
	public void setMaxPerf(long maxPerf) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.maxPerf = maxPerf;
	}
	public long getMinPerf() {
		return minPerf;
	}
	public void setMinPerf(long minPerf) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.minPerf = minPerf;
	}
	public String getSqlParams() {
		return sqlParams;
	}
	public void setSqlParams(String sqlParams) {
		if(this.isLocked()){
			throw new DataBeanLockException();
		}
		this.sqlParams = sqlParams;
	}
	
	public void parse(JsonNode node, String version) {
		if(Global.PROBE_VERSION.equals(version)){
			parse122(node, version);
		}
		this.version = version;
	}	
	
	private void parse122(JsonNode node, String version) {
	
		 sqlTraceTimeInSeconds = node.path(0).asLong();
		 actionRootMetricName  = node.path(1).asText();
		 metricName			   = node.path(2).asText();
		 requestUri			   = node.path(3).asText();
		 sqlObfuscated		   = node.path(4).asText();
		 callCount			   = node.path(5).asLong();
		 sumPerf			   = node.path(6).asLong();
		 maxPerf			   = node.path(7).asLong();
		 minPerf			   = node.path(8).asLong();
		 sqlParams			   = node.path(9).asText();
	}
	
}
