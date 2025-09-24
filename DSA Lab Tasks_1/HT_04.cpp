#include <iostream>
using namespace std;
int main() {
    int n;
    cout << "Enter number of members: ";
    cin >> n;
    int members[100];
    cout << "Enter membership numbers: ";
    for (int i = 0; i < n; i++) {
        cin >> members[i];
    }
    int target;
    cout << "Enter number to search: ";
    cin >> target;
    int first = -1, last = -1;
    for (int i = 0; i < n; i++) {
        if (members[i] == target) {
            if (first == -1) {
                first = i;   // set first time
            }
            last = i;        // update every time found
        }
    }
    cout << "First index = " << first << endl;
    cout << "Last index = " << last << endl;
    return 0;
}
