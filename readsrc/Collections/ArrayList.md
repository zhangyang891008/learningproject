*ArrayList*

一些变量：

```
private static final int DEFAULT_CAPACITY = 10; //某认容量为10

private static final Object[] EMPTY_ELEMENTDATA = {}; //默认为空的数组实例

transient Object[] elementData; //non-private to simplify nested class access

private int size; //The size of the ArrayList (the number of elements it contains).

/**
     * Shared empty array instance used for default sized empty instances. We
     * distinguish this from EMPTY_ELEMENTDATA to know how much to inflate when
     * first element is added.
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
```

构造方法：

（1）默认构建一个空数组：

```
public ArrayList() {
    this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
}
```

（2）给定数组大小的构造方法

```
public ArrayList(int initialCapacity) {
    if (initialCapacity > 0) {
        this.elementData = new Object[initialCapacity];
    } else if (initialCapacity == 0) {
        this.elementData = EMPTY_ELEMENTDATA;
    } else {
        throw new IllegalArgumentException("Illegal Capacity: "+
                                           initialCapacity);
    }
}
```

（3）给特定的集合构建数组

```
public ArrayList(Collection<? extends E> c) {
    elementData = c.toArray();
    if ((size = elementData.length) != 0) {
        // c.toArray might (incorrectly) not return Object[] (see 6260652)
        if (elementData.getClass() != Object[].class) //如果不是Object，转成实际类型
            elementData = Arrays.copyOf(elementData, size, Object[].class);
    } else {
        // replace with empty array.
        this.elementData = EMPTY_ELEMENTDATA;
    }
}

*Arrays.copyOf()*
    public static <T,U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
        @SuppressWarnings("unchecked")
        T[] copy = ((Object)newType == (Object)Object[].class)
            ? (T[]) new Object[newLength]
            : (T[]) Array.newInstance(newType.getComponentType(), newLength);
        System.arraycopy(original, 0, copy, 0,
                         Math.min(original.length, newLength));
        return copy;
    }
```

trimToSize

```
public void trimToSize() {
    modCount++;
    if (size < elementData.length) { //如果当前数组大小大于存储的元素的数量，才需要trim
        elementData = (size == 0)
          ? EMPTY_ELEMENTDATA
          : Arrays.copyOf(elementData, size);
    }
}
```

***ensureCapacity***

​	(1) 接口方法：

​		接收最小容量值参数，与当前数组的下界比较（如果数组为空下界0，如果不为空返回默认数组大小default_capacity）,如果minCapacity比当前的下界值大，就存在扩容的可能。

```
public void ensureCapacity(int minCapacity) {
    int minExpand = (elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
        // any size if not default element table
        ? 0
        // larger than default for default empty table. It's already
        // supposed to be at default size.
        : DEFAULT_CAPACITY;

    if (minCapacity > minExpand) {
        ensureExplicitCapacity(minCapacity);
    }
}
```

（2）内部方法：ensureExplicitCapacity

​		如果minCapacity比当前数组长度长，则有扩容的必要。

```
private void ensureExplicitCapacity(int minCapacity) {
    modCount++;

    // overflow-conscious code
    if (minCapacity - elementData.length > 0)
        grow(minCapacity);
}
```

（3）扩容方法：grow

​		扩容后容量为当前数组长度的1.5倍为newCapacity，如果newCapacity比minCapacity小，设置为minCapacity。

​		如果调整后的newCapacity比最大数组容量MAX_ARRAY_SIZE大，则比较minCapacity和最大数组容量MAX_ARRAY_SIZE，如果minCapacity更大，则扩容到Integer.MAX_VALUE，否则扩容到MAX_ARRAY_SIZE。

```
private void grow(int minCapacity) {
    // overflow-conscious code
    int oldCapacity = elementData.length;
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    if (newCapacity - minCapacity < 0)
        newCapacity = minCapacity;
    if (newCapacity - MAX_ARRAY_SIZE > 0)
        newCapacity = hugeCapacity(minCapacity);
    // minCapacity is usually close to size, so this is a win:
    elementData = Arrays.copyOf(elementData, newCapacity);
}

private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
            Integer.MAX_VALUE :
            MAX_ARRAY_SIZE;
    }
```

*两种转数组的方式*

返回Obbject数组的方式：

```
public Object[] toArray() {
    return Arrays.copyOf(elementData, size);
}
```

返回指定类型的方式：

```
public <T> T[] toArray(T[] a) {
    if (a.length < size)
        // Make a new array of a's runtime type, but my contents:
        return (T[]) Arrays.copyOf(elementData, size, a.getClass());
    System.arraycopy(elementData, 0, a, 0, size);
    if (a.length > size)
        a[size] = null; //标记为null以后表示数组结束
    return a;
}
```

**************************************

add方法：

（1）没有指定添加位置的：

