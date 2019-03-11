package org.seasar.sastruts.example.form;

import org.seasar.sastruts.example.validator.RequiredArray;

public class ProductForm {

	@RequiredArray
	public String[] products;
}
