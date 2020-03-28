
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
//内置线程池的使用；
//定时调度池ScheduledThreadPool()
class MyThreadFive implements Runnable{
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+","+i);
		}
	}	
}
public class BuiltInFour {
	public static void main(String[] args) throws InterruptedException {
		MyThreadFive myThread = new MyThreadFive();
		//内置线程池
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
		for(int i = 0;i<5;i++) {
			scheduledExecutorService.schedule(myThread, 2000, TimeUnit.MILLISECONDS);
		}
		//关闭线程池
		scheduledExecutorService.isShutdown();
	}
}
