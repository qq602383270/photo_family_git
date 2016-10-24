package cn.photofamily.core.commons.utils;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * ClassName:XMLUtils <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年9月7日 上午10:41:56 <br/>
 * 
 * @author wangyonghe
 * @version
 * @since JDK 1.7
 * @see
 */
public class XMLUtils {
    public static String beanToXML(Object obj, String encoding) {

        try {
            StringWriter writer = new StringWriter();
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
           // marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);  
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);  
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.FALSE);  
            marshaller.marshal(obj,writer);
            return writer.toString().replace("standalone=\"yes\"", "");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @SuppressWarnings("unchecked")
    public static <T> T XMLToBean(String xmlStr, Class<?> clazz) {
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new StringReader(xmlStr));

        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }

    }

}

