package code.MultiThread;

/**
 * @author ryan.zjf
 * @date 2021/05/08
 */
public class SequencePrint {

    public static void main(String[] args) {
        Object o = new Object();
        int[] nums = new int[52];
        char[] chars = new char[26];
        for(int i = 0; i < 52; i++) {
            nums[i] = i + 1;
        }
        for(int i = 1; i <= 26; ++i) {
            chars[i - 1] = (char)('A' + i - 1);
        }
        new Thread(() -> {
            try {
                synchronized (o) {
                    for(int i = 0; i < nums.length; ++i) {
                        System.out.print(nums[i]);
                        i++;
                        System.out.print(nums[i]);
                        o.wait();
                        o.notify();
                    }
                }
            } catch (Exception e) {

            }
        }).start();

        new Thread(() -> {
            try {
                synchronized (o) {
                    for(int j = 0; j < chars.length; ++j) {
                        System.out.print(chars[j]);
                        o.notify();
                        o.wait();
                    }
                }
            } catch (Exception e) {

            }
        }).start();

    }
}
