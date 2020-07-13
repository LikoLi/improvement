# 集合

数组是保存一组对象最有效的方式，如果想保存一组基本类型数据，也推荐使用数组。但数组具有固定的大小尺寸，在不知道将需要多少个对象，或者是否需要更复杂的方式存储对象时，固定大小这一限制就显得太过受限了。

java.util库提供了一套相当完整的集合类(collection classes)来解决这个问题，其中基本的类型有List、Set、Queue、和Map。这些类也被称作容器类（container classes）。

java集合类都可以自动地调整自己的大小。

## 泛型和类型安全的集合
使用Java5之前的集合的一个主要问题是编译器允许你向集合中插入不正确的类型。
使用泛型，从List中获取元素不需要强制类型转换。因为List知道它持有什么类型。

## 基本概念
集合(Collection): List/Set/Queue
映射(Map): Map

## 添加元素组
`Arrays.asList()` 调用 add() 或 remove()，由于这两个方法会尝试修改数组大小，所以会在运行时得到“Unsupported Operation（不支持的操作）”错误
`Collections.addAll()`

## 集合的打印
必须使用`Arrays.toString()`来生成数组的可打印形式。
打印集合无需任何帮助。

ArrayList和LinkedList的区别: 
    1. 执行某些操作时的性能
    2. LinkedList包含的操作多余ArrayList

Set:
    1. HashSet检索元素最快，存储复杂，无序
    2. TreeSet有序，将结果升序保存
    3. LinkedHashSet 按先后顺序保存

Map:
    1. HashMap中的顺序不是插入顺序，因为 HashMap 实现使用了非常快速的算法来控制顺序
    2. TreeMap通过比较结果升序来保存键
    3. LinkedHashMap在保持HashMap查找速度的同时按键的插入顺序保存键

## 列表List
List承诺将元素保存在特定的序列中。 List 接口在 Collection 的基础上添加了许多方法，允许在 List 的中间插入和删除元素。

有两种类型的 List ：
- 基本的 ArrayList ，擅长随机访问元素，但在 List 中间插入和删除元素时速度较慢。
- LinkedList ，它通过代价较低的在 List 中间进行的插入和删除操作，提供了优化的顺序访问。 LinkedList 对于随机访问来说相对较慢，但它具有比 ArrayList 更大的特征集。







