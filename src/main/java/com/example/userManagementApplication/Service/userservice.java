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