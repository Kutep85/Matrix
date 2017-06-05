
public class Matrix {
	private int[][] matrix;
	int size;
	
	Matrix() {
	this.size = 2 + (int) (Math.random() * 10);
	this.matrix = new int[size][size];
	for (int i = 0; i < size; i++){
		for (int j = 0; j < size; j++)
			matrix[i][j] = 1 + (int) (Math.random() * 10);
		}
	}
	
	void displayMatrix() {
		for (int i = 0; i < size; i++){
			for (int j = 0; j < size; j++) {
				if(j == size - 1)
					System.out.println(matrix[i][j]);
				else
					System.out.print(matrix[i][j] + "  ");
			}
		}
	}
	
	int getElement(int i, int j) {
		return this.matrix[i][j];
	}
	
	void setElement(int i, int j, int value) {
		matrix[i][j] = value;
	}
}
