import java.util.*;
public class ViewUnRedoListCommand implements Command{
    Stack undostack,redostack;


    public  ViewUnRedoListCommand(Stack undostack,Stack redostack){
        this.undostack=undostack;

        this.redostack=redostack;

    }

    public void execute(){
        System.out.println("Undo List");
        if(!undostack.isEmpty()){
            int undostacksize=undostack.size()-1;
            for(int x=undostacksize;x>-1;x--){
                System.out.println(undostack.get(x));    }
        }
        System.out.println("Redo List");
        if(!redostack.isEmpty()){
            int redostacksize=redostack.size()-1;
            for(int x=redostacksize;x>-1;x--){
                System.out.println(redostack.get(x));    }
        }
     
    }

    public void undo(){}

    public void redo(){}
}