package com.thd;

import com.thd.dao.UserMapper;
import com.thd.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;
import java.time.LocalDateTime;

@SpringBootTest
@RunWith(SpringRunner.class)
public class InsertTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void insert(){
        User build = User.builder().name("Kakalote")
                .age(25)
                .email("test5@baomidou.com")
                .createTime(LocalDateTime.now())
                .build();
        int insert = userMapper.insert(build);
        System.out.println(insert);
    }
}
