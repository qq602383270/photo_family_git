package cn.pothofamily.scancode.xml.response.merchant.init;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cn.pothofamily.scancode.xml.Message;
import cn.pothofamily.scancode.xml.ResponseHead;

/**
 * ClassName:InitMessage <br/>
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
public class InitMessage extends Message {

    private ResponseHead head;
    private InitBody body;

    @XmlElement
    public ResponseHead getHead() {
        return head;
    }

    public void setHead(ResponseHead head) {
        this.head = head;
    }

    @XmlElement
    public InitBody getBody() {
        return body;
    }

    public void setBody(InitBody body) {
        this.body = body;
    }


}

