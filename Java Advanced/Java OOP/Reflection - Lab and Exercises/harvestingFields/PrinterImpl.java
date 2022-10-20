package harvestingFields;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class PrinterImpl implements Printer{

   private Class<RichSoilLand> clazz;
   private  String command;

    public PrinterImpl(Class<RichSoilLand> clazz, String command) {
        this.clazz = clazz;
        this.command = command;
    }

    @Override
    public void print() {

        Arrays.stream(this.clazz.getDeclaredFields())
                .filter(f -> Modifier.toString(f.getModifiers()).equals(this.command) || this.command.equals("all"))
                .forEach(f -> System.out.printf("%s %s %s%n",
                        Modifier.toString(f.getModifiers()), f.getType().getSimpleName(), f.getName()));
    }


}
