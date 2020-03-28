//生产消费问题
class Box{
	int cake; 
}

class Production extends Thread{
	Box box;
	public Production(Box box) {
		this.box=box;
	}
	@Override
	public void run() {
		while(true) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (box) {
				if(box.cake==0) {
					box.cake++;
					System.out.println("生产一个蛋糕");
					box.notify();
				}else{
					System.out.println("不能生产蛋糕");
					try {
						box.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
class Consumption extends Thread{
	Box box;
	public Consumption(Box box) {
		this.box=box;
	}
	@Override
	public void run() {
		while(true) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		synchronized(box) {
				if(box.cake==1) {
					box.cake--;
					System.out.println("消费了一个蛋糕");
					box.notify();
				}else {
					System.out.println("不能消费蛋糕");
					try {
						box.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
public class TextThree {
	public static void main(String[] args) {
		Box box = new Box();
		Production p = new Production(box);
		Consumption c= new Consumption(box);
		p.start();
		c.start();
	}
}
