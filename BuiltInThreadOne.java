import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
//�����̳߳ص�ʹ�ã�
//���̳߳ص�SingleThreadExecutor;ֻ�ᴴ��һ���߳�
class MyThreadThree implements Callable<String>{
	@Override
	public String call() {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+","+i);
		}
		return Thread.currentThread().getName()+"ִ�����";
	}	
}
public class BuiltInThreadOne {
	public static void main(String[] args) {
		MyThreadThree myThread = new MyThreadThree();
		//�����̳߳�
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		//ֻ��Ҫ���������̳߳صĹ̶���С
		for(int i = 0;i<5;i++) {
			executorService.submit(myThread);
		}
		//�ر��̳߳�
		executorService.isShutdown();
	}
}
