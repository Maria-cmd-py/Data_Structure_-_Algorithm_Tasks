#include<iostream>
using namespace std;
int main(){
    int n;
    cout << "Enter the number of members: ";
    cin >> n;
    int members[100];
    cout<<"Enter the Member Number: ";
    for(int i = 0; i < n; i++){
        cin >> members[i];
    }
    cout<<"MemberShip Numbers are: ";
    for(int i = 0; i < n; i++){
        cout<<members[i]<<" ";
    }
    return 0;
}