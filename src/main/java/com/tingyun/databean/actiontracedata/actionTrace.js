
[
	{
		"actionTraces": 
		[
			[	
				1438247312,
				2152,
				"WebAction\/Servlet\/Proxy",
				"\/zjweb\/LoginCMWAP.do",
				"[
					1438247312,
					{},
					{\"httpStatus\":200,\"threadName\":\"[ACTIVE] ExecuteThread: '38' for queue: 'weblogic.kernel.Default (self-tuning)'\"},
					[
						这里没分清，应该是九项
						0,
						2152,
						\"ROOT\",null,1,\"weblogic.servlet.internal.WebAppServletContext\",\"execute\",{\"stacktrace\":[\"weblogic.servlet.internal.WebAppServletContext.execute(WebAppServletContext.java:2200)\",\"weblogic.servlet.internal.ServletRequestImpl.run(ServletRequestImpl.java:1491)\",\"weblogic.work.ExecuteThread.execute(ExecuteThread.java:256)\",\"weblogic.work.ExecuteThread.run(ExecuteThread.java:221)\"]},[[0,2152,\"RequestDispatcher\\\/NULL\\\/RequestDispatcher\\\/weblogic.servlet.internal.WebAppServletContext\\\/execute\",null,1,\"weblogic.servlet.internal.WebAppServletContext\",\"execute\",{\"stacktrace\":[\"weblogic.servlet.internal.WebAppServletContext.execute(WebAppServletContext.java:2200)\",\"weblogic.servlet.internal.ServletRequestImpl.run(ServletRequestImpl.java:1491)\",\"weblogic.work.ExecuteThread.execute(ExecuteThread.java:256)\",\"weblogic.work.ExecuteThread.run(ExecuteThread.java:221)\"]},[[0,2152,\"Servlet\\\/com.zjmobile.Servlet.ProxyServlet\\\/service\",\"\",
						1,
						\"javax.servlet.http.HttpServlet\",\"service\",{\"partialtrace\":[\"javax.servlet.http.HttpServlet.service(HttpServlet.java:821)\",\"weblogic.servlet.internal.StubSecurityHelper$ServletServiceAction.run(StubSecurityHelper.java:227)\",\"weblogic.servlet.internal.StubSecurityHelper.invokeServlet(StubSecurityHelper.java:125)\",\"weblogic.servlet.internal.ServletStubImpl.execute(ServletStubImpl.java:301)\",\"weblogic.servlet.internal.ServletStubImpl.execute(ServletStubImpl.java:184)\",\"weblogic.servlet.internal.WebAppServletContext$ServletInvocationAction.wrapRun(WebAppServletContext.java:3750)\",\"weblogic.servlet.internal.WebAppServletContext$ServletInvocationAction.run(WebAppServletContext.java:3714)\",\"weblogic.security.acl.internal.AuthenticatedSubject.doAs(AuthenticatedSubject.java:321)\",\"weblogic.security.service.SecurityManager.runAs(SecurityManager.java:120)\",\"weblogic.servlet.internal.WebAppServletContext.securedExecute(WebAppServletContext.java:2283)\"]},[[2,2151,\"External\\\/http:%2F%2Fapp-mapp.yw.zj.chinamobile.com%2Fzjapp%2FLoginCMWAP.do\\\/HttpClient\\\/execute\",\"http:\\\/\\\/app-mapp.yw.zj.chinamobile.com\\\/zjapp\\\/LoginCMWAP.do\",1,\"org.apache.http.impl.client.CloseableHttpClient\",\"execute\",{\"partialtrace\":[\"org.apache.http.impl.client.CloseableHttpClient.execute(CloseableHttpClient.java:106)\",\"com.zjmobile.Servlet.ProxyServlet.proxy(ProxyServlet.java:75)\",\"com.zjmobile.Servlet.ProxyServlet.doPost(ProxyServlet.java:152)\",\"javax.servlet.http.HttpServlet.service(HttpServlet.java:727)\"]},[]]]]]]]
					]
				]"
			]
		],
		"type": "actionTraceData"
	}
]

