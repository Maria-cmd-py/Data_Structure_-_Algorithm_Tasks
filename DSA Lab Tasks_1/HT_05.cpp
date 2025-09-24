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
    int evenCount = 0, oddCount = 0;
    for (int i = 0; i < n; i++) {
        if (members[i] % 2 == 0) {
            evenCount++;
        } else {
            oddCount++;
        }
    }
    cout << "Even count = " << evenCount << endl;
    cout << "Odd count = " << oddCount << endl;
    return 0;
}
