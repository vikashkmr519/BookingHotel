import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventory {

    public static int availableRooms = 7;

    ArrayList<Room> rooms;

    HashMap<Integer,Customer> customerMap;
    HashMap<Integer,List<Integer>> customerRoomMap;

    Inventory() {
        this.rooms = new ArrayList<>();
        this.customerMap = new HashMap<>();
        this.customerRoomMap = new HashMap<>();

        this.createRooms();
    }

    private void createRooms(){
        rooms.add(new Room(101,Occupancy.SINGLE,1,true,createFacility(true),Prices.price[0]+1000));
        rooms.add(new Room(102,Occupancy.DOUBLE,1,true,createFacility(true),Prices.price[1]+1000));
        rooms.add(new Room(103,Occupancy.DOUBLE,1,true,createFacility(false),Prices.price[1]));
        rooms.add(new Room(201,Occupancy.SINGLE,2,true,createFacility(true),Prices.price[0]+1000));
        rooms.add(new Room(202,Occupancy.SINGLE,2,true,createFacility(false),Prices.price[0]));
        rooms.add(new Room(203,Occupancy.DOUBLE,2,true,createFacility(true),Prices.price[1]+1000));
        rooms.add(new Room(204,Occupancy.TRIPPLE,2,true,createFacility(false),Prices.price[2]));


    }

    private Facility createFacility(boolean ac){
       Facility facility = new Facility();
       facility.setAC(ac);
       return facility;

    }
    public  Room isRoomAvailable(BookingRequest request){
        boolean ac = request.getFacility().getAC();
        Occupancy occ = request.getOccupancy();
        int floorNum = request.getFloorNumber();

        for(Room  room : rooms ){
            if(room.isRoomEmpty() && room.getOccupancy().equals(occ) && room.getFacility().getAC()==ac ){
                if(floorNum==0){
                    room.setRoomEmpty(false);
                    return room;
                }else if(floorNum == room.getFloorNum()){
                    room.setRoomEmpty(false);
                    return room;
                }
            }
        }
        return null;
    }

    public void addRoomToCustomer(Room room, Customer customer){

        if(this.customerMap.containsKey(customer.getCustomerId())){
            this.customerRoomMap.get(customer.getCustomerId()).add(room.getRoomNum());
        }else{
            this.customerMap.put(customer.getCustomerId(),customer);
            this.customerRoomMap.put(customer.getCustomerId(),List.of(room.getRoomNum()));
        }
        System.out.println("Customer attached with room... please give us a moment for final steps");

    }

    public void onPaymentUnsuccessful(Room room, Customer customer){
         this.customerRoomMap.get(customer.getCustomerId()).remove(room.getRoomNum());
         if(this.customerRoomMap.get(customer.getCustomerId()).size()==0){
             this.customerRoomMap.remove(customer.getCustomerId());
             this.customerMap.remove(customer.getCustomerId());
         }
    }
}
