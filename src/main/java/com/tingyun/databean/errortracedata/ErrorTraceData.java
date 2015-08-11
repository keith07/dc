package com.tingyun.databean.errortracedata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.tingyun.databean.DataBeanConvertor;
import com.tingyun.databean.DataBeanLockException;
import com.tingyun.databean.DefaultDataBeanLockAdaptor;
import com.tingyun.databean.sqltracedata.SqlTraceItem;

public class ErrorTraceData extends DefaultDataBeanLockAdaptor implements DataBeanConvertor {
	private List<ErrorItem> errors;
	private String    version  = null;
	private boolean  locked   = false;
	@Override
	public void lock() {
		super.lock();
		for(ErrorItem error:errors){
			error.lock();
		}
	}
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<ErrorItem> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorItem> errors) {
		if(this.locked){
			throw new DataBeanLockException();
		}
		this.errors = errors;
	}

	public ErrorTraceData(List<ErrorItem> errors) {
		super();
		this.errors = errors;
	}

	public ErrorTraceData() {
		super();
	}

	public void parse(JsonNode node, String version) {
		checkLock();
		errors = new ArrayList<ErrorItem>();
		Iterator<JsonNode> iterator = node.get("errors").elements();
        while (iterator.hasNext()) {
           JsonNode sqlTraceNode = iterator.next();
           ErrorItem errorTrace = new ErrorItem();
           errorTrace.parse(sqlTraceNode, version);
   		   errors.add(errorTrace);
        }
        this.setVersion(version);
	}
}
