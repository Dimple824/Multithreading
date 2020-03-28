class A1 extends Thread{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+
				Thread.currentThread().getPriority());
		B b =new B();
		Thread b1 = new Thread(b);
		b1.setName("线程B");
		b1.start();
	}
}
class B extends Thread{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+
				Thread.currentThread().getPriority());
	}
}
public class TextTwo {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+
				Thread.currentThread().getPriority());
		A1 a = new A1();
		Thread a1 = new Thread(a);
		a1.setName("线程A");
		a1.setPriority(10);
		a1.start();
	}
}