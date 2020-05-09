// 
// Decompiled by Procyon v0.5.36
// 

package collection;

import java.util.Comparator;
import java.util.Collections;

import basis.*;
import exception.NoArgument;
import input.FileInput;
import java.io.IOException;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.Writer;
import javax.xml.bind.JAXBContext;
import java.io.FileWriter;
import exception.IncorrectValue;
import basis.DragonType;
import input.IOInterface;

public class CollectionManager
{
    private String file;
    private DragonCollection dragon;
    public CommandHandler handler;
    
    public CollectionManager(final DragonCollection dragon, final String file) {
        this.dragon = dragon;
        this.file = file;
    }
    
    public void help() {
        System.out.println("help: Вывести справку по доступным командам" +
                " \ninfo: Вывести информацию о коллекции " +
                "\nadd: Добавить новый элемент в коллекцию " +
                "\nupdate id: Обновить значение элемента коллекции, id которого равен заданному"+
                "\n update_by_id {element}: обновить значение элемента коллекции по id"+
                "\n remove_by_id id: Удалить элемент из коллекции по его id"+
                "\n clear: Очистить коллекцию"+
                "\n save: Сохранить коллекцию в файл"+
                "\n execute_script file_name: Считать и исполнить скрипт из указанного файла"+
                " \n exit: Завершить программу (без сохранения в файл)"+
                " \n remove_first: Удалить из коллекции первый элемент"+
                "\n head: вывести первый элемент коллекции" +
                "\n history: вывести последние 9 команд"+
                "\n sum_of_age: вывести сумму значений поля для всех элементов коллекции"+
                "\n filter_by_type: вывести элементы, значение поля type которых равно заданному"+
                "\n filter_contains_name name: вывести элементы, значение поля name которых имеет заданную подстроку");
    }
    
    public void info() {
        System.out.println(this.dragon.toString());
    }
    
    public void show() {
        if (this.dragon.getDragons().size() != 0) {
            this.dragon.getDragons().forEach(value -> System.out.println(value));
        }
        else {
            System.out.println("Коллекция пуста.");
        }
    }
    
