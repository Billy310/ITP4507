import java.util.*;
public abstract class Building{
    private int id;
    private ArrayList <Room> rooms;

    public Building(int id, int noOfRooms){
        this.id=id;
        this.rooms=new ArrayList<Room>(noOfRooms);

    }

    public int getId(){
        return this.id;
    }

    public ArrayList<Room> getRooms(){
        return this.rooms;
    }

    public Room addRoom(double length,double width){
        
        Room rm=new Room(length,width);
        rooms.add(rm);
        return rm;

    }

    public void modifyRoom(int roomNo, double length, double width){
        
    }

    public void deleteRoom(int roomNo){
         rooms.remove(roomNo);
    }

    public void printRoom(int roomNo){
        System.out.println("Room No.:"+(roomNo+1)+" ,Length.: "+rooms.get(roomNo).getLength()+" Width: "+rooms.get(roomNo).getWidth());
    }

    public int getRoomQty(){
        return this.rooms.size();
    }

    public abstract void modifyBuilding();

    public abstract void printBuilding();

}