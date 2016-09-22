package cn.pothofamily.scancode.xml.request.cancel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cn.pothofamily.scancode.xml.Merchant;
import cn.pothofamily.scancode.xml.RequestHead;

/**
 * CancelMerchant <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年9月8日 下午5:29:25 <br/>
 * @author   wangyonghe
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@XmlRootElement
public class CancelMerchant extends Merchant {
    
    private RequestHead head;
    private CancelBody body;
    @XmlElement
    public RequestHead getHead() {
        return head;
    }
    public void setHead(RequestHead head) {
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

