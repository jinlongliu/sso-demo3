package org.playchain.demo3.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;
import org.playchain.demo3.model.Permission;
import org.playchain.demo3.model.PermissionExample;

public interface PermissionMapper {
    long countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExampleWithRowbounds(PermissionExample example, RowBounds rowBounds);

    List<Permission> selectByExample(PermissionExample example);

    Permission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    @Select("SELECT\n" +
            "\tp.*\n" +
            "FROM\n" +
            "\tUSER u\n" +
            "LEFT JOIN user_role ur ON u.id = ur.user_id\n" +
            "LEFT JOIN role r ON ur.role_id = r.id\n" +
            "LEFT JOIN role_permission rp ON rp.role_id = r.id\n" +
            "LEFT JOIN permission p ON p.id = rp.permission_id\n" +
            "WHERE\n" +
            "\tu.id = 1")
    List<Permission> selectPermissionByUserId(Integer id);
}