import java.util.Random;

public class Checkpoint {
	public static void main(String[] args) {
		int[][] numbers = new int[5][5];
		Random rand = new Random();
		
		for(int i = 0; i < numbers.length; i++) {
			for(int j = 0; j < numbers[i].length; j++) {
				numbers[i][j] = rand.nextInt(100);
			}
		}
		
		for(int i = 0; i < numbers.length; i++) {
			for(int j = 0; j < numbers[i].length; j++) {
				System.out.print(numbers[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
