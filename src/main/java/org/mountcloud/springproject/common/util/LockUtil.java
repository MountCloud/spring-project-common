package org.mountcloud.springproject.common.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁工具
 * @author zhanghaishan
 * @version V1.0
 * TODO: 锁工具，主要用于多线程的锁
 * 2019年12月25日.
 */
public class LockUtil {

	/**
	 * 单例时使用
	 */
	private static LockUtil lockUtil = null;

	/**
	 * 锁集合
	 */
	private Map<String,Lock> locks = new HashMap<String, Lock>();

	/**
	 * 本身的多线程锁
	 */
	private Lock locksLock = new ReentrantLock();

	/**
	 * 锁住一段代码
	 * @param lockName 锁的名字
	 * @param exec 需要执行的代码
	 */
	public void lock(String lockName,LockUtilExec exec) {
		Lock tempLock = getLock(lockName);
		
		tempLock.lock();
		try {
			exec.exec();
		}finally {
			tempLock.unlock();
		}
	}

	/**
	 * 根据锁的名字返回一个锁
	 * @param lockName 名字
	 * @return 锁
	 */
	private Lock getLock(String lockName) {
		Lock resultLock = null;
		locksLock.lock();
		try {
			resultLock = locks.get(lockName);
			if(resultLock==null) {
				resultLock = new ReentrantLock();
				locks.put(lockName, resultLock);
			}
		}finally {
			locksLock.unlock();
		}
		return resultLock;
	}

	/**
	 * 返回单例
	 * @return 单例
	 */
	public static LockUtil getInstance() {
		if(lockUtil==null) {
			lockUtil = new LockUtil();
		}
		return lockUtil;
	}
	
	private LockUtil() {
		
	}
	
	
	public interface LockUtilExec{
		
		void exec();
		
	}
}
