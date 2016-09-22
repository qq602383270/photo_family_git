package cn.pothofamily.scancode.xml;

import javax.xml.bind.annotation.XmlElement;

/**
 * ResponseHead <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年9月7日 上午10:23:55 <br/>
 * 
 * @author wangyonghe
 * @version
 * @since JDK 1.7
 * @see
 */
public class ResponseHead {

    private String smzfMsgId;

    private String respDate;

    private String respType;

    private String respCode;

    private String respMsg;

    private String version;
    private String msgType;
    private String reqDate;

    @XmlElement
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @XmlElement
    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    @XmlElement
    public String getReqDate() {
        return reqDate;
    }

    public void setReqDate(String reqDate) {
        this.reqDate = reqDate;
    }
    @XmlElement
    public String getSmzfMsgId() {
        return smzfMsgId;
    }
    public void setSmzfMsgId(String smzfMsgId) {
        this.smzfMsgId = smzfMsgId;
    }
    @XmlElement
    public String getRespDate() {
        return respDate;
    }

    public void setRespDate(String respDate) {
        this.respDate = respDate;
    }
    @XmlElement
    public String getRespType() {
        return respType;
    }

    public void setRespType(String respType) {
        this.respType = respType;
    }
    @XmlElement
    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }
    @XmlElement
    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }


}

