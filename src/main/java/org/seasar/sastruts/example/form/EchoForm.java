package org.seasar.sastruts.example.form;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
//import org.seasar.struts.annotation.IntegerType;
//import org.seasar.struts.annotation.Maxlength;
import org.seasar.struts.annotation.Required;

public class EchoForm {

	@Required
	public String name;

	public ActionMessages validate() {
		ActionMessages errors = new ActionMessages();
		// 名前が「たけぞう」でない場合はエラーにする
		if(!name.equals("たけぞう")) {
			errors.add("name", new ActionMessage("名前がたけぞうではありません！", false));
		}
		return errors;
	}
}