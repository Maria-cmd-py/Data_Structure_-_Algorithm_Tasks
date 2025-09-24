#include <iostream>
using namespace std;
int main() {
    int n;
    cout << "Enter number of members: ";
    cin >> n;
    int members[100], copy[100]; 
    cout << "Enter membership numbers: ";
    for (int i = 0; i < n; i++) {
        cin >> members[i];
    }
    for (int i = 0; i < n; i++) {
        copy[i] = members[i];
    }
    cout << "Copied array: ";
    for (int i = 0; i < n; i++) {
        cout << copy[i] << " ";
    }
    return 0;
}
