package com.xjj.token.mq.consumer;

import com.rabbitmq.client.Channel;
import com.xjj.token.mq.BaseConsumer;
import com.xjj.token.mq.MessageHelper;
import com.xjj.token.pojo.LoginLog;
import com.xjj.token.service.LoginLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LoginLogConsumer implements BaseConsumer {

    @Autowired
    private LoginLogService loginLogService;

    @Override
    public void consume(Message message, Channel channel) {
        log.info("收到消息: {}", message.toString());
        LoginLog loginLog = MessageHelper.msgToObj(message, LoginLog.class);
        loginLogService.insert(loginLog);
    }
}
