import java.util.*;
import java.io.File;

public class Main2{
    public static Scanner sc=new Scanner(System.in);
    //public static Scanner sc;
    public static int check(){
        System.out.println("Building Management System (BMS)\n"+
            "a = add building, d = display buildings, m = modify building, e = edit rooms\n"+
            "u = undo, r = redo, l = list undo/redo, x = exit system");   
        String [] anslist={"a","d","m","e","u","r","l","x"};

        String reply=sc.nextLine();

        int len=anslist.length;
        for (int x=0; x<anslist.length;x++){
            if(anslist[x].equals(reply)){
                return x;
            }
            else if(anslist[x].toUpperCase().equals(reply)){
                return x;
            };
        }
        System.out.println("Invaild Value. Please Enter Again");
        return check();
    }

    public static void main(String args[]){
        //try{
         // File myObj=new File("reply.txt");
          // sc= new Scanner(myObj);
            
                //if(myObj.exists()){
                 //  while(sc.hasNextLine()){
                    Vector <Building> built=new Vector<>();
                    Stack undostack= new Stack();
                    Stack redostack=new Stack();
                    Caretaker ct=new Caretaker();
            
                    CommandFactory [] factories = new CommandFactory[8];
                    factories[0]=new AddBuildingCommandFactory(sc,undostack,built);
                    factories[1]=new DisplayCommandFactory(sc,built);
                    factories[2]=new ModifyBuildingCommandFactory(sc,undostack,built,ct);
                    factories[3]=new EditCommandFactory(sc,undostack,built,ct);
                    factories[4]=new UndoCommandFactory(sc,undostack,redostack,built);
                    factories[5]=new RedoCommandFactory(sc,undostack,redostack,built);
                    factories[6]=new ViewUnRedoCommandFactory(undostack,redostack);
                    factories[7]=new ExitCommandFactory();

                    while(true){
                        Command co=factories[check()].create();
                        co.execute();

                    }
                }
             //   }
             //  else{
                  //  System.out.println("The file does not exist.");
            // }
            

        }
      //  catch(Exception e){
       // }
   // }
//}