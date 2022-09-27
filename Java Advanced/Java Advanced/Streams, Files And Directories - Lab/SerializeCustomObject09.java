import java.io.*;

public class SerializeCustomObject09 {
   public static class Cube implements Serializable {
        String colour;
        double width;
        double height;
        double depth;

        public Cube(String colour, double width, double height, double depth) {
            this.colour = colour;
            this.width = width;
            this.height = height;
            this.depth = depth;
        }
    }
    public static void main(String[] args) throws IOException {

        Cube cube = new Cube("green", 15.3, 12.4, 3.0);
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("cube.txt"));
        outputStream.writeObject(cube);

    }
}
