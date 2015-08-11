package com.tingyun.databean.perfmetricsdata;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tingyun.databean.DataBeanLock;

import junit.framework.TestCase;

public class PerfMetricsDataTest extends TestCase {
	public static void main(String args[]) throws JsonProcessingException, IOException{
		
		
		ObjectMapper mapper = new ObjectMapper();
		long time = System.currentTimeMillis();
		JsonNode	node =  mapper.readTree(PerfMetricsDataTest.class.getResourceAsStream("perfMetrics.js"));	
		
		PerfMetricsData data = new PerfMetricsData();
		data.parse(node, "1.2.2");
		System.out.println(System.currentTimeMillis()-time);		 
	}
}
