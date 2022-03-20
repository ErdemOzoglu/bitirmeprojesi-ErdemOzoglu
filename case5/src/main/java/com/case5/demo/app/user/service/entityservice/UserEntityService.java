package com.case5.demo.app.user.service.entityservice;

import com.case5.demo.app.gen.service.BaseEntityService;
import com.case5.demo.app.user.dao.UserDao;
import com.case5.demo.app.user.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService extends BaseEntityService<User, UserDao> {

    public UserEntityService(UserDao dao) {
        super(dao);
    }
    public User findByUserName(String username){
        return getDao().findByUserName(username);
    }
}
