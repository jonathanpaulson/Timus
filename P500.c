#include <stdio.h>

int main() { 
	int k,n,m;   
	scanf("%d %d %d",&k,&n,&m);
	int min = k;
	int best = 0;
	int adj[20][30];
	int i,j,A,v;
	for(i=0; i<20; i++)
		for(j=0; j<30; j++)
			adj[i][j]=0;
	for(i=0; i<m; i++) {
		int start,end,cat;
		scanf("%d %d %d",&start,&end,&cat);
		adj[cat][start] |= (1<<end);
		adj[cat][end]   |= (1<<start);
	}

	int lim = 2<<k;
	for(A=0; A<lim; A++) {
		int E[30];
		for(i=0;i<30; i++) E[i]=0;
		int count=0;
		for(i=0; i<k; i++) {
			if( ((A>>i)&1)==0 ) continue;
			count++;
			for(j=0; j<n; j++)
				E[j] |= adj[i][j];
		}

		int visited = 1;
		for(i=0; i<n; i++) {
			for(v=0; v<n; v++) {
				if( ((visited>>v)&1) )
					visited |= E[v];
			}
		}
		if( ((visited>>1)&1) == 1 && count<min) {
			min = count;
			best = A;
		}
	}
	printf("%d\n",min);
	for(i=0; i<k; i++)
		if( ((best>>i)&1)==1 )
			printf("%d ",i);
	printf("\n");
}
