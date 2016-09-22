package cn.pothofamily.scancode.xml.response.query;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cn.pothofamily.scancode.xml.Message;
import cn.pothofamily.scancode.xml.ResponseHead;

/**
 * ClassName:QueryMessage <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年9月8日 下午4:20:08 <br/>
 * 
 * @author wangyonghe
 * @version
 * @since JDK 1.7
 * @see
 */
@XmlRootElement(name="message")
public class QueryMessage extends Message {
    private QueryBody body;
    private ResponseHead head;
    @XmlElement
    public QueryBody getBody() {
        return body;
    }
    public void setBody(QueryBody body) {
        this.body = body;
    }
    @XmlElement
    public ResponseHead getHead() {
        return head;
    }
    public void setHead(ResponseHead head) {
        this.head = head;
    }

    
}

