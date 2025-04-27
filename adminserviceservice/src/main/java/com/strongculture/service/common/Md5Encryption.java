package com.strongculture.service.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密
 */
@Component
public class Md5Encryption {

    @Value("${encryption.md5.key}")
    private String key;

    /**
     * MD5加密
     * @param srcStr 待加密字符
     * @return 加密后字符
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public String encodeMd5(String srcStr) throws NoSuchAlgorithmException,UnsupportedEncodingException {
        // 确定计算方法
        MessageDigest md5=MessageDigest.getInstance("MD5");
        srcStr+=key; // 加盐
        md5.update(srcStr.getBytes());
        return new BigInteger(1, md5.digest()).toString(16);
    }
}
