package ua.edu.ucu.apps.Task1;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @AllArgsConstructor @NoArgsConstructor
public abstract class Banknote {
    private Banknote nextItem;
    private int banknoteNolinale;

    public void process(int amount) {
        int quantity = amount / banknoteNolinale;
        int rest = amount % banknoteNolinale;
        if (nextItem != null) {
            nextItem.process(rest);
        }
        else {
            if (rest != 0) {
                throw new IllegalArgumentException();
            }
        }
        System.out.format("Please, receive %d x %d\n", quantity, banknoteNolinale);
    }
}
