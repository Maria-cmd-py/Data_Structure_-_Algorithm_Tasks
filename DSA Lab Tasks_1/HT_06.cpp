#include <iostream>
using namespace std;
int main()
{
    int n;
    cout << "Enter number of members: ";
    cin >> n;
    int members[100];
    cout << "Enter membership numbers: ";
    for (int i = 0; i < n; i++)
    {
        cin >> members[i];
    }
    bool sorted = true; // assume sorted
    for (int i = 0; i < n - 1; i++)
    {
        if (members[i] > members[i + 1])
        {
            sorted = false;
            break;
        }
    }
    if (sorted)
        cout << "Sorted" << endl;
    else
        cout << "Not Sorted" << endl;
    return 0;
}
