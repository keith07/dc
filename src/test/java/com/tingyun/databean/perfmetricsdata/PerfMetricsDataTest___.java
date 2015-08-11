package com.tingyun.databean.perfmetricsdata;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tingyun.databean.generalmetric.GenericMetricItem;
import com.tingyun.databean.generalmetric.MetricKey;

public class PerfMetricsDataTest___ extends TestCase {
	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws JsonProcessingException, IOException{
		
		ObjectMapper mapper = new ObjectMapper();
		long time = System.currentTimeMillis();
		Map<String,Object> userData = mapper.readValue(new File("E://perfMetrics.js"), Map.class);
		
		PerfMetricsData pd = parsePerfMetrics(userData);
		System.out.println(System.currentTimeMillis()-time);	
	}
	
	private static PerfMetricsData parsePerfMetrics(Map<String, Object> map) {
		if(map == null)
			return null;
		
		Integer timeFrom = (Integer)map.get("timeFrom");
		Integer timeTo = (Integer)map.get("timeTo");
		Integer interval = (Integer)map.get("interval");
		List<?> actionsMetrics = (List<?>)map.get("actions");
		List<?> apdex = (List<?>)map.get("apdex");
		List<?> componentsMetrics = (List<?>)map.get("components");
		List<?> generalMetrics = (List<?>)map.get("general");
		List<?> errors = (List<?>)map.get("errors");
		
		PerfMetricsData perfMetrics = new PerfMetricsData(
						timeFrom.intValue(), timeTo.intValue(), interval.intValue(),
						parsePerfMetricItems(actionsMetrics),
						parseApdexItems(apdex),
						parseErrorCountItems(errors),
						parsePerfMetricItems(componentsMetrics),
						parsePerfMetricItems(generalMetrics)
						
					);
		
		return perfMetrics;
	}
	
	private static List<GenericMetricItem> parsePerfMetricItems(List<?> mapItems){
		if(mapItems == null || mapItems.size() == 0)
			return null;
		
		List<GenericMetricItem> items = new ArrayList<GenericMetricItem>(mapItems.size());
		for(Object _mapItem : mapItems) {
			List<?> mapItem = (List<?>)_mapItem;
			if(mapItem != null && mapItem.size() == 2) {
				Object _metricKey = (Object)mapItem.get(0);
				MetricKey metricKey;
				if(_metricKey instanceof Number) {
					metricKey = new MetricKey(2, 0, null, null);
				} else if(_metricKey instanceof Map) {
					Map metricKeyMap = (Map)_metricKey;
					String metricName = (String)metricKeyMap.get("name");
					int metricParentId = 0;
					String metricParentName = null;					
					Object metricParent = metricKeyMap.get("parent");
					if(metricParent != null) {
						if(metricParent instanceof Number) {
							metricParentId = 1;
						} else {
							metricParentName = (String)metricParent;
						}
					}
					metricKey = new MetricKey(0, metricParentId, metricName, metricParentName);
				} else {
					metricKey = null;
				}
				
				if(metricKey != null) {
					if((mapItem.get(1) instanceof List) && ((List<?>)mapItem.get(1)).size() == 6) {
						List<?> metricValues = (List<?>)mapItem.get(1);
						Object count = metricValues.get(0);
						Object sum = metricValues.get(1);
						Object sumEx = metricValues.get(2);
						Object max = metricValues.get(3);
						Object min = metricValues.get(4);
						Object squareSum = metricValues.get(5);
						
						boolean isDataValid = true;
						
						
						if(isDataValid) {
							GenericMetricItem item = new GenericMetricItem(
										metricKey,
										2,
										2,
										2,
										2,
										2,
										2
									);
							items.add(item);
						}
					} else {
					}					
				}
			} else {
			}
		}
		
		return items;
	}
	
	private static List<ApdexItem> parseApdexItems(List<?> mapItems){
		if(mapItems == null || mapItems.size() == 0)
			return null;
		
		List<ApdexItem> items = new ArrayList<ApdexItem>(mapItems.size());
		for(Object _mapItem : mapItems) {
			List<?> mapItem = (List<?>)_mapItem;
			if(mapItem != null && mapItem.size() == 2) {
				Object _metricKey = (Object)mapItem.get(0);
				MetricKey metricKey;
				if(_metricKey instanceof Number) {
					metricKey = new MetricKey(9, 0, null, null);
				} else if(_metricKey instanceof Map) {
					Map metricKeyMap = (Map)_metricKey;
					String metricName = (String)metricKeyMap.get("name");
					int metricParentId = 0;
					String metricParentName = null;					
					Object metricParent = metricKeyMap.get("parent");
					if(metricParent != null) {
						if(metricParent instanceof Number) {
							metricParentId =3;
						} else {
							metricParentName = (String)metricParent;
						}
					}
					metricKey = new MetricKey(0, metricParentId, metricName, metricParentName);
				} else {
					metricKey = null;
				}
				
				if(metricKey != null) {
					if((mapItem.get(1) instanceof List) && ((List<?>)mapItem.get(1)).size() == 4) {
						List<?> metricValues = (List<?>)mapItem.get(1);
						Object countSatisfied = metricValues.get(0);
						Object countTolerating = metricValues.get(1);
						Object countFrustrated = metricValues.get(2);
						Object apdexT = metricValues.get(3);
						
						ApdexItem item = new ApdexItem(
									metricKey,
									2,
									2,
									2,
									2
								);
						items.add(item);
					} else {
					}					
				}
			} else {
			}
		}
		
		return items;
	}
	
	private static List<ErrorCounterItem> parseErrorCountItems(List<?> mapItems){
		if(mapItems == null || mapItems.size() == 0)
			return null;
		
		List<ErrorCounterItem> items = new ArrayList<ErrorCounterItem>(mapItems.size());
		for(Object _mapItem : mapItems) {
			List<?> mapItem = (List<?>)_mapItem;
			if(mapItem != null && mapItem.size() == 2) {
				Object _metricKey = (Object)mapItem.get(0);
				MetricKey metricKey;
				if(_metricKey instanceof Number) {
					metricKey = new MetricKey(1, 0, null, null);
				} else if(_metricKey instanceof Map) {
					Map metricKeyMap = (Map)_metricKey;
					String metricName = (String)metricKeyMap.get("name");
					int metricParentId = 0;
					String metricParentName = null;					
					Object metricParent = metricKeyMap.get("parent");
					if(metricParent != null) {
						if(metricParent instanceof Number) {
							metricParentId = 2;
						} else {
							metricParentName = (String)metricParent;
						}
					}
					metricKey = new MetricKey(0, metricParentId, metricName, metricParentName);
				} else {
					metricKey = null;
				}
				
				if(metricKey != null) {
					if((mapItem.get(1) instanceof List) && ((List<?>)mapItem.get(1)).size() > 0) {
						List<?> metricValues = (List<?>)mapItem.get(1);
						Object countError = metricValues.get(0);
						
						ErrorCounterItem item = new ErrorCounterItem(
									metricKey,
									3
								);
						items.add(item);
					} else {
					}					
				}
			} else {
			}
		}
		
		return items;
	}
}
