/**
 * Project Name:ehking-bankchannel-core File Name:UpdateBody.java Package
 * Name:com.ehking.bankchannel.scancode.minsheng.xml.response.merchant.update
 * Date:2016年9月11日上午11:18:45 Copyright (c) 2016, ehking All Rights Reserved.
 *
 */

package cn.pothofamily.scancode.xml.request.merchant.update;

import javax.xml.bind.annotation.XmlElement;

/**
 * ClassName:UpdateBody <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年9月11日 上午11:18:45 <br/>
 * 
 * @author wangyonghe
 * @version
 * @since JDK 1.7
 * @see
 */
public class UpdateBody {
    /**
     * 合作方商户编码 (必填)
     */
    private String merchantId;
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
     * 联系人名称
     */
    private String contactName;
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
    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
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

