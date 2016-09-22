package cn.pothofamily.scancode.xml.response.callback;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cn.pothofamily.scancode.xml.Message;
import cn.pothofamily.scancode.xml.ResponseHead;

/**
 * CallbackMessage <br/>
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
public class CallbackMessage extends Message {

    private ResponseHead head;
    private CallbackBody body;
    @XmlElement
    public ResponseHead getHead() {
        return head;
    }
    public void setHead(ResponseHead head) {
        this.head = head;
    }
    @XmlElement
    public CallbackBody getBody() {
        return body;
    }
    public void setBody(CallbackBody body) {
        this.body = body;
    }
    
    
}

