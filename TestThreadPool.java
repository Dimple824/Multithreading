import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//�ֹ������̳߳�
//ʹ��ʵ��Callable<String>;����submit()������
//������̳߳�û�д����µ��̣߳�
//����Future�ӿڵ�get���������������̣߳�ֱ��ȡ�õ�ǰ�߳�ִ����Ϻ�ķ���ֵ��
class MyThread implements Callable<String>{
	@Override
	public String call() {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+","+i);
		}
		return Thread.currentThread().getName()+"ִ�����";
	}	
}
public class TestThreadPool {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		MyThread mythread = new MyThread();
		ExecutorService  executorService = new ThreadPoolExecutor(3, 5, 2000,TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());
//public ThreadPoolExecutor(int corePoolSize,�������̳߳ش�С��
//        int maximumPoolSize, ���̳߳ص����������
//        long keepAliveTime,  ���̱߳��ֻʱ�䣩
//        TimeUnit unit,  	���߳��ӳ�ʱ�䣩
//        BlockingQueue<Runnable> workQueue)��������У�����ȴ�ִ��������������С�
		for(int i = 0;i<5;i++) {
			Future future = executorService.submit(mythread);
			System.out.println(future.get());
		}
		//�ر��̳߳�
		executorService.isShutdown();
	}
}