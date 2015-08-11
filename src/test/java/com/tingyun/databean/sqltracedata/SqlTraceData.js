{
	"sqlTraces":
	[
		[
		 1438185558,
		"WebAction\/Servlet\/DBServlet",
		"Database\/test_slowsql\/SELECT",
		"\/TestAppdynamics\/testDb",
		"select * from test_slowsql where id>100 and id <500000",
		3,
		16764,
		5698,
		5458,
		"{\"explainPlan\":{\"keys\":[\"id\",\"select_type\",\"table\",\"type\",\"possible_keys\",\"key\",\"key_len\",\"ref\",\"rows\",\"Extra\"],\"values\":[[\"1\",\"SIMPLE\",\"test_slowsql\",\"range\",\"PRIMARY\",\"PRIMARY\",\"4\",\"\",\"389224\",\"Using where\"]]},\"stacktrace\":[\"com.mysql.jdbc.PreparedStatement.executeQuery(PreparedStatement.java:2303)\",\"com.tingyun.testad.dao.DataDaoImpl.getDataList(DataDaoImpl.java:41)\",\"com.tingyun.testad.service.impl.DataServiceImpl.getDataList(DataServiceImpl.java:27)\",\"com.tingyun.testad.servlet.DBServlet.doGet(DBServlet.java:39)\",\"javax.servlet.http.HttpServlet.service(HttpServlet.java:707)\",\"javax.servlet.http.HttpServlet.service(HttpServlet.java:820)\",\"weblogic.servlet.internal.StubSecurityHelper$ServletServiceAction.run(StubSecurityHelper.java:227)\",\"weblogic.servlet.internal.StubSecurityHelper.invokeServlet(StubSecurityHelper.java:125)\",\"weblogic.servlet.internal.ServletStubImpl.execute(ServletStubImpl.java:301)\",\"weblogic.servlet.internal.ServletStubImpl.execute(ServletStubImpl.java:184)\",\"weblogic.servlet.internal.WebAppServletContext$ServletInvocationAction.wrapRun(WebAppServletContext.java:3732)\",\"weblogic.servlet.internal.WebAppServletContext$ServletInvocationAction.run(WebAppServletContext.java:3696)\",\"weblogic.security.acl.internal.AuthenticatedSubject.doAs(AuthenticatedSubject.java:321)\",\"weblogic.security.service.SecurityManager.runAs(SecurityManager.java:120)\",\"weblogic.servlet.internal.WebAppServletContext.securedExecute(WebAppServletContext.java:2273)\",\"weblogic.servlet.internal.WebAppServletContext.execute(WebAppServletContext.java:2179)\",\"weblogic.servlet.internal.ServletRequestImpl.run(ServletRequestImpl.java:1490)\",\"weblogic.work.ExecuteThread.execute(ExecuteThread.java:256)\",\"weblogic.work.ExecuteThread.run(ExecuteThread.java:221)\"]}"]
	],
	"type": "sqlTraceData"
}