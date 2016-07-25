import java.util.*;


class PI_5
{

  public static void main(String[] args)
	{
               CoinChange obj1 = new CoinChange();
               int[] denom = {1,2,3};
		System.out.println(obj1.countWays(4,denom));
	}
}


class CoinChange
{

   int  countWays(int amount , int[] denominations)
	{
             int[] ways2makeamount = new int[amount+1];
             Arrays.fill(ways2makeamount,0);
             ways2makeamount[0] = 1;

              for(int coin : denominations)
            	{
		   for(int target = coin; target <= amount; target++)
             		{
		            ways2makeamount[target] += ways2makeamount[target-coin]; 
			}
		}

            return ways2makeamount[amount];
	}
}
