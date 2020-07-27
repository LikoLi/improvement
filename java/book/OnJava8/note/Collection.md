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

队列是一个典型的“先进先出”（FIFO）集合。 即从集合的一端放入事物，再从另一端去获取它们，事物放入集合的顺序和被取出的顺序是相同的。队列通常被当做一种可靠的将对象从程序的某个区域传输到另一个区域的途径。队列在[并发编程](http://localhost:4000/docs/book/12-Collections.html)中尤为重要，因为它们可以安全地将对象从一个任务传输到另一个任务。

**LinkedList** 实现了 **Queue** 接口，并且提供了一些方法以支持队列行为，因此 **LinkedList** 可以用作 **Queue** 的一种实现。 通过将 **LinkedList** 向上转换为 **Queue** ，下面的示例使用了在 **Queue** 接口中与 **Queue** 相关(Queue-specific)的方法

`offer()` 是与 **Queue** 相关的方法之一，它在允许的情况下，在队列的尾部插入一个元素，或者返回 **false** 。 `peek()` 和 `element()` 都返回队头元素而不删除它，但是如果队列为空，则 `element()` 抛出 **NoSuchElementException** ，而 `peek()` 返回 **null** 。 `poll()` 和 `remove()` *都删除并返回队头元素，但如果队列为空，`poll()` 返回 **null** ，而 `remove()` 抛出 **NoSuchElementException** 。

### 优先级队列PriorityQueue

先进先出（FIFO）描述了最典型的*队列规则*（queuing discipline）。队列规则是指在给定队列中的一组元素的情况下，确定下一个弹出队列的元素的规则。先进先出声明的是下一个弹出的元素应该是等待时间最长的元素。

优先级队列声明下一个弹出的元素是最需要的元素（具有最高的优先级）。例如，在机场，当飞机临近起飞时，这架飞机的乘客可以在办理登机手续时排到队头。如果构建了一个消息传递系统，某些消息比其他消息更重要，应该尽快处理，而不管它们何时到达。在Java 5 中添加了 **PriorityQueue** ，以便自动实现这种行为。

当在 **PriorityQueue** 上调用 `offer()` 方法来插入一个对象时，该对象会在队列中被排序。[5](http://localhost:4000/docs/book/12-Collections.html#fn_5)默认的排序使用队列中对象的*自然顺序*（natural order），但是可以通过提供自己的 **Comparator** 来修改这个顺序。 **PriorityQueue** 确保在调用 `peek()` ， `poll()` 或 `remove()` 方法时，获得的元素将是队列中优先级最高的元素。

**PriorityQueue** 是允许重复的，最小的值具有最高的优先级（如果是 **String** ，空格也可以算作值，并且比字母的优先级高）。为了展示如何通过提供自己的 **Comparator** 对象来改变顺序，第三个对 **PriorityQueue\** 构造器的调用，和第二个对 **PriorityQueue\** 的调用使用了由 `Collections.reverseOrder()` （Java 5 中新添加的）产生的反序的 **Comparator** 。

## 集合与迭代器

**Collection** 是所有序列集合共有的根接口。它可能会被认为是一种“附属接口”（incidental interface），即因为要表示其他若干个接口的共性而出现的接口。此外，**java.util.AbstractCollection** 类提供了 **Collection** 的默认实现，使得你可以创建 **AbstractCollection** 的子类型，而其中没有不必要的代码重复。

如果实现了 **Collection** ，就必须实现 `iterator()` ，并且只拿实现 `iterator()` 与继承 **AbstractCollection** 相比，花费的代价只有略微减少。但是，如果类已经继承了其他的类，那么就不能继承再 **AbstractCollection** 了。在这种情况下，要实现 **Collection** ，就必须实现该接口中的所有方法。此时，继承并提供创建迭代器的能力要容易得多.生成 **Iterator** 是将序列与消费该序列的方法连接在一起耦合度最小的方式，并且与实现 **Collection** 相比，它在序列类上所施加的约束也少得多。

## for-in和迭代器

到目前为止，*for-in* 语法主要用于数组，但它也适用于任何 **Collection** 对象。

Java 5 引入了一个名为 **Iterable** 的接口，该接口包含一个能够生成 **Iterator** 的 `iterator()` 方法。*for-in* 使用此 **Iterable** 接口来遍历序列。因此，如果创建了任何实现了 **Iterable** 的类，都可以将它用于 *for-in* 语句中.

### 适配器方法惯用法

如果现在有一个 **Iterable** 类，你想要添加一种或多种在 *for-in* 语句中使用这个类的方法，应该怎么做呢？例如，你希望可以选择正向还是反向遍历一个单词列表。如果直接继承这个类，并覆盖 `iterator()` 方法，则只能替换现有的方法，而不能实现遍历顺序的选择。

一种解决方案是所谓*适配器方法*（Adapter Method）的惯用法。“适配器”部分来自于设计模式，因为必须要提供特定的接口来满足 *for-in* 语句。如果已经有一个接口并且需要另一个接口时，则编写适配器就可以解决这个问题。 在这里，若希望在默认的正向迭代器的基础上，添加产生反向迭代器的能力，因此不能使用覆盖，相反，而是添加了一个能够生成 **Iterable** 对象的方法，该对象可以用于 *for-in* 语句。这使得我们可以提供多种使用 *for-in* 语句的方式

## 本章小节

Java 提供了许多保存对象的方法：

1. 数组将数字索引与对象相关联。它保存类型明确的对象，因此在查找对象时不必对结果做类型转换。它可以是多维的，可以保存基本类型的数据。虽然可以在运行时创建数组，但是一旦创建数组，就无法更改数组的大小。
2. **Collection** 保存单一的元素，而 **Map** 包含相关联的键值对。使用 Java 泛型，可以指定集合中保存的对象的类型，因此不能将错误类型的对象放入集合中，并且在从集合中获取元素时，不必进行类型转换。各种 **Collection** 和各种 **Map** 都可以在你向其中添加更多的元素时，自动调整其尺寸大小。集合不能保存基本类型，但自动装箱机制会负责执行基本类型和集合中保存的包装类型之间的双向转换。
3. 像数组一样， **List** 也将数字索引与对象相关联，因此，数组和 **List** 都是有序集合。
4. 如果要执行大量的随机访问，则使用 **ArrayList** ，如果要经常从表中间插入或删除元素，则应该使用 **LinkedList** 。
5. 队列和堆栈的行为是通过 **LinkedList** 提供的。
6. **Map** 是一种将对象（而非数字）与对象相关联的设计。 **HashMap** 专为快速访问而设计，而 **TreeMap** 保持键始终处于排序状态，所以没有 **HashMap** 快。 **LinkedHashMap** 按插入顺序保存其元素，但使用散列提供快速访问的能力。
7. **Set** 不接受重复元素。 **HashSet** 提供最快的查询速度，而 **TreeSet** 保持元素处于排序状态。 **LinkedHashSet** 按插入顺序保存其元素，但使用散列提供快速访问的能力。
8. 不要在新代码中使用遗留类 **Vector** ，**Hashtable** 和 **Stack** 。

![simple collection taxonomy](http://localhost:4000/docs/images/simple-collection-taxonomy.png)

### 简单集合分类

实际上只有四个基本的集合组件： **Map** ， **List** ， **Set** 和 **Queue**

![collection](http://localhost:4000/docs/images/collection.png)

![map](http://localhost:4000/docs/images/map.png)