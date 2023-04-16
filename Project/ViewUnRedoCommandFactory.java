import java.util.*;
public class ViewUnRedoCommandFactory implements CommandFactory{
    Stack undostack,redostack;
    public  ViewUnRedoCommandFactory(Stack undostack,Stack redostack){

        this.undostack=undostack;
        this.redostack=redostack;
   
    }

    public Command create(){
        Command com= new ViewUnRedoListCommand(undostack,redostack);
        return com;
    }
}