public class DoubleUp {
   /**
     * Returns a new string where each character of the given string is repeated twice.
     * Example: doubleUp("hello") -> "hheelllloo"
     */
   public static String doubleUp(String s) {
      // TODO: Fill in this function
      char[] arr1 = s.toCharArray();
      char[] arr2 = new char[2*arr1.length];
      for (int i = 0 ,j = 0; i < arr2.length; i+=2) {
         arr2[i] = arr2[i+1] = arr1[j++];
      }
      return String.valueOf(arr2);
   }
   
   public static void main(String[] args) {
      String s = doubleUp("hello");
      System.out.println(s);
      
      System.out.println(doubleUp("cat"));
   }
}