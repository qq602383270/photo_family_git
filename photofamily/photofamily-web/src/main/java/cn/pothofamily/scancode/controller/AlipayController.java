/**
 * Project Name:photofamily-web File Name:AlipayController.java Package Name:cn.pothofamily.scancode
 * Date:2016年9月21日下午6:07:56 Copyright (c) 2016, ehking All Rights Reserved.
 *
 */

package cn.pothofamily.scancode.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.photofamily.core.commons.utils.XMLUtils;
import cn.photofamily.core.commons.utils.qrcode.QRCodeUtils;
import cn.pothofamily.commons.controller.BasicController;
import cn.pothofamily.scancode.CMCCUtlis;
import cn.pothofamily.scancode.enums.TradeEnums;
import cn.pothofamily.scancode.xml.RequestHead;
import cn.pothofamily.scancode.xml.ResponseHead;
import cn.pothofamily.scancode.xml.request.pay.ScanCodeBody;
import cn.pothofamily.scancode.xml.request.pay.ScanCodeMerchant;
import cn.pothofamily.scancode.xml.response.pay.ScanCodeMessage;

/**
 * ClassName:AlipayController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年9月21日 下午6:07:56 <br/>
 * 
 * @author wangyonghe
 * @version
 * @since JDK 1.7
 * @see
 */
@Controller
@RequestMapping("alipay")
public class AlipayController extends BasicController {
    @Autowired
    CMCCUtlis cmccUtlis;

    @RequestMapping("/scancode")
    public ModelAndView scancode(HttpServletResponse response, HttpServletRequest request) throws IOException {
        ModelAndView mav = new ModelAndView("alipay/scancode/index");
        System.err.println(request);

        return mav;
    }

    @RequestMapping("/initCode")
    public void initCode(HttpServletResponse response, HttpServletRequest request) throws Exception {
        /**
         * 商户编号
         */
        String merchantCode = "2016091904484273";

        ScanCodeMerchant scanCodeMerchant = new ScanCodeMerchant();
        String amount = request.getParameter("amount");
        RequestHead head = new RequestHead();

        head.setVersion("1.0.0");
        head.setMsgType("01");
        head.setReqDate(DateFormatUtils.format(new Date(), "yyyyMMddHHmmss"));

        ScanCodeBody body = new ScanCodeBody();

        body.setMerchantCode(merchantCode);
        body.setTotalAmount(new BigDecimal(amount));
        body.setSubject("易汇金");

        scanCodeMerchant.setHead(head);
        scanCodeMerchant.setBody(body);

        String tranCode = TradeEnums.SMZF002.name();

        String orderId = UUID.randomUUID().toString().replaceAll("-", "");
        /**
         * 请求返回数据
         */
        ScanCodeMessage scanCodeMessage = (ScanCodeMessage) cmccUtlis.post(orderId, scanCodeMerchant, tranCode, ScanCodeMessage.class);

        if (scanCodeMessage != null) {
            ResponseHead responseHead = scanCodeMessage.getHead();
            cn.pothofamily.scancode.xml.response.pay.ScanCodeBody responsebody = scanCodeMessage.getBody();
            if (responseHead != null && responsebody != null) {



                byte[] scanCode = QRCodeUtils.createQRCode(responsebody.getQrCode());
                if (scanCode != null) {
                    // 生成页面二维码
                    response.setHeader("Cache-Control", "no-store");
                    response.setHeader("Pragma", "no-cache");
                    response.setDateHeader("Expires", 0);
                    response.setContentType("image/jpeg");

                    ServletOutputStream responseOutputStream = response.getOutputStream();
                    responseOutputStream.write(scanCode);
                    responseOutputStream.flush();
                    responseOutputStream.close();
                }
            } else {
            }
        }
    }

    @Test
    public void test() {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?><message><head><version>1.0.0</version><msgType>02</msgType><smzfMsgId>2016092304490149</smzfMsgId><reqDate>20160923114933</reqDate><respDate>20160923115213</respDate><respType>R</respType><respCode>200002</respCode><respMsg>交易状态未知</respMsg></head><body><qrCode>https://qr.alipay.com/bax098220yrfr6oxzcga80cd</qrCode><extend1></extend1><extend2></extend2><extend3></extend3></body></message>";

        ScanCodeMessage message = XMLUtils.XMLToBean(xml, ScanCodeMessage.class);
        System.out.println(message);


    }
}

