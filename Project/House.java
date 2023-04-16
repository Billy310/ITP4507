public class House extends Building{

    private int noOfFloors;
    public House(int id ,int noOfRooms, int noOfFloors){
        super(id,noOfRooms);
        this.noOfFloors=noOfFloors;

    }

    public void setFloors(int noOfFloors){
        this.noOfFloors=noOfFloors;
    }

    public int getFloors(){
        return this.noOfFloors;
    }

    public void modifyBuilding(){

    }

    public void printBuilding(){
        //System.out.println(" Building No : "+this.getId()+" No. of Floors: "+this.getFloors()+" Number of rooms: "+this.getRoomQty());
        System.out.println("Building No :" +this.getId()+"\n No. of Floors: "+this.getFloors());
    }

    public String toString(){
        //return " Building No : "+this.getId()+"\n"+" No. of Floors: "+this.getFloors();
        return"Building No :   "+this.getId()+" No. of Floors:   "+this.getFloors();
    }

}