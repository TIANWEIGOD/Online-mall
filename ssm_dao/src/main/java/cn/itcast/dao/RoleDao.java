package cn.itcast.dao;

import cn.itcast.domain.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {

    @Select("select r.id rid,r.roleName,r.roleDesc from sys_role r,sys_user_role sr where r.id = sr.roleId and sr.userId = #{userId}")
    @Results({
            @Result(property = "id", column = "rid"),
            @Result(property = "permissions", column = "rid", javaType = List.class,
                    many = @Many(select = "cn.itcast.dao.PermissionDao.findPermissionByRoleId", fetchType = FetchType.LAZY))
    })
        //findPerssmionByRoleId
    List<Role> findRoleByUserId(String id);

    @Select("select * from sys_role")
    List<Role> findAllRole();

    @Insert("insert into sys_role values (role_sequence.nextval,#{roleName},#{roleDesc})")
    int saveRole(Role role);

    @Select("select * from sys_role where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "permissions", column = "id", javaType = List.class,
                    many = @Many(select = "cn.itcast.dao.PermissionDao.findPermissionById", fetchType = FetchType.LAZY))
    })
    Role findRoleById(String roleId);


    @Delete("delete from sys_role_permission where roleId = #{roleId}")
    void deleteAllPermission(String roleId);

    @Insert("insert into sys_role_permission values (#{id},#{roleId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("id") String id);
}
