
package basis;

import java.time.LocalDate;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateSerializer extends XmlAdapter<String, LocalDate>
{
    public LocalDate unmarshal(final String v) throws Exception {
        return LocalDate.parse(v);
    }
    
    public String marshal(final LocalDate v) throws Exception {
        return v.toString();
    }
}
