import java.util.*;


class AppleStocks
{
  static public void main(String[] args)
  {
        int[] stockPrices = {10,40,20,100,30,400};
	System.out.println("Profit:" + getMaxProfit(stockPrices));
  }

  static public int getMaxProfit(int[] stockPrices)
	{
	   int max = 0;
           int cur_max = 0;
           int min = stockPrices[0];

          for(int i = 1; i < stockPrices.length; i++)
	 {
           cur_max = stockPrices[i] - min;          
	   if(cur_max > max)  max = cur_max;
           if(stockPrices[i] < min ) min = stockPrices[i]; 
         }
           return max;
	}

}
