package com.miguelpoyatosmora.paymenttracker.services;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class DefaultBank implements Bank {

    private ConcurrentMap<String, BigDecimal> balances = new BalancesHashMap();
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private LockMap lock = new LockMap<String>();

    @Override
    public void deposit(ImmutablePair<String, BigDecimal> money) {

        BigDecimal amount = money.getValue();
        if (BigDecimal.ZERO.equals(amount)) return;

        String currency = money.getKey();

        lock.lockIfEquals(currency);

        BigDecimal currentBalance = balances.get(currency);

        if (currentBalance != null) {
            BigDecimal newAmount = currentBalance.add(amount);
            if (BigDecimal.ZERO.equals(newAmount)) {
                balances.remove(currency);
            } else {
                balances.put(currency, newAmount);
            }
        } else {
            balances.put(currency, amount);
        }
        lock.unLock(currency);

    }

    @Override
    public Map<String, BigDecimal> getBalances() {
        return balances;
    }

    private class BalancesHashMap extends ConcurrentHashMap<String, BigDecimal> {

        @Override
        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            for (Entry entry : this.entrySet()) {
                stringBuffer.append(entry.getKey());
                stringBuffer.append(" ");
                stringBuffer.append(entry.getValue());
                stringBuffer.append("\n");
            }
            return stringBuffer.toString();
        }
    }

    private class LockMap<T> {

        ConcurrentMap<T, Lock> lockMap = new ConcurrentHashMap<T, Lock>();

        public void lockIfEquals(T key) {
            getLock(key).lock();

        }

        private Lock getLock(T key) {

            ReentrantLock value = new ReentrantLock();
            Lock lock1 = lockMap.putIfAbsent(key, value);
            if (lock1 == null) {
                return value;
            } else {
                return lock1;
            }
        }

        public void unLock(T key) {
            getLock(key).unlock();

        }
    }
}
