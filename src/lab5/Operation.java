package lab5;

// TODO 3: Create the following interfaces: Minus, Plus, Mult, Div
//  and the Operation class which implements them
public class Operation implements Minus, Plus, Mult, Div {
    private float number;

    public float getNumber() {
        return number;
    }

    public Operation(float value) {
        this.number = value;
    }

    @Override
    public void minus(float value) {
        number -= value;
    }

    @Override
    public void plus(float value) {
        number += value;
    }

    @Override
    public void mult(float value) {
        number *= value;
    }

    @Override
    public void div(float value) {
        if (value != 0) {
            number /= value;
        }
    }

}
