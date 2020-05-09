package basis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Person
{
    private String name;
    private int height;
    private Color eyeColor;
    private Color hairColor;
    private Location location;

    Person() {
    }
    
    public Person(final String name,final int height, final Color hairColor, final Color eyeColor, final Location location) {
        this.name = name;
        this.height = height;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.location = location;
    }
    
    public String getName() {
        return this.name;
    }
    
    @Override
    public String toString() {
        return "killer{name='" + this.name + '\'' + ", height="+ this.height+", hairColor="+ this.hairColor+ ", eyeColor="+ this.eyeColor+"Location="+this.location+ '}';
    }
}
