package cn.pothofamily.scancode.xml.request.query;

import javax.xml.bind.annotation.XmlElement;

/**
 * ClassName:QueryBody <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年9月8日 下午1:41:58 <br/>
 * 
 * @author wangyonghe
 * @version
 * @since JDK 1.7
 * @see
 */
public class QueryBody {

    /**
     * 原交易流水号 (必填)
     */
    private String oriReqMsgId;
    /**
     * operatorId
     */
    private String operatorId;

    @XmlElement
    public String getOriReqMsgId() {
        return oriReqMsgId;
    }

    public void setOriReqMsgId(String oriReqMsgId) {
        this.oriReqMsgId = oriReqMsgId;
    }

    @XmlElement
    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }



}

