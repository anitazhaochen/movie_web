package com.imp4m.controller;


import com.alibaba.fastjson.JSONObject;
import com.imp4m.entity.User;
import com.imp4m.entity.VipCode;
import com.imp4m.service.IUserService;
import com.imp4m.service.IVipCodeService;
import com.imp4m.util.MD5Auth;
import com.imp4m.util.Tools;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 管理处理
 *
 * @author 10589
 * @date 2016/10/6
 * @time 23:23
 */
@Controller
public class Authentication {


    private final static String key = "sw23klkj3nm23";
    public final static String USER_KEY = "u_skl";

    @Resource
    private IUserService userService;

    @Resource
    private IVipCodeService vipCodeService;


    /**
     * 目录
     */
    @RequestMapping(value = "/registerInput.html")
    public String registerInput(ModelMap map) {
        return "authentication/register_input";
    }



    @RequestMapping(value = "/register.html")
    @ResponseBody
    public String register(User user, HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        /**根据输入的用户名（账号）查询该账户是否存在*/
        User userCondition = new User();
        userCondition.setUserEmail(user.getUserEmail());
        List<User> users = userService.findByCondition(userCondition);
        if(users==null || users.isEmpty()){
            userCondition = new User();
            userCondition.setUserName(user.getUserName());
            users = userService.findByCondition(userCondition);
            if(users==null || users.isEmpty()){
                user.setCreateDate(new Date());
                user.setExpireDate(new Date());
                user.setUserPasswd(MD5Auth.MD5Encode(user.getUserPasswd()+key, "UTF-8").toUpperCase());
                User u = userService.add(user);
                if(null!=u){
                    jsonObject.put("code","1");
                    jsonObject.put("data",u);
                    session.setAttribute(USER_KEY,u);
                }else{
                    jsonObject.put("code","0");
                    jsonObject.put("error","注册失败！请稍后重试");
                }
            }else{
                jsonObject.put("code","0");
                jsonObject.put("error","该用户名已存在！");
            }
        }else{
            jsonObject.put("code","0");
            jsonObject.put("error","该邮箱已经注册！");
        }
        return jsonObject.toString();
    }


    /**
     * 时间
     * @param account_l
     * @param password_l
     * @param session
     * @return
     */
    @RequestMapping(value = "/login.html")
    @ResponseBody
    public String login(String account_l,String password_l,HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        User user = new User();
        List<User> userList =null;
        if(Tools.notEmpty(account_l)){
            user.setUserName(account_l);
            userList = userService.findByCondition(user);
        }
        if(userList!=null && !userList.isEmpty()){
            loginAuthentication(password_l, session, jsonObject, userList);
        }else{
            user.setUserEmail(account_l);
            userList = userService.findByCondition(user);
            if(userList!=null && !userList.isEmpty()){
                loginAuthentication(password_l, session, jsonObject, userList);
            }else {
                jsonObject.put("code","0");
                jsonObject.put("error","登录失败，用户不存在！");
            }
        }
        return jsonObject.toString();
    }

    /**
     * 校验密码是否正确
     * @param password_l
     * @param session
     * @param jsonObject
     * @param userList
     */
    private void loginAuthentication(String password_l, HttpSession session, JSONObject jsonObject, List<User> userList) {
        User userDb = userList.get(0);
        if(MD5Auth.validatePassword(userDb.getUserPasswd(), password_l + key, "UTF-8")) {
            jsonObject.put("code","1");

            /**进行VIP身份过期校验*/
            if(userDb.getExpireDate().getTime()<=new Date().getTime()){
                /**当前过期时间与当前的时间小，则表示已经过期*/
                userDb.setIsVip(0);
                userService.update(userDb);
            }

            /**登录成功，写入当前登录信息到seesion中*/
            session.setAttribute(USER_KEY,userDb);
        }else {
            jsonObject.put("code","0");
            jsonObject.put("error","用户或密码错误！");
        }
    }


    @RequestMapping(value = "/logout.html")
    @ResponseBody
    public String logout(HttpSession session) {
        JSONObject jsonObject = new JSONObject();
        session.removeAttribute(USER_KEY);
        jsonObject.put("code","1");
        return jsonObject.toString();
    }


    @RequestMapping(value = "/vipCodeVerification.html")
    @ResponseBody
    public String vipCodeVerification(String vip_code,HttpSession session) {
        JSONObject jsonObject = new JSONObject();

        VipCode vipCode = vipCodeService.findByVipCode(vip_code);
        if(vipCode!=null){
            /**
             1.获取当前登录用户
             */
            User u_skl = (User) session.getAttribute(USER_KEY);
            User user = userService.load(u_skl.getId());
            if(user!=null){
                /**获取该用户的到期时间*/
                Date expireTime = user.getExpireDate();
                Date expireTimeTemp = expireTime;
                long isVip = user.getIsVip();
                /**判断是否比当前时间大*/
                Calendar rightNow = Calendar.getInstance();
                if(expireTime.getTime()>new Date().getTime()){
                    rightNow.setTime(expireTime);
                    rightNow.add(Calendar.MONTH,1);
                    expireTime = rightNow.getTime();
                }else{
                    rightNow.add(Calendar.MONTH,1);
                    expireTime = rightNow.getTime();
                }
                user.setExpireDate(expireTime);
                user.setIsVip(1);
                if(userService.update(user)){
                    session.setAttribute(USER_KEY,user);

                    /**修改vipCode为不能使用，增加过期时间*/
                    vipCode.setExpire_time(new Date());
                    vipCode.setIs_use("0");
                    if(vipCodeService.update(vipCode)){
                        jsonObject.put("code","1");
                    }else{
                        user.setExpireDate(expireTimeTemp);
                        user.setIsVip(isVip);
                        userService.update(user);
                    }
                }else{
                    jsonObject.put("code","0");
                    jsonObject.put("error","加油失败！请稍后重试");
                }
            }else{
                jsonObject.put("code","0");
                jsonObject.put("error","用户信息错误！");
            }
        }else{
            jsonObject.put("code","0");
            jsonObject.put("error","秘钥不存在！");
        }
        return jsonObject.toString();
    }



}
