#include <iostream>
using namespace std;
int main()
{
	const int CAP = 100;
	int a[CAP]; // array of integers
	int n;
	cout << "Size: ";
	cin >> n;
	if (n < 0 || n > CAP){
		cout << "Invalid size" << endl;
		return 0;
	}cout << "Enter " << n << " tokens: "; // read n integers
	for (int i = 0; i < n; i++){
		cin >> a[i]; // read an integer
	}
	int k;
	cout << "Delete index (0.." << n - 1 << "): ";
	cin >> k;
	if (k < 0 || k >= n){
		cout << "Invalid index" << endl;
		return 0;
	}
	for (int i = k; i < n - 1; i++){// Shift Left from k
		a[i] = a[i + 1]; // copy from right to left
	} n--; // reduce size by 1
	cout << "After Delete: ";
	for (int i = 0; i < n; i++){
		cout << a[i] << (i + 1 < n ? ' ' : '\n');
	}
	return 0;
}