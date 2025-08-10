#ifndef BINARYTREE_H
#define BINARYTREE_H
#include <vector>
using std::vector;
class binarytree
{
public:
    struct node {
        public:
            int value;
            node* right;
            node* left;
            node(int val) : value(val), left(nullptr), right(nullptr) {}
    };
    int find(int target);
    void push(int value);
    bool contains(int val);
    vector<int> preorder();
    vector<int> inorder();
    vector<int> postorder();
    vector<int> BFS();
    binarytree();
    ~binarytree();
private:
    node* root;

};

#endif // BINARYTREE_H
