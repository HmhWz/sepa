package com.hmh.controller;

import com.hmh.entity.User;
import com.hmh.service.MailService;
import com.hmh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/users")
public class UserController extends BaseController{
    @Resource(name = "userServiceImpl")
    private UserService userService;
    @Resource(name = "mailServiceImpl")
    private MailService mailService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<List<User>> getUserList(
            @RequestParam(value = "offset", defaultValue = "0") long offset,
            @RequestParam(value = "limit", defaultValue = MAX_LONG_AS_STRING) long limit)
    {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("offset", offset);
        param.put("limit", limit);
        List<User> userList = userService.query(param);
        if (userList.size() == 0)
        {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<User> getUserById(@PathVariable int id)
    {

        User user = userService.findById(id);
        if (user == null)
        {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(userService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
    public ResponseEntity<User> deleteUser(@PathVariable int id)
    {
        User user = userService.findById(id);
        if (user == null)
        {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        userService.deleteUser(id);
        mailService.sendEmail(user);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    // @RequestMapping(method = RequestMethod.DELETE)
    // public ResponseEntity<User> deleteUsers() {
    // //Deleting All Users
    // userService.deleteUsers();
    // return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    // }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json; charset=utf-8")
    public ResponseEntity<User> saveUser(@RequestBody User user, UriComponentsBuilder ucb)
    {

        // if (userService.isUserExist(user)) {
        // System.out.println("A User with name " + user.getName() +
        // " already exist");
        // return new ResponseEntity<User>(user, HttpStatus.CONFLICT);
        // }
        User saved = userService.saveUser(user);

        HttpHeaders headers = new HttpHeaders();
        URI locationUri = ucb.path("/users/").path(String.valueOf(saved.getId())).build().toUri();
        headers.setLocation(locationUri);

        ResponseEntity<User> responseEntity = new ResponseEntity<User>(saved, headers,
                HttpStatus.CREATED);
        return responseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json; charset=utf-8")
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user)
    {
        User currentUser = userService.findById(id);

        if (currentUser == null)
        {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        currentUser.setId(id);
        currentUser.setName(user.getName());
        currentUser.setAddress(user.getAddress());

        userService.updateUser(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }
}

