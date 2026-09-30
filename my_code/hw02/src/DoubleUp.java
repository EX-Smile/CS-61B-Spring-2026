public class DoubleUp {
   /**
     * Returns a new string where each character of the given string is repeated twice.
     * Example: doubleUp("hello") -> "hheelllloo"
     */
   public static String doubleUp(String s) {
      // TODO: Fill in this function
      String s1 = "";
      for (int i = 0; i < s.length(); i++) {
         char c = s.charAt(i);
         s1 += c;
         s1 += c;//不可以直接写s1 = charAt(i) + charAt(i)，这样是ASCII码值相加，拼接得是char类型
      }
      return s1;
   }
   
   public static void main(String[] args) {
      String s = doubleUp("hello");
      System.out.println(s);
      
      System.out.println(doubleUp("cat"));
   }
}