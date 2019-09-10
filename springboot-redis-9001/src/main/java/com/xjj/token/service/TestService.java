package com.xjj.token.service;

import com.xjj.token.common.ServerResponse;
import com.xjj.token.pojo.Mail;

public interface TestService {

    ServerResponse testIdempotence();

    ServerResponse accessLimit();

    ServerResponse send(Mail mail);
}
