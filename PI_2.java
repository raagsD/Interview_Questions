import java.util.*;


class PI_2
{

  public static void main(String[] args)
	{
                int[] arr = {1,2,3,4,5};
		ProductsExceptSelf obj1 = new ProductsExceptSelf();
		int[] res = obj1.getProductsOfAllIntsExceptAtIndex(arr);
		for(int prod : res)
		System.out.print(prod +" -- " );
                System.out.println(" ");
	}
}



class ProductsExceptSelf
{
  int[] getProductsOfAllIntsExceptAtIndex(int[] arr)
	{
		int[] exceptSelfProd = new int[arr.length];
                exceptSelfProd[0] = arr[0];
		for(int i = 1 ; i < exceptSelfProd.length ;i++)
		{
		   exceptSelfProd[i] = exceptSelfProd[i-1]*arr[i];
		} 

  		for(int j = arr.length-1; j>= 0;j--)
		{
                  int suffix = 0 ; 
                  int prefix = 0 ;
                  int last_prod = 1;
                  if(j+1 > arr.length-1) 
		  {
                     suffix = 1;
                     prefix = exceptSelfProd[j-1];
                  }
                  else if(j-1 < 0)
		  {
                     prefix = 1;   
		     suffix = arr[j+1];
                  }
		  else
                  {
                      prefix = exceptSelfProd[j-1];
                      suffix = arr[j+1];
                  }
                  exceptSelfProd[j] = prefix*suffix;
                  arr[j] = arr[j] * suffix;
		}

            return exceptSelfProd;
	}
}
