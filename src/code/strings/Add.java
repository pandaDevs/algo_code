package code.strings;

/**
 * 十进制加法
 */
public class Add {
    public String addBinary(String a, String b) {
        StringBuilder ret = new StringBuilder();
        int carryOver = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while(i >= 0 || j >=0) {
            int sum = carryOver;
            if(i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if(j >= 0) {
                sum += b.charAt(j--) - '0';
            }

            ret.insert(0, sum % 10);
            carryOver = sum / 10;
        }

        if(carryOver == 1) {
            ret.insert(0, carryOver);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String a = "121299322311212155699";
        String b = "3229399391821213212312312";
        Add binary = new Add();
        String ret = binary.addBinary(a, b);
        System.out.println(ret);
    }
}
