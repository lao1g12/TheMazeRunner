package maze;

public abstract class TheMazeRunner {

	public static void main(String[] args) {
		Printer printer = new Printer();
		MazeRunMethod mazeRunner = new MazeRunMethod();
		Reader reader = new Reader();
		//Load in the maze text file (which is added by dragging into the java folder)
		//ENTER FILE NAME BELOW:
		char[][] maze = reader.mazeReader("medium_input.txt");
		//Methods get the finishing co-ords
		int finalRow = reader.getrFinish();
		int finalColumn = reader.getcFinish();
		/*The maze runner is run, the start point must be defined here rather than in the method for a few reasons, more adaptable for future mazes, but also the method 
		 is called within itself, therefore it is faster to just define the start point rather than requiring to redefine the start every time the method is called*/
		mazeRunner.solver(1, 1, maze, finalRow, finalColumn);
		printer.viewPrinter(mazeRunner.getSolution());
	}

}
