public class StarTriangleN {
   /**
     * Prints a right-aligned triangle of stars ('*') with N lines.
     * The first row contains 1 star, the second 2 stars, and so on. 
     */
   public static void starTriangle(int N) {
      // TODO: Fill in this function
      for (int i = 0; i < N; i++) {
         //打印空格
         for (int j = i; j < N - 1; j++) {
            System.out.print(" ");
         }
         //打印星星
         for (int k = 0; k < i + 1; k++) {
            System.out.print("*");

         }
         if (i != N - 1) {
            System.out.print("\n");
         }
      }
   }
   
   public static void main(String[] args) {
      starTriangle(7);
   }
}