package com.wexad.spring_boot_cashing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {
    private final MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/")
    public List<Integer> get() {
        return myService.operate();
    }

    @GetMapping("/{num}")
    public void add(@PathVariable int num) {
        myService.add(num);
    }
    @GetMapping("/evict")
    public void evict() {
        myService.evict();
    }
}
