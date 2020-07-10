package code.strings;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder ret = new StringBuilder();
        int flag = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        for(; i >=0 && j>=0; --i, --j) {
            char aChar = a.charAt(i);
            char bChar = b.charAt(j);
            if(aChar == '1' && aChar == bChar) {
                if(flag == 1) {
                    ret.insert(0,"1");
                } else {
                    flag = 1;
                    ret.insert(0,"0");
                }
            } else if( (aChar == '1' && bChar == '0') || (aChar == '0' && bChar == '1')) {
                if(flag == 1) {
                    ret.insert(0, "0");
                } else {
                    ret.insert(0, "1");
                }
            } else {
                if(flag == 1) {
                    flag = 0;
                    ret.insert(0, "1");
                } else {
                    ret.insert(0, "0");
                }
            }
        }
        if(i >= 0 ) {
            String left = a.substring(0, i + 1);
            if(flag == 1) {
                return addBinary(left, "1") + ret.toString();
            } else {
                return left + ret.toString();
            }
        } else if(j >= 0) {
            String left = b.substring(0, j + 1);
            if(flag == 1) {
                return addBinary(left, "1") + ret.toString();
            } else {
                return left + ret.toString();
            }
        } else {
            if(flag == 1) {
                return "1" + ret.toString();
            } else {
                return ret.toString();
            }
        }
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        AddBinary binary = new AddBinary();
        String ret = binary.addBinary(a, b);
        System.out.println(ret);
    }
}
