
[{
	"interval": 60,
	"timeTo": 1438247209,
	"timeFrom": 1438247149,
	"apdex": 
		[
			[	
				1268,
				[
					11,
					0,
					0,
					0.5
				]
			],
			[
				{
					"name": "Apdex"
				},
				[
					425,
					87,
					21,
					0.5
				]
			]
		],
	"components": 
			[
				[
					293,
					[
						2,
						2,
						0,
						1,
						1,
						3
					]
				]
			],
	"general": 
		[
			[
				556,
				[
					533,
					181307,
					115,
					4498,
					0,
					289913885
				]
			],
		
			[
				{
					"name": "ClassLoading\/NULL\/LoadedClassCount"
				},
				[
					1,
					28543,
					28543,
					28543,
					28543,
					814702848
				]
			]
		]
	"actions": 
		[
			[
				1229,
				[
					403,
					181277,
					0,
					4498,
					7,
					289913876
				]
			]
		]
	"errors":
		[
			[
				1307,
				[
					1,
					0,
					0,
					0,
					0,
					0
				]
			]
		]
	"type": "perfMetrics",
}]

{
	“type” : “perfMetrics”,
	“timeFrom” : BEGIN_TIME_IN_SECONDS,
	“timeTo” : END_TIME_IN_SECONDS,
	“interval” : DATA_SENT_INTERVAL_IN_SECONDS,
	“actions” : ACTION_METRIC_DATA_ARRAY,
	“apdex”: APDEX_DATA_ARRAY,
	“components” : COMPONENT_METRICS_DATA_ARRAY,
	“general” : GENERAL_METRICS_DATA_ARRAY,
	“errors” : ERROR_COUNTERS_ARRAY
}
timeFrom: 当前上传数据时间段的起始EPOCH时间戳（秒）
timeTo: 当前上传数据时间段的起始EPOCH时间戳（秒）
interval: 数据上传间隔(秒)。若Agent端上传故障，可能做合并处理，服务器端入库时应将该时间段内的数据平均分散存储（SUM及Count）。
actions: Web action或后台应用相关的性能数据。actions中仅包含正常访问的数据，错误数据（HTTP或服务器端异常的Action）不包含在actions中。
apdex: Web action Apdex数据
components: Web应用过程或后台应用break down性能数据
general: 其它性能数据，包括数据库、NoSQL、当前应用的CPU、内存、Deadlock线程、系统探针数据等。


