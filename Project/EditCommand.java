import java.util.*;

public class EditCommand implements Command{
    private Scanner sc;
    private Stack undostack;
    private Vector <Building> built;
    private Building building;
    private Caretaker ct;
    public EditCommand(Scanner sc, Stack undostack,Vector <Building> built,Caretaker ct){
        this.sc=sc;
        this.undostack=undostack;
        this.built=built;
        this.building=null;
        this.ct=ct;
    }

    public int check(){
        sc.nextLine();
        System.out.println("Please enter command: [a|d|m]");   
        String [] anslist={"a","d","m"};
        String reply=sc.nextLine();
        int len=anslist.length;
        for (int x=0; x<anslist.length;x++){
            if(anslist[x].equals(reply)){
                return x;
            }
        }
        System.out.println("Invaild Value. Please Enter Again");
        return check();
    }

    public int ask(){
        try{

            System.out.print("Building No. : ");
            int id=sc.nextInt();
            while(id>=0){

                return id;
            }
        }
        catch(InputMismatchException e){
            System.out.println("Please Input Building No. Only");
            sc.nextLine();
            return ask();
        }
        return ask();
    }

    public Building getbuilding(int bnum){
        for(int x=0;x<built.size();x++){
            if(bnum==built.get(x).getId()){
                System.out.println(built.get(x).toString());
                for(int y=0;y<built.get(x).getRoomQty();y++){
                    built.get(x).printRoom(y);
                }
                return built.get(x);
            }
        }
        System.out.println("No existed Result. Please try again");
        return getbuilding(ask());
    }

    public void execute(){
        Building building=getbuilding(ask());
        CommandFactory cf[]=new CommandFactory[3];
        cf[0]=new AddRoomCommandFactory(sc,undostack,building,ct);
        cf[1]=new DeleteRoomCommandFactory(sc,undostack,building,ct);
        cf[2]=new EditRoomCommandFactory(sc,undostack,building,ct);
        Command com=cf[check()].create();
        com.execute();
        System.out.println("Updated Building:");
        System.out.println(building.toString());
        sc.nextLine();
        for(int y=0;y<building.getRoomQty();y++){
            building.printRoom(y);
        }

    }

    public void undo(){}

    public void redo(){}
}