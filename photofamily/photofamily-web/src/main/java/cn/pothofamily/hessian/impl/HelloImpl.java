/**
 * Project Name:photofamily-web
 * File Name:HelloImp.java
 * Package Name:cn.pothofamily.hessian.impl
 * Date:2016年10月24日下午4:59:47
 * Copyright (c) 2016, ehking All Rights Reserved.
 *
*/

package cn.pothofamily.hessian.impl;

import cn.pothofamily.hessian.IHello;

/**
 * ClassName:HelloImp <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年10月24日 下午4:59:47 <br/>
 * @author   wangyonghe
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class HelloImpl implements IHello {

    @Override
    public String sayHello(String str) {
        System.out.println("hell word");
        return str;
    }

}

