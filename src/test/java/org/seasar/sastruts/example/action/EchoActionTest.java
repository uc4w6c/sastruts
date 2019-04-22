package org.seasar.sastruts.example.action;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.framework.aop.interceptors.MockInterceptor;
import org.seasar.framework.unit.Seasar2;
import org.seasar.sastruts.example.service.EchoUsersService;

//@RunWith(Seasar2.class)
public class EchoActionTest {

	@InjectMocks
	@Autowired
	private EchoAction echoAction;

	//private MockInterceptor echoUsersServiceMI;
	//private EchoUsersService echoUsersService;

	@Before
	public void setUp() {
		echoAction = new EchoAction();
	}

	@Test
	public void indexTest() {
		assertThat(echoAction.index(), is("input.jsp"));
	}

	@Test
	public void usersTest() {
		MockInterceptor mock = new MockInterceptor();
		List<String> users = new ArrayList<>();
		users.add("test1");
		users.add("test2");
		mock.setReturnValue("findUsers", users);
		EchoUsersService echoUsersService = (EchoUsersService) mock.createProxy(EchoUsersService.class);

		assertThat(echoAction.users(), is("users.jsp"));
		System.out.println(echoAction.users());
	}
}
