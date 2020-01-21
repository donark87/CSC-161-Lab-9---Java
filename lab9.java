//Donark Patel
//Lab 9
//Arrays

import java.util.Scanner;
import java.io.*;

public class lab9 {

		public static void main (String[] args)throws IOException {

			// variables

			int i, iid, hits, walks, outs, nplayers, mi, row;

			float batAvg;
			String playerName;

			File myFile = new File ("PlayersID.txt");
			File myFile2 = new File ("stats.txt");
       		Scanner inFile = new  Scanner (myFile);
       		Scanner inFile2 = new  Scanner (myFile2);

       		int [] id = new int [26];
       		String [] player = new String [26];
       		int [] hitsInTotal = new int [120];
       		int [] walksInTotal = new int [120];
       		int [] outsInTotal = new int [120];
       		float [] average = new float [26];

			nplayers = 26;
			batAvg = 0;

			// inputs

			while(inFile.hasNext())
			{
				iid = inFile.nextInt();
				playerName = inFile.nextLine().trim();

				id[iid] = iid;
				player[iid] = playerName;
			}

			// calculations

			while(inFile2.hasNext())
			{
				iid = inFile2.nextInt();
				hits = inFile2.nextInt();
				walks = inFile2.nextInt();
				outs = inFile2.nextInt();

				hitsInTotal[iid] = hitsInTotal[iid] + hits;
				walksInTotal[iid] = walksInTotal[iid] + walks;
				outsInTotal[iid] = outsInTotal[iid] + outs;
			}

			for (i=1;i<nplayers;i++)
			{
				average[i] = ((float)hitsInTotal[i])/(hitsInTotal[i] + outsInTotal[i]);
				batAvg = average[i];
			}

			for (row=1;row<nplayers-1;row++)
	   		{
		  		mi=row;
		    	for (i=row+1;i<nplayers;i++)
		   		{
		 	   		if (average[i]>average[mi])
		     	   		mi=i;
	 	   		}
		   	swap(player,row,mi);
		   	swap(id,row,mi);
		   	swap(hitsInTotal,row,mi);
		   	swap(walksInTotal,row,mi);
		   	swap(outsInTotal,row,mi);
		  	swap(average,row,mi);
			}

			// output

			System.out.println("Lab8");
			System.out.println ("--------------------------------\n\n");

			System.out.printf("%11s%11s%11s%11s%11s%11s\n", "PLAYER", "ID", "HITS", "WALKS", "OUTS","AVERAGE");

			for (i=1;i<nplayers;i++)
			{
				System.out.printf("%11s%11d%11d%11d%11d%11.3f\n", player[i], id[i], hitsInTotal[i], walksInTotal[i], outsInTotal[i],average[i]);
			}

			inFile.close();
		}

	public static void swap (int [] a, int i, int j)
	{
		int temp;
		temp=a[i];
		a[i]=a[j];
		a[j]=temp;

	}
	public static void swap (float [] a, int i, int j)
	{
		float temp;
		temp=a[i];
		a[i]=a[j];
		a[j]=temp;

	}
	public static void swap (String [] a, int i, int j)
	{
		String temp;
		temp=a[i];
		a[i]=a[j];
		a[j]=temp;

	}
}