package ua.edu.ucu.apps.Task1;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Banknote100 extends Banknote {

    public Banknote100(Banknote nextItem) {
        super(nextItem, 100);
    }
    
}
