package maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Reader {
	private int rFinish, cFinish, numRow, numCol;
	private char[][] maze;
	
	public char[][] mazeReader(String fileName){
		ArrayList<String> rows = new ArrayList<>();
		String dimensions;
		String end;
		try {
			Scanner scanner = new Scanner(new File(fileName));
			dimensions = scanner.nextLine();
				ArrayList<String> dimensionArray = new ArrayList<String>(Arrays.asList(dimensions.split(" ")));
				numCol = Integer.parseInt(dimensionArray.get(0));
				numRow = Integer.parseInt(dimensionArray.get(1));
				//Sets the dimensions of the maze
			scanner.nextLine();
			end = scanner.nextLine();
				ArrayList<String> endArray = new ArrayList<String>(Arrays.asList(end.split(" ")));
				cFinish = Integer.parseInt(endArray.get(0));
				rFinish = Integer.parseInt(endArray.get(1));
				//Sets the end point of the maze
			while (scanner.hasNextLine()){
				String nextLine = scanner.nextLine();
				rows.add(nextLine);
				//Runs a while loop to add each line of the text file to an array
			}
			scanner.close();
		}catch (FileNotFoundException e) {
			//Try catch required in case the file error is input wrong
			System.out.println("File read error");
		}
		//2D array dimensions need to be initially defined
		maze= new char[numRow][numCol];
		//The nested for loops iterate along each row and adds to the 2D array, then moves row when whole row is added
		for(int r = 0; r < numRow; r++) {
			ArrayList<String> cols = new ArrayList<String>(Arrays.asList(rows.get(r).split(" ")));
			for(int c = 0; c<numCol; c++) {
				String column = cols.get(c);
				char chari = column.charAt(0);
				maze[r][c] = chari;
			}
		}
		System.out.println("Maze loaded");
		return maze;
		
	}

	public int getrFinish() {
		return rFinish;
	}

	public int getcFinish() {
		return cFinish;
	}

}
