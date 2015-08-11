package com.tingyun.databean.errortracedata;

import java.io.IOException;

import junit.framework.TestCase;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ErrorTraceDataTest extends TestCase {
	public static void main(String args[]) throws JsonProcessingException, IOException{
		
		
		ObjectMapper mapper = new ObjectMapper();
		//JsonParseException: Illegal unquoted character ((CTRL-CHAR, code 9)): has to be escaped 的解决办法。
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
		JsonNode	node =  mapper.readTree(ErrorTraceDataTest.class.getResourceAsStream("errorTrace.js"));	
		long time = System.currentTimeMillis();
		ErrorTraceData data = new ErrorTraceData();
		data.parse(node, "1.2.2");
		System.out.println(data); 
	}
}
