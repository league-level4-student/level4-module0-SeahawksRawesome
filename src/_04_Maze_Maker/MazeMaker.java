package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


public class MazeMaker{
	
	private static int width;
	private static int height;
	
	private static Maze maze;
	
	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();
	
	
	public static Maze generateMaze(int w, int h){
		width = w;
		height = h;
		maze = new Maze(width, height);
		
		//4. select a random cell to start
		Random rand = new Random();
		Cell randoms = maze.getCell(rand.nextInt(width), rand.nextInt(height));
		
		
		//5. call selectNextPath method with the randomly selected cell
		selectNextPath(randoms);
		
		return maze;
	}

	//6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		//A. mark cell as visited
		currentCell.hasBeenVisited();
		//B. check for unvisited neighbors using the cell
	ArrayList<Cell> ceels = getUnvisitedNeighbors(currentCell);
		//C. if has unvisited neighbors,
		if(ceels.size() == 0) {
			
			//C1. select one at random.
			Random rand = new Random();
			Cell temp  = ceels.get(rand.nextInt(ceels.size() -1));
			//C2. push it to the stack
			uncheckedCells.push(temp);
			//C3. remove the wall between the two cells
			removeWalls(temp, currentCell);
			//C4. make the new cell the current cell and mark it as visited
			currentCell = temp;
			currentCell.hasBeenVisited();
			//C5. call the selectNextPath method with the current cell
			selectNextPath(currentCell);
		}
			
		//D. if all neighbors are visited
		if(currentCell.hasBeenVisited()) {
			
		
			//D1. if the stack is not empty
			if(!uncheckedCells.isEmpty()) {
				
			
				// D1a. pop a cell from the stack
				Cell curr = uncheckedCells.pop();
				// D1b. make that the current cell
				currentCell = curr;
				// D1c. call the selectNextPath method with the current cell
				selectNextPath(currentCell);
			}	
		}	
		
	}

	//7. Complete the remove walls method.
	//   This method will check if c1 and c2 are adjacent.
	//   If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		if(Math.abs(c1.getX() - c2.getX()) <= width/5) {
			if(Math.abs(c1.getY() - c2.getY()) <= height/5) {
				c1.hasEastWall(); 
				c2.hasWestWall();
			}
		}
	}
	
	//8. Complete the getUnvisitedNeighbors method
	//   Any unvisited neighbor of the passed in cell gets added
	//   to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		
		return null;
	}
}
