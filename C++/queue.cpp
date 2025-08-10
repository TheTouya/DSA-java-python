#include "queue.h"
#include <iostream>
using std::cerr;
queue::queue()
{
    length = 0;
    head = nullptr;
    tail = nullptr;
}

queue::~queue()
{
    if(length == 0) cerr << "THE QUEUE IS ALREADY EMPTY";
    node* cur = head;
    while(cur != nullptr) {
        node* temp = cur->next;
        delete cur;
        cur = temp;
    }
}
void queue::enque(int val) {
    node* nd = new node(val);
    if(length == 0) {
        head = nd;
        tail = nd;
    } else {
        tail->next = nd;
        tail = nd;
    }
    length++;
}
int queue::deque() {
    if(length == 0) cerr << "QUEUE EMPTY" << std::endl;
    node* temp = head;
    int val = head->value;
    head = head->next;
    delete temp;
    length--;
    return val;
}
const bool queue::isEmpty() {
    return length == 0;
}
const int queue::get_length() {
    return length;
}