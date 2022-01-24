import java.util.*;

interface Searchable {
    public int search(int start_index, Object key);
}

class Char {
    private char c;
    public Char(char c_) {
        c = c_;
    }
    public boolean equals(Object d) {
        if (d instanceof Char) {
            Char other = (Char) d;
            return this.c == other.c;
        } else {
            return false;
        }
    }
}
class CharArray implements Searchable{
    private Char[] carr;
    public CharArray(Char[] carr_){
        carr = carr_;
    }
    public int search(int start_index, Object key) {
        for (int i = start_index; i < this.carr.length; i++) {
            if (this.carr[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}

class FrequencyCounter{
    public static int getFrequency(Searchable ob, Object key){
        if (ob instanceof CharArray) {
            CharArray ob_ = (CharArray) ob;
            int count = 0;
            int running_index = 0;
            int next_index;
            while (true) {
                next_index = ob_.search(running_index, key);
                if (next_index == -1) {
                    return count
                } else {
                    running_index = next_index + 1;
                    count++;
                }
            }
        }
        else
            return 0;
    }
}
class FClass{
    public static void main(String[] args) {
        String str;
        char c;
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        c = sc.next().charAt(0);
        Char key = new Char(c);
        Char[] cA = new Char[str.length()]; 
        for(int i = 0; i < str.length(); i++) {
            cA[i] = new Char(str.charAt(i));
        }
        CharArray caObj = new CharArray(cA);
        System.out.println(FrequencyCounter.getFrequency(caObj, key));
    }
}