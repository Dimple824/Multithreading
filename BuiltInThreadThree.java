import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
//内置线程池的使用；
//缓存线程池CachedThreadPool    根据需要创建新线程
//当提交任务速度快于执行任务速度，缓存线程池会不断创建线程；
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
		//内置线程池
		ExecutorService executorService = Executors.newCachedThreadPool();
		for(int i = 0;i<5;i++) {
			Thread.sleep(2000);
			executorService.submit(myThread);
		}
		//关闭线程池
		executorService.isShutdown();
	}
}
