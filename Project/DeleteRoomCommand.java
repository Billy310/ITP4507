import java.util.*;
public class DeleteRoomCommand implements Command{
    private Scanner sc;
    private Stack st;
    private Building building;
    private Room backuproom;
    private int roomnum;
    private ArrayList <Room> backuprooms;    
    private Caretaker ct;

    public  DeleteRoomCommand(Scanner sc,Building building,Caretaker ct){
        this.sc=sc;
        this.st=st;
        this.building=building;
        this.backuproom=null;
        this.roomnum=0;
        this.backuprooms=null;
        this.ct=ct;
    }

    public int ask(){
        try{

            System.out.print("Room No.:  ");
            int id=sc.nextInt();
            while(id>=0){

                return id;
            }
        }
        catch(InputMismatchException e){
            System.out.println("Please Input Vaild Room No.:");
            sc.nextLine();
            return ask();
        }
        return ask();
    }

    public void execute(){
        backuprooms=building.getRooms();
        ArrayList <Room> b = new ArrayList <Room>();
        for(int x=0;x<backuprooms.size();x++){
            b.add(new Room(backuprooms.get(x).getLength(),backuprooms.get(x).getWidth()));
        }
        ct.saveRooms(building,b);
        roomnum=ask();
        roomnum-=1;
        backuproom=new Room(building.getRooms().get(roomnum).getLength(),
            building.getRooms().get(roomnum).getWidth());
        building.deleteRoom(roomnum);
    }

    public void undo(){
        ct.undo();
    }

    public void redo(){
        ct.redo();
    }

    public String toString(){
        return "Delete Room: "+
        building.getId()+
        "Room No."+
        (roomnum+1)+
        "  "+
        backuproom;
    }

}