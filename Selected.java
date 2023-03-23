package DealNoDealGame;

import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class Selected {
    public int selectedBox;
    private int last;
    public HashMap<Integer,Boolean> map = new HashMap<>();
    public HashMap<Integer,Boolean> boxRemain = new HashMap<>();
    public ArrayList<Integer> remainingPrices = new ArrayList<>();
    public int[] boxes;
    public Selected(int selectedBox,int[] boxes){
        this.selectedBox = selectedBox;
        this.boxes = boxes;
        map.put(selectedBox,true);
        for (int i = 0; i < 22; i++) {
            if(i!=selectedBox){
                boxRemain.put(i,true);
            }
        }
    }
    public void playGame(int i){
        Scanner sc= new Scanner(System.in);
        System.out.println("Remaining Boxes");
        this.printRemainingIndex();
        System.out.print("select "+i+"th box: ");
        int a = sc.nextInt();
        while(!this.boxRemain.containsKey(a-1)){
            System.out.println("This box is not available choose a correct one");
            a = sc.nextInt();
        }
        this.map.put(a-1,true);
        this.boxRemain.remove(a-1);
        System.out.println("The remaining price money is:");
        this.printRemainingPrices();
    }
    public void printRemainingIndex(){
        for (int j = 0; j < this.boxes.length; j++) {
            if(this.boxRemain.containsKey(j)){
                System.out.print((j+1)+" ");
            }
        }
        System.out.println("\n");
    }

    public void printRemainingPrices(){
        this.remainingPrices.clear();
        for (int i = 0; i < this.boxes.length; i++) {
            if(!this.map.containsKey(i) || i==this.selectedBox){
                remainingPrices.add(this.boxes[i]);
            }
        }
        Collections.sort(remainingPrices);
        for(int p:remainingPrices){
            System.out.print(p+" ");
        }
        System.out.println("\n");
    }
    public int swap(){
        for(int k:boxRemain.keySet()){
            last = k;
        }
        return this.boxes[last];
    }
}
