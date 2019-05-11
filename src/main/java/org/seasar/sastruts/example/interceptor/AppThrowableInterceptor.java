package org.seasar.sastruts.example.interceptor;

import java.util.Collections;

import org.aopalliance.intercept.MethodInvocation;
import org.seasar.framework.aop.interceptors.ThrowsInterceptor;
import org.seasar.sastruts.example.dto.ErrorDto;
import org.seasar.sastruts.example.util.BusinessLogicException;
import org.seasar.struts.util.ResponseUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AppThrowableInterceptor extends ThrowsInterceptor {
	public void handleThrowable(BusinessLogicException e, MethodInvocation invocation) throws Throwable {
		System.out.println("業務エラー発生");

		ErrorDto errorDto = new ErrorDto("500", Collections.singletonList(e.getMessage()));
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(errorDto);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		ResponseUtil.write(json);

		throw e;
	}
}
