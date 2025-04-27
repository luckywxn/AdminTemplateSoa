package com.strongculture.service.service.common;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

public interface MessageService {

    /**
     * 发送短信
     * @param templateCode 短信模板
     * @param phoneNumber 手机号
     * @param params 模板参数
     * @return result
     */
    String sendSms(@PathVariable(value = "templateCode") String templateCode,
                                      @PathVariable(value = "phoneNumber") String phoneNumber,
                                      @RequestBody Map<String, String> params);

    /**
     * 发送邮件
     * @param to 收件人邮箱
     * @param subject 主题
     * @param content 内容
     * @return result
     */
    void sendMail(@PathVariable("to") String to,
                          @PathVariable("subject") String subject,
                          @RequestBody String content);

    /**
     * 保存redis
     * @param key
     * @param value
     * @param seconds
     * @return
     */
    void setKeyValue(@RequestParam(value = "key",required = true) String key,
                                  @RequestParam(value = "value",required = true) String value,
                                  @RequestParam(value = "seconds",required = true) Integer seconds);

    /**
     * 去redis获取纸
     * @param key
     * @return
     */
    String getValue(@RequestParam(value = "key",required = true) String key);
}
