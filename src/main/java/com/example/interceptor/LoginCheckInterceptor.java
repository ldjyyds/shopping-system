package com.example.interceptor;


import com.alibaba.fastjson.JSONObject;
import com.example.pojo.Result;
import com.example.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component  //交给ioc容器管理
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override//在目标资源运行前运行，返回值如果为true，则放行，返回false，不放行。
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {

        //1.获取请求url
        String url = req.getRequestURL().toString();
        log.info("请求的url：{}",url);

        //2.判断请求url中是否包含login，如果包含，说明是登录操作，放行。
        if(url.contains("login")){
            log.info("登录操作，直接放行...");
            return true;
        }

        //3.获取请求头中的令牌（token）
        //请求的信息都在request里面封装着
        String jwt = req.getHeader("token");   //请求头的名字就叫token;
        //4.判断令牌是否存在，如果不存在，返回错误结果（未登录）
        if(!StringUtils.hasLength(jwt)){
            log.info("请求头token为空，返回未登录信息");
            Result err = Result.error("NOT_LOGIN");
            //手动转换， 将对象转化成json格式  ----》阿里巴巴fastJSON
            String notLogin = JSONObject.toJSONString(err);
            resp.getWriter().write(notLogin);
            //响应数据通过response对象来。
            return false;
        }
        //5.解析token，如果解析失败，返回错误结果（未登录）
        try{
            JwtUtils.parseJWT(jwt);
        } catch (Exception e){ //jwt令牌解析失败。
            //出现异常才会被catch，捕获
            e.printStackTrace();
            log.info("解析令牌失败，返回未登录错误信息");
            Result err = Result.error("NOT_LOGIN");
            //手动转换， 将对象转化成json格式  ----》阿里巴巴fastJSON
            String notLogin = JSONObject.toJSONString(err);
            resp.getWriter().write(notLogin);
            //响应数据通过response对象来。
            return false;
        }

        //6.放行。
        log.info("令牌合法，放行");
        return true;
    }

    @Override//在目标资源运行后运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override//最后运行。
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}

