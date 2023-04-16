import java.util.*;
public class UndoCommandFactory implements CommandFactory{
    Scanner sc;
    Stack undostack,redostack;
    Vector <Building> built;
    public UndoCommandFactory(Scanner sc,Stack undostack,Stack redostack,
    Vector <Building> built){
        this.sc=sc;
        this.undostack=undostack;
        this.redostack=redostack;
        this.built=built;

    }

    public Command create(){
        return new UndoCommand(sc,undostack,redostack,built);
    }
}