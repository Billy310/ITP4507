import java.util.*;
public class ApartmentFactory implements BuildingFactory{
    Vector <Building> built;
    Scanner sc;
    private Building b;
    public ApartmentFactory(Scanner sc,Vector <Building> built){
        this.sc=sc;
        this.built=built;
        this.b=null;
    }

    public Building create(){
        
        System.out.print("Building No.:");
        int id=sc.nextInt();
        System.out.print("Monthly Rental:");
        double monthlyRental=sc.nextDouble();
        System.out.print("Support Staff: ");
        sc.nextLine();
        String supportStaff=sc.nextLine();
        System.out.print("Number of rooms: ");
        int noOfRooms=sc.nextInt();
        sc.nextLine();
         b=new Apartment(id,noOfRooms,monthlyRental,supportStaff);
         RoomFactory rf=new RoomFactory(sc,b);
        
          for(int x=1;x<=noOfRooms;x++){
            System.out.println("Room No."+x);
            rf.create();
        }
        return b;
    }
    

}