import java.util.*;
public class ModifyBuildingCommandFactory implements CommandFactory{
    Stack undostack;
    Scanner sc;
    Vector <Building> built;
    private Caretaker ct;
    public ModifyBuildingCommandFactory(Scanner sc, Stack undostack,Vector <Building> built,Caretaker ct){
        this.sc=sc;
        this.undostack=undostack;
        this.built=built;
        this.ct=ct;
    }
    public Command create(){
        Command com= new ModifyBuildingCommand(sc,built,ct);
        this.undostack.push(com);
        return com;
    }
}