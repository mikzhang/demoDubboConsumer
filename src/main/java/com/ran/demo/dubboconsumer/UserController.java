package com.ran.demo.dubboconsumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ran.demo.dubboproducer.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Reference  //将生产者注册到Dubbo映射到该对象上, 这里完成了服务之间的调用
    private UserService userService;

    @RequestMapping("/getUserById")
    public Object getUserById (int id){
        return userService.getUserById(id);
    }
}
