import java.util.*;
public class Caretaker{

    private Vector undoList;
    private Vector redoList;

    public Caretaker(){
        this.undoList=new Vector();
        this.redoList=new Vector();
    }

    public void saveRooms(Building building, ArrayList<Room> room){
        RoomsMemento rm=new RoomsMemento(building,room);
        undoList.add(rm);
    }

    public void saveBuilding(Building building,Building existingbuilding){
        BuildingMemento bm=new BuildingMemento(building,existingbuilding);
        undoList.add(bm);
    }

    public void undo(){
        if(undoList.size()>0){
            if(undoList.lastElement() instanceof RoomsMemento){
                RoomsMemento rm=(RoomsMemento)undoList.lastElement();
                rm.restore();
                System.out.println("Undo1");
            }

            if(undoList.lastElement() instanceof BuildingMemento){
                BuildingMemento bm=(BuildingMemento)undoList.lastElement();
                bm.restore(); 
                System.out.println("Undo2");
            }
        }
        else{
            System.out.println("The UndoList is Empty");
        }
        redoList.add(undoList.lastElement());
        undoList.remove(undoList.lastElement());
    }

    public void redo(){
        if(redoList.size()>0){
            if(redoList.lastElement() instanceof RoomsMemento){
                RoomsMemento rm=(RoomsMemento)redoList.lastElement();
                rm.restore();
                System.out.println("Redo1");
            }
            if(redoList.lastElement() instanceof BuildingMemento){
                BuildingMemento bm=(BuildingMemento)redoList.lastElement();
                bm.restore(); 
                System.out.println("Redo2");
            }
        }

        else{
            System.out.println("The RedoList is Empty");

        }
        undoList.add(redoList.lastElement());
        redoList.remove(redoList.lastElement());

    }
}
