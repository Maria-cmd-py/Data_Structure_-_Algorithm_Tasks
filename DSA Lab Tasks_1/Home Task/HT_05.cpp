#include <iostream>
using namespace std;
int main() {
    int n;
    cout << "Enter number of members: ";
    cin >> n;
    int members[100];
    cout << "Enter membership numbers: ";
    for (int i = 0; i < n; i++) cin >> members[i];
    int idx;
    cout << "Enter index to delete: ";
    cin >> idx;
    if (idx < 0 || idx >= n) {
        cout << "Invalid index.\n";
        return 0;
    }
    for (int i = idx; i < n - 1; i++) {
        members[i] = members[i + 1];
    }
    n--;
    cout << "After delete: ";
    for (int i = 0; i < n; i++) cout << members[i] << " ";
    cout << endl;
}
