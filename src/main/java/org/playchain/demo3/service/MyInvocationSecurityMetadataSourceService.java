package org.playchain.demo3.service;

import org.playchain.demo3.mapper.PermissionMapper;
import org.playchain.demo3.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by Liu on 2017/8/24.
 */
@Service
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private PermissionMapper permissionMapper;

    private HashMap<String, Collection<ConfigAttribute>> map = null;

    /*
    * 加载权限表中所有定义权限
    *
    * */
    public void loadResourceDefine() {
        map = new HashMap<>();

        Collection<ConfigAttribute> array;

        ConfigAttribute cfg;

        List<Permission> permissions = permissionMapper.selectByExample(null);
        for (Permission permission : permissions) {
            array = new ArrayList<>();
            cfg = new SecurityConfig(permission.getName());
            array.add(cfg);
            map.put(permission.getUrl(), array);
        }
    }


    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if (map == null) loadResourceDefine();

//        object包含请求信息
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        AntPathRequestMatcher matcher;
        String resUrl;
        for (Iterator<String> iterator =  map.keySet().iterator(); iterator.hasNext();) {
            resUrl = iterator.next();
            matcher = new AntPathRequestMatcher(resUrl);
            if (matcher.matches(request)) {
                return map.get(resUrl);
            }
        }
        return null;
     }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
