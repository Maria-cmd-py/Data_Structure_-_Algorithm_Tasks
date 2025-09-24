#include <iostream>
using namespace std;
int main() {
    int n;
    cout << "Enter number of members: ";
    cin >> n;
    int members[100];
    cout << "Enter membership numbers: ";
    for (int i = 0; i < n; i++) cin >> members[i];
    int target, comparisons = 0;
    cout << "Enter number to search: ";
    cin >> target;
    int index = -1;
    for (int i = 0; i < n; i++) {
        comparisons++;
        if (members[i] == target) {
            index = i;
            break;
        }
    }
    if (index != -1)
        cout << "Found at index " << index;
    else
        cout << "Not found";
    cout << " | Comparisons: " << comparisons << endl;
}
