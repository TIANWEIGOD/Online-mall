package cn.itcast.dao;

import cn.itcast.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface LogDao {

    @Insert("insert into sys_log values (common_sequence.nextval,#{visitTime},#{username},#{ip},#{method}" +
            ",#{executeMsg},#{executeResult},#{executeTime})")
    int saveLog(SysLog sysLog);
}
