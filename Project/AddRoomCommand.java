import java.util.*;
public class AddRoomCommand implements Command{
    Scanner sc;
    Stack st;
    Building building;
    Room backuproom;
    int roomnum;
    private Caretaker ct;
    public  AddRoomCommand(Scanner sc,Building building,Caretaker ct){
        this.ct=ct;
        this.sc=sc;
        this.st=st;
        this.building=building;
        this.backuproom=null;
        this.roomnum=0;
    }


    public  void execute(){
        ArrayList <Room> existarraylist=building.getRooms();
        ArrayList <Room> backuparraylist = new ArrayList <Room>();
        for(int x=0;x<existarraylist.size();x++){
            backuparraylist.add(new Room(existarraylist.get(x).getLength(),existarraylist.get(x).getWidth()));
        }
        ct.saveRooms(building,backuparraylist);

        RoomFactory rf= new RoomFactory(sc,building);
        Room newroom=rf.create();
        backuproom=new Room(newroom.getLength(),
            newroom.getWidth());
        roomnum=building.getRoomQty()-1;
    }

    public void undo(){
        ct.undo();
    }

    public void redo(){
        ct.redo();
    }

    public String toString(){
        return 
        "Add Room:"+
        "Building No. "+
        building.getId()+
        ", "+
        " Room No. "+
        roomnum+
        ", "+
        backuproom;

    }
}