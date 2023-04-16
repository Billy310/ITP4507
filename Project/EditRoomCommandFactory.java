import java.util.*;
public class EditRoomCommandFactory implements CommandFactory{
    Scanner sc;
    Stack undostack;
    Building building;
    private Caretaker ct;

    public EditRoomCommandFactory(Scanner sc,Stack undostack,Building building,Caretaker ct){
        this.sc=sc;
        this.undostack=undostack;
        this.ct=ct;
        this.building=building;
    }   

    public Command create(){
        Command com= new EditRoomCommand(sc,building,ct);

        undostack.push(com);
        return com;

    }
}