package lab.mathOperation;

public class MathOperation {

    int add(int first, int second) {
        return first + second;
    }

    int add(int first, int second, int third) {
        return add(add(first, second), third);
    }

    int add(int first, int second, int third, int forth) {
        return add(add(first, second, third), forth);
    }
}
