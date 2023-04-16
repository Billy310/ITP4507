import java.util.*;
public class UndoCommand implements Command{
    Scanner sc;
    Stack undostack,redostack;
    Vector <Building> built;
    public UndoCommand(Scanner sc,Stack undostack,Stack redostack,
    Vector <Building> built){
        this.sc=sc;
        this.undostack=undostack;
        this.redostack=redostack;
        this.built=built;

    }

    public void execute(){
        if(!undostack.isEmpty()){
            Command c=(Command) undostack.pop();
            c.undo();
            redostack.push(c);

            
        }
        else{
            System.out.println("No Command can undo");
        }

    }

    public void undo(){}

    public void redo(){
    }
}