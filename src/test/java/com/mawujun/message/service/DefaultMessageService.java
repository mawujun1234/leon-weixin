package com.mawujun.message.service;

import com.mawujun.messge.service.DefaultRequestProcess;
import com.mawujun.messge.service.IRequestProcess;
import com.mawujun.messge.service.IResponseProcess;
import com.mawujun.messge.service.AbstractMessageService;

public class DefaultMessageService extends AbstractMessageService {

	@Override
	public IRequestProcess getRequestProcess() {
		// TODO Auto-generated method stub
		return new DefaultRequestProcess();
	}

	@Override
	public IResponseProcess getResponseProcess() {
		// TODO Auto-generated method stub
		return new DefaultResponseProcess();
	}
	

}
