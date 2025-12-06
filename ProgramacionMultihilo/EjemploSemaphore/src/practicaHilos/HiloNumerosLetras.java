package practicaHilos;

import java.util.concurrent.Semaphore;

public class HiloNumerosLetras {
	
	public static final char[] letras = {
		    'A','B','C','D','E','F','G','H','I','J','K','L','M',
		    'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
		};

//purba 
    public static void main(String[] args) throws InterruptedException {
    	
    	Semaphore s1 = new Semaphore(1); 
    	Semaphore s2 = new Semaphore(0); 
    	
    	Thread t1 = new Thread(() -> {
    		try {
    			s1.acquire(); 
    			for (int i = 0; i <= 30; i++) {
    				System.out.println(i); 
    				Thread.sleep(200); 
    			}
    			s2.release(); 
    		} catch (Exception ex) {
    			ex.printStackTrace(); 
    		}
    		
    	}, "hiloNumeros"); 
    	
    	Thread t2 = new Thread(() -> {
    		try {
    			s2.acquire(); 
    			for (int i = 0; i < letras.length; i++) {
    				System.out.println(letras[i]); 
    				Thread.sleep(200); 
    			}
    		} catch (Exception ex) {
    			ex.printStackTrace(); 
    		}  		
    	}, "hiloLetras"); 
    	
    	t1.start();
    	t2.start();
    }
}

