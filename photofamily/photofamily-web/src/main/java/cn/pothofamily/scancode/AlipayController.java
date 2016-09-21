/**
 * Project Name:photofamily-web
 * File Name:AlipayController.java
 * Package Name:cn.pothofamily.scancode
 * Date:2016年9月21日下午6:07:56
 * Copyright (c) 2016, ehking All Rights Reserved.
 *
*/

package cn.pothofamily.scancode;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.pothofamily.commons.controller.BasicController;

/**
 * ClassName:AlipayController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年9月21日 下午6:07:56 <br/>
 * @author   wangyonghe
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Controller
@RequestMapping("alipay")
public class AlipayController extends BasicController {
    
    @RequestMapping("/scancode")
    public String scancode(HttpServletResponse response, HttpServletRequest request) throws IOException {
        
        System.err.println(request);
        
        return "";
    }

}

