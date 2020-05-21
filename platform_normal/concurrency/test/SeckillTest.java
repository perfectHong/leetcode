package concurrency.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author mengfh
 * 
 * @version 2020-5-21上午10:03:07
 * 
 * @description
 */
public class SeckillTest {

	private static ThreadPoolExecutor executor  = new ThreadPoolExecutor(0, 0, 1, null, null);
	
	public static void main(String[] args) {

	}

	public void startKafkaQueue(long seckillId) {
		//seckillService.deleteSeckill(seckillId);
		//final long killId = seckillId;
		//LOGGER.info("开始秒杀四");
		for (int i = 0; i < 1000; i++) {
			//final long userId = i;
			Runnable task1 = new Runnable() {  /**注意这三种写法都可以，都实现了Runnable*/
				@Override
				public void run() {
					System.out.println("task1");
				}
			};
			Thread task2 = new Thread() {
				@Override
				public void run() {
					System.out.println("task2");
				}
			};
			Thread task3 = new Thread(new Runnable(){
				@Override
				public void run() {
					System.out.println("task3");
				}
			});
			executor.execute(task1);
			executor.execute(task2);
			task3.start();
		}
		try {
			Thread.sleep(10000);
			//redisUtil.cacheValue(killId + "", null);
			//Long seckillCount = seckillService.getSeckillCount(seckillId);
			//LOGGER.info("一共秒杀出{" + seckillCount + "}件商品");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
