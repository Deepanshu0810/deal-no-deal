package DealNoDealGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    public boolean offerTaken;
    public int price;
    public Bank(){
        this.offerTaken = false;
    }

    public void getOffer(ArrayList<Integer> remainingPrices){
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to take the following offer");
        System.out.println(this.offer(remainingPrices));
        System.out.println("press 0 for no and continue the game");
        System.out.println("press 1 to take the offer and exit");
        int c = sc.nextInt();
        while(c!=0 && c!=1){
            System.out.println("Please choose a valid option");
            c=sc.nextInt();
        }
        if(c==1){
            this.offerTaken=true;
        }else{
            this.offerTaken=false;
        }
    }
    public int  offer(ArrayList<Integer> remainingPrices) {
        int sum=0;
        for(int money:remainingPrices){
            sum+=money;
        }
        this.price = sum/remainingPrices.size();
        return this.price;
    }
}
