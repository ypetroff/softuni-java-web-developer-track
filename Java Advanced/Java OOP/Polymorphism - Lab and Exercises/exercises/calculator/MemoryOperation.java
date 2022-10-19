package exercises.calculator;

import java.util.Deque;

public class MemoryOperation implements Operation {

    private final Deque<Integer> memory;

    public MemoryOperation(Deque<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
        this.memory.push(operand);
    }

    @Override
    public int getResult() {
        return this.memory.peek();
    }

    @Override
    public boolean isCompleted() {
        return false;
    }
}
