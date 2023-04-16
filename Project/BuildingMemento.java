import java.util.*;
public class BuildingMemento implements Memento {

    private Building building;
    private Building existingbuilding;

    public BuildingMemento(Building building,Building existingbuilding){
        this.building=building;
        this.existingbuilding=existingbuilding;
    }
    
    public void setBuilding(Building building){
        this.building=building;
    }


    public void restore(){
        Vector <Building> b=new Vector<Building>();
        if(building instanceof Apartment){
        Apartment apartment=(Apartment)building;
        Apartment existapartment=(Apartment)existingbuilding;
        b.add(new Apartment(existapartment.getId(),existapartment.getRoomQty(),existapartment.getMonthlyRental(),existapartment.getSupportStaff()));
        // System.out.print(apartment.getMonthlyRental());
        // System.out.print(apartment.getSupportStaff());
        existapartment.setMonthlyRental(apartment.getMonthlyRental());
        existapartment.setSupportStaff(apartment.getSupportStaff());
        setBuilding(b.get(0));
        }
        if(building instanceof House){
        House house=(House) building;
        House existhouse=(House) existingbuilding;
        b.add(new House(existhouse.getId(),existhouse.getRoomQty(),existhouse.getFloors()));
        
        existhouse.setFloors(house.getFloors());
        setBuilding(b.get(0));
        }
    }
}
