import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.management.timer.TimerNotification;
//TimerNotification
//手工创建线程池
//使用实现接口Runnable;使用execute()方法
//结果。线程池没有创建新的线程，
class MyThreadOne implements Runnable{
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+","+i);
		}
	}
}
public class TestThreadPoolOne {
	public static void main(String[] args) {
		MyThreadOne mythread = new MyThreadOne();
		ExecutorService  executorService = new ThreadPoolExecutor(3, 5, 2000,TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());
//public ThreadPoolExecutor(int corePoolSize,（核心线程池大小）
//        int maximumPoolSize, （线程池的最大数量）
//        long keepAliveTime,  （线程保持活动时间）
//        TimeUnit unit,  	（线程延迟时间）
//        BlockingQueue<Runnable> workQueue)（任务队列）保存等待执行任务的阻塞队列。
		for(int i = 0;i<5;i++) {
			executorService.execute(mythread);
		}
		//关闭线程池
		executorService.isShutdown();
	}
}
