package cn.photofamily.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

/*********************************
 *
 * 短信发送接口调用类
 *
 * @author YangJin
 *
 ********************************/
public class MessageUtil {
    public String transmessage(String requrl, String paras) {
        String ret = null;
        try {

            URL url = new URL(requrl);

            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setConnectTimeout(30000);
            httpConn.setReadTimeout(30000);
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            httpConn.setRequestMethod("POST");
            DataOutputStream out = new DataOutputStream(httpConn.getOutputStream());

            String reqstr = paras;

            out.write(reqstr.getBytes("UTF-8"));

            out.flush();
            out.close();
            InputStream stream = httpConn.getInputStream();

            DataInputStream in = new DataInputStream(stream);
            byte[] bin = null;
            byte[] inc = new byte[1024];
            int datelength = 0;
            int insize = 0;
            while ((insize = in.read(inc)) != -1) {
                int oldlength = datelength;
                datelength += insize;
                byte[] oldbin = new byte[datelength];
                for (int i = 0; i < oldlength; i++)
                    oldbin[i] = bin[i];
                for (int i = oldlength; i < datelength; i++)
                    oldbin[i] = inc[i - oldlength];
                bin = oldbin;
            }
            ret = new String(bin, "UTF8");
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return ret;
    }

    private final String MD5(String s) {
        char hexdigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        try {
            byte[] strTemp = s.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexdigits[byte0 >>> 4 & 0xf];
                str[k++] = hexdigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }


    public String getSig(JSONObject reqjson, String secretkey) {
        String result = null;

        if (reqjson == null || secretkey == null) {
            return result;
        }

        Set<String> set = reqjson.keySet();

        set = new TreeSet<>(set);// 利用treeSet对set进行排序

        StringBuffer sb = new StringBuffer();

        for (String key : set) {
            sb.append(key).append("=").append(reqjson.get(key));
        }

        sb.append(secretkey);


        result = MD5(sb.toString());


        return result;
    }

    @Test
    public void testSend() throws Exception {
        String taskId = System.currentTimeMillis() + "";
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("op", "Sms.send");
        jsonObj.put("apiKey", "70c26d58126ae3ca9446b7453f22af0c");
        jsonObj.put("ts", System.currentTimeMillis());
        jsonObj.put("phone", "18510970050");
        jsonObj.put("templateId", "1533");
        jsonObj.put("content", "2016-10-28 16:40:06,商户编号120140583发生境内转帐下发业务已经扣款，请核对扣款金额。");
        jsonObj.put("taskId", taskId);// 不超过64位长度的唯一字符串，通过和recvRPT获取的结果里的teskid关联，确定发送的信息是否收到。
        jsonObj.put("extNum", "");
        jsonObj.put("sig", getSig(jsonObj, "E1F137695622FA7B"));

        String url = "http://api.sms.testin.cn/sms";
        System.out.println("taskId:" + taskId);
        System.out.println(jsonObj);
        String result = transmessage(url, jsonObj.toString());

        System.out.println(result);
    }

    @Test
    public void testQuery() throws Exception {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("op", "Sms.account");
        jsonObj.put("apiKey", "70c26d58126ae3ca9446b7453f22af0c");
        jsonObj.put("ts", System.currentTimeMillis());
        jsonObj.put("sig", getSig(jsonObj, "E1F137695622FA7B"));

        String url = "http://api.sms.testin.cn/sms";

        System.out.println(jsonObj);
        String result = transmessage(url, jsonObj.toString());
        JSONObject reJson = JSONObject.parseObject(result);
        BigDecimal fee = new BigDecimal("0.05").multiply(new BigDecimal(reJson.getString("balance")));
        System.out.println(fee);
        System.out.println(result);
    }
    
    @Test
    public void testgetStatus() throws Exception {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("op", "Sms.status");
        jsonObj.put("apiKey", "70c26d58126ae3ca9446b7453f22af0c");
        jsonObj.put("ts", System.currentTimeMillis());
        jsonObj.put("sig", getSig(jsonObj, "E1F137695622FA7B"));
        
        String url = "http://api.sms.testin.cn/sms";
        
        System.out.println(jsonObj);
        String result = transmessage(url, jsonObj.toString());
        System.out.println(result);
    }
}
