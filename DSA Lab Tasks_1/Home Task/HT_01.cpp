#include <iostream>
using namespace std;
int main() {
    int n;
    cout << "Enter number of members: ";
    cin >> n;
    int members[100];
    cout << "Enter membership numbers: ";
    for (int i = 0; i < n; i++) cin >> members[i];
    cout << "Reverse order: ";
    for (int i = n - 1; i >= 0; i--) cout << members[i] << " ";
    cout << endl;
}
