package cn.itcast.service.impl;

import cn.itcast.dao.LogDao;
import cn.itcast.domain.SysLog;
import cn.itcast.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao ld;

    @Override
    public void saveLog(SysLog sysLog) {
        ld.saveLog(sysLog);
    }
}
