/**
 * Project Name:photofamily-core
 * File Name:TestBasic.java
 * Package Name:cn.photofamily.test
 * Date:2016年6月25日上午1:29:14
 * Copyright (c) 2016, ehking All Rights Reserved.
 *
*/

package cn.photofamily.test;

import java.net.MalformedURLException;

import com.caucho.hessian.client.HessianProxyFactory;

import cn.pothofamily.hessian.IHello;

/**
 * ClassName:TestBasic <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年6月25日 上午1:29:14 <br/>
 * @author   wangyonghe
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class TestBasic {
    public static void main(String[] args) {
        
        String url="http://127.0.0.1:8088/photofamily-web/HelloServlet";
        HessianProxyFactory hessianProxyFactory = new HessianProxyFactory();  
        try {  
            // IHello是客户端的接口，与服务器接口一致（客户端的语言包括：Java,Objective C,Flex 等）  
            IHello iHello = (IHello) hessianProxyFactory.create(IHello.class,  
                    url);  
            // 客户端调服务器的接口实现  
            System.out.println("Result == " + iHello.sayHello("ssssssssssssssssssssss"));  
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        } 
        
    }
}

