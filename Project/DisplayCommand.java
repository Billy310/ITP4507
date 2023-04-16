import java.util.*;
public class DisplayCommand implements Command{
    private Scanner sc;
    private Vector <Building> built;
    private boolean haverecord=false;

    public DisplayCommand(Scanner sc,Vector <Building> built){
        this.sc=sc;
        this.built=built;
    }

    public void execute(){
        try{
            System.out.print("Enter Building No. (* to display all)");
            String reply=sc.nextLine();

            if(reply.equals("*")){
                if(!built.isEmpty()){
                    for(int y=0;y<built.size();y++){
                        //built.get(y).printBuilding();
                        System.out.println(built.get(y).toString());

                    }
                    return;
                }
                else{
                    System.out.println("No Result.");
                }
            }
            else{
                for(int x=0;x<built.size();x++){
                    if(Integer.parseInt(reply)==built.get(x).getId()){
                        //System.out.println(built.get(x).toString());
                        built.get(x).printBuilding();
                        for(int y=0;y<built.get(x).getRoomQty();y++){
                            built.get(x).printRoom(y);
                        }
                        haverecord=true;
                        break;
                    }

                }

                if(!haverecord){
                    System.out.println("No Relative Building Existed.");

                }
            }
        }
        catch(NumberFormatException e){
            System.out.println("Please Input "+'"'+"*"+'"'+" or Numeric Characters Only ");

        }
        catch(Exception e){}

    }

    public void undo(){}

    public void redo(){}
}