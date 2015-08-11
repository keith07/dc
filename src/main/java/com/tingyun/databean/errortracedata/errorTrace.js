
[{
	"errors": 
			[
				[
					1438247226,
					"WebAction\/NormalizedUri\/408%2F*",
					503,
					"weblogic.utils.NestedRuntimeException",
					"Cannot parse POST parameters of request: '\/zjweb\/DiscoveryShow.do'",
					1,
					"\/zjweb\/DiscoveryShow.do",
					"{\"params\":{\"threadName\":\"[ACTIVE] ExecuteThread: '30' for queue: 'weblogic.kernel.Default (self-tuning)'\",\"httpStatus\":408},\"stacktrace\":[\"\\tweblogic.servlet.internal.ServletRequestImpl$RequestParameters.mergePostParams(ServletRequestImpl.java:2208)\",\"\\tweblogic.servlet.internal.ServletRequestImpl$RequestParameters.parseQueryParams(ServletRequestImpl.java:2088)\",\"\\tweblogic.servlet.internal.ServletRequestImpl$RequestParameters.peekParameter(ServletRequestImpl.java:2244)\",\"\\tweblogic.servlet.internal.ServletRequestImpl$RequestParameters.peekPostParameter(ServletRequestImpl.java:2227)\",\"\\tweblogic.servlet.internal.ServletRequestImpl$RequestParameters.access$2700(ServletRequestImpl.java:1871)\",\"\\tweblogic.servlet.internal.ServletRequestImpl$SessionHelper.getSessionIdFromPostData(ServletRequestImpl.java:2897)\",\"\\tweblogic.servlet.internal.ServletRequestImpl$SessionHelper.initSessionInfoWithContext(ServletRequestImpl.java:2826)\",\"\\tweblogic.servlet.internal.ServletRequestImpl$SessionHelper.initSessionInfo(ServletRequestImpl.java:2734)\",\"\\tweblogic.servlet.internal.ServletRequestImpl$SessionHelper.getSessionInternal(ServletRequestImpl.java:2477)\",\"\\tweblogic.servlet.internal.ServletRequestImpl$SessionHelper.getSession(ServletRequestImpl.java:2467)\",\"\\tweblogic.servlet.internal.ServletRequestImpl.getSession(ServletRequestImpl.java:1331)\",\"\\tweblogic.servlet.security.internal.SecurityModule$SessionRetrievalAction.run(SecurityModule.java:626)\",\"\\tweblogic.security.acl.internal.AuthenticatedSubject.doAs(AuthenticatedSubject.java:321)\",\"\\tweblogic.security.service.SecurityManager.runAs(SecurityManager.java:120)\",\"\\tweblogic.servlet.security.internal.SecurityModule.getUserSession(SecurityModule.java:512)\",\"\\tweblogic.servlet.security.internal.ServletSecurityManager.checkAccess(ServletSecurityManager.java:81)\",\"\\tweblogic.servlet.internal.WebAppServletContext.securedExecute(WebAppServletContext.java:2219)\",\"\\tweblogic.servlet.internal.WebAppServletContext.execute(WebAppServletContext.java:2182)\",\"\\tweblogic.servlet.internal.ServletRequestImpl.run(ServletRequestImpl.java:1491)\",\"\\tweblogic.work.ExecuteThread.execute(ExecuteThread.java:256)\",\"\\tweblogic.work.ExecuteThread.run(ExecuteThread.java:221)\",\" \",\" caused by java.net.SocketTimeoutException: Read timed out\",\"\\tjava.net.SocketInputStream.socketRead0(Native Method)\",\"\\tjava.net.SocketInputStream.read(SocketInputStream.java:129)\",\"\\tweblogic.servlet.internal.PostInputStream.read(PostInputStream.java:196)\",\"\\tweblogic.servlet.internal.ServletInputStreamImpl$1.read(ServletInputStreamImpl.java:163)\",\"\\tweblogic.servlet.internal.ServletInputStreamImpl.read(ServletInputStreamImpl.java:228)\",\"\\tweblogic.servlet.internal.ServletRequestImpl$RequestParameters.mergePostParams(ServletRequestImpl.java:2182)\",\"\\tweblogic.servlet.internal.ServletRequestImpl$RequestParameters.parseQueryParams(ServletRequestImpl.java:2088)\",\"\\tweblogic.servlet.internal.ServletRequestImpl$RequestParameters.peekParameter(ServletRequestImpl.java:2244)\",\"\\tweblogic.servlet.internal.ServletRequestImpl$RequestParameters.peekPostParameter(ServletRequestImpl.java:2227)\",\"\\tweblogic.servlet.internal.ServletRequestImpl$RequestParameters.access$2700(ServletRequestImpl.java:1871)\",\"\\tweblogic.servlet.internal.ServletRequestImpl$SessionHelper.getSessionIdFromPostData(ServletRequestImpl.java:2897)\",\"\\tweblogic.servlet.internal.ServletRequestImpl$SessionHelper.initSessionInfoWithContext(ServletRequestImpl.java:2826)\",\"\\tweblogic.servlet.internal.ServletRequestImpl$SessionHelper.initSessionInfo(ServletRequestImpl.java:2734)\",\"\\tweblogic.servlet.internal.ServletRequestImpl$SessionHelper.getSessionInternal(ServletRequestImpl.java:2477)\",\"\\tweblogic.servlet.internal.ServletRequestImpl$SessionHelper.getSession(ServletRequestImpl.java:2467)\",\"\\tweblogic.servlet.internal.ServletRequestImpl.getSession(ServletRequestImpl.java:1331)\",\"\\tweblogic.servlet.security.internal.SecurityModule$SessionRetrievalAction.run(SecurityModule.java:626)\",\"\\tweblogic.security.acl.internal.AuthenticatedSubject.doAs(AuthenticatedSubject.java:321)\",\"\\tweblogic.security.service.SecurityManager.runAs(SecurityManager.java:120)\",\"\\tweblogic.servlet.security.internal.SecurityModule.getUserSession(SecurityModule.java:512)\",\"\\tweblogic.servlet.security.internal.ServletSecurityManager.checkAccess(ServletSecurityManager.java:81)\",\"\\tweblogic.servlet.internal.WebAppServletContext.securedExecute(WebAppServletContext.java:2219)\",\"\\tweblogic.servlet.internal.WebAppServletContext.execute(WebAppServletContext.java:2182)\",\"\\tweblogic.servlet.internal.ServletRequestImpl.run(ServletRequestImpl.java:1491)\",\"\\tweblogic.work.ExecuteThread.execute(ExecuteThread.java:256)\",\"\\tweblogic.work.ExecuteThread.run(ExecuteThread.java:221)\"]}"
				]
			],
	"type": "errorTraceData"
}]

