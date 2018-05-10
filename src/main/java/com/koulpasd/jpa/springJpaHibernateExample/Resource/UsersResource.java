package com.koulpasd.jpa.springJpaHibernateExample.Resource;

import com.koulpasd.jpa.springJpaHibernateExample.Model.Users;
import com.koulpasd.jpa.springJpaHibernateExample.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/users")
public class UsersResource {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/all")
    public List<Users> getALL(){
        return  userRepository.findAll();
    }

    @GetMapping("/{name}")
    public List<Users> getUser(@PathVariable final String name){
        return userRepository.findByName(name);
    }

    @GetMapping("/id/{id}")
    public Optional<Users> getId(@PathVariable("id") final Integer id) {
        return userRepository.findById(id);
    }

    @GetMapping("/update/{id}/{name}")
    public Users update(@PathVariable("id") final Integer id, @PathVariable("name")
    final String name) {
        Optional<Users> users = userRepository.findById(id);

        if(users.isPresent()){
            users.get().setName(name);
        }else
            throw new UnsupportedOperationException("No User with this Id Found");
        return userRepository.save(users.get());
    }
}
