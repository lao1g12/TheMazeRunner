package maze;

public class Printer {
	
	public void viewPrinter(char arr [][]) {
		/*The printer iterates through the 2D array and builds the 2D print out. In this scenario the 1's are replaced with #'s, the unused path and space is set as a space
		and then the start is set as S (The end is defined in the solver).*/
		try {
			for(int r=0; r < arr.length; r++) {
				for(int c=0; c < arr[r].length; c++) {
					if(arr[r][c] == '1') {
						arr[r][c] = '#';
					}
					if(arr[r][c] == 'P' || arr[r][c] == '0') {
						arr[r][c] = ' ';
						
					}
					if(r == 1) {
						if (c == 1) {
							arr[r][c] = 'S';
						}
					}
					System.out.print(arr[r][c]);
				}System.out.println();
			}
		} catch (NullPointerException ne) {
			System.out.println("The maze was unsolvable");
		}

	}

}
