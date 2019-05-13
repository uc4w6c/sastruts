package org.seasar.sastruts.example.action;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expectLastCall;
//import static org.easymock.classextension.EasyMock.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.seasar.framework.aop.interceptors.MockInterceptor;
import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.mock.servlet.MockHttpServletResponse;
import org.seasar.framework.unit.Seasar2;
import org.seasar.framework.unit.annotation.EasyMock;
import org.seasar.framework.unit.annotation.EasyMockType;
import org.seasar.sastruts.example.dao.BalanceDao;
import org.seasar.sastruts.example.dao.TransferDao;
import org.seasar.sastruts.example.dto.TransferResultDto;
import org.seasar.sastruts.example.form.TransferForm;
import org.seasar.sastruts.example.service.EchoUsersService;
import org.seasar.sastruts.example.service.TransferService;
import org.seasar.struts.util.ResponseUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(Seasar2.class)
@PrepareForTest(TransferAction.class)
public class TransferActionTest {

	//@Binding
	//TransferAction transferAction;
	private TransferAction transferAction = new TransferAction();

	@EasyMock(value = EasyMockType.DEFAULT, register = true)
	TransferForm transferForm;

	@EasyMock(value = EasyMockType.DEFAULT, register = true)
	TransferService transferService;

	@Binding
	MockHttpServletResponse mockHttpServletResponse;

	//@EasyMock(value = EasyMockType.DEFAULT, register = true)
	//ObjectMapper mapper;

	public void record正常テスト() throws Exception {
		// TransferForm transferForm = new TransferForm();
		//TransferForm transferForm = createMock(TransferForm.class);

		expect(transferForm.getPayerAccountId()).andReturn("1");
		expect(transferForm.getPayeeAccountId()).andReturn("2");
		expect(transferForm.getPayerName()).andReturn("田中太郎");
		expect(transferForm.getTransferAmount()).andReturn((long) 1000);

		TransferResultDto expectTransferResult =
				new TransferResultDto("1", "2", "田中太郎", "佐藤花子", 1000, 19000);
		//TransferService transferService = createMock(TransferService.class);

		expect(transferService.transfer("1", "2", "田中太郎", 1000)).andReturn(expectTransferResult);

		String expectJson = "{\"payerAccountId\":\"1\","
				   + "\"payeeAccountId\":\"1\","
				   + "\"payerName\":\"田中太郎\","
				   + "\"payeeName\":\"佐藤花子\","
				   + "\"transferAmount\":1000,"
				   + "\"amount\":19000}";
		
		PowerMock.mockStaticPartial(ResponseUtil.class, "write");
		ResponseUtil.write(expectJson);
		expectLastCall();

		/*
		String expectJson = "{\"payerAccountId\":\"1\","
				   + "\"payeeAccountId\":\"1\","
				   + "\"payerName\":\"田中太郎\","
				   + "\"payeeName\":\"佐藤花子\","
				   + "\"transferAmount\":1000,"
				   + "\"amount\":19000}";
		ObjectMapper mapper = createMock(ObjectMapper.class);
		expect(mapper.writeValueAsString(expectTransferResult)).andReturn(expectJson);
		replay(mapper);
		ResponseUtil responseUtil = createMock(ResponseUtil.class);
		responseUtil.write(expectJson);
		expectLastCall();
		verify(mapper);
		verify(responseUtil);
		*/
	}

	@Test
	public void 正常テスト() {
		transferAction.transferForm = transferForm;
		transferAction.transferService = transferService;

		assertThat(transferAction.execute(), nullValue());
	}

	/*
	@Test
	public void 正常テスト() {
		transferAction.transferForm = transferForm;
		transferAction.transferService = transferService;
		assertThat(transferAction.execute(), nullValue());
	}
	*/

	/*
	@Test
	public void モックテスト() {
		TransferForm transferForm = createMock(TransferForm.class);
		expect(transferForm.getPayerAccountId()).andReturn("1");
		expect(transferForm.getPayeeAccountId()).andReturn("2");
		expect(transferForm.getPayerName()).andReturn("田中太郎");
		expect(transferForm.getTransferAmount()).andReturn((long) 1000);
		replay(transferForm);

		TransferResultDto expectTransferResult =
				new TransferResultDto("1", "2", "田中太郎", "佐藤花子", 1000, 19000);
		TransferService transferService = createMock(TransferService.class);

		expect(transferService.transfer("1", "2", "田中太郎", 1000)).andReturn(expectTransferResult);
		replay(transferService);

		transferAction.transferForm = transferForm;
		transferAction.transferService = transferService;

		assertThat(transferAction.execute(), nullValue());
		verify(transferForm);
		verify(transferService);
	}
	*/
}
