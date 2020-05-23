package concurrency.support;

import java.util.concurrent.TimeUnit;
/**
 * @author mengfh
 *
 * @version 2020-5-23ионГ9:15:16
 *
 * @description SleepUtils
 */
public class SleepUtils {
		public static final void second(long seconds) {
			try {
				TimeUnit.SECONDS.sleep(seconds);
			} catch (InterruptedException e) {
			}
		}
	}