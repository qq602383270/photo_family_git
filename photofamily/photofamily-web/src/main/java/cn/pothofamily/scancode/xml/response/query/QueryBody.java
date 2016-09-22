package cn.pothofamily.scancode.xml.response.query;

import java.math.BigDecimal;

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
     * 原交易应答类型 (必填) S：成功 E：失败 R：不确定（处理中）
     */
    private String oriRespType;
    /**
     * 原交易应答码 (必填) 成功：000000
     */
    private String oriRespCode;
    /**
     * 原交易应答描述 (必填)
     */
    private String oriRespMsg;
    /**
     * 订单金额 (必填)
     */
    private BigDecimal totalAmount;
    /**
     * 买家实付金额
     */
    private BigDecimal buyerPayAmount;
    /**
     * 积分支付金额
     */
    private BigDecimal pointAmount;
    /**
     * 商户门店编号
     */
    private String storeId;
    /**
     * 商户机具终端编号
     */
    private String terminalId;
    /**
     * 买家编号
     */
    private String buyerId;
    /**
     * 买家帐号
     */
    private String buyerAccount;
    /**
     * 对账日期
     */
    private String settleDate;
    /**
     * 清算撤销标识 0正常清算-1发生撤销，渠道不产生退款
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
     * 备用域3
     */
    private String extend2;
    /**
     * 备用域3
     */
    private String extend3;

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

    @XmlElement
    public String getOriRespType() {
        return oriRespType;
    }

    public void setOriRespType(String oriRespType) {
        this.oriRespType = oriRespType;
    }

    @XmlElement
    public String getOriRespCode() {
        return oriRespCode;
    }

    public void setOriRespCode(String oriRespCode) {
        this.oriRespCode = oriRespCode;
    }

    @XmlElement
    public String getOriRespMsg() {
        return oriRespMsg;
    }

    public void setOriRespMsg(String oriRespMsg) {
        this.oriRespMsg = oriRespMsg;
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



}

