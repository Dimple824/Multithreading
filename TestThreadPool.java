import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//手工创建线程池
//使用实现Callable<String>;调用submit()方法；
//结果。线程池没有创建新的线程，
//调用Future接口的get方法会阻塞其他线程，直到取得当前线程执行完毕后的返回值。
class MyThread implements Callable<String>{
	@Override
	public String call() {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+","+i);
		}
		return Thread.currentThread().getName()+"执行完毕";
	}	
}
public class TestThreadPool {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		MyThread mythread = new MyThread();
		ExecutorService  executorService = new ThreadPoolExecutor(3, 5, 2000,TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());
//public ThreadPoolExecutor(int corePoolSize,（核心线程池大小）
//        int maximumPoolSize, （线程池的最大数量）
//        long keepAliveTime,  （线程保持活动时间）
//        TimeUnit unit,  	（线程延迟时间）
//        BlockingQueue<Runnable> workQueue)（任务队列）保存等待执行任务的阻塞队列。
		for(int i = 0;i<5;i++) {
			Future future = executorService.submit(mythread);
			System.out.println(future.get());
		}
		//关闭线程池
		executorService.isShutdown();
	}
}