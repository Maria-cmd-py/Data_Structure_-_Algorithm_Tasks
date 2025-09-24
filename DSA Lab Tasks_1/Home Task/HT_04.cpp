#include <iostream>
using namespace std;
int main() {
    int n;
    cout << "Enter number of members: ";
    cin >> n;
    int members[100];
    cout << "Enter membership numbers: ";
    for (int i = 0; i < n; i++) cin >> members[i];
    int pos, newMem;
    cout << "Enter position and new member: ";
    cin >> pos >> newMem;
    if (pos < 0 || pos > n) {
        cout << "Invalid position.\n";
        return 0;
    }
    for (int i = n; i > pos; i--) {
        members[i] = members[i - 1];
    }
    members[pos] = newMem;
    n++;
    cout << "After insert: ";
    for (int i = 0; i < n; i++) cout << members[i] << " ";
    cout << endl;
}
