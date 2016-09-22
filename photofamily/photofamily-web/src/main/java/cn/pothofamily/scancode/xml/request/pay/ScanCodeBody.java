package cn.pothofamily.scancode.xml.request.pay;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;

/**
 * ClassName:Body <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年9月7日 上午10:24:47 <br/>
 * 
 * @author wangyonghe
 * @version
 * @since JDK 1.7
 * @see
 */
public class ScanCodeBody {
    
    /**
     * 银行商户编码 (必填)
     */
    private String merchantCode;
    /**
     * 订单金额 (必填)
     */
    private BigDecimal totalAmount;
    /**
     * 订单标题 (必填)
     */
    private String subject;
    /**
     * 订单描述
     */
    private String desc;
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
     * 指定支付方式 目前仅当微信支付模式下可用。
     */
    private String limitPay;
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
    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    @XmlElement
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @XmlElement
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @XmlElement
    public String getLimitPay() {
        return limitPay;
    }

    public void setLimitPay(String limitPay) {
        this.limitPay = limitPay;
    }

}

