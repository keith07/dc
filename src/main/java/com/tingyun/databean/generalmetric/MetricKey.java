package com.tingyun.databean.generalmetric;

public class MetricKey {
	private int id;
	private int parentId;
	private String name;
	private String parent;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public MetricKey(int id, int parentId, String name, String parent) {
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.parent = parent;
	}
	public MetricKey() {
	}
	
}