ACTION_TRACE_ITEM :=
		[
			ACTION_TRACE_TIME_IN_SECONDS,
			ACTION_DURATION,
			“ACTION_ ROOT_METRIC_NAME”,
			“REQUEST_URI”,
			“ACTION_TRACE_DATA”,
			“TRANSACTION_ID”,
			“TRACE_GUID”
]
	
ACTION_TRACE_TIME_IN_SECONDS : Trace时间。EPOCH时间戳（单位：秒）
ACTION_DURATION : 当前Action的持续时间（单位：毫秒）
ACTION_ ROOT_METRIC_NAME : Action名称
REQUEST_URI : Action请求URI
ACTION_TRACE_DATA :=
	[
		ACTION_TRACE_TIME_IN_SECONDS,
		REQUEST_PARAMS,
		CUSTOM_PARAMS,
		ROOT_ACTION_TRACE_SEGMENT
]
	注：ACTION_TRACE_DATA：需要序列化成字符串后上传（非结构化数据直接以裸数据保存，以便服务器可选择parse-on-demand）
	TRANSACTION_ID: Action trace的transactionId，参见4.6 跨应用追踪之X-Tingyun-Tx-Id。当发起跨应用追踪时，由跨应用追踪的发起方生成txId，并传输至后端，后端的应用若产生Action trace，则直接复用前端传过来的txId。若发起方未启用跨应用追踪，则该字段置空。
	TRACE_GUID: Action trace的GUID，由探针生成，若被调用方未触发Action trace，则不返回该字段，或置空。
REQUEST_PARAMS :=
	{
		“REQUEST_PARAM_1” : “REQUEST_PARAM_VALUE_1”,
		“REQUEST_PARAM_2” : “REQUEST_PARAM_VALUE_2”,
		……
}
CUSTOM_PARAMS :=
{
	“threadName” : “THREAD_NAME”,
	“httpStatus” : HTTP_STATUS,
	“referer” : REQUEST_REFERER
}

ROOT_ACTION_TRACE_SEGMENT 	:=
	ACTION_TRACE_SEGMENT		:=
		[
			ENTRY_TIME_FROM_ACTION_START,
			EXIT_TIME_FROM_ACTION_START,
			SEGMENT_METRIC_NAME,
			SEGMENT_CALL_URL,
			SEGMENT_CALL_COUNT,
			SEGMENT_CLASS_NAME,
			SEGMENT_METHOD_NAME,
			SEGMENT_PARAMS,
			CHILDREN_TRACE_SEGMENTS
		]

	ENTRY_TIME_FROM_ACTION_START : Tracer方法进入的时间 – Action开始时间。单位：毫秒。
	EXIT_TIME_FROM_ACTION_START : Tracer方法执行完毕时间 – Action开始时间。单位：毫秒。
	SEGMENT_METRIC_NAME : Segment指标名称
	SEGMENT_CALL_URL: Segment URL。通常为空，对于外部HTTP调用或跨应用时，需记录调用的URI。
	SEGMENT_CALL_COUNT : 调用次数
	SEGMENT_CLASS_NAME : 类名（包含包名）
	SEGMENT_METHOD_NAME : 方法名
	SEGMENT_PARAMS :=
						{
							“sql” : SQL_IF_ANY,
							“explainPlan” : EXPLAIN_PLAN_RESULT_IF_ANY ?,
							“stacktrace” : STACK_TRACE_IF_ANY ?,
							“partialtrace” : PARTIAL_TRACE_IF_ANY ?,
							“txId”: “TRANSACTION_ID_IF_ANY” ? ,
							“txData”: CALLE_TRANSACTION_DATA_IF_ANY ? ,
							……
						}
响应数据：
{
	“status” : “success” | “error”
}
服务器端处理成功返回success标识，否则返回error标识，无论成功或失败，Agent端均忽略响应内容。
