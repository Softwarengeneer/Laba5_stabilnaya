// 
// Decompiled by Procyon v0.5.36
// 

package collection;

import basis.Dragon;
import exception.IncorrectValue;
import java.io.IOException;
import java.io.FileNotFoundException;
import exception.NoArgument;
import input.IOInterface;

public class CommandHandler
{
    private final DragonCollection dragon;
    CollectionManager manager;
    CommandReader reader;
    private String[] rightCommand;
    
    public CommandHandler(final DragonCollection dragon, final String file) {
        this.reader = new CommandReader();
        this.dragon = dragon;
        this.manager = new CollectionManager(dragon, file);
    }
    
    public void doCommand(final IOInterface inputCommand) throws IOException, IncorrectValue, NoArgument {
        this.rightCommand = this.reader.returnCommand(inputCommand);
        final String s = this.rightCommand[0];
        switch (s) {
            case "": {
                break;
            }
            case "help": {
                this.manager.help();
                break;
            }
            case "info": {
                this.manager.info();
                break;
            }
            case "show": {
                this.manager.show();
                break;
            }
            case "add": {
                this.manager.add(inputCommand);
                break;
            }
            case "update": {
                try {
                    if (this.rightCommand.length < 2) {
                        throw new NoArgument("ID то введи, всему учить надо...");
                    }
                    this.manager.update(Integer.parseInt(this.rightCommand[1]), inputCommand);
                }
                catch (NoArgument e) {
                    e.getMessage();
                }
                catch (NumberFormatException e3) {
                    System.out.println("а число где? ты дурной?");
                }
                break;
            }
            case "remove_by_id": {
                try {
                    if (this.rightCommand.length < 2) {
                        throw new NoArgument("");
                    }
                    this.manager.removeById(Integer.parseInt(this.rightCommand[1]));
                }
                catch (NoArgument e) {
                    e.getMessage();
                }
                catch (NumberFormatException e3) {
                    System.out.println("а число где? ты дурной?");
                }
                catch (Exception e2) {
                    System.out.println("Такого дракона нема");
                }
                break;
            }
            case "clear": {
                this.manager.clear();
                break;
            }
            case "exit": {
                System.exit(0);
                break;
            }
            case "save": {
                try {
                    this.manager.save();
                }
                catch (Exception e2) {
                    System.out.println("\u041d\u0435 \u043c\u043e\u0433\u0443 \u0441\u043e\u0445\u0440\u0430\u043d\u0438\u0442\u044c:" + e2.getMessage());
                }
                break;
            }
            case "execute_script": {
                try {
                    if (this.rightCommand.length < 2) {
                        throw new NoArgument("А имя за тебя мама вводить будет?");
                    }
                    this.manager.executeScript(this.rightCommand[1]);
                }
                catch (NoArgument e) {
                    e.getMessage();
                }
                catch (FileNotFoundException e4) {
                    System.out.println("Этого файла не завезли");
                }
                break;
            }


            case "sort": {
                this.manager.sort();
                break;
            }


            default: {
                System.out.println("Ты попутал, такой команды не добавили");
                break;
            }
        }
    }
}
