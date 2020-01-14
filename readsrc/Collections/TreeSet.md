**TreeSet**

实现接口NavigableSet<E>, NavigableSet继承自SortedSet<E>。是有序的集合

存储集合元素的容器 

```
private transient NavigableMap<E,Object> m;
```

add批量添加元素：

```
public  boolean addAll(Collection<? extends E> c) {
    // Use linear-time version if applicable 
    //（1）入参collection如果是SortedSet，并且当前容器是TreeMap,采用TreeMap中自带的方法添加
    //（2）否则，调用AbstractionCollection抽象方法addAll()的具体实现。
    if (m.size()==0 && c.size() > 0 &&
        c instanceof SortedSet &&
        m instanceof TreeMap) {
        SortedSet<? extends E> set = (SortedSet<? extends E>) c;
        TreeMap<E,Object> map = (TreeMap<E, Object>) m;
        Comparator<?> cc = set.comparator();
        Comparator<? super E> mc = map.comparator();
        if (cc==mc || (cc != null && cc.equals(mc))) {
            map.addAllForTreeSet(set, PRESENT);
            return true;
        }
    }
    return super.addAll(c);
}
```