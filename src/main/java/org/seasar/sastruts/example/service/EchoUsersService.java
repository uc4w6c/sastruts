package org.seasar.sastruts.example.service;

import java.util.ArrayList;
import java.util.List;

public class EchoUsersService {

	public List<String> findUsers() {
		List<String> users = new ArrayList<>();
		users.add("田中 太郎");
		users.add("鈴木 操");
		users.add("佐藤 珠江");
		users.add("櫻田 一郎");
		return users;
	}

}
