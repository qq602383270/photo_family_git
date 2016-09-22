package cn.pothofamily.scancode.xml;

import javax.xml.bind.annotation.XmlElement;

/**
 * 
 * ClassName: RequestHead <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年9月8日 上午10:41:06 <br/>
 *
 * @author wangyonghe
 * @version
 * @since JDK 1.7
 */
public class RequestHead {
    /**
     * 目前版本“1.0.0”
     */
    private String version;
    /**
     * 合作方相关报文：01 
     * 民生扫码支付平台相关报文：02
     */
    private String msgType;
    /**
     * 格式为yyyyMMddHHmmss
     */
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
}

