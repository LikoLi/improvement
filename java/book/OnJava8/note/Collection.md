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

## 迭代器

迭代器可以解决的问题: 编写一段通用代码，它不知道或不关心它正在使用什么类型的集合，因此它可以用于不同类型的集合

*迭代器*（也是一种设计模式）的概念实现了这种抽象。迭代器是一个对象，它在一个序列中移动并选择该序列中的每个对象，而客户端程序员不知道或不关心该序列的底层结构。另外，迭代器通常被称为*轻量级对象*（lightweight object）：创建它的代价小。因此，经常可以看到一些对迭代器有些奇怪的约束。例如，Java 的 **Iterator** 只能单向移动。这个 **Iterator** 只能用来：

1. 使用 `iterator()` 方法要求集合返回一个 **Iterator**。 **Iterator** 将准备好返回序列中的第一个元素。
2. 使用 `next()` 方法获得序列中的下一个元素。
3. 使用 `hasNext()` 方法检查序列中是否还有元素。
4. 使用 `remove()` 方法将迭代器最近返回的那个元素删除。

迭代器统一了对集合的访问

### ListIterator

**ListIterator** 是一个更强大的 **Iterator** 子类型，它只能由各种 **List** 类生成。 **Iterator** 只能向前移动，而 **ListIterator** 可以双向移动。它可以生成迭代器在列表中指向位置的后一个和前一个元素的索引，并且可以使用 `set()` 方法替换它访问过的最近一个元素。可以通过调用 `listIterator()` 方法来生成指向 **List** 开头处的 **ListIterator** ，还可以通过调用 `listIterator(n)` 创建一个一开始就指向列表索引号为 **n** 的元素处的 **ListIterator** 。

## 链表LinkedList

**LinkedList** 也像 **ArrayList** 一样实现了基本的 **List** 接口，但它在 **List** 中间执行插入和删除操作时比 **ArrayList** 更高效。然而,它在随机访问操作效率方面却要逊色一些。

**LinkedList 还添加了一些方法，使其可以被用作栈、队列或双端队列（deque）** 。在这些方法中，有些彼此之间可能只是名称有些差异，或者只存在些许差异，以使得这些名字在特定用法的上下文环境中更加适用（特别是在 **Queue** 中）。例如：

- `getFirst()` 和 `element()` 是相同的，它们都返回列表的头部（第一个元素）而并不删除它，如果 **List** 为空，则抛出 **NoSuchElementException** 异常。 `peek()` 方法与这两个方法只是稍有差异，它在列表为空时返回 **null** 。
- `removeFirst()` 和 `remove()` 也是相同的，它们删除并返回列表的头部元素，并在列表为空时抛出 **NoSuchElementException** 异常。 `poll()` 稍有差异，它在列表为空时返回 **null** 。
- `addFirst()` 在列表的开头插入一个元素。
- `offer()` 与 `add()` 和 `addLast()` 相同。 它们都在列表的尾部（末尾）添加一个元素。
- `removeLast()` 删除并返回列表的最后一个元素。

## 堆栈Stack

堆栈是“后进先出”（LIFO）集合。它有时被称为*叠加栈*（pushdown stack），因为最后“压入”（push）栈的元素，第一个被“弹出”（pop）栈。经常用来类比栈的事物是带有弹簧支架的自助餐厅托盘。最后装入的托盘总是最先拿出来使用的。

Java 1.0 中附带了一个 **Stack** 类，结果设计得很糟糕（为了向后兼容，我们永远坚持 Java 中的旧设计错误）。Java 6 添加了 **ArrayDeque** ，其中包含直接实现堆栈功能的方法

## 集合

**Set** 不保存重复的元素。 如果试图将相同对象的多个实例添加到 **Set** 中，那么它会阻止这种重复行为。 **Set** 最常见的用途是测试归属性，可以很轻松地询问某个对象是否在一个 **Set** 中。因此，查找通常是 **Set** 最重要的操作，因此通常会选择 **HashSet** 实现，该实现针对快速查找进行了优化。

**Set** 具有与 **Collection** 相同的接口，因此没有任何额外的功能，不像前面两种不同类型的 **List** 那样。实际上， **Set** 就是一个 **Collection** ，只是行为不同。（这是继承和多态思想的典型应用：表现不同的行为。）

早期 Java 版本中的 **HashSet** 产生的输出没有可辨别的顺序。这是因为出于对速度的追求， **HashSet** 使用了散列。由 **HashSet** 维护的顺序与 **TreeSet** 或 **LinkedHashSet** 不同，因为它们的实现具有不同的元素存储方式。 **TreeSet** 将元素存储在红-黑树数据结构中，而 **HashSet** 使用散列函数。 **LinkedHashSet** 因为查询速度的原因也使用了散列，但是看起来使用了链表来维护元素的插入顺序。

使用TreeSet可以对结果进行排序

## 映射Map

**Map** 可以返回由其键组成的 **Set** ，由其值组成的 **Collection** ，或者其键值对的 **Set** 。

## 队列Queue

