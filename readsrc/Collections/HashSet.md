**HashSet**

构造函数：现有的集合初始化，需要设置HashMap的大小为集合大小1.25倍和16之间的较大值

```
public HashSet(Collection<? extends E> c) {
    map = new HashMap<>(Math.max((int) (c.size()/.75f) + 1, 16));
    addAll(c);
}
```

自定义装填因子、容器大小的构造函数

```
public HashSet(int initialCapacity, float loadFactor) {
    map = new HashMap<>(initialCapacity, loadFactor);
}
 
public HashSet(int initialCapacity) {
    map = new HashMap<>(initialCapacity);
}
```



HashSet中的修改操作：时间复杂度都是常量

add(E e):HashMap中的key存储值，PRESENT是填充值。key可以为空

```
// Dummy value to associate with an Object in the backing Map
private static final Object PRESENT = new Object();
```

```
public boolean add(E e) {
    return map.put(e, PRESENT)==null;
}
```

remove（Object o）

```
public boolean remove(Object o) {
    return map.remove(o)==PRESENT;
}
```

序列化：重写序列化方法 writeObject readObject

​		*** CSDN帖子：https://blog.csdn.net/u014653197/article/details/78114041

​		处理下面的readObject  writeObject方法外，如果使用的不是枚举的实现形式，为了保证反序列化出来后的对象，不会破坏单例的情况，我们还会经常看到下面的方法：private Object readResolve()

由于map被访问修饰符transient修饰，因此默认的序列化是不会存在这个信息的。

```
private transient HashMap<E,Object> map;
```

writeObject（）方法在写入默认的信息以后，添加自定义的信息的写入。

```
private void writeObject(java.io.ObjectOutputStream s)
    throws java.io.IOException {
    // Write out any hidden serialization magic
    s.defaultWriteObject();

    // Write out HashMap capacity and load factor
    s.writeInt(map.capacity());
    s.writeFloat(map.loadFactor());

    // Write out size
    s.writeInt(map.size());

    // Write out all elements in the proper order.
    for (E e : map.keySet())
        s.writeObject(e);
}
```

readObject（）在读取信息反序列化时，先反序列化默认信息，然后再反序列化自定义的信息

```
private void readObject(java.io.ObjectInputStream s)
    throws java.io.IOException, ClassNotFoundException {
    // Read in any hidden serialization magic
    s.defaultReadObject();

    // Read capacity and verify non-negative.
    int capacity = s.readInt();
    if (capacity < 0) {
        throw new InvalidObjectException("Illegal capacity: " +
                                         capacity);
    }

    // Read load factor and verify positive and non NaN.
    float loadFactor = s.readFloat();
    if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
        throw new InvalidObjectException("Illegal load factor: " +
                                         loadFactor);
    }

    // Read size and verify non-negative.
    int size = s.readInt();
    if (size < 0) {
        throw new InvalidObjectException("Illegal size: " +
                                         size);
    }

    // Set the capacity according to the size and load factor ensuring that
    // the HashMap is at least 25% full but clamping to maximum capacity.
    capacity = (int) Math.min(size * Math.min(1 / loadFactor, 4.0f),
            HashMap.MAXIMUM_CAPACITY);

    // Create backing HashMap
    map = (((HashSet<?>)this) instanceof LinkedHashSet ?
           new LinkedHashMap<E,Object>(capacity, loadFactor) :
           new HashMap<E,Object>(capacity, loadFactor));

    // Read in all elements in the proper order.
    for (int i=0; i<size; i++) {
        @SuppressWarnings("unchecked")
            E e = (E) s.readObject();
        map.put(e, PRESENT);
    }
}
```

**为什么HashMap要自己实现writeObject和readObject方法？**

参考：https://blog.csdn.net/weixin_34346099/article/details/91940085