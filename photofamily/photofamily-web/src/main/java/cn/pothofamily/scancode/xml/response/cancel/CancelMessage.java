package cn.pothofamily.scancode.xml.response.cancel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cn.pothofamily.scancode.xml.Message;
import cn.pothofamily.scancode.xml.ResponseHead;

/**
 * CancelMessage <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年9月8日 下午4:23:26 <br/>
 * 
 * @author wangyonghe
 * @version
 * @since JDK 1.7
 * @see
 */
@XmlRootElement(name="message")
public class CancelMessage extends Message {

    private ResponseHead head;
    private CancelBody body;
    @XmlElement
    public ResponseHead getHead() {
        return head;
    }
    public void setHead(ResponseHead head) {
        this.head = head;
    }
    @XmlElement
    public CancelBody getBody() {
        return body;
    }
    public void setBody(CancelBody body) {
        this.body = body;
    }
    
    
}

