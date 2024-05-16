/**
 * @Author: SS Ntuli
 * @Contacts: +27 69 488 3778
 * Email: siyandasec25@gmail.com
 */
import java.util.Random;
import java.util.Scanner; 

public class Matrix{
	public static void main(String[] args){
		int nCols;
		int nRows;
		int rowNum;
		int colNum;
		boolean continue = true;

//****************************Matrix Size********************************* */
		String strMatrixSize = "Enter the size of the matrix below";

		String strNumRows = "\n Number of Rows: \t\t";
		String strNumCols = "\n Number of Columns: \t";

//***************************Get row and/or column*******************************/
		String strGetRC = "\nEnter the row and/or columns number you want below:";
		
		String strRowNum = "\nRow number: \t\t";
		String strColNum = "\nColumn number: \t";

//***************************User inputs***************************************/
	//++++++++++++++++++++++Matrix size++++++++++++++++++++++++++++++++++/
		Scanner scan = new Scanner(System.in);
		System.out.print(strMatrixSize+strNumRows);
		nRows = scan.nextInt();		//number of rows
		System.out.print(strNumCols);
		nCols = scan.nextInt(); 	//number of columns

	//+++++++++++++++++++++Get row and/or number+++++++++++++++++++++++++/
		System.out.print(strGetRC+strRowNum);
		rowNum = scan.nextInt(); 	//row number
		System.out.print(strColNum); 
		colNum = scan.nextInt(); 	//column number

//*******************Invocking the functions from the Matrix class**************** */
		do{
			System.out.print("Do you want to continue?(Y-Yes & N-No): ");
			String response = scan.nextLine();
			if((response.toUppercase()).equals("Y")){

			}else if((response.toUppercase()).equals("N")){
				continue = false;
			}else{
				System.out.print("ERROR!!!");
			}
			Matrics myMatric = new Matrics(nRows,nCols);
			System.out.println(myMatric.displayMatrix());
			System.out.println("Row Number "+rowNum+": \t"+myMatric.getRow(rowNum));
			System.out.println("Column numb "+colNum+": \t"+myMatric.getCol(colNum));

		}while(continue);
	}
}


//************************************ Marix Class**********************************/
class Matrics{
	private int[][] myMatric;
	private int nRows;
	private int nCols;

//***********************************Constructor*******************/
	Matrics(int nRows, int nCols){
		this.nCols = nCols;					//Initialize number of columns
		this.nRows = nRows;					//Initialize number of columns
		myMatric = new int[nRows][nCols];	//Setting up the size of the array
		fillMatrix();
	}


//****************************Fill in the 2D array with the Random numbers*/
	private void fillMatrix(){
		for(int i=0; i<nRows; i++){
			for(int j=0; j<nCols; j++){
				Random rand = new Random();
				int number = rand.nextInt(10);
				myMatric[i][j] = number;
			}
		}
	}

//****************************Display*************************************/
	public String displayMatrix(){
		String strPrint = "";
		int row = 0;
		strPrint = strPrint+" \t  ";
		for(int i=1; i<=nCols; i++){
			strPrint = strPrint+i+" ";
		}
		strPrint = strPrint+"\n";
		for(int i=0; i<nRows; i++){
			row++;
			strPrint = strPrint + row+ "\t[ ";
			for(int j=0; j<nCols; j++){
				strPrint = strPrint + myMatric[i][j] +" ";
			}
			strPrint = strPrint+ "]\n";
		}
		return strPrint;
	}
	
//****************************Get row from the Matrix*************************/
	public String getRow(int rowNum){
		String strPrint = "";
		for(int i=0; i<nCols; i++){
			strPrint = strPrint+myMatric[rowNum-1][i]+" ";
		}
		return strPrint;
	}

//*************************Get column from the matrix************************/
	public String getCol(int colNum){
		String strPrint = "";
		for(int i=0; i<nRows; i++){
			strPrint = strPrint+myMatric[i][colNum-1]+" ";
		}
		return strPrint;
	}
}