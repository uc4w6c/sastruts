package org.seasar.sastruts.example.action;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.framework.aop.interceptors.MockInterceptor;
import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.unit.Seasar2;
import org.seasar.framework.unit.annotation.EasyMock;
import org.seasar.framework.unit.annotation.EasyMockType;
import org.seasar.sastruts.example.dao.BalanceDao;
import org.seasar.sastruts.example.dao.TransferDao;
import org.seasar.sastruts.example.form.TransferForm;
import org.seasar.sastruts.example.service.EchoUsersService;
import org.seasar.sastruts.example.service.TransferService;

@RunWith(Seasar2.class)
public class TransferActionTest {

	@Binding
	TransferAction transferAction;

	@EasyMock(value = EasyMockType.DEFAULT, register = true)
	TransferForm transferForm;

	@EasyMock(value = EasyMockType.DEFAULT, register = true)
	TransferService transferService;




}
