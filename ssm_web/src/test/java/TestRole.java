import cn.itcast.domain.Role;
import cn.itcast.service.RoleService;
import cn.itcast.service.impl.RoleServiceImpl;
import org.junit.Test;

import java.util.List;

public class TestRole {

    @Test
    public void test(){

        RoleServiceImpl rs = new RoleServiceImpl();

        List<Role> roles = rs.findRoleByUserId("2");


    }

}
