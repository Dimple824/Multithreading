import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
//�����̳߳ص�ʹ�ã�
//�����̳߳�CachedThreadPool    ������Ҫ�������߳�
//���ύ�����ٶȿ���ִ�������ٶȣ������̳߳ػ᲻�ϴ����̣߳�
class MyThreadFour implements Runnable{
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+","+i);
		}
	}	
}
public class BuiltInThreadThree {
	public static void main(String[] args) throws InterruptedException {
		MyThreadFour myThread = new MyThreadFour();
		//�����̳߳�
		ExecutorService executorService = Executors.newCachedThreadPool();
		for(int i = 0;i<5;i++) {
			Thread.sleep(2000);
			executorService.submit(myThread);
		}
		//�ر��̳߳�
		executorService.isShutdown();
	}
}
