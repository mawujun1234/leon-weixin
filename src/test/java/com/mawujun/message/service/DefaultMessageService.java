package com.mawujun.message.service;

import com.mawujun.messge.service.DefaultRequestProcess;
import com.mawujun.messge.service.IRequestProcess;
import com.mawujun.messge.service.IResponseProcess;
import com.mawujun.messge.service.MessageService;

public class DefaultMessageService extends MessageService {

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
