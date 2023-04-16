import java.util.*;
public class RoomsMemento implements Memento {

    private  ArrayList <Room> room;
    private Building building;

    public RoomsMemento(Building building,ArrayList <Room> room){
        this.room=room;
        this.building=building;
    }
    
    public void setRooms(ArrayList <Room> cp){
       
        this.room=cp;
        
    }

    public void restore(){
        ArrayList<Room> cp=new ArrayList<Room>();
        ArrayList<Room> now=building.getRooms();
        for(int x=0;x<now.size();x++){
        cp.add(new Room(now.get(x).getLength(),now.get(x).getWidth()));
        }
        
        building.getRooms().clear();
        for(int x=0;x<room.size();x++){
        building.addRoom(room.get(x).getLength(),room.get(x).getWidth());
        }
        setRooms(cp);
    }
}
