package com.tingyun.databean.actiontracedata;

import java.io.IOException;

import junit.framework.TestCase;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ActionTraceDataTest extends TestCase {
	public static void main(String args[]) throws JsonProcessingException, IOException{
		
		
		ObjectMapper mapper = new ObjectMapper();
		//JsonParseException: Illegal unquoted character ((CTRL-CHAR, code 9)): has to be escaped 的解决办法。(是因为包含了tab空格等控制字符，可以设置)
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
		JsonNode	node =  mapper.readTree(ActionTraceDataTest.class.getResourceAsStream("actionTrace.js"));	
		long time = System.currentTimeMillis();
		ActionTraceData data = new ActionTraceData();
		data.parse(node, "1.2.2");
		System.out.println(data); 
	}
}
