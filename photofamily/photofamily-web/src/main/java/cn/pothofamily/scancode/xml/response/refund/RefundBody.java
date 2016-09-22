package cn.pothofamily.scancode.xml.response.refund;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;

/**
 * ClassName:RefundBody <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年9月11日 上午10:30:24 <br/>
 * 
 * @author wangyonghe
 * @version
 * @since JDK 1.7
 * @see
 */
public class RefundBody {
    /**
     * 退款金额 (必填＃)
     */
    private BigDecimal refundAmount;
    /**
     * 实际退款金额
     */
    private BigDecimal refundFee;
    /**
     * 剩余可退金额 (必填)
     */
    private BigDecimal backFee;
    /**
     * 退款支付时间
     */
    private BigDecimal refundTime;
    /**
     * 对账日期
     */
    private BigDecimal settleDate;
    /**
     * 买家编号
     */
    private String buyerId;
    /**
     * 清算撤销标识
     */
    private String isClearOrCancel;
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
    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    @XmlElement
    public BigDecimal getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(BigDecimal refundFee) {
        this.refundFee = refundFee;
    }

    @XmlElement
    public BigDecimal getBackFee() {
        return backFee;
    }

    public void setBackFee(BigDecimal backFee) {
        this.backFee = backFee;
    }

    @XmlElement
    public BigDecimal getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(BigDecimal refundTime) {
        this.refundTime = refundTime;
    }

    @XmlElement
    public BigDecimal getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(BigDecimal settleDate) {
        this.settleDate = settleDate;
    }

    @XmlElement
    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    @XmlElement
    public String getIsClearOrCancel() {
        return isClearOrCancel;
    }

    public void setIsClearOrCancel(String isClearOrCancel) {
        this.isClearOrCancel = isClearOrCancel;
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

