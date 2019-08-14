package com.example.demo.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author zhangxiaofeng
 * @Describetion: zookeeper 分布式锁
 * @date 2019/3/612:30
 */
public class DistributedLock implements Lock, Watcher {

    private ZooKeeper zooKeeper= null;
    private String ROOT_LOCK="/locks";//锁目录
    private String WAIT_LOCK;//等待前一个锁
    private String CURRENT_LOCK;//当前锁
    private String connectionString = "127.0.0.1:2181";
    public DistributedLock(){
        try {
            zooKeeper = new ZooKeeper(connectionString, 4000, this);
            Stat stat = zooKeeper.exists(ROOT_LOCK, false);
            if (stat == null) {
                //创建根节点
                zooKeeper.create(ROOT_LOCK, "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void lock() {

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {

    }
}
