import java.util.*;
public class HouseFactory implements BuildingFactory{
    Vector <Building> built;
    Scanner sc;
    private Building b;
    public HouseFactory(Scanner sc,Vector <Building> built){
        this.sc=sc;
  
        this.built=built;
        this.b=null;

    }

    public Building create(){
        System.out.print("Building No.:");
        int id=sc.nextInt();
        System.out.print("No. of Floors:");
        int floor=sc.nextInt();

        System.out.print("Number of rooms: ");
        int noOfRooms=sc.nextInt();
        Building house=new House(id,noOfRooms,floor);
        b=(Building)house;
         RoomFactory rf=new RoomFactory(sc,b);
        
          for(int x=1;x<=noOfRooms;x++){
            System.out.println("Room No."+x);
            rf.create();
        }

        return b;

    }


}