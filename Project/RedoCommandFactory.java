import java.util.*;
public class RedoCommandFactory implements CommandFactory{

Scanner sc;
    Stack undostack,redostack;
    Vector <Building> built;
    public  RedoCommandFactory(Scanner sc,Stack undostack,Stack redostack,
    Vector <Building> built){
        this.sc=sc;
        this.undostack=undostack;
        this.redostack=redostack;
        this.built=built;

    }

    public Command create(){
        return new RedoCommand(sc,undostack,redostack,built);
    }
}