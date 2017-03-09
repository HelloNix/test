package multithread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Multithread
 * @author Nix
 * @date 2017年3月9日下午8:11:37
 */
public class Multithread{

	public static void main(String[] args){
		SellThread thread = new SellThread();
		Thread t1 = new Thread(thread,"A");
		Thread t2 = new Thread(thread,"B");
		Thread t3 = new Thread(thread,"C");
		t1.start();
		t2.start();
		t3.start();
	}	
}

class SellThread implements Runnable{
	
	public List<String> tickets = new ArrayList<String>(Arrays.asList("北京-上海","北京-深圳","北京-广州","北京-桂林","北京-南昌","北京-厦门","北京-海口","北京-汕头"));

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			synchronized(tickets){
				if(tickets.size()<=0){
					break;
				}
				String tic = tickets.get(0);
				tickets.remove(0);
				System.out.println(Thread.currentThread().getName() + " tickets saled [" + tic +"] and left :" + tickets.size());				
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}

}
