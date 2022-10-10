package PetClinics08;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class Clinic implements Iterable<Pet>{
    private Pet[] rooms;


    public Clinic(int numberOfRooms) {
        setRooms(numberOfRooms);
    }

    public void setRooms(int numberOfRooms) {
        validate(numberOfRooms);
            this.rooms = new Pet[numberOfRooms];
    }

    public Pet[] getRooms() {
        return rooms;
    }

    private void validate(int rooms) {
        if(rooms % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
    }
    public boolean addPet(Pet pet) {
       int room = this.rooms.length / 2;
       int i = 0;
       while (i < this.rooms.length) {
           if(i % 2 == 0) {
               room+=i;
           }else {
               room-=i;
           }

           if(this.rooms[room] == null) {
               this.rooms[room] = pet;
               return true;
           }
           i++;
       }
       return false;
    }

    public boolean release() {
        int room = rooms.length / 2;
        {
            int i = room;

            while (i < rooms.length) {
                if (this.rooms[i] != null) {
                    this.rooms[i] = null;
                    return true;
                }
                i++;
            }
        }
       int i = 0;
        while (i < room) {
            if(this.rooms[i] != null) {
                this.rooms[i] = null;
                return true;
            }
            i++;
        }
        return false;
    }

    boolean hasEmptyRooms(){
        return Arrays.stream(this.rooms).anyMatch(Objects::isNull);
    }

    public void print(int room) {
        System.out.println(this.rooms[room - 1] == null ? "Room empty" : rooms[room - 1].toString());
    }

    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < rooms.length;
            }

            @Override
            public Pet next() {
                return rooms[index++];
            }
        };
    }
}
