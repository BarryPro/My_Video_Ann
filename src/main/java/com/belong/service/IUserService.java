package com.belong.service;

import com.belong.model.User;

import java.util.Map;

/**
 * Created by belong on 16-11-5.
 */
public interface IUserService {
    User login(Map map);
    User getPic(Map map);
    int register(Map map);
}
