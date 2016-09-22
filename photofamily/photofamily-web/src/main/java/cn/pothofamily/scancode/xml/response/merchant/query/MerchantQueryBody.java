package cn.pothofamily.scancode.xml.response.merchant.query;

import javax.xml.bind.annotation.XmlElement;

/**
 * MerchantQueryBody <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年9月11日 上午11:07:06 <br/>
 * 
 * @author wangyonghe
 * @version
 * @since JDK 1.7
 * @see
 */
public class MerchantQueryBody {
    /**
     * 合作方商户编码 (必填)
     */
    private String merchantId;
    /**
     * 银行商户编码
     */
    private String merchantCode;
    /**
     * 原交易应答类型 (必填) S：成功 E：失败 R：不确定（处理中）
     * 
     */
    private String oriRespType;
    /**
     * 原交易应答码 (必填)
     */
    private String oriRespCode;
    /**
     * 原交易应答描述 (必填)
     */
    private String oriRespMsg;
    /**
     * 支付通道 (必填)
     */
    private String payWay;
    /**
     * 商户名称 (必填)
     */
    private String merchantName;
    /**
     * 商户简称 (必填)
     */
    private String shortName;
    /**
     * 商户地址 (必填)
     */
    private String merchantAddress;
    /**
     * 客服电话 (必填)
     */
    private String servicePhone;
    /**
     * 组织机构代码
     */
    private String orgCode;
    /**
     * 联系人名词
     */
    private String contactName;
    /**
     * 联系人电话
     */
    private String contactPhone;
    /**
     * 联系人手机号
     */
    private String contactMobile;
    /**
     * 联系人邮箱
     */
    private String contactEmail;
    /**
     * 经营类目 (必填)
     */
    private String category;
    /**
     * 备注说明
     */
    private String remark;
    /**
     * 状态
     */
    private String status;
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
    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    @XmlElement
    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
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
    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    @XmlElement
    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    @XmlElement
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @XmlElement
    public String getMerchantAddress() {
        return merchantAddress;
    }

    public void setMerchantAddress(String merchantAddress) {
        this.merchantAddress = merchantAddress;
    }

    @XmlElement
    public String getServicePhone() {
        return servicePhone;
    }

    public void setServicePhone(String servicePhone) {
        this.servicePhone = servicePhone;
    }

    @XmlElement
    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    @XmlElement
    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    @XmlElement
    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    @XmlElement
    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    @XmlElement
    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    @XmlElement
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @XmlElement
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @XmlElement
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

