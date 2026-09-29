public class StarTriangle5 {
   /**
     * Prints a right-aligned triangle of stars ('*') with 5 lines.
     * The first row contains 1 star, the second 2 stars, and so on. 
     */
   public static void starTriangle5() {
      // TODO: Fill in this function
      for (int i = 0; i < 5; i++) {
         //打印空格
         for (int j = i; j < 4; j++) {
            System.out.print(" ");
         }
         //打印星星
         for (int k = 0; k < i + 1; k++) {
            System.out.print("*");

         }
         if (i != 4) {
            System.out.print("\n");
         }
      }
   }
   
   public static void main(String[] args) {
      starTriangle5();
   }
}