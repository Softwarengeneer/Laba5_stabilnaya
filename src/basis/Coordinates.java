// 
// Decompiled by Procyon v0.5.36
// 

package basis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Coordinates
{
    private Long x;
    private Float y;
    
    public Coordinates(final Long x, final Float y) {
        this.x = x;
        this.y = y;
    }
    
    Coordinates() {
    }
    
    public Long getX() {
        return this.x;
    }
    
    public Float getY() {
        return this.y;
    }
    
    @Override
    public String toString() {
        return "[x=" + this.getX() + ", y=" + this.getY() + "]";
    }
}
