package com.wang;

import com.wang.business.model.User;
import com.wang.business.service.IUserService;
import com.wang.feature.page.PageableTools;
import com.wang.feature.search.BaseSearch;
import com.wang.feature.search.SearchDto;
import com.wang.feature.search.SearchTools;
import com.wang.feature.sort.SortDto;
import com.wang.feature.sort.SortTools;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by wangyongwei on 2017/8/21.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
public class UserTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testAdd() {
        User user = new User();
        user.setEmail("393156105@qq.com");
        user.setNickName("知识林");
        user.setPassword("123456");
        user.setUserName("zslin");

        userService.save(user);
    }

    @Test
    public void testFindAll() {
        List<User> list = userService.findAll();
        for (User u : list) {
            System.out.println("nickName: " + u.getNickName()+", email: " + u.getEmail());
        }
    }

    @Test
    public void testFindById() {
        User u = userService.findById(3);
        System.out.println("nickName : " + u.getNickName() + ", email : " + u.getEmail());
    }

    @Test
    public void testSort() {
        List<User> list = userService.findAll(SortTools.basicSort());
        for (User  u: list ) {
            System.out.println("nickName: " + u.getNickName()+", email: " + u.getEmail());
        }
    }

    @Test
    public void testSort2() {
        List<User> list = userService.findAll(SortTools.basicSort(new SortDto("desc", "userName"), new SortDto("id")));
        for (User u : list) {
            System.out.println("nickName: " + u.getNickName()+", email: " + u.getEmail());
        }
    }

    private void print(Page<User> datas) {
        System.out.println("总条数："+datas.getTotalElements());
        System.out.println("总页数："+datas.getTotalPages());
        for(User u : datas) {
            System.out.println(u.getId()+"===="+u.getUserName());
        }
    }

    @Test
    public void test2() {
        Page<User> datas = userService.findAll(PageableTools.basicPage(0));
        print(datas);
    }

    @Test
    public void testSearch() {
        List<User> list = userService.findAll(SearchTools.buildSpecification(
                SearchTools.buildSpeDto("and", new SearchDto("and", "id", "gt", 2)),
                SearchTools.buildSpeDto("and", new SearchDto("userName", "ne", "user5"),
                        new SearchDto("or", "userName", "ne", "user9"))
        ));
        printList(list);
    }

    private void printList(List<User> list) {
        for(User u : list) {
            System.out.println(u.getId()+"==="+u.getUserName());
        }
    }

    @Test
    public void test1() {
        List<User> list = userService.findAll(new BaseSearch<User>(new SearchDto("userName","eq", "user1")));
        printList(list);
    }
}
