#include <iostream>

int lim = 64000;
int tree[64000];
int get(int x) {
	int sum = 0;
	while (x > 0){
		sum += tree[x];
		x -= (x & -x);
	}
	return sum;
}
void add(int x) {
	while(x <= lim) {
		tree[x]++;
		x += (x & -x);
	}
}
int main() {
	int n,x,y;
	scanf("%d",&n);
	int cnts[15000];
	for(int i=0; i<n; i++) cnts[i]=0;
	for(int i=0; i<n; i++) {
		scanf("%d %d",&x,&y);
		x++;
		cnts[get(x)]++;
		add(x);
	}
	for(int i=0; i<n; i++)
		printf("%d\n",cnts[i]);
}
