package kyu3;

public class Spiralizor {

	   public static int[][] spiralize(int size) {
	          
	      int[][] result = new int[size][size];
	          for (int i = 0; i < size; i++)
	            for (int j = 0; j < size; j++)
	              result[i][j] = 0;
	          int k = size;
	          while(k > 0){
	            for (int i = (size -k)/2; i < size - ((size - k) / 2); i++) {
	              result[(size -k)/2][i] = 1;
	              result[size - ((size - k) / 2) - 1][i] = 1;
	              result[i][(size - k) / 2] = 1;
	              result[i][size - ((size - k) / 2) - 1] = 1;
	            }
	            k -= 4;
	            if (k == 1)
	              result[size/2][size/2] = 1;
	            if (k == 2) {
	              result[size/2 - 1][size/2 - 1] = 1;
	              result[size/2][size/2 -1] = 1;
	              result[size/2 - 1][size/2] = 1;
	              result[size/2][size/2] = 1;
	            }
	          }
	          int miss = 0;
	          while (miss < size/2) {
	            if (result[miss + 1][miss] == 1) {
	              result[miss + 1][miss] = 0;
	            } else {
	              result[miss + 1][miss] = 1;
	            }
	            miss+=1;
	          }
	          if (size % 2 == 0){
	            result[size/2][size/2-1]=0;
	          }
	          return result;
	   }
	}
