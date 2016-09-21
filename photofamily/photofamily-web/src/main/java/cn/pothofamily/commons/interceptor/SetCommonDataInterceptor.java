package cn.pothofamily.commons.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SetCommonDataInterceptor
  extends HandlerInterceptorAdapter
  implements ApplicationContextAware, InitializingBean
{
  public void afterPropertiesSet()
    throws Exception
  {}
  
  public void setApplicationContext(ApplicationContext applicationContext)
    throws BeansException
  {}
  
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
    throws Exception
  {
    System.out.println(request.getContextPath());
    return super.preHandle(request, response, handler);
  }
}
