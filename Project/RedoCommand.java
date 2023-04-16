import java.util.*;
public class RedoCommand implements Command{
    Scanner sc;
    Stack undostack,redostack;
    Vector <Building> built;
    public RedoCommand(Scanner sc,Stack undostack,Stack redostack,
    Vector <Building> built){
        this.sc=sc;
        this.undostack=undostack;
        this.redostack=redostack;
        this.built=built;

    }

    public void execute(){
        if(!redostack.isEmpty()){
            Command c=(Command) redostack.pop();
            c.redo();
            undostack.push(c);
        }
        else{
            System.out.println("No Command can redo");
        }

    }

    public void undo(){
    
    }

    public void redo(){}
}