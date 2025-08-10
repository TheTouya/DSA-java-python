#include <iostream>
#include "LinkedList.h"
#include "binarytree.h"
#include <vector>
#include <functional>
#include "stack.h"
#include "queue.h"

using namespace std;

int main() {
    queue que;
    que.enque(12);
    que.enque(14);
    cout << que.deque() << endl;
    cout << que.isEmpty() << endl;
    cout << que.get_length() << endl;
    return 0;
}