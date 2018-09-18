package cn.tj.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(@RequestParam("username")String username,
                      @RequestParam("password")String password){
        //1.验证用户名密码
        //2.生成token
        //3.缓存用户
    }

}
