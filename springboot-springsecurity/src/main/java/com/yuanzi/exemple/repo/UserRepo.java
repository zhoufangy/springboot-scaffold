package com.yuanzi.exemple.repo;

import com.yuanzi.exemple.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by ZhouFangyuan on 2018/1/8. Information:
 */
@RepositoryRestResource(path = "user")
public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsernameAndPassword(String userName,String passward);
}
