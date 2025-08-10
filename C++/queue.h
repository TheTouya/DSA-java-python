#ifndef QUEUE_H
#define QUEUE_H
class queue
{
public:
    struct node {
        int value;
        node* next;
        node(int val) : value(val), next(nullptr) {}
    };
    queue();
    void enque(int val);
    int deque();
    const bool isEmpty();
    const int get_length();
    ~queue();
private:
    node* head;
    node* tail;
    int length;

};

#endif // QUEUE_H
