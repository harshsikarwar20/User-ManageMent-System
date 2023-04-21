package com.example.userManagementApplication.Controller;
import com.example.userManagementApplication.Model.User;
import com.example.userManagementApplication.Service.userservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userManagement/manage-app")

public class usercontroller {
    private final userservice newUserServe;

    public usercontroller(userservice newUserServe){
        this.newUserServe = newUserServe;
    }

    //url : localhost:8080/api/userManagement/manage-app/add-user
    @PostMapping("/add-user")
    public void addUser(@RequestBody User newManage){
        newUserServe.addUser(newManage);
    }

    //url : http://localhost:8080/api/userManagement/manage-app/get-User/id/{id}
    @GetMapping("/get-User/id/{id}")
    public User getUserById(@PathVariable int id){
        return newUserServe.getUserById(id);
    }

    //url : http://localhost:8080/api/userManagement/manage-app/get-allUser
    @GetMapping("/get-allUser")
    public List<User> getAllUser(){
        return newUserServe.getAllUser();
    }

    //url : localhost:8080/api/userManagement/manage-app/update-User/id/2
    @PutMapping("update-User/id/{id}")
    public void updateUserInfo(@PathVariable int id, @RequestBody User newUpdate){
        newUserServe.updateUserInfo(id,newUpdate);
    }

    //url : localhost:8080/api/userManagement/manage-app/delete-User/id/3
    @DeleteMapping("delete-User/id/{id}")
    public void deleteUser(@PathVariable int id){
        newUserServe.deleteUser(id);
    }
}