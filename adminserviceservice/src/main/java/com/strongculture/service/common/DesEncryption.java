package com.strongculture.service.common;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * DES加解密
 */
@Component
public class DesEncryption {

    @Value("${encryption.des.key}")
    private String key;

    /**
     * 将key转换成16进制字符串
     * @return
     */
    private byte[] hex(){
        String f=DigestUtils.md5Hex(key);
        byte[] bkeys=new String(f).getBytes();
        byte[] enk=new byte[24];
        for(int i=0;i<24;i++){
            enk[i]=bkeys[i];
        }
        return enk;
    }

    /**
     * 3DES加密
     * @param srcStr 原始字符
     * @return 加密字符
     */
    public String encode3Des(String srcStr){
        byte[] keybyte = hex();
        byte[] src = srcStr.getBytes();
        try {
            //生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, "DESede");
            //加密
            Cipher c1 = Cipher.getInstance("DESede");
            c1.init(Cipher.ENCRYPT_MODE, deskey);

            String pwd = Base64.encodeBase64String(c1.doFinal(src));
//           return c1.doFinal(src);//在单一方面的加密或解密
            return pwd;
        } catch (java.security.NoSuchAlgorithmException e1) {
            // TODO: handle exception
            e1.printStackTrace();
        }catch(javax.crypto.NoSuchPaddingException e2){
            e2.printStackTrace();
        }catch(Exception e3){
            e3.printStackTrace();
        }
        return null;
    }

    /**
     * 3DES解密
     * @param desStr 加密字符
     * @return 解密后字符
     */
    public String decode3Des(String desStr){
        Base64 base64 = new Base64();
        byte[] keybyte = hex();
        byte[] src = base64.decode(desStr);

        try {
            //生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, "DESede");
            //解密
            Cipher c1 = Cipher.getInstance("DESede");
            c1.init(Cipher.DECRYPT_MODE, deskey);
            String pwd = new String(c1.doFinal(src));
//            return c1.doFinal(src);
            return pwd;
        } catch (java.security.NoSuchAlgorithmException e1) {
            // TODO: handle exception
            e1.printStackTrace();
        }catch(javax.crypto.NoSuchPaddingException e2){
            e2.printStackTrace();
        }catch(Exception e3){
            e3.printStackTrace();
        }
        return null;
    }
}
