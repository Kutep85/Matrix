import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class Processing implements Runnable {
	private int factor;
	private Matrix matrix;
	
	Processing(int factor) throws InterruptedException {
		this.factor = factor;
		matrix = new Matrix();
		System.err.println("ORIGINAL MATRIX:");
		Thread.sleep(1000);
		matrix.displayMatrix();
		System.out.println();
	}
	
	synchronized void proc() throws InterruptedException {
		CountDownLatch matr = new CountDownLatch(matrix.size);
		int line = 0;
		for(int i = 0; i < matrix.size; i++) {
			matr.countDown();
			new Thread (this, "#" + i).start();
			}
		Thread.sleep(1000);
		System.err.println("MATRIX WITH FACTOR:");
		Thread.sleep(1000);
		matrix.displayMatrix();
		}

	@Override
	public void run(){
		char[] number = Thread.currentThread().toString().toCharArray();
		String num = "";
		int numm = 0;
		for(int i = 0; i < number.length; i++){
			if(number[i] == '#') {
				int j = ++i;
					while(number[j] != ',') {
						num += number[j];
						j++;
					}				
				}
			}
		numm = Integer.parseInt(num);
		for(int i = 0; i < matrix.size; i++) {
			matrix.setElement(numm, i, matrix.getElement(numm, i) * factor);
		}
	}
}
