package com.mindtree.shoppingcart.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6198867792764313918L;

	public RecordNotFoundException(String exception) {
		super(exception);
	}
}