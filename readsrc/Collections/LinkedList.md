**LinkedList**

添加元素add(E element)不指定具体添加位置的方法，默认添加到链表的末尾

```
public boolean add(E e) {
    linkLast(e);
    return true;
}
```

```
void linkLast(E e) {
    final Node<E> l = last;
    final Node<E> newNode = new Node<>(l, e, null);
    last = newNode;
    if (l == null)
        first = newNode;
    else
        l.next = newNode;
    size++;
    modCount++;
}
```

带有指定添加元素位置的方法add(int index, E element)

```
public void add(int index, E element) {
    checkPositionIndex(index);

    if (index == size)
        linkLast(element);
    else
        linkBefore(element, node(index));
}
```

```
void linkBefore(E e, Node<E> succ) {
    // assert succ != null;
    final Node<E> pred = succ.prev;
    final Node<E> newNode = new Node<>(pred, e, succ);
    succ.prev = newNode;
    if (pred == null)
        first = newNode;
    else
        pred.next = newNode;
    size++;
    modCount++;
}
```

**找到要添加元素位置的前驱元素**

```
Node<E> node(int index) {
    // assert isElementIndex(index);
		//如果index小于一半，从前向后找，如果大于一半从后往前找
    if (index < (size >> 1)) {
        Node<E> x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    } else {
        Node<E> x = last;
        for (int i = size - 1; i > index; i--)
            x = x.prev;
        return x;
    }
}
```

批量添加元素

```
public boolean addAll(int index, Collection<? extends E> c) {
    checkPositionIndex(index);

    Object[] a = c.toArray();
    int numNew = a.length;
    if (numNew == 0)      //没有需要添加的元素，直接返回
        return false;

    Node<E> pred, succ;    //找到当前添加位置的前驱、后继元素
    if (index == size) {
        succ = null;
        pred = last;
    } else {
        succ = node(index);  
        pred = succ.prev;
    }

    for (Object o : a) {       //循环逐一添加元素
        @SuppressWarnings("unchecked") E e = (E) o;
        Node<E> newNode = new Node<>(pred, e, null);
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        pred = newNode;
    }

    if (succ == null) {       //调整前驱和后继指针
        last = pred;
    } else {
        pred.next = succ;
        succ.prev = pred;
    }

    size += numNew;      //调整链表大小，更新修改计数器
    modCount++;
    return true;
}
```

 DescendingIterator 降序迭代器：包装了ListItr。

```
/**
 * Adapter to provide descending iterators via ListItr.previous
 */
private class DescendingIterator implements Iterator<E> {
    private final ListItr itr = new ListItr(size());
    public boolean hasNext() {
        return itr.hasPrevious();
    }
    public E next() {
        return itr.previous();
    }
    public void remove() {
        itr.remove();
    }
}
```

**实现了Dequeue的双端队列的接口方法**

** removeFirst removeLast

** getFirst getLast

** removeFirst removeLast

