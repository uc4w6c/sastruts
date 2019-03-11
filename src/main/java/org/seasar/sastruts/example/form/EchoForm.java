package org.seasar.sastruts.example.form;

import org.seasar.struts.annotation.IntegerType;
import org.seasar.struts.annotation.Maxlength;
import org.seasar.struts.annotation.Required;

public class EchoForm {

	@Required
	@Maxlength(maxlength=20)
	public String name;

	@Required
	@IntegerType
	public String age;
}
