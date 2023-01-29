import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class neww {
    public static void main(String[] args) throws IOException {

        //Declare variables of type integer
        int userChoice, computerChoice, rock, paper, scissors;

        //create input object so as to use it's methods for geting use input
        Scanner input = new Scanner(System.in);

        //create random input for the computer
        Random rnd = new Random();

        //Assigning values to the following variables:
        rock = 0;
        paper = 1;
        scissors = 2;

        BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\VARUN\\OneDrive\\Desktop\\game.txt"));
        String st,sk="";
        while((st=br.readLine())!=null)
        {
            sk+=st;
        }
        String[] b=sk.split(" ");
        //display the game name
        System.out.println("ROCK - PAPER - SCISSORRS GAME");
        System.out.println("Enter your name");
        String name=input.nextLine();
        int total=0;
        while (true) {
            if(Integer.parseInt(b[1])<total){
                BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\VARUN\\OneDrive\\Desktop\\game.txt"));
                writer.write(name+" "+total);
                writer.flush();
            }
            BufferedReader br1=new BufferedReader(new FileReader("C:\\Users\\VARUN\\OneDrive\\Desktop\\game.txt"));
            String st1,sk1="";
            while((st1=br1.readLine())!=null)
            {
                sk1+=st1;
            }
            String[] b1=sk1.split(" ");
            System.out.println("Highest Score->"+b1[0]+" has scored "+b1[1]);
            System.out.println("Enter your choice (0=rock, 1=paper, 2=scissors) or quit(-1)");
            //User input
            userChoice = input.nextInt();
            if(userChoice==-1) {

                System.exit(0);
            }
            //if user chooses above 2
            while (userChoice > 2) {
                System.out.println("give number between 0 and 2");
                userChoice = input.nextInt();
            }
            //user selections
            if (userChoice == rock) {
                System.out.println("User chose ROCK");
            } else {
                if (userChoice == paper) {
                    System.out.println("User chose PAPER");
                } else {
                    System.out.println("User chose SCISSORS");
                }
            }
            //computer input (random)
            computerChoice = rnd.nextInt(3);

            //computer selection
            if (computerChoice == rock) {
                System.out.println("Computer chose ROCK");
            } else {
                if (computerChoice == paper) {
                    System.out.println("Computer chose PAPER");
                } else {
                    System.out.println("Computer chose SCISSORS");
                }
            }

            //Results section

            //Draw
            while (userChoice == computerChoice) {
                System.out.println("draw try again");

                // if user chooses above 2
                userChoice = input.nextInt();
                while (userChoice > 2) {
                    System.out.println("give number between 0 and 2");
                    userChoice = input.nextInt();
                }
                computerChoice = rnd.nextInt(3);
                // DRAW user selections
                if (userChoice == rock) {
                    System.out.println("User chose ROCK");
                } else {
                    if (userChoice == paper) {
                        System.out.println("User chose PAPER");
                    } else {
                        System.out.println("User chose SCISSORS");
                    }
                }
                //DRAW computer selection
                if (computerChoice == rock) {
                    System.out.println("Computer chose ROCK");
                } else {
                    if (computerChoice == paper) {
                        System.out.println("Computer chose PAPER");
                    } else {
                        System.out.println("Computer chose SCISSORS");
                    }
                }
            } //END DRAW

//RESULTS
            if (computerChoice == rock) {
                if (userChoice == paper) {
                    System.out.println("User wins!");
                    total+=1;
                } else {
                    System.out.println("Computer Wins");
                }
            } else if (computerChoice == paper) {
                if (userChoice == rock) {
                    System.out.println("Computer wins");
                } else {
                    System.out.println("User Wins!");
                    total+=1;
                }
            } else if (userChoice == rock) {
                System.out.println("User Wins");
                total+=1;
            } else {
                System.out.println("Computer Wins");
            }
        }
    }//END main

}