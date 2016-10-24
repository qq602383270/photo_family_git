package cn.pothofamily.chat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.pothofamily.commons.controller.BasicController;

@RequestMapping("/chat")
@Controller
public class ChatController extends BasicController {
    @RequestMapping("/index")
    public ModelAndView chat(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("dwr/chat");
        mav.addObject("username", System.getProperty("os.name"));
        return mav;
    }
}
