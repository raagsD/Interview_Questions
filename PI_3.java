import java.util.*;



class PI_3
{

  public static void main(String[] args)
	{
           int[] arr = {1,-2,3,-1}; //Input Array of integers
           ProductCalc obj1 = new ProductCalc();
	   int res = obj1.getMaxProduct(arr);
           System.out.println(res);
	}

}


class ProductCalc
{

  int getMaxProduct(int[] arr)
	{
	   int highest = Math.max(arr[0], arr[1]);
           int lowest = Math.min(arr[0], arr[1]);

           int highest2 = arr[0]*arr[1];
           int lowest2 = highest2;

           int highest3 = Integer.MIN_VALUE;
           
		
            for(int i = 2; i<= arr.length-1; i++)
	    { 
                int num = arr[i];
		highest3 = Math.max(highest3,Math.max(highest2*num,lowest2*num));
                highest2 = Math.max(highest2,Math.max(highest*num,lowest*num));
                lowest2 = Math.min(lowest2, Math.min(lowest*num, highest*num));
                if(num > highest) highest = num;
                if(num < lowest ) lowest = num;

            }

           return highest3;
	}

}
