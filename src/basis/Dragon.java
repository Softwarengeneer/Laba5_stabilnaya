package basis;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dragon")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dragon implements Comparable<Dragon>
{
    private Integer id;
    private String name;
    private Coordinates coordinates;
    @XmlJavaTypeAdapter(LocalDateSerializer.class)
    private LocalDate creationDate;
    private Integer age;
    private DragonType type;
    private DragonCharacter character;
    private Color color;
    private Person killer;

    public Dragon() {
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {return this.age; }

    public DragonType getDragonType() {
        return this.type;
    }

    public Color getColor() {
        return this.color;
    }

    public Dragon(final String name,
                  final Coordinates coordinates,
                  final Integer age,
                  final DragonType type,
                  final Color color,
                  final DragonCharacter character,
                  final Person killer) {
        this.id = (int)(Math.random() * 1000.0);
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDate.now();
        this.age = age;
        this.type = type;
        this.color = color;
        this.character = character;
        this.killer = killer;

    }

    @Override
    public String toString() {
        return "Dragon{id=" + this.id + ", name='" + this.name + '\'' + ", coordinates=" + this.coordinates + ", creationDate=" + this.creationDate + ", age=" + this.age + ", type=" + this.type + ", color=" + this.color + ",character="+this.character+", person=" + this.killer + '}';
    }

    @Override
    public int compareTo(final Dragon anotherDragon) {

        return 0;
    }

    public LocalDate getCreationDate() {
        return this.creationDate;
    }


    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setCoordinates(final Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(final LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
