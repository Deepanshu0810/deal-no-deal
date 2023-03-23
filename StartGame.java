package DealNoDealGame;

import java.util.Scanner;
public class StartGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;
        while(true){
            System.out.println("Do you want to play Deal OR No Deal?");
            System.out.println("Press 0 to quit 1 to play");
            ch=sc.nextInt();
            if(ch==0){
                System.out.println("See you again");
                break;
            }else if(ch==1){
//                System.out.println("Enter you name :");
//                String name = sc.next();
                System.out.println("Select 1 box out of 1 to 22 to start the game");
                int boxNo = sc.nextInt();
                while(boxNo<1 || boxNo>22){
                    System.out.println("Please select a valid box");
                    boxNo = sc.nextInt();
                }
                Player p = new Player(boxNo);
                Selected s = new Selected(p.selectedBox,p.boxes);
                Bank b = new Bank();
                int round =1;
                while(round<5 && !b.offerTaken){
                    if(round==1){
                        System.out.println("Select 6 boxes:");
                        for (int i = 1; i < 7; i++) {
                            s.playGame(i);
                        }
                        b.getOffer(s.remainingPrices);
                        if(b.offerTaken){
                            System.out.println("You got "+b.price);
                            break;
                        }
                        round++;
                    }
                    else if(round==2){
                        System.out.println("Select 5 boxes:");
                        for (int i = 1; i < 6; i++) {
                            s.playGame(i);
                        }
                        b.getOffer(s.remainingPrices);
                        if(b.offerTaken){
                            System.out.println("You got "+b.price);
                            break;
                        }
                        round++;
                    }
                    else if(round==3){
                        System.out.println("Select 5 boxes:");
                        for (int i = 1; i < 6; i++) {
                            s.playGame(i);
                        }
                        b.getOffer(s.remainingPrices);
                        if(b.offerTaken){
                            System.out.println("You got "+b.price);
                            break;
                        }
                        round++;
                    }
                    else if(round==4){
                        System.out.println("\nSelect 4 boxes:");
                        for (int i = 1; i < 5; i++) {
                            s.playGame(i);
                        }
                        b.getOffer(s.remainingPrices);
                        if(b.offerTaken){
                            System.out.println("You got "+b.price);
                            break;
                        }
                        round++;
                    }
                }
                if(!b.offerTaken){
                    System.out.println("Do You want to swap your box?");
                    System.out.println("press 0 for no ");
                    System.out.println("press 1 to yes");
                    int sw = sc.nextInt();
                    while(sw!=0 && sw!=1){
                        System.out.println("Please choose a valid option");
                        sw = sc.nextInt();
                    }
                    if(sw==0){
                        System.out.println("you won "+s.boxes[s.selectedBox]);
                    }else{
                        System.out.println("you won "+s.swap());
                    }
                }
            }else{
                System.out.println("You entered a wrong choice, Try Again");
                ch=sc.nextInt();
            }
        }
    }
}
