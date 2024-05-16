import java.util.Random;
import java.util.Scanner;


public class NumberGuessing{
    public static void main(String... args){
        int[] arra = {3,4,2};
        GuessNumber game = new GuessNumber(3);

        //System.out.print(game.compare());
        
    }
}

class GuessNumber{
    int nNumbers;
    int[] generatedNumbers;
    int[] guessedNumber;

    GuessNumber(int nNumbers){
        this.nNumbers = nNumbers;
        generatedNumbers = new int[this.nNumbers];
        guessedNumber = new int[this.nNumbers];
        generator();
    }

    public void generator(){
        boolean track;
        for(int i = 0; i<nNumbers; i++){
            track = true;
            Random rand = new Random(nNumbers);
            int generatedNum = rand.nextInt();
            //Check if the newly generated number doesn't exit in the array
            while(track){
                for(int j=0; j<nNumbers; j++){
                    //if the newly generated number does exits in the array, ignore it and generate new number...
                    if(generatedNum == generatedNumbers[j]){
                        generatedNum = rand.nextInt(); //... and assign the to generatedNum
                    }else{
                        track=false; //If the new generated number doesn't exit in the array, exit the while loop
                    }
                }
            }
            generatedNumbers[i] = generatedNum;
        }

        for(int i=0; i<nNumbers; i++){
            System.out.print(generatedNumbers[i]+" ");
        }
    }

    public String compare(int[] array){
        String display = "Matching numbers: ";
        //counter to count matching numbers
        int counter = 0;
        guessedNumber = array;
        for(int i=0; i<nNumbers; i++){
            for(int j=0; i<nNumbers; i++){
                if(guessedNumber[i] == generatedNumbers[j]){
                    display = display+guessedNumber[i]+" "; //Show matching numbers
                    counter++;
                }
            }
        }

        int results = (counter/nNumbers)*100;
        String grade = "";

        if(results<50){
            grade = "E";
        }else if(results>=50 && results<70){
            grade = "D";
        }else if(results<=70 && results<80){
            grade = "C";
        }else if(results<=80 && results<90){
            grade = "B";
        }else if(results<=90 && results<100){
            grade = "A";
        }else{
            grade = "A+";
        }
        display = display +"\nGrade: "+grade;
        return display;
    }

    public String display(){
        String strDisplay = "";
        strDisplay = strDisplay+"[ ";
        for(int i=0; i<nNumbers; i++){
            strDisplay = strDisplay+ generatedNumbers+" ";
        }
        strDisplay = strDisplay+"]\n Re";

        return strDisplay;
    }
}