#include "stack.h"
#include <iostream>
using std::vector;
using std::cerr;
stack::stack()
{
    length = 0;
    top = nullptr;
}

stack::~stack()
{
    if(length == 0) cerr << "THE STACK IS ALREADY EMPTY";
    node* cur = top;
    while(cur != nullptr) {
        node* temp= cur->below;
        delete cur;
        cur = temp;
    }
}
void stack::push(int val) {
    node* nd = new node(val);
    if(length == 0) top = nd;
    nd->below = top;
    top = nd;
    length++;
    
}
int stack::pop() {
    if(length == 0) cerr << "THE STACK IS EMPTY";
    int rt_val = top->val;
    node* temp = top;
    top = top->below;
    delete temp;
    length--;
    return rt_val;
}
vector<int> stack::display() {
    if(length == 0) cerr << "THE STACK IS EMPTY";
    vector<int> arr;
    node* temp = top;
    while(temp != nullptr) {
        arr.push_back(temp->val);
        temp = temp->below;
    }
    return arr;
}