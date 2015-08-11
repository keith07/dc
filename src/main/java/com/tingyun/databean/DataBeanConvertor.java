package com.tingyun.databean;

import com.fasterxml.jackson.databind.JsonNode;

public interface DataBeanConvertor {
	public void parse(JsonNode node,String version);
	
}
