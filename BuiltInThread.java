import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
//�����̳߳ص�ʹ�ã�
//�̶���С�̳߳�FixedThreadPool��ֻ�ᴴ��4���߳�
class MyThreadTwo implements Callable<String>{
	@Override
	public String call() {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+","+i);
		}
		return Thread.currentThread().getName()+"ִ�����";
	}	
}
public class BuiltInThread {
	public static void main(String[] args) {
		MyThreadTwo myThread = new MyThreadTwo();
		//�����̳߳�
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		//ֻ��Ҫ���������̳߳صĹ̶���С
		for(int i = 0;i<5;i++) {
			executorService.submit(myThread);
		}
		//�ر��̳߳�
		executorService.isShutdown();
	}
}
