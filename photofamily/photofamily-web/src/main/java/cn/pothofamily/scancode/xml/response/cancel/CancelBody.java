package cn.pothofamily.scancode.xml.response.cancel;

import javax.xml.bind.annotation.XmlElement;

/**
 * ClassName:CancelBody <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年9月11日 上午10:44:29 <br/>
 * 
 * @author wangyonghe
 * @version
 * @since JDK 1.7
 * @see
 */
public class CancelBody {
    /**
     * 对账日期
     */
    private String settleDate;
    /**
     * 清算撤销标识 0正常清算-1发生撤销，渠道不产生退款
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

