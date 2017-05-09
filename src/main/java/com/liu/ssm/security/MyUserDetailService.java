package com.liu.ssm.security;

import com.liu.ssm.dao.UserMapper;
import com.liu.ssm.model.UserExample;
import com.liu.ssm.service.UserService;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetailService implements UserDetailsService {
    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;
    //登陆验证时，通过username获取用户的所有权限信息，
    //并返回User放到spring的全局缓存SecurityContextHolder中，以供授权器使用
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
        Collection<GrantedAuthority> auths=new ArrayList<GrantedAuthority>();

        GrantedAuthorityImpl auth2=new GrantedAuthorityImpl("ROLE_ADMIN");
        GrantedAuthorityImpl auth1=new GrantedAuthorityImpl("ROLE_USER");
        String password ="";
        String username1 ="";
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(username);
        List<com.liu.ssm.model.User> userList = userMapper.selectByExample(userExample);
        if(null != userList || 0 > userList.size()){
            com.liu.ssm.model.User user1 = userList.get(0);
            if(username.equals(user1.getUserName())){
                auths=new ArrayList<GrantedAuthority>();
                auths.add(auth1);
                auths.add(auth2);
                username1 = user1.getUserName();
                password = user1.getPassword();
            }

        }


        User user = new User(username1, password, true, true, true, true, auths);
        return user;
    }
}