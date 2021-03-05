package com.kevin.leecode.godzuo.stack;

import java.util.Stack;

/**
 * 用栈实现队列
 *
 * @author kevin lau
 */
public class StackToQueue {

    private Stack<Integer> push;

    private Stack<Integer> pop;

    public StackToQueue() {
        pop = new Stack<>();
        push = new Stack<>();
    }

    public void push(int x) {
        while(!pop.isEmpty()) {
            push.push(pop.pop());
        }
        push.push(x);
    }

    public int poll() {
        if(empty()) {
            throw new RuntimeException("queue is empty");
        }
        while(!push.isEmpty()) {
            pop.push(push.pop());
        }
        return pop.pop();
    }

    public int peek(){
        if(empty()) {
            throw new RuntimeException("queue is empty");
        }
        while(!push.isEmpty()) {
            pop.push(push.pop());
        }
        return pop.peek();
    }

    public boolean empty(){
        return push.isEmpty()&&pop.isEmpty();
    }
}
