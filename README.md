# user-management-system
##### :green_square: Its a Web Application
## :hash: Frameworks and Languages Used -
    1. SpringBoot
    2. JAVA
    3. Postman
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
## :hash: Dataflow (Functions Used In)
### :green_square: 1. Model - I have used one model which is User.java
#### :large_orange_diamond: User.java
```java
package com.example.userManagementApplication.Model;

public class User {
    private int id;
    private String name;
    private String username;
    private String address;
    private String phoneNum;

    public User(int id, String name, String username, String address, String phoneNum){
        this.id = id;
        this.name = name;
        this.username = username;
        this.address = address;
        this.phoneNum = phoneNum;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String toString(){
        return "manage{" +
                "id=" + id +
                ",name='" + name + '\'' +
                ",username='" + username + '\'' +
                ",address='" + address + '\'' +
                ",phoneNumber='" + phoneNum +
                "}";
    }
}
```
##### To See Model
:heavy_check_mark: [Model](https://github.com/harshsikarwar20/user-management-system/tree/master/src/main/java/com/example/userManagementApplication/Model)
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
### :green_square: 2. Service - I have used one service which is userservice.java
#### :large_orange_diamond: userservice.java
```java
package com.example.userManagementApplication.Service;
import com.example.userManagementApplication.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
@Service
public class userservice {
    private static List<User> user = new ArrayList<>();

    private static int manageCount = 0;

    static {
        user.add(new User(++manageCount,"Harsh","harsh@1234","Gwalior,India","7999018195"));
        user.add(new User(++manageCount,"ravi","ravi@365","Gwalior,India","3478901245"));
        user.add(new User(++manageCount,"arun","arun@pandit13","Gwalior,India","9999334210"));
        user.add(new User(++manageCount,"kk","kk@444","Gwalior,India","5689347612"));
        user.add(new User(++manageCount,"anurag","anurag@90","Gwalior,India","7056234100"));
        user.add(new User(++manageCount,"Nikhil","nikhil@45","Gwalior,India","6671235902"));
    }

    public List<User> getAllUser() {
        return user;
    }

    public void addUser(User addOne){
        user.add(addOne);
    }

    public User getUserById(int id){
        Predicate<? super User> predicate = todo -> todo.getId() == id;
        User manageId = user.stream().filter(predicate).findFirst().get();
        return manageId;
    }

    public void deleteUser(int id){
        Predicate<? super User> predicate = todo -> todo.getId() == id;
        user.removeIf(predicate);
    }

    public void updateUserInfo(int id, User newUser){

        User manageNew = getUserById(id);
        manageNew.setId(newUser.getId());
        manageNew.setName(newUser.getName());
        manageNew.setUsername(newUser.getUsername());
        manageNew.setAddress(newUser.getAddress());
        manageNew.setPhoneNum(newUser.getPhoneNum());
    }
}
```
#### To See Service
:heavy_check_mark: [Service](https://github.com/harshsikarwar20/user-management-system/tree/master/src/main/java/com/example/userManagementApplication/Service)
-----------------------------------------------------------------------------------------------------------------------------------------------------------

### :green_square: 3. Controller - I have used one controller which is usercontroller.java
#### :large_orange_diamond: usercontroller.java
```java
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
```
#### To See Controller
:heavy_check_mark: [Controller](https://github.com/harshsikarwar20/user-management-system/tree/master/src/main/java/com/example/userManagementApplication/Controller)
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
## :hash: DataStructures Used in Project
    1. ARRAYLIST
    2. List
-------------------------------------------------------------------------------------------------------------------------------------------------------
## :hash: Project Summary
### :large_orange_diamond: Project result 

### :green_square: Get All Users By Browser - http://localhost:8080/api/userManagement/manage-app/get-allUser
#### :small_blue_diamond: Image after hitting the GetMapping on Brower.
![A1](https://user-images.githubusercontent.com/123385605/233766602-07ed2948-343e-4c2b-a1cd-1cd0ce561eee.png)

### :green_square: Added User By Postman - localhost:8080/api/userManagement/manage-app/update-User/id/2

#### :small_blue_diamond: Image after hitting the PostMapping on Postman.
![A2](https://user-images.githubusercontent.com/123385605/233767065-2ca41c21-ff26-4c31-86e3-4d7bd943d969.png)

#### :small_blue_diamond: Image after hitting the GetMapping on Brower, we can see one post.
![A2](https://user-images.githubusercontent.com/123385605/233767468-dcc114b0-781e-4caa-98b7-1c6e846d1be6.png)

### :green_square: Update User By Postman - localhost:8080/api/userManagement/manage-app/update-User/id/{id}

#### :small_blue_diamond: Image after hitting the PutMapping on Postman.
![A3](https://user-images.githubusercontent.com/123385605/233767296-de22a494-6377-4f91-8de1-0f17c9cdb20b.png)
#### :small_blue_diamond: Image after hitting the GetMapping on Brower, we can see one updation at id : 2.
![A4](https://user-images.githubusercontent.com/123385605/233767524-4900fb05-657a-449d-acdc-032bdb16b968.png)

### :green_square: Delete User By Postman - localhost:8080/api/userManagement/manage-app/delete-User/id/5

#### :small_blue_diamond: Image after hitting the DeleteMapping on Postman.
![A5](https://user-images.githubusercontent.com/123385605/233767633-ae5022ea-e56e-4c4f-81da-cf41576f4749.png)

#### :small_blue_diamond: Image after hitting the GetMapping on Brower, we can see id : 5 has been deleted.
![A6](https://user-images.githubusercontent.com/123385605/233767656-1c3cfeef-8aa3-4659-b8e7-6e45933230d4.png)
