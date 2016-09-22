package cn.pothofamily.scancode.xml.request.refund;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;

/**
 * ClassName:RefundBody <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年9月9日 下午12:39:52 <br/>
 * 
 * @author wangyonghe
 * @version
 * @since JDK 1.7
 * @see
 */
public class RefundBody {
    /**
     * 原支付交易流水号 (必填)
     */
    private String oriReqMsgId;
    /**
     * 退款金额 (必填)
     */
    private BigDecimal refundAmount;
    /**
     * 退款原因
     */
    private String refundReason;
    /**
     * 商户操作员编号
     */
    private String operatorId;
    /**
     * 商户门店编号
     */
    private String storeId;
    /**
     * 商户机具终端编号
     */
    private String terminalId;
    /**
     * 备用域1
     */
    private String extend1;
    /**
     * 备用域2
     */
    private String extend2;
    /**
     * 备用域3
     */
    private String extend3;

    @XmlElement
    public String getOriReqMsgId() {
        return oriReqMsgId;
    }

    public void setOriReqMsgId(String oriReqMsgId) {
        this.oriReqMsgId = oriReqMsgId;
    }

    @XmlElement
    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    @XmlElement
    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    @XmlElement
    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    @XmlElement
    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    @XmlElement
    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    @XmlElement
    public String getExtend1() {
        return extend1;
    }

    public void setExtend1(String extend1) {
        this.extend1 = extend1;
    }

    @XmlElement
    public String getExtend2() {
        return extend2;
    }

    public void setExtend2(String extend2) {
        this.extend2 = extend2;
    }

    @XmlElement
    public String getExtend3() {
        return extend3;
    }

    public void setExtend3(String extend3) {
        this.extend3 = extend3;
    }


}

