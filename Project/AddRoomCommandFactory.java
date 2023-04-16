import java.util.*;
public class AddRoomCommandFactory implements CommandFactory{
    Scanner sc;
    Stack undostack;
private Caretaker ct;
    Building building;

    public AddRoomCommandFactory(Scanner sc,Stack undostack,Building building,Caretaker ct){
        this.sc=sc;
        this.undostack=undostack;
        this.ct=ct;
        this.building=building;
    }   

    public Command create(){
        Command com=new AddRoomCommand(sc,building,ct);
         
        undostack.push(com);
        return com;

    }

}