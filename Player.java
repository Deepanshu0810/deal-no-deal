package DealNoDealGame;

import java.util.*;

public class Player {
    private String name;
    public int[] boxes = new int[22];
    public int selectedBox;

    public Player(int boxNo){
//        this.name = name;
        this.selectedBox = boxNo-1;
        List<Integer> money = new ArrayList<>();
        Collections.addAll(money,1,5,10,50,100,500,1000,5000,10000,25000,50000,75000,100000,250000,500000,600000,700000,1000000,2500000,5000000,7500000,10000000);
        for (int i = 0; i < this.boxes.length; i++) {
            int index = (int)Math.floor(Math.random()*(22-i));
            this.boxes[i] = money.get(index);
            money.remove(index);
        }
    }

}
