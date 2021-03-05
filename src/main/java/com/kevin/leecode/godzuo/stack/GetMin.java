package com.kevin.leecode.godzuo.stack;

import java.util.Stack;

/**
 * 设计一个特殊的栈 能O(1)获取当前栈的最小值
 *
 * @author kevin lau
 */
public class GetMin {

    private Stack<Integer> data = new Stack<>();

    private Stack<Integer> min = new Stack<>();

    public int pop(){
        if (data.isEmpty()) {
              throw new RuntimeException("data is empty");
        }
        Integer pop = data.pop();
        if (pop <= min.peek()) {
            min.pop();
        }
        return pop;
    }

    public void push(int value) {
        data.push(value);
        if(min.isEmpty()||value<=min.peek()) {
            min.push(value);
        }
    }

    public int getMin(){
        return min.peek();
    }

    public static void main(String[] args) {

    }
}
