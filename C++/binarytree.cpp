#include <iostream>
#include "binarytree.h"
#include <queue>
#include <vector>
#include <functional>
using std::queue;
using std::vector;
using std::endl;
using std::function;
using std::cout;
binarytree::binarytree()
{
    root = nullptr;
}

binarytree::~binarytree()
{
    if(!root) {return;}
    queue<node*> que;
    node* temp = root;
    que.push(temp);
    while(!que.empty()) {
        node* cur = que.front();
        que.pop();
        if(cur->left != nullptr) {
            que.push(cur->left);
        }
        if(cur->right != nullptr) {
            que.push(cur->right);
        }
        delete cur;
    }
}
void binarytree::push(int value) {
    node* new_node = new node(value);
    if(root == nullptr) {
        root = new_node;
    } else {
        node* cur = root;
        while(true) {
            if(cur->value < new_node->value) {
                if(cur->right == nullptr) {
                    cur->right = new_node;
                    break;
                } else {
                    cur = cur->right;
                }
            } else if(cur->value > new_node->value) {
                if(cur->left == nullptr) {
                    cur->left = new_node;
                    break;
                } else {
                    cur = cur->left;
                }
            } else {
                std::cout << "UNACCEOPTABLE" << std::endl;
                break;
            }
        }
    }
}
bool binarytree::contains(int val) {
    if(root == nullptr) return false;
    node* temp = root;
    while(temp != nullptr) {
        if(temp->value == val) {
            return true;
        } else if(temp->value < val) {
            temp = temp->right;
        } else {
            temp = temp->left;
        }
    }
    return false;
}
vector<int> binarytree::preorder() {
    vector<int> arr = {};
    function<void (node*)> traverse;
    traverse = [&](node* temp) {
        if(temp == nullptr) {
            return;
        }
        arr.push_back(temp->value);
        traverse(temp->left);
        traverse(temp->right);
    };
    traverse(root);
    return arr;
}
vector<int> binarytree::inorder() {
    vector<int> arr;
    function<void (node*)> traverse = [&](node* temp) {
        if(temp == nullptr) return;
        traverse(temp->left);
        arr.push_back(temp->value);
        traverse(temp->right);
    };
    traverse(root);
    return arr;
}
vector<int> binarytree::postorder() {
    vector<int> arr;
    function<void(node*)> traverse = [&](node* node) {
        if(node == nullptr) {
            return;
        }
        traverse(node->left);
        traverse(node->right);
        arr.push_back(node->value);
    };
    traverse(root);
    return arr;
}
vector<int> binarytree::BFS() {
    vector<int> visited;
    queue<node*> que;
    que.push(root);
    while(!que.empty()) {
        node* temp = que.front();
        que.pop();
        visited.push_back(temp->value);
        if(temp->left) {que.push(temp->left);}
        if(temp->right) {que.push(temp->right);}
    }
    return visited;
}