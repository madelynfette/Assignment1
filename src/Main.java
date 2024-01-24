
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //Problem 1
        System.out.println("Problem 1: Common Subsequence");
        System.out.println("Input: ");
        String first = "almanacs";
        String second = "albatross";
        System.out.println("First Word: " + first);
        System.out.println("Second Word: " + second);
        longestCommonSubsequence(first,second);


        //Problem 2
        System.out.println("Problem 2: Common Substring");
        System.out.println("Input: ");
        String text1 = "gears of war";
        String text2 = "history of warriors";
        System.out.println(text1);
        System.out.println(text2);
        commonSubstring(text1,text2);


        //Problem 3
        System.out.println("Problem 3: NotFibonacci");
        System.out.println("Input: ");
        int number = 10;
        System.out.println(number);
        notFibonacci(number);


        //Problem 4
        System.out.println("");
        System.out.println("Problem 4: Where in Sequence");
        System.out.println("Input: ");
        int numb = 8;
        System.out.println(numb);
        whereInSequence(numb);


        //Problem 5
        System.out.println("Problem 5: Remove Element");
        int [] nums = {1,1,2,3,1,2,1};
        int val = 1;
        System.out.println("Input: ");
        System.out.println(Arrays.toString(nums));
        System.out.println(val);
        removeElement(nums, val);



        //Problem 6
        /*Problem 1:
        Big-O: O(length of text1 * length of text 2)
        Big-Ω: Ω(length of text1 + length of text2)

        This is the case since the program iterates through nested loops for the lengths of text 1 and text 2 and
        the time complexity depends on the lengths of both strings. So in the best case, Ω(length of text1 + length of text2) would
        be the fastest time versus the worst case of O(length of text1 * length of text 2).

        Problem 2:
        Big-O: O(length of text1 * length of text 2)
        Big-Ω: Ω(length of text1 + length of text2)

        Similarly to problem 1, since the program iterates through nested loops for the lengths of text 1 and text 2, the time
        complexity depends on the lengths of both strings. So in the best case, Ω(length of text1 + length of text2) would
        be the fastest time versus the worst case of O(length of text1 * length of text 2).

        Problem 3:
        Big-O: O(number)
        Big-Ω: Ω(number)

        Since the variable "number" is directly responsible for the amount of times the nested loop iterates, the time complexity is
        O(number) in the worst case and Ω(number) in the best case.

        Problem 4:
        Big-O: O(number)
        Big-Ω: Ω(1)

        In the worst case, the time complexity is O(number) because it iterates until it reaches the position of the input
        variable "number". In the best case the time complexity is Ω(1) given that it finds the position in the first iteration.

        Problem 5:
        Big-O: O(length of nums[])
        Big-Ω: Ω(length of nums[])

        In the worst case, it needs to iterate through the entire array of nums and in the best case it also needs to iterate through
        the entire array of nums in order to count the elements that are not equal to val.

        */


    }




    // Problem 1
    public static int longestCommonSubsequence(String text1, String text2) {
        //takes the 2 input strings and converts them into character arrays
        char[] string1 = text1.toCharArray();
        char[] string2 = text2.toCharArray();

        //makes 2 ints, the lengths of each of the character arrays
        int length1 = string1.length;
        int length2 = string2.length;

        //store the length of the common subsequences
        int[][] cs = new int[length1 + 1][length2 + 1];

        //iterate through loops of strings and store common subsequence in cs
        for (int i = 1; i <= length1; i++) {
            for (int m = 1; m <= length2; m++) {
                if (string1[i - 1] == string2[m - 1]) {
                    cs[i][m] = cs[i - 1][m - 1] + 1;
                }
                else {
                    //store max between the 2
                    cs[i][m] = Math.max(cs[i - 1][m], cs[i][m - 1]);
                }
            }
        }
        System.out.println("Output:");
        System.out.println(cs[length1][length2]);
        return cs[length1][length2];

    }

    //Problem 2

    public static String commonSubstring(String text1, String text2){

        //puts the strings of text into character arrays
        char[] string1 = text1.toCharArray();
        char[] string2 = text2.toCharArray();

        //create ints for the length of each array
        int length1 = string1.length;
        int length2 = string2.length;

        //store common substring
        int[][] cs = new int[length1 + 1][length2 + 1];

        //store start and end position of longest common substring
        int start = 0;
        int end = 0;


        //iterate to find longest common substring and store in cs
        for (int i = 1; i <= length1; i++) {
            for (int m = 1; m <= length2; m++) {
                if (string1[i - 1] == string2[m - 1]) {
                    cs[i][m] = cs[i - 1][m - 1] + 1;
                    if (cs[i][m] > cs[start][end]) {
                        start = i - cs[i][m];
                        end = i - 1;
                    }
                } else {
                    //store max between the 2
                    cs[i][m] = Math.max(cs[i - 1][m], cs[i][m - 1]);
                }
            }
        }
        System.out.println("Output:");
        System.out.println(text1.substring(start+1, end + 1));
        return text1.substring(start+1 , end + 1);
    }



    //Problem 3

    private static void notFibonacci(int number) {
        //initialize starting values for the notFibonacci sequence
        long valueOne = 0;
        long valueTwo = 1;


        System.out.println("Output:");
        //print first 2 values
        System.out.print(valueOne + " " + valueTwo + " ");

        //print the rest of the values
        for (int i = 3; i <= number; i++) {
            //use algorithm
            long next = (3 * valueTwo) + (2*valueOne);
            //print out numbers
            System.out.print(next + " ");
            //increase to next value
            valueOne = valueTwo;
            valueTwo = next;
        }
    }


    //Problem 4
    public static int whereInSequence(int number){
        //starting values, just replicated the notFibonacci sequence
        long valueOne = 0;
        long valueTwo = 1;

        //starting position since 0 and 1 are already declared
        //side note, I am starting this as 0 at position 1, 1 at position 2 and so on as the assignment implies
        int pos = 3;

        System.out.println("Output: ");
        while(true){
            //sequence
            long next = (3 * valueTwo) + (2*valueOne);
            //print number if matches
            if(next==number) {
                System.out.println(pos);
                return pos;
            }
            //print closest lower number
            else if(next> number){
                System.out.println(pos-1);
                return pos-1;

            }
            valueOne = valueTwo;
            valueTwo = next;
            pos++;

        }

    }


    //Problem 5
    public static int removeElement(int[] nums, int val) {

        //store the element count that are not equal to val
        int countofelements = 0;

        //iterate through array
        for (int i = 0; i < nums.length; i++) {
            //if not equal, it assigns index value to the new count of elements
            if (nums[i] != val) {
                nums[countofelements++] = nums[i];
            }

        }
        //returns the count of the elements that are not equal to val
        System.out.println("Output: ");
        System.out.println(countofelements);
        return countofelements;

    }






}





