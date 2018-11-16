package cn.itcast.controller.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHandlerException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        MyException myException = null;

        if (e instanceof MyException) {

            myException = (MyException) e;

        } else {

            myException = new MyException(e.getMessage() + "系统出现异常");

        }

        ModelAndView mv = new ModelAndView();

        mv.addObject("errorMessage", myException.getMessage());
        mv.setViewName("error");

        return mv;
    }
}
