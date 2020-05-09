package basis;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Location {
    private Integer x;
    private Integer y;
    private long z;
    private String name;

    Location(){
    }
    public Location(final Integer x,final Integer y, final long z, final String name){
        this.x=x;
        this.y=y;
        this.z=z;
        this.name=name;
    }
    @Override
    public String toString(){
        return "Location={x="+this.x+", y="+this.y+", z="+this.z+", name='"+this.name+'\''+"}";
    }
}
