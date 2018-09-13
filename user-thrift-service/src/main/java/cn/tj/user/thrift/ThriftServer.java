package cn.tj.user.thrift;

import cn.tj.thrift.user.UserService;
import org.apache.thrift.TProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class ThriftServer {

    @Autowired
    private UserService.Iface userService;

    @PostConstruct
    public void startThriftServer() {
        TProcessor processor = new UserService.Processor<>(userService);

    }
}
