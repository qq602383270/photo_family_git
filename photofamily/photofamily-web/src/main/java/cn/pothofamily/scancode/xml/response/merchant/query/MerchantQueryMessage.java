package cn.pothofamily.scancode.xml.response.merchant.query;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cn.pothofamily.scancode.xml.Message;
import cn.pothofamily.scancode.xml.ResponseHead;

/**
 * MerchantQueryMessage <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年9月8日 下午5:38:58 <br/>
 * 
 * @author wangyonghe
 * @version
 * @since JDK 1.7
 * @see
 */
@XmlRootElement(name = "message")
public class MerchantQueryMessage extends Message {

    private ResponseHead head;
    private MerchantQueryBody body;

    @XmlElement
    public ResponseHead getHead() {
        return head;
    }

    public void setHead(ResponseHead head) {
        this.head = head;
    }

    @XmlElement
    public MerchantQueryBody getBody() {
        return body;
    }

    public void setBody(MerchantQueryBody body) {
        this.body = body;
    }


}