ERROR_ITEM :=
		[
			ERROR_TIME_IN_SECONDS,
			“ACTION_METRIC_NAME”,
			HTTP_STATUS,
			“EXCEPTION_CLASS_NAME”,
			“ERROR_MESSAGE”,
			COUNT_OF_ERRORS,
			“REQUEST_URI”,
			“ERROR_PARAMS”
]
ERROR_PARAMS :=
	{
		“params” : CUSTOM_PARAMS,
		“requestParams” : REQUEST_PARAMS,
		“stacktrace” : ERROR_STACK_TRACE
	}

CUSTOM_PARAMS :=
	{
		“threadName” : “THREAD_NAME”,
				“httpStatus” : HTTP_STATUS,
				“referer” : REQUEST_REFERER
	}
REQUEST_PARAMS :=
	{
		“REQUEST_PARAM_1” : “REQUEST_PARAM_VALUE_1”,
		“REQUEST_PARAM_2” : “REQUEST_PARAM_VALUE_2”,
		……
	}
ERROR_STACK_TRACE := 
	[
			“STACK_TRACE_ELEMENT_DESCRIPTION” *
	]


ERROR_PARAMS: 需要序列化成字符串后上传（非结构化数据直接以裸数据保存，以便服务器可选择parse-on-demand）
ERROR_STACK_TRACE: 错误的stacktrace（仅适用于服务器端Exception类错误，HTTP错误无stacktrace），

响应数据：
{
	“status” : “success” | “error”
}
服务器端处理成功返回success标识，否则返回error标识，无论成功或失败，Agent端均忽略响应内容。
