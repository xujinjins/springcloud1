package com.xjj.token.service.impl;

import com.xjj.token.common.Constant;
import com.xjj.token.common.ResponseCode;
import com.xjj.token.common.ServerResponse;
import com.xjj.token.exception.ServiceException;
import com.xjj.token.service.TokenService;
import com.xjj.token.util.JedisUtil;
import com.xjj.token.util.RandomUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.text.StrBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class TokenServiceImpl implements TokenService {

    private static final String TOKEN_NAME = "token";

    @Autowired
    private JedisUtil jedisUtil;

    @Override
    public ServerResponse createToken() {
        String str = RandomUtil.UUID32();
        StrBuilder token = new StrBuilder();
        token.append(Constant.Redis.TOKEN_PREFIX).append(str);

        //token一分钟过期
        jedisUtil.set(token.toString(), token.toString(), Constant.Redis.EXPIRE_TIME_MINUTE);

        return ServerResponse.success(token.toString());
    }

    @Override
    public void checkToken(HttpServletRequest request) {
        String token = request.getHeader(TOKEN_NAME);
        // 请求中不存在token，抛出异常
        if (StringUtils.isBlank(token)) {
            token = request.getParameter(TOKEN_NAME);
            if (StringUtils.isBlank(token)) {// parameter中也不存在token
                throw new ServiceException(ResponseCode.ILLEGAL_ARGUMENT.getMsg());
            }
        }

        //如果有token但是redis中不存在此token，说明为重复操作
        if (!jedisUtil.exists(token)) {
            throw new ServiceException(ResponseCode.REPETITIVE_OPERATION.getMsg());
        }
        //有token，则删除redis中的token
        Long del = jedisUtil.del(token);

        //如果<=0，说明删除失败，可能在执行过程中，被别的操作给删了(或许是过期了)。
        if (del <= 0) {
            throw new ServiceException(ResponseCode.REPETITIVE_OPERATION.getMsg());
        }
    }

}