```
public boolean add(E e) {
    ensureCapacityInternal(size + 1);  // Increments modCount!!
    elementData[size++] = e;
    return true;
}
```

（2）指定添加索引位置的：

```
public void add(int index, E element) {
    rangeCheckForAdd(index); // 大于size小于0不合法！

    ensureCapacityInternal(size + 1);  // Increments modCount!!
    System.arraycopy(elementData, index, elementData, index + 1,
                     size - index);
    elementData[index] = element;
    size++;
}
```

********************

remove方法：

（1）按照索引位置移除：先判断边界，然后记录修改加1，oldValue保存被删除的值，移动删除元素后面 的元素，多余位置为空，size--，返回删除元素

```
public E remove(int index) {
    rangeCheck(index);

    modCount++;
    E oldValue = elementData(index);

    int numMoved = size - index - 1;
    if (numMoved > 0)
        System.arraycopy(elementData, index+1, elementData, index,
                         numMoved);
    elementData[--size] = null; // clear to let GC do its work

    return oldValue;
}
```

（2）按照元素移除：

​		如果元素为空，遍历找到为空的元素，移动删除元素后面的元素，最后的元素置空，size--

​		不为空则遍历元素，逐一比对，找到删除元素的位置，然后执行删除流程。这个流程与按索引删除相同，为什么不直接复用代码呢？？？

```
public boolean remove(Object o) {
    if (o == null) {
        for (int index = 0; index < size; index++)
            if (elementData[index] == null) {
                fastRemove(index);
                return true;
            }
    } else {
        for (int index = 0; index < size; index++)
            if (o.equals(elementData[index])) {
                fastRemove(index);
                return true;
            }
    }
    return false;
}

/*
 * Private remove method that skips bounds checking and does not
 * return the value removed.
 */
private void fastRemove(int index) {
    modCount++;
    int numMoved = size - index - 1;
    if (numMoved > 0)
        System.arraycopy(elementData, index+1, elementData, index,
                         numMoved);
    elementData[--size] = null; // clear to let GC do its work
}
```

**1.8新特性，支持并发

    // 表示迭代器需要按照原始的顺序迭代器中的元素
        public static final int ORDERED    = 0x00000010;
        // 迭代器中的元素是没音重复的
        public static final int DISTINCT   = 0x00000001;
        // 按照某种排序方式的顺序迭代其中的元素
        public static final int SORTED     = 0x00000004;
        // 表示迭代器中的元素的个数是可计数的，有界的
        public static final int SIZED      = 0x00000040;
        // 迭代器中的元素是非空的
        public static final int NONNULL    = 0x00000100;
        // 迭代器中的元素是不可以改变的，不能增加也不能替换和删除。
        public static final int IMMUTABLE  = 0x00000400;
        // 表示迭代器的数据源是线程安全的`
        public static final int CONCURRENT = 0x00001000;
        // 表示当前的迭代器的所有的子迭代器（直接的或者间接的），都是'SIZED'和SUBSIZED的
        public static final int SUBSIZED = 0x00004000;
     
     
     ******************
     
     
     public interface Spliterator<T> {
        // 如果有元素剩余，那么执行action，并返回true，如果没有元素剩余，返回false
        boolean tryAdvance(Consumer<? super T> action);
        
        // 对当前的线程中的元素执行给定的操作，直到所有的元素被处理或者抛出异常
        default void forEachRemaining(Consumer<? super T> action) {
            // 从这里也可以看出tryAdvance的用法
            do { } while (tryAdvance(action));
        }
        
        // 将一个Spliterator。分割的Spliterator可以被用于每个子线程进行处理，从而达到并发的效果
        Spliterator<T> trySplit();
        
        // 返回forEachRemain()需要遍历元素总数的估计值，如果这个结果是无穷大，未计数的，那么返回
        long estimateSize();
        
        // 如果当前线程是可以计算剩余元素的总数，那么返回剩余元素的总数，否则返回-1
        default long getExactSizeIfKnown() {
            // 这里利用了与、或运算，可以先看下面的
            return (characteristics() & SIZED) == 0 ? -1L : estimateSize();
        }
        
        // 返回此Spliterator及其元素的一组特征值，这些结果表示为（ORDERED ， DISTINCT ， SORTED ， SIZED ，  NONNULL ， IMMUTABLE ， CONCURRENT ， SUBSIZED ）的或运算
        // 如果符合该Spliterator有什么特性，那么代表那个属性的那一位就是1，否则就是0
        int characteristics();
    
        // Spliterator是否有执行的特性，
        // 这里同样使用了位运算的特性
        default boolean hasCharacteristics(int characteristics) {
            return (characteristics() & characteristics) == characteristics;
        }
    
        // 如果这个Spilterator的数据源是可排序的，如果数据源是自然排序，返回null。 如果数据源不是SORTED，则抛出IllegalStateException
        default Comparator<? super T> getComparator() {
            throw new IllegalStateException();
    }
     
