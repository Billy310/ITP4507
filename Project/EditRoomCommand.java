import java.util.*;
public class EditRoomCommand implements Command{
    private Scanner sc;
    private Stack st;
    private Building building;
    private Room room;
    int roomnum;
    Caretaker ct;
    private ArrayList <Room> a;   

    public  EditRoomCommand(Scanner sc,Building building,Caretaker ct){
        this.sc=sc;
        this.st=st;
        this.building=building;
        this.ct=ct;
        this.room=null;
        this.roomnum=0;
        this.a=null;
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

    public double askWidth(){
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
            return askWidth();
        }
        sc.nextLine();
        return askWidth();
    }

    public double askLength(){
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
            return  askLength();
        }
        sc.nextLine();
        return  askLength();
    }

    public void execute(){
        roomnum=ask()-1;
        room=new Room(building.getRooms().get(roomnum).getLength(),
            building.getRooms().get(roomnum).getWidth());
        a=building.getRooms();
        ArrayList <Room> b = new ArrayList <Room>();
        for(int x=0;x<a.size();x++){
            b.add(new Room(a.get(x).getLength(),a.get(x).getWidth()));
        }
        ct.saveRooms(building,b);
        
        double afterl=askLength();
        double afterw=askWidth();
        
        building.getRooms().get(roomnum).setLength(afterl);
        building.getRooms().get(roomnum).setWidth(afterw); 
        room=building.getRooms().get(roomnum);

    }

    public void undo(){
        ct.undo();
        // building.getRooms().get(roomnum).setLength(beforel); 
        // building.getRooms().get(roomnum).setWidth(beforew); 
    }

    public void redo(){
        ct.redo();
        // building.getRooms().get(roomnum).setLength(afterl);
        // building.getRooms().get(roomnum).setWidth(afterw); 
    }

    public String toString(){
        return "Modify Room: "+
        building.getId()+
        "Room No."+
        (roomnum+1)+
        "  "+
        room.toString();
    }

}