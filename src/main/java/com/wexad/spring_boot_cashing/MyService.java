package com.wexad.spring_boot_cashing;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;
import org.springframework.cache.annotation.Cacheable;

import java.util.ArrayList;
import java.util.List;


@Component
public class MyService {

    private final List<Integer> nums;

    public MyService() {
        this.nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
    }

    @Cacheable("nums")
    public List<Integer> operate() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return nums;
    }

    @CacheEvict("nums")
    public void add(int num) {
        nums.add(num);
    }

    @CacheEvict("nums")
    public void evict() {
    }
}
