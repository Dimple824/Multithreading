//������������
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
					System.out.println("����һ������");
					box.notify();
				}else{
					System.out.println("������������");
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
					System.out.println("������һ������");
					box.notify();
				}else {
					System.out.println("�������ѵ���");
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
