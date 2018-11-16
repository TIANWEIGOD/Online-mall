package cn.itcast.dao;

import cn.itcast.domain.SysUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao {

    @Select("select * from sys_user where username = #{uesename}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roles", column = "id", javaType = List.class,
                    many = @Many(select = "cn.itcast.dao.RoleDao.findRoleByUserId",fetchType = FetchType.LAZY))
    })
    SysUser findUserByUsername(String username);

    @Select("select * from sys_user")
    List<SysUser> findAllUser();

    @Insert("insert into sys_user values " +
            "(user_sequence.nextval,#{username},#{email},#{password},#{phoneNum},#{status})")
    int saveUser(SysUser sysUser);

    @Select("select * from sys_user where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roles", column = "id", javaType = List.class,
                    many = @Many(select = "cn.itcast.dao.RoleDao.findRoleByUserId",fetchType = FetchType.LAZY))
    })
    SysUser findUserById(String id);

    @Delete("delete from sys_user_role where userId = #{userId}")
    int deleteUser_RoleById(String userId);

    @Insert("insert into sys_user_role values (#{userId},#{roleId})")
    int addRoLeToUser(@Param("userId") String userId, @Param("roleId") String id);
}
