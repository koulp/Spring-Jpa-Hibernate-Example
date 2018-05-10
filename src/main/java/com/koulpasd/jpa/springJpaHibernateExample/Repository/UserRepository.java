package com.koulpasd.jpa.springJpaHibernateExample.Repository;

import com.koulpasd.jpa.springJpaHibernateExample.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Integer> {

    List<Users> findByName(String name);
}
