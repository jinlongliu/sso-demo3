package org.playchain.demo3.service;

import org.playchain.demo3.mapper.PermissionMapper;
import org.playchain.demo3.mapper.UserMapper;
import org.playchain.demo3.model.Permission;
import org.playchain.demo3.model.User;
import org.playchain.demo3.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liu on 2017/8/24.
 *
 * 用户详情验证服务
 *
 */
public class UserService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    PermissionMapper permissionMapper;

    /*登录时需要调用*/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);

        if (users.size() == 1) {
            User user = users.get(0);
            List<Permission> permissions = permissionMapper.selectPermissionByUserId(user.getId());

            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (Permission permission : permissions) {
                if(permission != null && permission.getName() != null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                    grantedAuthorities.add(grantedAuthority);
                }
            }

//            从数据库查询用户详情交给spring security比对
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                    grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("admin:" + username + "do not exist!");
        }
    }
}
