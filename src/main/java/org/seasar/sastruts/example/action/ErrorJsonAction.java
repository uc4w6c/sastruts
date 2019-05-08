package org.seasar.sastruts.example.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.sastruts.example.dto.ErrorDto;
import org.seasar.sastruts.example.entity.Balance;
import org.seasar.sastruts.example.form.BalanceForm;
import org.seasar.sastruts.example.form.ExampleForm;
import org.seasar.sastruts.example.form.TransferForm;
import org.seasar.sastruts.example.service.BalanceService;
import org.seasar.sastruts.example.service.TransferService;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.MessageResourcesUtil;
import org.seasar.struts.util.RequestUtil;
import org.seasar.struts.util.ResponseUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ErrorJsonAction {

	@Execute(validator = false)
	public static String returnErrorJson() {
		
		HttpServletRequest request = RequestUtil.getRequest();
		ActionMessages messages = (ActionMessages)request.getAttribute(Globals.ERROR_KEY);
		if(messages==null) return null;

		List<String> messageList = new ArrayList<String>();
		for(Iterator<?> iter = messages.get(); iter.hasNext();){
			ActionMessage msg = (ActionMessage)iter.next();
			if (msg.getKey() == null) {
				messageList.add(MessageResourcesUtil.getMessage(msg.getKey(), msg.getValues()));
			} else {
				messageList.add(msg.getKey());
			}
		}

		ErrorDto errorDto = new ErrorDto("500", messageList);
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(errorDto);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		ResponseUtil.write(json);
		return null;
	}
}
