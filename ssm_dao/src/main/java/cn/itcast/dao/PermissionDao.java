package cn.itcast.dao;

import cn.itcast.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionDao {
    @Select("select p.* from sys_permission p,sys_role_permission rp where p.id = rp.permissionId and rp.roleId = #{roleId}")
    List<Permission> findPermissionByRoleId(String id);

    @Select("select * from sys_permission")
    List<Permission> findAllPermission();

    @Insert("insert into sys_permission values (common_sequence.nextval,#{permissionName},#{url},#{pid,jdbcType=VARCHAR})")
    int savePermission(Permission permission);

    @Select("select * from sys_permission where id in (select permissionId from sys_role_permission where roleId = #{id})")
    List<Permission> findPermissionById(String id);
}
