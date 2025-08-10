#ifndef LINKEDLIST_H
#define LINKEDLIST_H

class LinkedList
{
public:
    struct node {
        public:
            int value;
            node* next;
            node(int val) : value(val), next(nullptr) {}
    };
    LinkedList();
    ~LinkedList();
    void push(int val);
    int pop();
    bool isEmpty();
    int size();
    void show();
    void reverse();
private:
    node* head;
    node* tail;
    int length;

};
#endif
