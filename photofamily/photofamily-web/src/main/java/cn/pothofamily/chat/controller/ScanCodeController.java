
    /**  
    * @Title: ScanCodeController.java
    * @Package cn.pothofamily.chat.controller
    * @Description: TODO(用一句话描述该文件做什么)
    * @author wangyonghe
    * @date 2017年8月3日
    * @version V1.0  
    */
    
package cn.pothofamily.chat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.pothofamily.commons.controller.BasicController;

/**
    * @ClassName: ScanCodeController
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author wangyonghe
    * @date 2017年8月3日
    *
    */

@RequestMapping("/scancode")
@Controller
public class ScanCodeController extends BasicController {
    @RequestMapping("/index")
    public ModelAndView chat(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("dwr/chat");
        mav.addObject("username", System.getProperty("os.name"));
        return mav;
    }
}
