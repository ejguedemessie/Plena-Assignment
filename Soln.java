import java.util.*;

class Sol {
    class pair implements Comparable<pair>{
        int  freq;
        char elem;

        public int compareTo(pair o){
            return o.freq - this.freq;
        }

    }

    public String frequencySort(String s) {

        pair[] arr = new pair[256];

        for(int i=0;i<256;i++) arr[i] = new pair();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            arr[ch].freq++;
            arr[ch].elem = ch;
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder("");

        for(int i=0;i<arr.length;i++){
            if(arr[i].freq!=0){
                int x = arr[i].freq;
                char ch = arr[i].elem;
                while(x-->0) sb.append(ch);
            }
        }

        return sb.reverse().toString();

    }
}

public class Soln {
    public static int firstUniqChar(String s) {

        Set<Character> exist = new HashSet<Character>();
        Set<Character> repeat = new HashSet<Character>();

        //determine which characters are repeated
        for(int i=0; i<s.length(); i++){
            if(exist.contains(s.charAt(i))){
                repeat.add(s.charAt(i));
            }
            exist.add(s.charAt(i));
        }

        //determine first non repeated character
        for(int i =0; i<s.length(); i++){
            if(!repeat.contains(s.charAt(i))){
                return i;
            }
        }

        //found nothing
        return -1;
    }

    // Driver method
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter your value :");
        String s = input.next();
        int index = firstUniqChar(s.toLowerCase());
        Sol solutionss = new Sol();

        System.out.println(
                index == -1
                        ? "Either all characters are repeating or string "
                        + "is empty"
                        : "First non-repeating character is "
                        + s.charAt(index));
        System.out.println(solutionss.frequencySort(s));
    }

}


