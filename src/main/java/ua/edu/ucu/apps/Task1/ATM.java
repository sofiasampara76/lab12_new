package ua.edu.ucu.apps.Task1;

public class ATM {
    private Banknote firstItem;

    public ATM() {
        firstItem = new Banknote100(new Banknote50(new Banknote5(null)));
    }
    public void process(int amount) {
        firstItem.process(amount);
    }
}
