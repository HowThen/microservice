package cn.tj.user.controller;

import cn.tj.thrift.user.UserInfo;
import cn.tj.user.thrift.ServiceProvider;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private ServiceProvider serviceProvider;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(@RequestParam("username")String username,
                      @RequestParam("password")String password){
        //1.验证用户名密码
        try {
            UserInfo userInfo = serviceProvider.getUserService().getUserByName(username);
        } catch (TException e) {
            e.printStackTrace();
        }



        //2.生成token
        //3.缓存用户
    }

}
