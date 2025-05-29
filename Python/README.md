# DSA Python Library

This is a simple and extensible Python library for practicing and implementing fundamental **Data Structures and Algorithms (DSA)**.

Currently, it includes an enhanced **Linked List** implementation with the following features:

## Features

- Custom `Linked_List` class with:
  - `push()` and `pop()` methods
  - Reversal (`reverse()`)
  - Length support via `len()` (`__len__`)
  - Indexing support (`__getitem__`)
  - Iteration support (`__iter__`)
  - String representation (`__str__`)

## Example Usage

```python
from linked_list import Linked_List

ll = Linked_List()
ll.push(10)
ll.push(20)
ll.push(30)

print(len(ll))        # Output: 3
print(ll[1])          # Output: 20
for val in ll:
    print(val)        # Output: 10, 20, 30

ll.reverse()
print(ll)             # Output: 30 -> 20 -> 10
```