    public Dragon readElement(final IOInterface command) throws IncorrectValue {
        Dragon h = null;
        DragonType type = null;
        Color color = null;
        DragonCharacter character = null;
        Color eyeColor = null;
        Color hairColor = null;
        try {
            // ИМЯ ДРАКОНА
            String name;
            do {
                command.output("Я хочу от тебя имя дракоши");
                name = command.getNextInput().trim();
            } while (name.equals(""));
            // КООРДИНАТА X
            long x = 0L;
            do {
                command.output("Куда засунешь дракона?, x:");
                final String x2 = command.getNextInput().trim();
                if (x2.matches("[-+]?\\d+")) {
                    x = Long.parseLong(x2);
                    if (x >= -181L) {
                        continue;
                    }
                    x = 0L;
                    System.out.println(" -671");
                }
            } while (x == 0L);
            //КООРДИНАТА Y
            float y = 0.0f;
            String y2;
            do {
                command.output("y:");
                y2 = command.getNextInput();
                if (y2.matches("((-|\\\\+)?[0-9]+(\\\\.[0-9]+)?)+")) {
                    y = Float.parseFloat(y2);
                    if (y <= 649.0f) {
                        continue;
                    }
                    y = 0.0f;
                    System.out.println(" y - 649");
                }
            } while (y == 0.0f);
            //ВОЗРАСТ ДРАКОНА
            Integer age = -1;
            do {
                command.output("Че там по возрасту скажешь?:");
                final String age2 = command.getNextInput();
                if (age2.matches("[-+]?\\d+")) {
                    age = Integer.parseInt(y2);
                }
            } while (age == -1);
            // ТИП ДРАКОНА
            String answer3;
            do {
                command.output("Выбери какой у тебя тип дракона underground, air или water?");
                final String trim;
                answer3 = (trim = command.getNextInput().trim());
                switch (trim) {
                    case "underground": {
                        type = DragonType.UNDERGROUND;
                        continue;
                    }
                    case "water": {
                        type = DragonType.WATER;
                        continue;
                    }
                    case "air": {
                        type = DragonType.AIR;
                        continue;
                    }

                    case "": {
                        type = null;
                        continue;
                    }
                    default: {
                        command.output("Не получилось, не фартануло, такого варианта как раз не завезли(");
                        continue;
                    }
                }
            } while (!answer3.toLowerCase().equals("water") && !answer3.toLowerCase().equals("air") && !answer3.toLowerCase().equals("underground") && !answer3.equals(""));
            //ЦВЕТ ДРАКОНА
            String answer4;
            do {
                command.output("Так, а эт самое, цвет то у дракона какой хочешь? WHITE, RED, BROWN, BLUE, ORANGE");
                final String trim2;
                answer4 = (trim2 = command.getNextInput().trim());
                switch (trim2) {
                    case "red": {
                        color = Color.RED;
                        continue;
                    }
                    case "white": {
                        color = Color.WHITE;
                        continue;
                    }
                    case "brown": {
                        color = Color.BROWN;
                        continue;
                    }
                    case "blue": {
                        color = Color.BLUE;
                        continue;
                    }
                    case "orange":{
                        color = Color.ORANGE;
                        continue;

                    }
                    case "": {
                        color = null;
                        continue;
                    }
                    default: {
                        command.output("Не получилось, не фартануло, такого варианта как раз не завезли(");
                        continue;
                    }
                }
            } while (!answer4.toLowerCase().equals("orange") && !answer4.toLowerCase().equals("blue") && !answer4.toLowerCase().equals("red") && !answer4.toLowerCase().equals("white")&& !answer4.toLowerCase().equals("brown") && !answer4.equals(""));
            // ХАРАКТЕР ДРАКОНА
            String answer5;
            do {
                command.output("Так, остался характер, вращай барабан: CHAOTIC, CUNNING, EVIL, FICKLE, WISE");
                final String trim3;
                answer5 = (trim3 = command.getNextInput().trim());
                switch (trim3) {
                    case "chaotic": {
                        character = DragonCharacter.CHAOTIC;
                        continue;
                    }
                    case "cunning": {
                        character = DragonCharacter.CUNNING;
                        continue;
                    }
                    case "evil": {
                        character = DragonCharacter.EVIL;
                        continue;
                    }
                    case "fickle": {
                        character = DragonCharacter.FICKLE;
                        continue;
                    }
                    case "wise":{
                        character = DragonCharacter.WISE;
                        continue;

                    }
                    case "": {
                        color = null;
                        continue;
                    }
                    default: {
                        command.output("Не получилось, не фартануло, такого варианта как раз не завезли(");
                        continue;
                    }
                }
            } while (!answer5.toLowerCase().equals("wise") && !answer5.toLowerCase().equals("fickle") && !answer5.toLowerCase().equals("evil") && !answer5.toLowerCase().equals("cunning") && !answer5.toLowerCase().equals("chaotic") && !answer5.equals(""));
            //ИМЯ КИЛЛЕРА
            command.output("Теперь шо касается Киллера, обзови его как нибудь:");
            final String nameOfPerson = command.getNextInput().trim();
            //РОСТ КИЛЛЕРА
            int height = 0;
            do {
                command.output("А чего там по росту киллера?:");
                final String Height = command.getNextInput().trim();
                if (Height.matches("[-+]?\\d+")) {
                    height = Integer.parseInt(Height);
                    if (height >= -671L) {
                        continue;
                    }
                    height = 0;
                    System.out.println(" -671");
                }
            } while (height == 0);
            //ЦВЕТ ГЛАЗ
            String answer6;
            do {
                command.output("Так, а эт самое, цвет глаз какой хочешь? WHITE, RED, BROWN, BLUE, ORANGE");
                final String trim4;
                answer6 = (trim4 = command.getNextInput().trim());
                switch (trim4) {
                    case "red": {
                        eyeColor =eyeColor.RED;
                        continue;
                    }
                    case "white": {
                        eyeColor = eyeColor.WHITE;
                        continue;
                    }
                    case "brown": {
                        eyeColor = eyeColor.BROWN;
                        continue;
                    }
                    case "blue": {
                        eyeColor = eyeColor.BLUE;
                        continue;
                    }
                    case "orange":{
                        eyeColor = eyeColor.ORANGE;
                        continue;

                    }
                    case "": {
                        eyeColor = null;
                        continue;
                    }
                    default: {
                        command.output("Не получилось, не фартануло, такого варианта как раз не завезли(");
                        continue;
                    }
                }
            } while (!answer6.toLowerCase().equals("orange") && !answer6.toLowerCase().equals("blue") && !answer6.toLowerCase().equals("red") && !answer6.toLowerCase().equals("white")&& !answer6.toLowerCase().equals("brown") && !answer6.equals(""));
            //ЦВЕТ ВОЛОС
            String answer7;
            do {
                command.output("Так, а эт самое, цвет волос какой хочешь? WHITE, RED, BROWN, BLUE, ORANGE");
                final String trim1;
                answer7 = (trim1 = command.getNextInput().trim());
                switch (trim1) {
                    case "red": {
                        hairColor = hairColor.RED;
                        continue;
                    }
                    case "white": {
                        hairColor = hairColor.WHITE;
                        continue;
                    }
                    case "brown": {
                        hairColor = hairColor.BROWN;
                        continue;
                    }
                    case "blue": {
                        hairColor = hairColor.BLUE;
                        continue;
                    }
                    case "orange":{
                        hairColor = hairColor.ORANGE;
                        continue;

                    }
                    case "": {
                        hairColor = null;
                        continue;
                    }
                    default: {
                        command.output("Не получилось, не фартануло, такого варианта как раз не завезли(");
                        continue;
                    }
                }
            } while (!answer7.toLowerCase().equals("orange") && !answer7.toLowerCase().equals("blue") && !answer7.toLowerCase().equals("red") && !answer7.toLowerCase().equals("white")&& !answer7.toLowerCase().equals("brown") && !answer7.equals(""));

            command.output("Где там твой гангстер обитает?:");
            final String nameOfLocation = command.getNextInput().trim();

            Integer xl = -1;
            do {
                command.output("Че там по X?:");
                final String xxl = command.getNextInput();
                if (xxl.matches("[-+]?\\d+")) {
                    xl = Integer.parseInt(xxl);
                }
            } while (xl == -1);


            Integer yl = -1;
            do {
                command.output("Че там по Y?:");
                final String yyl = command.getNextInput();
                if (yyl.matches("[-+]?\\d+")) {
                    yl = Integer.parseInt(yyl);
                }
            } while (yl == -1);

            long zl = 0L;
            do {
                command.output("А по Z?");
                final String zzl = command.getNextInput().trim();
                if (zzl.matches("[-+]?\\d+")) {
                    zl = Long.parseLong(zzl);
                    if (zl >= -671L) {
                        continue;
                    }
                    zl = 0L;
                    System.out.println(" -671");
                }
            } while (zl == 0L);



            h = new Dragon(name, new Coordinates(x, y), age, type, color, character, new Person(nameOfPerson, height, eyeColor, hairColor, new Location( xl, yl, zl, nameOfLocation) ));
        }
        catch (NullPointerException e) {
            System.out.println("Вот ты балбес, проверь скрипт");
        }
        return h;
    }
    
