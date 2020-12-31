package com.jrsapp.handler;

import com.jrsapp.manager.TransactionHandler;

public class CommonHandler extends TransactionHandler {

	public CommonHandler() {
		System.out.println("CommonHandler init");
	}

	public void handle() {
		System.out.println("commonHandler:handle");
		String res = doTxn();
	}

	public String doTxn() {
		super.doTxn();
		return "CommonHandler:doTxn";
	}
}
