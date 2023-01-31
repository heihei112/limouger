package com.run.shopping.service.service.sms;

import com.aliyuncs.exceptions.ClientException;

public interface SmsService {

    void send(String mobile) throws ClientException;
}