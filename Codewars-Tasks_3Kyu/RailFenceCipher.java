package codewarsTasks;

public class RailFenceCipher {

	 static private int getTerm(int iteration, int row, int size) {
	        if ((size == 0) || (size == 1)) {
	            return 1;
	        }
	        if((row == 0) || (row == size-1)) { 
	            return (size-1)*2;
	        }

	        if (iteration % 2 == 0) { 
	            return (size-1-row)*2;
	        }
	        return 2*row;
	    }
	  
	   static String encode(String message, int key) {
	        if (key < 0) {
	            throw new ArithmeticException("Negative key value");
	        } else if (key == 0) {
	            key = 1;
	        }
	        String encodedMessage = "";

	        for(int row = 0; row < key; row++) { 
	            int iter = 0;
	            for(int i = row; i < message.length(); i += getTerm(iter++, row, key)) {

	                encodedMessage += message.charAt(i); 
	            }


	        }
	        return encodedMessage;
	    }
	  
	   static String decode(String message, int key) {
	        if (key < 0) {
	            throw new ArithmeticException("Negative key value");
	        }
	        StringBuilder decodedMessage = new StringBuilder(message);
	        int currPosition = 0; 
	        for(int row = 0; row < key; row++) { 
	            int iter = 0; 
	            for(int i = row; i < message.length(); i += getTerm(iter++, row, key)) {
	                decodedMessage.setCharAt(i, message.charAt(currPosition++));
	            }


	        }

	        return decodedMessage.toString();
	    }
    
    public static void main(String[] args) {
    	System.out.println(encode("WEAREDISCOVEREDFLEEATONCE", 5));
    	System.out.println((decode(encode("WEAREDISCOVEREDFLEEATONCE", 5), 5)));
    }
}
