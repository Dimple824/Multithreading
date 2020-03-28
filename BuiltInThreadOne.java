import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
//内置线程池的使用；
//单线程池的SingleThreadExecutor;只会创建一个线程
class MyThreadThree implements Callable<String>{
	@Override
	public String call() {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+","+i);
		}
		return Thread.currentThread().getName()+"执行完毕";
	}	
}
public class BuiltInThreadOne {
	public static void main(String[] args) {
		MyThreadThree myThread = new MyThreadThree();
		//内置线程池
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		//只需要传入内置线程池的固定大小
		for(int i = 0;i<5;i++) {
			executorService.submit(myThread);
		}
		//关闭线程池
		executorService.isShutdown();
	}
}
