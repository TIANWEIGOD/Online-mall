package cn.itcast.controller;

import cn.itcast.domain.SysLog;
import cn.itcast.service.LogService;
import cn.itcast.service.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    private SysLog log;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private LogService ls;


    /*@Before("arround()")
    public void logBefore(JoinPoint jp) {
        clazz = jp.getTarget().getClass();

        String className = clazz.getSimpleName();

        methodName = jp.getSignature().getName();
        Signature signature = jp.getSignature();

        methodName = className + "." + methodName;
        System.out.println("getName--" + signature.getName());
        System.out.println("DeclaringTypeName--" + signature.getDeclaringTypeName());
        System.out.println("toShortString--" + signature.toShortString());// UserController.findAllUser(..)
        System.out.println("toLongString--" + signature.toLongString()); // public java.lang.String cn.itcast.controller.UserController.findAllUser(org.springframework.ui.Model)

    }

    @After("arround()")
    public void logAfter() {
        SysLog sysLog = new SysLog();

        sysLog.setIp(request.getRemoteAddr()); // 远程登录地址
        sysLog.setMethod(methodName);

        // 获取认证对象
        SecurityContext securityContext = SecurityContextHolder.getContext();

        Authentication authentication = securityContext.getAuthentication();

        User principal = (User) authentication.getPrincipal();

        sysLog.setUsername(principal.getUsername());
        sysLog.setVisitTime(new Date());

        ls.saveLog(sysLog);
    }*/

    @Before("execution(* cn.itcast.controller.*Controller.*(..))")
    public void beforeAop(JoinPoint joinPoint) {
        log = new SysLog();
        log.setVisitTime(new Date());
        log.setIp(request.getRemoteAddr());

        System.out.println(2);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        User principal = (User) authentication.getPrincipal();
        log.setUsername(principal.getUsername());

        Class clazz = joinPoint.getTarget().getClass();
        String className = clazz.getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        log.setMethod(className + "--" + methodName);
    }

    @AfterReturning("execution(* cn.itcast.controller.*Controller.*(..))")
    public void afterReturning() {
        log.setExecuteMsg("执行成功");
        log.setExecuteResult("success");
        log.setExecuteTime(new Date().getTime() - log.getVisitTime().getTime());
        ls.saveLog(log);

    }

    @AfterThrowing(pointcut = "execution(* cn.itcast.controller.*Controller.*(..))", throwing = "e")
    public void afterThrowing(Exception e) {
        log.setExecuteMsg(e.getMessage());
        log.setExecuteResult("exception");
        log.setExecuteTime(new Date().getTime() - log.getVisitTime().getTime());
        ls.saveLog(log);
    }

    @Pointcut("execution(* cn.itcast.controller.*Controller.*(..))")
    public void arround() {
        // ProceedingJoinPoint php
        try {
            // 方法执行
            // php.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
}
