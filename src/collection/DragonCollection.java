
package collection;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import basis.Dragon;

import java.util.LinkedList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dragonLife")
@XmlAccessorType(XmlAccessType.FIELD)
public class DragonCollection
{
    @XmlElement(name = "dragon")
    public LinkedList<Dragon> dragon;
    private Date date;
    
    public LinkedList<Dragon> getDragons() {
        return this.dragon;
    }
    
    public LinkedList<Dragon> getCollection() {
        return this.dragon;
    }
    
    public DragonCollection(final LinkedList<Dragon> dragon) {
        this.dragon = dragon;
        this.date = new Date();
    }
    
    public DragonCollection() {
    }
    
    @Override
    public String toString() {
        return "Тип коллекции: " + this.getCollection().getClass() +
                "\nДата инициализации: " + date +
                "\nКоличество элементов: " + this.getCollection().size();
    }
    
    public void setDate(final Date date) {
        this.date = date;
    }
}
