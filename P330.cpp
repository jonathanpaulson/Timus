#include <iostream>
using namespace std;
int main() {
    int sums[10001];
    int n,q,a,b;
    cin>>n;
    for(int i=1; i<=n; i++) {
        cin>>sums[i];
        sums[i]=sums[i]+sums[i-1];
    }
    cin>>q;
    for(int i=0; i<q; i++) {
        cin>>a;
        cin>>b;
        cout<<(sums[b]-sums[a-1])<<endl;
    }
}
