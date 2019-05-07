package com.imp4m.task;
import com.imp4m.entity.CataLog;
import com.imp4m.service.ICataLogService;
import com.imp4m.service.IFilmService;
import com.imp4m.util.mail.MailSenderInfo;
import com.imp4m.util.mail.SimpleMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 时间任务
 * @author 10589
 * @date 2016/7/21
 * @time 9:54
 */
@Component
public class TimeTask {

    @Resource
    private IFilmService filmService;

    @Resource
    private ICataLogService cataLogService;

/*
    @Scheduled(cron="0 30 18 L * ?")
    public void myTask(){
        *//*总影片数*//*
        sendalert();
    }*/

/*    private void sendalert() {
        *//*总影片数*//*
        int totalFilmCount = filmService.getCountAll();
        StringBuilder stringBuilder = new StringBuilder("其中");
        List<CataLog> list = cataLogService.listIsUse();
        for (int i = 0; i < list.size(); i++) {
            if(i!=(list.size()-1)){
                stringBuilder.append(list.get(i).getName()+filmService.getCountByCataLog(list.get(i).getId())+"部、");
            }else{
                stringBuilder.append(list.get(i).getName()+filmService.getCountByCataLog(list.get(i).getId())+"部");
            }
        }
        //这个类主要是设置邮件
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost("smtp.163.com");
        mailInfo.setMailServerPort("25");
        mailInfo.setValidate(true);
        mailInfo.setUserName("lovsvol@163.com");
        mailInfo.setPassword("lovsvol123");//您的邮箱密码
        mailInfo.setFromAddress("lovsvol@163.com");
        mailInfo.setToAddress("1058980664@qq.com");
        mailInfo.setSubject("温馨提醒");
        mailInfo.setContent("温馨提醒:本站总影片数量"+totalFilmCount+"部,"+stringBuilder.toString()+",上传影片地址：http://film.sityd.com/film.html");
        //这个类主要来发送邮件
        SimpleMailSender sms = new SimpleMailSender();
        *//* sms.sendTextMail(mailInfo);//发送文体格式*//*
        sms.sendHtmlMail(mailInfo);//发送html格式
    }*/
}
