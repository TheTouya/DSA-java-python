#ifndef STACK_H
#define STACK_H
#include <vector>
using std::vector;
class stack
{
public:
    struct node {
        public:
            int val;
            node *below;
            node(int value) : val(value), below(nullptr) {}
    };
    void push(int val);
    int pop();
    vector<int> display();
    stack();
    ~stack();
private:
    int length;
    node* top;

};

#endif // STACK_H
