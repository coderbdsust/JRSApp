package com.jrsapp.manager;

import com.jrsapp.handler.CashInHandler;
import com.jrsapp.handler.CashoutHandler;
import com.jrsapp.handler.FundTransferHandler;

public class TransactionManager {

	public String handle(final Integer serviceId) {
		TransactionHandler handler;
		if (serviceId == 1) {
			handler = new CashInHandler();
		} else if (serviceId == 2) {
			handler = new CashoutHandler();
		} else if (serviceId == 3) {
			handler = new FundTransferHandler();
		} else {
			return "Invalid service Id";
		}
		
		return handler.doTxn();

	}

}