    public void add(final IOInterface c) throws IncorrectValue {
        this.dragon.getDragons().add(this.readElement(c));
    }
    
    public void update(final int id, final IOInterface c) throws IncorrectValue {
        int k = 0;
        for (int i = 0; i < this.dragon.getDragons().size(); ++i) {
            if (this.dragon.getDragons().get(i).getId() == id) {
                ++k;
            }
        }
        if (k > 0) {
            final Dragon h = this.readElement(c);
            for (int j = 0; j < this.dragon.getDragons().size(); ++j) {
                if (this.dragon.getDragons().get(j).getId() == id) {
                    System.out.println(this.dragon.getDragons().get(j).toString());
                    this.dragon.getDragons().remove(j);
                    h.setId(id);
                    this.dragon.getDragons().add(h);
                }
            }
            System.out.println("\u042d\u043b\u0435\u043c\u0435\u043d\u0442 \u043a\u043e\u043b\u043b\u0435\u043a\u0446\u0438\u0438 \u043e\u0431\u043d\u043e\u0432\u043b\u0435\u043d.");
        }
        else {
            System.out.println("\u0422\u0430\u043a\u043e\u0433\u043e id \u043d\u0435\u0442");
        }
    }
    
    public void removeById(final int id) {
        int k = 0;
        for (int i = 0; i < this.dragon.getDragons().size(); ++i) {
            if (this.dragon.getDragons().get(i).getId() == id) {
                ++k;
            }
        }
        if (k > 0) {
            for (int i = 0; i < this.dragon.getDragons().size(); ++i) {
                if (this.dragon.getDragons().get(i).getId() == id) {
                    this.dragon.getDragons().remove(i);
                }
            }
            System.out.println("А вот такого ID не завезли");
        }
        else {
            System.out.println("и был таков");
        }
    }
    
    public void clear() {
        this.dragon.getDragons().clear();
        System.out.println("О нет, драконов больше нет(");
    }
    
    public void save() throws JAXBException, IOException {
        final FileWriter writer = new FileWriter(this.file);
        final JAXBContext context1 = JAXBContext.newInstance(new Class[] { DragonCollection.class });
        final Marshaller marshaller = context1.createMarshaller();
        marshaller.marshal((Object)this.dragon, (Writer)writer);
        marshaller.marshal((Object)this.dragon, new File(this.file));
        System.out.println("Сохранилось!");
        writer.close();
    }
    
    public void executeScript(final String fileName) throws IOException, IncorrectValue, NoArgument {
        final CommandHandler handler = new CommandHandler(this.dragon, this.file);
        final FileInput input = new FileInput(fileName);
        try {
            while (input.getNextInput() != null) {
                if (input.getCurrentInput().equals("execute_script " + fileName)) {
                    throw new IncorrectValue("укажи нормально файл");
                }
                handler.doCommand(input);
            }
        }
        catch (IncorrectValue e) {
            e.getMessage();
        }
    }


    
    public void sort() {
        final Comparator<Dragon> comparator = Comparator.comparing(obj -> obj.getName());
        Collections.sort(this.dragon.getDragons(), comparator);
        System.out.println("Сортировка удалась, а твоя жизнь нет");
    }

}
