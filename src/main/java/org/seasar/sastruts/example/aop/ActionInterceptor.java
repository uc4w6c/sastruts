package org.seasar.sastruts.example.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;
import org.seasar.struts.annotation.Execute;

public class ActionInterceptor extends AbstractInterceptor {
	// 変数
	Logger logger = Logger.getLogger(getClass());

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("LogAspect~start!~");
		String actionName = getActionName(invocation);
		boolean isExecuteMethod = invocation.getMethod().isAnnotationPresent(Execute.class);

		if (isExecuteMethod) {
			logger.info(actionName + "を開始します。"); 
		}

		Object object = invocation.proceed();

		if (isExecuteMethod) {
			logger.info(actionName + "を終了します。");
		}
		return object;
	}

	private String getActionName(MethodInvocation invocation) {
		 
		String className;
		String methodName;
		String actionName;
	
		// アクション名取得
		className = getTargetClass(invocation).getSimpleName();
		methodName = invocation.getMethod().getName();
		actionName = className + "#" + methodName;
	
		// アクション名返却
		return actionName;
	}
}
