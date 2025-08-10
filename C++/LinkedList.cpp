#include <iostream>
#include "LinkedList.h"

LinkedList::LinkedList()
{
    head = nullptr;
    tail = nullptr;
    length = 0;
}

LinkedList::~LinkedList()
{
    node* temp = head;
    while(temp != nullptr) {
        node* tem_next = temp->next;
        delete temp;
        temp = tem_next;
    }
}
int LinkedList::size() {
    return length;
}
void LinkedList::push(int val) {
    node* new_node = new node(val);
    if(length == 0) {
        head = new_node;
        tail = new_node;
    } else {
        tail->next = new_node;
        tail = new_node;
    }
    length++;
}
int LinkedList::pop() {
    if(length == 0) {
        std::cout << "error out of index" << std::endl;
        return -1;
    } else if(length == 1) {
        int val = tail->value;
        tail = nullptr;
        head = nullptr;
        return val;
    } else {
        node* temp = head;
        while(temp->next != tail) {
            temp = temp->next;
        }
        int val = temp->next->value;
        tail = temp;
        temp->next = nullptr;
        delete temp->next;
        return val;
    }
}
bool LinkedList::isEmpty() {
    return length == 0;
}
void LinkedList::show() {
    node* temp = head;
    while(temp != nullptr) {
        std::cout << temp->value << "->";
        temp = temp->next;
    }
    std::cout << "" << std::endl;
}
void LinkedList::reverse() {
    if(length == 0) {
        std::cout << "cant be done" << std::endl;
    } else {
        node* cur = head;
        node* before {nullptr};
        node* after {nullptr};
        while(cur != nullptr) {
            after = cur->next;
            cur->next = before;
            before = cur;
            cur = after;
        }
        head = tail;
 
    }
}