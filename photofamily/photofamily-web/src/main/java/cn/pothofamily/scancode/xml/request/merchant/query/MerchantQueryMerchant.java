package cn.pothofamily.scancode.xml.request.merchant.query;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cn.pothofamily.scancode.xml.Merchant;
import cn.pothofamily.scancode.xml.RequestHead;

/**
 * MerchantQueryMerchant <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年9月8日 下午5:29:25 <br/>
 * @author   wangyonghe
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@XmlRootElement
public class MerchantQueryMerchant extends Merchant {
    
    private RequestHead head;
    private MerchantQueryBody body;
    @XmlElement
    public RequestHead getHead() {
        return head;
    }
    public void setHead(RequestHead head) {
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

