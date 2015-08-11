package com.tingyun.databean.sqltracedata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.tingyun.databean.DataBeanConvertor;
import com.tingyun.databean.DefaultDataBeanLockAdaptor;
import com.tingyun.databean.DataBeanLockException;

public class SqlTraceData extends DefaultDataBeanLockAdaptor implements DataBeanConvertor {
	
	@Override
	public void lock() {
		super.lock();
		for(SqlTraceItem sqTraceItem:sqlTraces){
			sqTraceItem.lock();
		}
	}
	
	private boolean  locked   = false;
	private String    version  = null;
	
	
	//Trace 数据信息
	private List<SqlTraceItem> sqlTraces;
	
	
	public List<SqlTraceItem> getSqlTraces() {
		return sqlTraces;
	}

	public void setSqlTraces(List<SqlTraceItem> sqlTraces) {
		if(this.locked){
			throw new DataBeanLockException();
		}
		this.sqlTraces = sqlTraces;
	}

	

	public void parse(JsonNode node, String version) {
		checkLock();
		sqlTraces = new ArrayList<SqlTraceItem>();
		Iterator<JsonNode> iterator = node.get("sqlTraces").elements();
        while (iterator.hasNext()) {
           JsonNode sqlTraceNode = iterator.next();
           SqlTraceItem sqlTrace = new SqlTraceItem();
           			sqlTrace.parse(sqlTraceNode, version);
        }
        this.setVersion(version);
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
