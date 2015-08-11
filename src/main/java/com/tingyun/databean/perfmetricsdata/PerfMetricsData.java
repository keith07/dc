package com.tingyun.databean.perfmetricsdata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.tingyun.databean.DataBeanConvertor;
import com.tingyun.databean.DataBeanLockException;
import com.tingyun.databean.DefaultDataBeanLockAdaptor;
import com.tingyun.databean.generalmetric.GenericMetricItem;

public class PerfMetricsData extends DefaultDataBeanLockAdaptor  implements DataBeanConvertor  {
	//当前上传数据时间段的起始EPOCH时间戳（秒）
	private int timeFrom;
	//当前上传数据时间段的起始EPOCH时间戳（秒）
	private int timeTo;
	// 数据上传间隔(秒)。若Agent端上传故障，可能做合并处理，服务器
	private int interval;
	//Web action或后台应用相关的性能数据。actions中仅包含正常访问的数
	private List<GenericMetricItem> actions;
	// Web action Apdex数据
	private List<ApdexItem> apdex;
	//错误信息
	private List<ErrorCounterItem> errors;
	//Web应用过程或后台应用break down性能数据
	private List<GenericMetricItem> components;
	//其它性能数据，包括数据库、NoSQL、当前应用的CPU、内存、Deadlock线程、系统探针数据等。
	private List<GenericMetricItem> general;
	
	private boolean  locked   = false;
	@Override
	public void lock() {
		super.lock();
		for(GenericMetricItem gmi:actions){
			gmi.lock();
		}
		for(GenericMetricItem gmi:components){
			gmi.lock();
		}
		for(GenericMetricItem gmi:general){
			gmi.lock();
		}
		for(ApdexItem gmi:apdex){
			gmi.lock();
		}
		for(ErrorCounterItem gmi:errors){
			gmi.lock();
		}
	}
	public int getTimeFrom() {
		return timeFrom;
	}
	public void setTimeFrom(int timeFrom) {
		if(this.locked){
			throw new DataBeanLockException();
		}
		this.timeFrom = timeFrom;
	}
	public int getTimeTo() {
		return timeTo;
	}
	public void setTimeTo(int timeTo) {
		if(this.locked){
			throw new DataBeanLockException();
		}
		this.timeTo = timeTo;
	}
	public int getInterval() {
		return interval;
	}
	public void setInterval(int interval) {
		if(this.locked){
			throw new DataBeanLockException();
		}
		this.interval = interval;
	}
	public List<GenericMetricItem> getActions() {
		return actions;
	}
	public void setActions(List<GenericMetricItem> actions) {
		if(this.locked){
			throw new DataBeanLockException();
		}
		this.actions = actions;
	}
	public List<ApdexItem> getApdex() {
		return apdex;
	}
	public void setApdex(List<ApdexItem> apdex) {
		if(this.locked){
			throw new DataBeanLockException();
		}
		this.apdex = apdex;
	}
	public List<ErrorCounterItem> getErrors() {
		return errors;
	}
	public void setErrors(List<ErrorCounterItem> errors) {
		if(this.locked){
			throw new DataBeanLockException();
		}
		this.errors = errors;
	}
	public List<GenericMetricItem> getComponents() {
		return components;
	}
	public void setComponents(List<GenericMetricItem> components) {
		if(this.locked){
			throw new DataBeanLockException();
		}
		this.components = components;
	}
	public List<GenericMetricItem> getGeneral() {
		return general;
	}
	public void setGeneral(List<GenericMetricItem> general) {
		if(this.locked){
			throw new DataBeanLockException();
		}
		this.general = general;
	}
	public PerfMetricsData(int timeFrom, int timeTo, int interval,
			List<GenericMetricItem> actions, List<ApdexItem> apdex,
			List<ErrorCounterItem> errors, List<GenericMetricItem> components,
			List<GenericMetricItem> general) {
		super();
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
		this.interval = interval;
		this.actions = actions;
		this.apdex = apdex;
		this.errors = errors;
		this.components = components;
		this.general = general;
	}
	
	public PerfMetricsData() {
		super();
	}
	
	public void parse(JsonNode node, String version) {
		checkLock();
		this.interval = node.get("interval").asInt();
		this.timeFrom = node.get("timeFrom").asInt();
		this.timeTo   = node.get("timeTo").asInt();
		actions = new ArrayList<GenericMetricItem>();
		apdex = new ArrayList<ApdexItem>();
		errors = new ArrayList<ErrorCounterItem>();
		components = new ArrayList<GenericMetricItem>();
		general  = new ArrayList<GenericMetricItem>();
		//解析general
		Iterator<JsonNode> iterator = node.get("general").elements();
        while (iterator.hasNext()) {
           JsonNode sqlTraceNode = iterator.next();
           GenericMetricItem genericMetricItem = new GenericMetricItem();
           genericMetricItem.parse(sqlTraceNode, version);
           general.add(genericMetricItem);
        }
        //解析apdex
        iterator = node.get("apdex").elements();
        while (iterator.hasNext()) {
            JsonNode apdexNode = iterator.next();
            ApdexItem apdexItem = new ApdexItem();
            apdexItem.parse(apdexNode, version);
            apdex.add(apdexItem);
         }
      //解析components
        iterator = node.get("components").elements();
        while (iterator.hasNext()) {
            JsonNode componentsNode = iterator.next();
            GenericMetricItem componentItem = new GenericMetricItem();
            componentItem.parse(componentsNode, version);
            components.add(componentItem);
         }
        
        //解析actions
        iterator = node.get("actions").elements();
        while (iterator.hasNext()) {
            JsonNode actionsNode = iterator.next();
            GenericMetricItem actionItem = new GenericMetricItem();
            actionItem.parse(actionsNode, version);
            actions.add(actionItem);
         }
        
        //解析actions
        iterator = node.get("errors").elements();
        while (iterator.hasNext()) {
            JsonNode errorsNode = iterator.next();
            ErrorCounterItem errorItem = new ErrorCounterItem();
            errorItem.parse(errorsNode, version);
            errors.add(errorItem);
         }
        
	}
	
	
	
}
