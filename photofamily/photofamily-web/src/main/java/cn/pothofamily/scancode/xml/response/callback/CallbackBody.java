package cn.pothofamily.scancode.xml.response.callback;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;

/**
 * ClassName:CallbackBody <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年9月11日 上午10:50:30 <br/>
 * 
 * @author wangyonghe
 * @version
 * @since JDK 1.7
 * @see
 */
public class CallbackBody {
    /**
     * 买家编号
     */
    private String buyerId;
    /**
     * 买家帐号
     */
    private String buyerAccount;
    /**
     * 订单金额 (必填)
     */
    private BigDecimal totalAmount;
    /**
     * 买家付款金额
     */
    private BigDecimal buyerPayAmount;
    /**
     * 积分付款金额
     */
    private BigDecimal pointAmount;
    /**
     * 交易支付时间
     */
    private String payTime;
    /**
     * 对账日期 (必填)
     */
    private String settleDate;
    /**
     * 清算撤销标识
     */
    private String isClearOrCancel;
    /**
     * 支付渠道流水
     */
    private String channelNo;
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
    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    @XmlElement
    public String getBuyerAccount() {
        return buyerAccount;
    }

    public void setBuyerAccount(String buyerAccount) {
        this.buyerAccount = buyerAccount;
    }

    @XmlElement
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @XmlElement
    public BigDecimal getBuyerPayAmount() {
        return buyerPayAmount;
    }

    public void setBuyerPayAmount(BigDecimal buyerPayAmount) {
        this.buyerPayAmount = buyerPayAmount;
    }

    @XmlElement
    public BigDecimal getPointAmount() {
        return pointAmount;
    }

    public void setPointAmount(BigDecimal pointAmount) {
        this.pointAmount = pointAmount;
    }

    @XmlElement
    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    @XmlElement
    public String getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate;
    }

    @XmlElement
    public String getIsClearOrCancel() {
        return isClearOrCancel;
    }

    public void setIsClearOrCancel(String isClearOrCancel) {
        this.isClearOrCancel = isClearOrCancel;
    }

    @XmlElement
    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
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

