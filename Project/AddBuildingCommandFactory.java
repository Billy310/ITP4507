import java.util.*;
public class AddBuildingCommandFactory implements CommandFactory{
    private Scanner sc;
    private Stack undostack;
    private Vector <Building> built;
    public AddBuildingCommandFactory(Scanner sc,Stack undostack,Vector <Building> built){
        this.sc=sc;
        this.undostack=undostack;
        this.built=built;

    }

    public Command create(){
        Command com= new AddBuildingCommand(sc,built);
        undostack.push(com);
        return com;

    }
}