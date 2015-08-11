package com.tingyun.databean.sqltracedata;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tingyun.databean.DataBeanLock;

import junit.framework.TestCase;

public class SqlTraceDataTest extends TestCase {
	public static void main(String args[]) throws JsonProcessingException, IOException{
		
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode	node =  mapper.readTree(SqlTraceDataTest.class.getResourceAsStream("SqlTraceData.js"));	
		long time = System.currentTimeMillis();
		System.out.println();
		SqlTraceData data = new SqlTraceData();
					 data.parse(node, "1.2.2");
					 
					 DataBeanLock lock = 			 new SqlTraceData();
		System.out.println(System.currentTimeMillis()-time );			 
	}
}
