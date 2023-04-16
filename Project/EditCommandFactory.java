import java.util.*;
public class EditCommandFactory implements CommandFactory{
private Scanner sc;
private Stack undostack;
private Vector <Building> built;
private Caretaker ct;
public EditCommandFactory(Scanner sc, Stack undostack,Vector <Building> built,Caretaker ct){
this.sc=sc;
this.undostack=undostack;
this.built=built;
this.ct=ct;
}

public Command create(){
Command com= new EditCommand(sc,undostack,built,ct);
return com;
}
}