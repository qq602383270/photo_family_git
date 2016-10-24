/**
 * Project Name:photofamily-core
 * File Name:CMCCUtlis.java
 * Package Name:photofamily.core.commons.utils.cmcc
 * Date:2016年9月22日下午7:00:47
 * Copyright (c) 2016, ehking All Rights Reserved.
 *
*/

package cn.pothofamily.scancode;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import cn.photofamily.core.commons.utils.CryptoUtil;
import cn.photofamily.core.commons.utils.HttpClient4Util;
import cn.photofamily.core.commons.utils.XMLUtils;
import cn.pothofamily.scancode.xml.Merchant;
import cn.pothofamily.scancode.xml.Message;




/**
 * ClassName:CMCCUtlis <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年9月22日 下午7:00:47 <br/>
 * @author   wangyonghe
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Component
public class CMCCUtlis {
    

    /**
     * 民生请求地址
     */
    private String serverUrl= "http://110.80.39.174:9013/nbp-smzf-hzf";
    /**
     * 回调地址
     */
    private String callBack="https://dev-bankchannel.ehking.com/bankchannel/";
    /**
     * 编码
     */
    private String charset="utf-8";
    /**
     * 合作方标示
     */
    private String cooperator="SMZF_YHJ"; //   合作方标示
    /**
     * 民生公钥
     */
    private String msPublicKeyPath= "/Users/wangyonghe/Downloads/ms/ehking_ms_rsa_public_key_2048.pem";
    /**
     * 合作方私钥
     */
    private String hzfPrivateKeyPath= "/Users/wangyonghe/Downloads/ms/ehking_pkcs8_rsa_private_key_2048.pem";
    /**
     * AES密钥
     */
    private String AESkeyStr= "1122334455667788";

    
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Message post(String reqMsgId, Merchant merchant, String tranCode, Class<?> clazz) throws Exception {


        InputStream msPublicKeyStream = new FileInputStream(msPublicKeyPath);
        PublicKey yhPubKey = CryptoUtil.getRSAPublicKeyByFileSuffix(msPublicKeyStream, "pem", "RSA");

        InputStream hzfPrivateKeyStream = new FileInputStream(hzfPrivateKeyPath);
        final PrivateKey hzfPriKey = CryptoUtil.getRSAPrivateKeyByFileSuffix(hzfPrivateKeyStream, "pem", null, "RSA");


        String plainXML = XMLUtils.beanToXML(merchant, charset).toString();

        System.out.println("请求发送的xml报文:" + plainXML);

        byte[] plainBytes = plainXML.getBytes(charset);
        byte[] keyBytes = AESkeyStr.getBytes(charset);
        String encryptData = new String(Base64.encodeBase64((CryptoUtil.AESEncrypt(plainBytes, keyBytes, "AES", "AES/ECB/PKCS5Padding", null))), charset);
        String signData = new String(Base64.encodeBase64(CryptoUtil.digitalSign(plainBytes, hzfPriKey, "SHA1WithRSA")), charset);
        String encrtptKey = new String(Base64.encodeBase64(CryptoUtil.RSAEncrypt(keyBytes, yhPubKey, 2048, 11, "RSA/ECB/PKCS1Padding")), charset);


        final ArrayBlockingQueue vmQueue = new ArrayBlockingQueue<List<NameValuePair>>(10000, true);

        List<NameValuePair> nvps = new LinkedList<NameValuePair>();
        nvps.add(new BasicNameValuePair("encryptData", encryptData));
        nvps.add(new BasicNameValuePair("encryptKey", encrtptKey));
        nvps.add(new BasicNameValuePair("cooperator", cooperator));
        nvps.add(new BasicNameValuePair("signData", signData));
        nvps.add(new BasicNameValuePair("tranCode", tranCode));
        nvps.add(new BasicNameValuePair("callBack", callBack));
        nvps.add(new BasicNameValuePair("reqMsgId", reqMsgId));
        vmQueue.put(nvps);

        nvps = (List<NameValuePair>) vmQueue.take();
        System.out.println(tranCode+" 请求发送的数据:" + nvps);
        byte[] b = HttpClient4Util.getInstance().doPost(serverUrl, null, nvps);
        String respStr = new String(b, charset);
        JSONObject jsonObject = JSONObject.parseObject(respStr);
        String resXml = Decod(jsonObject);
        System.out.println(tranCode+" 请求返回的数据:" + jsonObject);
        System.out.println(tranCode+" 请求返回xml报文:" + resXml.replaceAll("\r|\n", ""));
        Message message = XMLUtils.XMLToBean(resXml, clazz);
        message.setReqMsgId(jsonObject.getString("reqMsgId"));
        System.out.println(tranCode+" 请求返回的流水号:" + jsonObject.getString("reqMsgId"));
        return message;

    }

    public String Decod(JSONObject jsonObject) throws Exception {
        InputStream hzfPrivateKeyStream = new FileInputStream(hzfPrivateKeyPath);

        final PrivateKey hzfPriKey = CryptoUtil.getRSAPrivateKeyByFileSuffix(hzfPrivateKeyStream, "pem", null, "RSA");


        String resEncryptData = jsonObject.getString("encryptData");
        String resEncryptKey = jsonObject.getString("encryptKey");
        byte[] decodeBase64KeyBytes = Base64.decodeBase64(resEncryptKey.getBytes(charset));
        // 解密encryptKey得到merchantAESKey
        byte[] merchantAESKeyBytes = CryptoUtil.RSADecrypt(decodeBase64KeyBytes, hzfPriKey, 2048, 11, "RSA/ECB/PKCS1Padding");
        // 使用base64解码商户请求报文
        byte[] decodeBase64DataBytes = Base64.decodeBase64(resEncryptData.getBytes(charset));
        // 用解密得到的merchantAESKey解密encryptData
        byte[] merchantXmlDataBytes = CryptoUtil.AESDecrypt(decodeBase64DataBytes, merchantAESKeyBytes, "AES", "AES/ECB/PKCS5Padding", null);

        return new String(merchantXmlDataBytes, charset);
    }
}

