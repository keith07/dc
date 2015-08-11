package com.tingyun.databean.actiontracedata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.tingyun.databean.DataBeanConvertor;
import com.tingyun.databean.DefaultDataBeanLockAdaptor;


public class ActionTraceData extends DefaultDataBeanLockAdaptor implements DataBeanConvertor{
	private List<ActionTraceItem> actionTraces;
	
	private String    version  = null;
	
	private boolean  locked   = false;
	
	@Override
	public void lock() {
		super.lock();
		for(ActionTraceItem ati: actionTraces){
			ati.lock();
		}
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public ActionTraceData() {

	}

	public ActionTraceData(List<ActionTraceItem> actionTraces) {
		this.actionTraces = actionTraces;
	}

	

	/**
	 * @return the actionTraces
	 */
	public List<ActionTraceItem> getActionTraces() {
		return actionTraces;
	}

	/**
	 * @param actionTraces the actionTraces to set
	 */
	public void setActionTraces(List<ActionTraceItem> actionTraces) {
		this.actionTraces = actionTraces;
	}

	public void parse(JsonNode node, String version) {
		checkLock();
		actionTraces = new ArrayList<ActionTraceItem>();
		Iterator<JsonNode> iterator = node.get("actionTraces").elements();
        while (iterator.hasNext()) {
           JsonNode actionTraceNode = iterator.next();
           ActionTraceItem actionTrace = new ActionTraceItem();
           actionTrace.parse(actionTraceNode, version);
           actionTraces.add(actionTrace);
        }
        this.setVersion(version);
	}

}
