package org.seasar.sastruts.example.form;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.framework.util.StringUtil;

public class BalanceForm {

	private String name;

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public ActionMessages validate() {
		ActionMessages errors = new ActionMessages();
		if (StringUtil.isEmpty(name)) {
			errors.add("name", new ActionMessage("名前空です", false));
		}
		return errors;
	}
}
