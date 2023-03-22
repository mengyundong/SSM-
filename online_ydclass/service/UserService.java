package net.ydclass.online_ydclass.service;

import net.ydclass.online_ydclass.model.entity.User;

import java.util.Map;

public interface UserService {

    /**
     * 新增用户
     *
     * @param userInfo
     * @return
     */
    int save(Map<String, String> userInfo);

    String findByPhoneAndPwd(String phone, String pwd);

    User findByUserId(Integer userId);
}
