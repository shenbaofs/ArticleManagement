package com.objectfrontier.training.article.model;

import com.objectfrontier.training.article.model.AppErrorCode;

public class AppException
extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AppException(AppErrorCode code) {
		super(code.getMessage());
	}

	public AppException(Throwable cause) {
		super(cause);
	}
}
 