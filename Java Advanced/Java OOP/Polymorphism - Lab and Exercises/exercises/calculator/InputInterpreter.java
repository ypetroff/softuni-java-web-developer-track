package exercises.calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class InputInterpreter {
    private CalculationEngine engine;
    private final Deque<Integer> memory;

    public InputInterpreter(CalculationEngine engine){
        this.engine = engine;
        this.memory = new ArrayDeque<>();
    }

    public boolean interpret(String input) {
        try {
            engine.pushNumber(Integer.parseInt(input));
        }catch (Exception ex){
            engine.pushOperation(this.getOperation(input));
        }
        return true;
    }
    public Operation getOperation(String operation) {
        switch (operation) {
            case "*":
                return new MultiplicationOperation();
            case "/":
                return new DivisionOperation();
            case "ms":
                return new MemoryOperation(this.memory);
            case "mr":
                return new MemoryRecallOperation(this.memory);
            default: return null;
        }
    }
}
