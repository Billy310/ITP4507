import java.util.*;
public class DisplayCommandFactory implements CommandFactory{
    private Scanner sc;
    private Vector <Building> built;
    public DisplayCommandFactory(Scanner sc,Vector <Building> built){

        this.sc=sc;
        this.built=built;
    }

    public Command create(){
        Command com= new DisplayCommand(sc,built);
        return com;
    }
}