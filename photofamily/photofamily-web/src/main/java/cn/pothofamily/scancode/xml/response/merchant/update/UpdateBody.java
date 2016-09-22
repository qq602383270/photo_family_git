package cn.pothofamily.scancode.xml.response.merchant.update;

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
     * 银行商户编码 (必填)
     */
    private String merchantCode;
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
    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
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

