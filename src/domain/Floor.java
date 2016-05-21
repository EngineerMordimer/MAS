package domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by maciek on 20/05/16.
 */
public class Floor {
    private int number;
    private Map<Integer , Workstation> workstationMap = new HashMap<>();

    public Floor(int number){
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void addWorkstation(Workstation newWorkstation){
        if ( !workstationMap.containsKey(newWorkstation.getRoomNumber())){
            workstationMap.put(newWorkstation.getRoomNumber() , newWorkstation);
            newWorkstation.setFloor(this);
        }
    }

    public Workstation findWorkstation(Integer roomNumber) throws Exception {

        if (!workstationMap.containsKey( roomNumber)){
            throw new Exception("Nie odnaleziono pokoju o numerze: "+ roomNumber);
        }
        return workstationMap.get(roomNumber);
    }
}
