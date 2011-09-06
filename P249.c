#include <stdio.h>

int main() { 
    int n,m;
    int prev[3000];
    int line[3000];
    int i;
	scanf("%d %d",&n,&m);
    if(n <=1 || m<=1) { printf("Yes"); return 0; }

    for(i=0; i<m; i++)
        scanf("%d",&line[i]);
    int cnt = 1;

    do {
        for(i=0; i<m; i++)
            prev[i] = line[i];
        for(i=0; i<m; i++)
            scanf("%d",&line[i]);
        cnt++;
        for(i=0; i<m-1; i++)
            if(line[i]+line[i+1]+prev[i]+prev[i+1] == 3) {
                printf("No"); return 0;
            }
    } while(cnt < n);
    printf("Yes");
}
