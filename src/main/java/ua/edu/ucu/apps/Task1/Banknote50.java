package ua.edu.ucu.apps.Task1;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Banknote50 extends Banknote {
    public Banknote50(Banknote nextItem) {
        super(nextItem, 50);
    }
}
