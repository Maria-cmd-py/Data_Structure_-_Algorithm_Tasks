#include <iostream>
using namespace std;
int main() {
    int m;
    cout << "Enter number of hours: ";
    cin >> m;
    int visitors[100];
    cout << "Enter visitors for each hour: ";
    for (int i = 0; i < m; i++) {
        cin >> visitors[i];
    }
    int sum = 0;
    for (int i = 0; i < m; i++) {
        sum += visitors[i];   // add all visitors
    }
    cout << "Total visitors = " << sum << endl;
    cout << "Count of hours = " << m << endl;
    return 0;
}
