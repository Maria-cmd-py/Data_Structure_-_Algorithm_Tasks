#include <iostream>
using namespace std;
int main() {
    int n;
    cout << "Enter hours: ";
    cin >> n;
    int visitors[100];
    cout << "Enter visitors per hour: ";
    for (int i = 0; i < n; i++) cin >> visitors[i];
    int mn = visitors[0], mx = visitors[0], sum = 0;
    for (int i = 0; i < n; i++) {
        if (visitors[i] < mn) mn = visitors[i];
        if (visitors[i] > mx) mx = visitors[i];
        sum += visitors[i];
    }
    cout << "Min: " << mn << ", Max: " << mx 
         << ", Avg: " << (sum / (double)n) << endl;
}
