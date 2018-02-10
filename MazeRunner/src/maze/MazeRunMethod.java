package maze;

public class MazeRunMethod {
	
	Printer printer = new Printer();
	char[][] solution;
	
	public boolean solver (int r, int c, char[][] maze, int endR, int endC) {
		
		//This if statement checks if the current coordinate is equivalent to the final coordinate
		if(r == endR){
			if(c == endC) {
				//The end point is set as E and all the nested calls to this method are satisfied
				maze[r][c] = 'E';
				return true;
			}
		}
		if(maze[r][c] != '0') {
			//Checks if the current point is a 0 (Free space) this stops the 'pointer' moving onto a wall or a point previously traversed
			return false;
		}
		//Sets the path which the pointer has moved to during solving the maze
		maze[r][c] = 'P';
		
		//The below statements are if statements calling too the current method, and checking whether the Up/Down/Left/Right position COULD be part of the solution
		//Below I have set a priority so the method always tries to move down and to the right before going "backwards" (Up or left), this is a hope to make the route as efficient as possible
		if(solver(r+1, c, maze, endR, endC)) {
			maze[r][c] = 'X';
			solution = maze;
			return true;
		}
		if(solver(r, c+1, maze, endR, endC)) {
			maze[r][c] = 'X';
			solution = maze;
			return true;
		}
		if(solver(r-1, c, maze, endR, endC)) {
			maze[r][c] = 'X';
			solution = maze;
			return true;
		}
		if(solver(r, c-1, maze, endR, endC)) {
			maze[r][c] = 'X';
			solution = maze;
			return true;
		}

		/*This method returns false below when it hits a dead end, if the method is nested within itself then it will essentially move back to the previous space along the path,
		and continue the above if statements. If it is not a nested if statement then the maze is impossible */
		return false;
		
	}
	
	public char[][] getSolution(){
		return solution;
	}

}
