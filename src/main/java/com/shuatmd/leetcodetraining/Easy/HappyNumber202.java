package com.shuatmd.leetcodetraining.Easy;

//202. 快乐数
//编写一个算法来判断一个数 n 是不是快乐数。
//
//「快乐数」 定义为：
//
//对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
//然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
//如果这个过程 结果为 1，那么这个数就是快乐数。
//如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
public class HappyNumber202 {
    public static void main(String[] args) {
        HappyNumber202 test = new HappyNumber202();
        test.isHappy(19);
    }
    //官方解法：快慢指针
    //因为结果要么是循环 要么是=1 所以用快慢指针
    //检查相等的时候是否都为1 不为1则说明死循环
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        slow = bitSqureSum(slow);
        fast = bitSqureSum(fast);
        fast = bitSqureSum(fast);
        while(slow != fast){
            slow = bitSqureSum(slow);
            fast = bitSqureSum(fast);
            fast = bitSqureSum(fast);
        }
        return slow == 1;
    }

    public int bitSqureSum(int n) {
        int sum = 0;
        while (n > 0) {
            int bit = n % 10;
            sum += bit * bit;
            n = n / 10;
        }
        return sum;
    }
}
