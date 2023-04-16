import java.util.*;
public class AddBuildingCommand implements Command{
    private Scanner sc;
    private Vector <Building> built; 
    private Building displaybuilding;
    private Building nowbuilding;

    public AddBuildingCommand(Scanner sc,Vector <Building> built){
        this.sc=sc;

        this.built=built;
        this.displaybuilding=null;
    }

    public int check(){
        System.out.print("Enter Building Type (a=Apartment/h=House):");   
        String [] anslist={"a","h"};
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

    public void execute(){
        ArrayList <Building> a=new ArrayList<Building> ();
        BuildingFactory [] builds= new BuildingFactory[2];
        builds[0]=new ApartmentFactory(sc,built);
        builds[1]=new HouseFactory(sc,built);
        Building created=builds[check()].create();
        // buildingid=created.getId();
        built.add(created);
        nowbuilding=created;

        sc.nextLine();
        if(created instanceof Apartment){
            Apartment b_ap=(Apartment)created;
            displaybuilding=new Apartment(b_ap.getId(),b_ap.getRoomQty(),b_ap.getMonthlyRental(),b_ap.getSupportStaff());
            // monthlyrental=b_ap.getMonthlyRental();
            // supportstaff=b_ap.getSupportStaff();
        }
        if(created instanceof House){
            House b_ho=(House)created;
            displaybuilding=new House(b_ho.getId(),b_ho.getRoomQty(),b_ho.getFloors());
            // floors=b_ho.getFloors();

        }

        System.out.println("New Building Added:");
        created.printBuilding();
        for(int x=0;x<created.getRoomQty();x++){
            created.printRoom(x);
        }

    }

    public String toString(){
        return "Add Building: "+displaybuilding;
    }

    public void undo(){
        if(built!=null){
            built.remove(nowbuilding);
        }
    }

    public void redo(){
        built.add(nowbuilding);}
}