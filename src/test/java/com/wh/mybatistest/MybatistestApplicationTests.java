package com.wh.mybatistest;

import com.wh.mybatistest.pojo.User;
import com.wh.mybatistest.services.IUserService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.jws.soap.SOAPBinding;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class MybatistestApplicationTests {
    @Autowired
    private IUserService userService;
    @Test
    void queryUser() {
        List<User> users = userService.findUserByMobile("456");
        System.out.println(users);
    }

    @SneakyThrows
    @Test
    void createUser(){
        String parseDate = "1997-11-5 11:22:33";
        SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date birth = simpleDateFormat.parse(parseDate);
        User user = User.builder().id(13L).mobile("456").password("123").sex("男").birthdate(birth).address("成都市锦江区").email("1146694782@qq.com").state("1").createTime(new Date()).updateTime(new Date()).build();
        userService.create(user);
        queryUser();
    }

    @Test
    void updateUser(){
        User user=User.builder().address("重庆").updateTime(new Date()).password("12312").id(13L).build();
        userService.updateUser(user);
        queryUser();
    }
    @Test
    void deleteUser(){
        User user = new User();
        user.setId(13L);
        System.out.println(userService.deleteUser(13L));
        queryUser();
    }
}
