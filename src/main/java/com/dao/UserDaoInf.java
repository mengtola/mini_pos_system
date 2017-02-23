package com.dao;

import java.util.List;

import com.domain.Users;

public interface UserDaoInf {

    List<Users> list();
    Users get(int id);
    Users create(Users Users);
    int delete(int id);
    Users update(Users Users);
}
