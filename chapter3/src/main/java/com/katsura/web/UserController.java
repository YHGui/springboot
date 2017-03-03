package com.katsura.web;

import com.katsura.domain.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by Katsura on 2017/2/18.
 */

@RestController
@RequestMapping("/users")
public class UserController {

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @ApiOperation(value = "get the list of users", notes = "")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList(){
        List<User> r = new ArrayList<User>(users.values());

        return r;
    }

    //@ModelAttribute注解在方法上时，优先于@RequestMapping方法执行，最常见的使用场景：
    // 一个表单中有下拉框，下拉框的数据从后台读取的情况，使用这个注解，就不需要在每个@RequestMapping方法中编写查询下拉框数据的代码。这种场景还可以用@SessionAttributes
    //@ModelAttribute注解在方法参数上，表示该参数可以从以下途径获得值：
    // 1、如果在该方法所属的类上有@SessionAttributes注解，则该参数从session中取值；
    // 2、从model中获得值，如果model没有，则spring会自动初始化并把该参数加入到model；
    // 3、遍历所有的请求参数，如果请求参数名与参数的属性匹配，则将请求参数的值放入参数对象；
    // 4、从URI的restful变量中取值，比如：/owners/{ownerId}/pets/{petId}/edit，pet对象就会取：ownerId和petId的值，并填入pet对象中
    @ApiOperation(value = "create users", notes = "create users according to User")
    @ApiImplicitParam(name = "user", value = "user")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user){
        users.put(user.getId(), user);
        return "success";
    }

    @ApiOperation(value = "get information about user", notes = "get information with id")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        return users.get(id);
    }

    @ApiOperation(value = "update users", notes = "select the user with id, update the information with ModelAttribute user")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "information about user", required = true, dataType = "User")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user){
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    @ApiOperation(value = "delete users", notes = "delete users with id")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id){
        users.remove(id);
        return "success";
    }
}
