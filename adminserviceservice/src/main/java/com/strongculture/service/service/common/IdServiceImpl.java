package com.strongculture.service.service.common;

import com.strongculture.service.common.DesEncryption;
import com.strongculture.service.common.IdWorker;
import com.strongculture.service.common.Md5Encryption;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import java.text.SimpleDateFormat;
import java.util.Random;

@Slf4j
@Service
public class IdServiceImpl implements IdService{

    @Autowired
    private DesEncryption desEncryption;
    @Autowired
    private Md5Encryption md5Encryption;

    @Override
    public String createdUUID() {
        String uuid=java.util.UUID.randomUUID().toString();
        return uuid.replace("-","");
    }

    @Override
    public String createdNumber() {
        String number="";

        // 优先用雪花算法生成
        Integer workId=1;
        IdWorker idWorker=new IdWorker(workId);
        try{
            number = String.valueOf(idWorker.nextId());
        }catch (Exception e){
            log.error(e.getMessage());

            // 发生异常则生成时间种子
            long now = System.currentTimeMillis();
            //获取4位年份数字
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
            //获取时间戳
            String time = dateFormat.format(now);
            String info = now + "";
            int ran=(int)(Math.random()*900)+100;
            number = time+info.substring(2,info.length())+ran;
        }

        return number + getRandom();
    }

    @Override
    public String createdValidCode() {
        int randomNum=(int)((Math.random()*9+1)*100000);
        return Integer.toString(randomNum);
    }

    @Override
    public String encodeMd5(String srcStr) {
        try{
            return md5Encryption.encodeMd5(srcStr);
        }catch (Exception err){
            err.printStackTrace();
        }
        return "";
    }

    @Override
    public String encodeDes(String srcStr) {
        String pass=desEncryption.encode3Des(srcStr);
        pass= Base64Utils.encodeToUrlSafeString(pass.getBytes());
        return pass;
    }

    @Override
    public String decodeDes(String passStr) {
        String pass=new String(Base64Utils.decodeFromUrlSafeString(passStr));
        return desEncryption.decode3Des(pass);
    }

    /**
     * 获取5位随机数
     * @return
     */
    private String getRandom(){
        String number="";
        Random random=new Random();
        int rd=random.nextInt(99999);
        number=String.valueOf(rd);
        if(number.length()<5){
            for(int i=0;i<(5-number.length());i++){
                number="0"+number;
            }
        }
        return number;
    }
}
