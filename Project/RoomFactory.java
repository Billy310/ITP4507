import java.util.*;
public class RoomFactory {
    Scanner sc;
    Building building;
    public RoomFactory(Scanner sc,Building building){
    this.sc=sc;
    this.building=building;
    }
    
    public double askwidth(){
        try{

            System.out.println("Width: ");
            double id=sc.nextDouble();
            while(id>=0){

                return id;
            }
        }
        catch(InputMismatchException e){
            System.out.println("Please Input Width");
            sc.nextLine();
            return askwidth();
        }
        sc.nextLine();
        return askwidth();
    }

    public double asklength(){
        try{

            System.out.println("Length: ");
            double id=sc.nextDouble();
            while(id>=0){

                return id;
            }
        }
        catch(InputMismatchException e){
            System.out.println("Please Input Length");
            sc.nextLine();
            return  asklength();
        }
        sc.nextLine();
        return  asklength();
    }
    
public Room create(){
    
return building.addRoom(asklength(),askwidth());
        
}

   public void undo(){}
    
    public void redo(){};
}