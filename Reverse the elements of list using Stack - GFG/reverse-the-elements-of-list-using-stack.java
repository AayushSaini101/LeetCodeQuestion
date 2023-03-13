import java.util.*;
public class Main {



    public static void main(String[] args) {

      Scanner scan=new Scanner(System.in);

      int t=scan.nextInt();

      while(t-->0){

          int n=scan.nextInt();

          int count=0;

          Stack<Integer>st=new Stack<>();

          int arr[]=new int[n];

          for(int i=0;i<n;++i){

              arr[i]=scan.nextInt();

              st.add(arr[i]);
          }

          while(st.size()!=0){

              System.out.print(st.pop()+" ");
          }
          System.out.println();


      }


    }
}