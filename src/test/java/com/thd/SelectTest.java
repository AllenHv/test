package com.thd;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.thd.dao.UserMapper;
import com.thd.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.*;

/**
 * Wrappers工具类
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SelectTest {
    @Resource
    private UserMapper userMapper;

    /**
     * 查询所有
     */
    @Test
    public void select() {
        List<User> list = userMapper.selectList(null);
        Assert.assertEquals(8, list.size());
        list.forEach(System.out::println);
    }

    /**
     * 根据id查询
     */
    @Test
    public void selectById() {
        User user = userMapper.selectById(1203951123950489601L);
        System.out.println(user);
    }

    /**
     * 根据多个id查询
     */
    @Test
    public void selectIds() {
        List<Long> lists = Arrays.asList(1203951123950489601L, 1203952663415259138L, 1203953478754381826L);
        List<User> users = userMapper.selectBatchIds(lists);
        users.forEach(System.out::println);
    }

    /**
     * 根据列数据查询数据
     */
    @Test
    public void selectByMap() {
        HashMap<String, Object> columnMap = new HashMap<>();
        columnMap.put("name", "Allen");
        columnMap.put("age", 26);
        List<User> users = userMapper.selectByMap(columnMap);
        users.forEach(System.out::println);
    }

    /**
     * 名字里包含"A",且年龄小于20的
     */
    @Test
    public void selectByWrapper1() {
        QueryWrapper<User> query = Wrappers.<User>query();
        query.like("name", "A")
                .lt("age", 20);
        List<User> userList = userMapper.selectList(query);
        userList.forEach(System.out::println);
    }

    /**
     * 名字里包含"A",且年龄大于等于20小于等于25,且email不为空
     */
    @Test
    public void selectByWrapper2() {
        QueryWrapper<User> query = Wrappers.<User>query();
        query.like("name", "A")
                .between("age", 20, 25)
                .isNotNull("email");
        List<User> userList = userMapper.selectList(query);
        userList.forEach(System.out::println);
    }

    /**
     * 名字以"A"开头,或者年龄大于等于20,按照年龄降序排序,年龄相同按照id升序排序
     */
    @Test
    public void selectByWrapper3() {
        QueryWrapper<User> query = Wrappers.query();
        query.likeRight("name", "A")
                .or()
                .gt("age", 20)
                .orderByDesc("age")
                .orderByAsc("id");
        List<User> userList = userMapper.selectList(query);
        userList.forEach(System.out::println);
    }

    /**
     * 名字以"A"开头,并且(年龄小于40或邮箱不为空)
     */
    @Test
    public void selectByWrapper4() {
        QueryWrapper<User> query = Wrappers.query();
        query.likeRight("name", "A")
                .and(qw -> qw.lt("age", 40)
                        .or()
                        .isNotNull("email"));
        List<User> userList = userMapper.selectList(query);
        userList.forEach(System.out::println);
    }

    /**
     * 名字以"A"开头,或者(年龄小于40且年龄大于20并且邮箱不为空)
     */
    @Test
    public void selectByWrapper5() {
        QueryWrapper<User> query = Wrappers.query();
        query.likeRight("name", "A")
                .or().and(qw -> qw.lt("age", 40)
                .gt("age", 20)
                .isNotNull("email"));
        List<User> userList = userMapper.selectList(query);
        userList.forEach(System.out::println);
    }

    /**
     * (年龄小于40或邮箱不为空),并且名字以"A"开头.
     */
    @Test
    public void selectByWrapper6() {
        QueryWrapper<User> query = Wrappers.query();
        query.nested(qw -> qw.lt("age", 40)
                .or()
                .isNotNull("email"))
                .likeRight("name", "A");
        List<User> userList = userMapper.selectList(query);
        userList.forEach(System.out::println);
    }

    /**
     * 查询年龄为23,24,25,26的.
     */
    @Test
    public void selectByWrapper7() {
        QueryWrapper<User> query = Wrappers.query();
        query.in("age", Arrays.asList(23, 24, 25, 26));
        List<User> userList = userMapper.selectList(query);
        userList.forEach(System.out::println);
    }

    /**
     * 查询年龄为23,24,25,26的.结果只打印一条数据
     */
    @Test
    public void selectByWrapper8() {
        QueryWrapper<User> query = Wrappers.query();
        query.in("age", Arrays.asList(23, 24, 25, 26)).last("limit 1");
        List<User> userList = userMapper.selectList(query);
        userList.forEach(System.out::println);
    }

    /**
     * 名字里包含"A",且年龄小于20的,出现问题的代码.
     */
    @Test
    public void selectByWrapperSuper1() {
        QueryWrapper<User> query = Wrappers.query();
        query.select("id", "name").like("name", "A")
                .lt("age", 40);
        List<User> userList = userMapper.selectList(query);
        System.out.println("集合长度为:" + userList.size());
        userList.forEach(System.out::println);
    }

    /**
     * 尝试.xml方式,仍报错.
     */
    @Test
    public void test() {
        String name = "A";
        List<User> users = userMapper.selectTest(name);
        if (CollectionUtils.isNotEmpty(users)) {
            for (User user : users) {
                System.err.println(user);
            }
        }
    }


}
