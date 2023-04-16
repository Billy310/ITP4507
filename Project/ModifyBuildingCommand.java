import java.util.*;
public class ModifyBuildingCommand implements Command{
    Scanner sc;
    Vector <Building> built;
    private Building building;
    private Caretaker ct;

    public ModifyBuildingCommand(Scanner sc,
    Vector <Building> built,Caretaker ct){
        this.sc=sc;
        this.built=built;
        this.building=null;
        this.ct=ct;
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
        sc.nextLine();
        return ask();
    }

    public double askMonthly(){
        try{

            System.out.print("Modify Monthly Rental: ");
            double id=sc.nextDouble();
            while(id>=0){

                return id;
            }
        }
        catch(InputMismatchException e){
            System.out.print("Please Input Monthly Rental Only");
            sc.nextLine();
            return askMonthly();
        }
        sc.nextLine();
        return askMonthly();
    }

    public int asknoOfFloors(){
        try{

            System.out.println("No. of Floors: ");
            int id=sc.nextInt();
            while(id>=0){

                return id;
            }
        }
        catch(InputMismatchException e){
            System.out.println("Please Input Monthly Rental Only");
            sc.nextLine();
            return asknoOfFloors();
        }
        sc.nextLine();
        return asknoOfFloors();
    }

    public String askSupportStaff(){
        sc.nextLine();      
        System.out.print("Modify Support Staff: ");
        String staff=sc.nextLine();
        return staff;

    }

    public void execute(){
        int bnum=ask();
        for(int x=0;x<built.size();x++){
            if(bnum==built.get(x).getId()){
                Vector <Building> copy=new Vector<Building>();
                Building target=built.get(x);
                building=target;

                System.out.println(built.get(x).toString());
                if(built.get(x) instanceof Apartment){
                    Apartment apartment =(Apartment)target;
                    apartment.setMonthlyRental(askMonthly());
                    apartment.setSupportStaff(askSupportStaff());

                    copy.add(new 
                        Apartment(apartment.getId(),
                            apartment.getRoomQty(),
                            apartment.getMonthlyRental(),
                            apartment.getSupportStaff()));
                }
                else if(built.get(x) instanceof House){
                    House house=(House)target;
                    house.setFloors(asknoOfFloors());
                    copy.add(new 
                        House(house.getId(),
                            house.getRoomQty(),
                            house.getFloors()));
                }
                ct.saveBuilding(copy.lastElement(),target);
                System.out.println("Building is modified:");
                System.out.println(copy.lastElement());
                break;
            }

        }
    }

    public void undo(){
        ct.undo();

        // if(building instanceof Apartment){
        // Apartment apartment=(Apartment) building;
        // double newmonthlyRental=apartment.getMonthlyRental();
        // String newsupportStaff=apartment.getSupportStaff();
        // apartment.setMonthlyRental(monthlyRental);
        // apartment.setSupportStaff(supportStaff);
        // monthlyRental=newmonthlyRental;
        // supportStaff=newsupportStaff;
        // }
        // if(building instanceof House){
        // House house=(House)building;
        // int newfloors=house.getFloors();
        // house.setFloors(floors);
        // floors=newfloors;

        // }

    }

    public void redo(){
        ct.redo();
        // if(building instanceof Apartment){

        // Apartment apartment=(Apartment) building;
        // double oldmonthlyRental=apartment.getMonthlyRental();
        // String oldsupportStaff=apartment.getSupportStaff();
        // apartment.setMonthlyRental(monthlyRental);
        // apartment.setSupportStaff(supportStaff);
        // supportStaff=oldsupportStaff;
        // monthlyRental=oldmonthlyRental;
        // }
        // if(building instanceof House){
        // House house=(House)building;
        // int newfloors=house.getFloors();
        // house.setFloors(floors);
        // floors=newfloors;    
        // }

    }

    public String toString(){

        return "Modify Building:"+building.toString();
    }
}