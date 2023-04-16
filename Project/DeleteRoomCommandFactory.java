import java.util.*;
 class DeleteRoomCommandFactory implements CommandFactory{
    private Scanner sc;
    private Stack undostack;
    private Building building;
    private Caretaker ct;


    public DeleteRoomCommandFactory(Scanner sc,Stack undostack,Building building,Caretaker ct){
        this.sc=sc;
        this.undostack=undostack;
        this.building=building;
        this.ct=ct;
    }   
    public Command create(){

    Command com= new DeleteRoomCommand(sc,building,ct);
    undostack.push(com);
    return com;
    
    }
}