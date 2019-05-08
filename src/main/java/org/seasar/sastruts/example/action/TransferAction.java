package org.seasar.sastruts.example.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.sastruts.example.dto.ErrorDto;
import org.seasar.sastruts.example.dto.TransferResultDto;
import org.seasar.sastruts.example.entity.Balance;
import org.seasar.sastruts.example.form.BalanceForm;
import org.seasar.sastruts.example.form.ExampleForm;
import org.seasar.sastruts.example.form.TransferForm;
import org.seasar.sastruts.example.service.BalanceService;
import org.seasar.sastruts.example.service.TransferService;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ResponseUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TransferAction {

	@Resource
	@ActionForm
	protected TransferForm transferForm;

	@Binding
	TransferService transferService;

	// TODO: http://d.hatena.ne.jp/suusuke/20090223/1235358321を参考にし対応すること
	//		 共通メソッドで対応したい。継承はしたくないかな
	// @Execute(validate="validate", validator=true, input = "ErrorJsonAction.backToIndex") これは失敗
	@Execute(validate="validate", validator=true, input = "returnErrorJson")
	public String execute() {
		TransferResultDto transferResultDto = 
						transferService.transfer(transferForm.getPayerAccountId(),
												 transferForm.getPayeeAccountId(),
												 transferForm.getPayerName(),
												 transferForm.getTransferAmount());

		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(transferResultDto);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		ResponseUtil.write(json);
		return null;
	}

	@Execute(validator = false)
	public static String returnErrorJson() {
		return ErrorJsonAction.returnErrorJson();
	}
}
