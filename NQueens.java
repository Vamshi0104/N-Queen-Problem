import java.util.*;
class NQueens
{
	static int[] a=new int[100];
	static int c=0;
	static void queen(int k,int n)
	{
		for(int i=1;i<=n;i++)
		{
			if(isSafe(k,i)==1)
			{
				a[k]=i;// Assigning Queen and checking for the conditon.
				if(k==n) //End of Length of Board of Queens
				{
					c++;
					System.out.println("Solution :"+c);
					//Prints all possible Solution of 'N' Queens
					print(n);
					System.out.println();
				}
				else
				{
				queen(k+1,n);//Checking the isSafe function until length 
				}
			}
		}
	}
	static void print(int n)
	{
		char[][] b=new char[n+1][n+1];
		for(int i=1;i<=n;i++)
		{
		int j=a[i];
		b[i][j]='Q'; //Presence of Queen is represented by 'Q'
		}
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(b[i][j]!='Q')
					System.out.print('.'+" "); 
				else
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}
	}
	static int isSafe(int k,int i)
	{
		for(int j=1;j<=(k-1);j++)
		{
			if(a[j]==i||((Math.abs(a[j]-i))==(Math.abs(j-k)))) //Diagonality Check between Queens
			{
				return 0;//Presence of Queen 
			}
		}
		return 1;//Queen can be placed 
	}
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Number of Queens :");
		int n=s.nextInt();
		queen(1,n);
	}
}