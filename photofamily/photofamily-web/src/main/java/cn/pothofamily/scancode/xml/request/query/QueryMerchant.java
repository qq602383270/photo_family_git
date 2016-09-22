package cn.pothofamily.scancode.xml.request.query;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cn.pothofamily.scancode.xml.Merchant;
import cn.pothofamily.scancode.xml.RequestHead;

/**
 * Merchant <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年9月7日 上午10:22:57 <br/>
 * @author   wangyonghe
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@XmlRootElement(name="merchant")
public class QueryMerchant extends Merchant {

    private RequestHead head;
    private QueryBody body;
    
    @XmlElement
    public RequestHead getHead() {
        return head;
    }
    public void setHead(RequestHead head) {
        this.head = head;
    }
    @XmlElement
    public QueryBody getBody() {
        return body;
    }
    public void setBody(QueryBody body) {
        this.body = body;
    }
    
}

