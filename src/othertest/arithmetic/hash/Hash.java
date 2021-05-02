package src.othertest.arithmetic.hash;

/**
 * 散列
 *
 * 冲突：开放寻址法（线性探测） 最坏情况下的时间复杂度为 O(n)
 *          删除操作稍微有些特别，在查找的时候，一旦我们通过线性探测方法，找到一个空闲位置，我们就可以认定散列表中不存在这个数据。
 *          但是，如果这个空闲位置是我们后来删除的，就会导致原来的查找算法失效，将删除的元素，特殊标记为 deleted
 *
 * 二次探测：步长就变成了原来的“二次方”，也就是说，它探测的下标序列就是 hash(key)+0，hash(key)+12，hash(key)+22……
 *
 * 双重散列：使用一组散列函数 hash1(key)，hash2(key)，hash3(key)……我们先用第一个散列函数，如果计算得到的存储位置已经被占用，再用第二个散列函数，依次类推，直到找到空闲的存储位置
 *
 *
 * 散列冲突解决办法:
 *
 *      散列表的装载因子 = 填入表中的元素个数 / 散列表的长度
 *
 *      链表法：每个“桶（bucket）”或者“槽（slot）”会对应一条链表，所有散列值相同的元素我们都放到相同槽位对应的链表中
 *
 */
public class Hash {

    // 1.数据分析法
    // 2.直接寻址法、
    // 3.平方取中法、
    // 4.折叠法、
    // 5.随机数法


    // 扩容：一次性扩容 ---重新计算哈希值，并且从原来的散列表搬移到新的散列表
    //      一次扩容，多次转移 ---将扩容操作穿插在插入操作的过程中，分批完成。当装载因子触达阈值之后，我们只申请新空间，
    //                          查询的时候，先从新散列表中查找，如果没有找到，再去老的散列表中查找。


    // LinkedHashMap:链表发解决冲突:链表法对内存的利用率比开放寻址法要高,适合存储大对象、大数据量的散列表，
    //                而且，比起开放寻址法，它更加灵活，支持更多的优化策略，比如用红黑树代替链表
    // ThreadLocalMap:线性探测的开放寻址法 :当数据量比较小、装载因子小的时候，适合采用开放寻址法


    // HashMap
    // 默认的初始大小是 16
    // 最大装载因子默认是 0.75
    // 每次扩容都会扩容为原来的两倍大小  为什么？
    // 因为Hashmap计算存储位置时，使用了(n - 1) & hash。
    // 只有当容量n为2的幂次方，n-1的二进制会全为1，位运算时可以充分散列，避免不必要的哈希冲突，所以扩容必须2倍就是为了维持容量始终为2的幂次方。
    // 当链表长度太长（默认超过 8）时，链表就转换为红黑树。我们可以利用红黑树快速增删改查的特点，提高 HashMap 的性能。
    // 当红黑树结点个数少于 8 个的时候，又会将红黑树转化为链表。因为在数据量较小的情况下，红黑树要维护平衡，比起链表来，性能上的优势并不明显。



    // new LinkedHashMap<>(10, 0.75f, true); 会根据数据的访问顺序来打印，后访问到的数据会放到链表尾部
    // new LinkedHashMap<> 不会根据访问顺序来打印
    // LinkedHashMap 是通过双向链表和散列表这两种数据结构组合实现的
    // LinkedHashMap 本身就是一个支持 LRU 缓存淘汰策略的缓存系统

    // 散列表经常和链表一起使用，一个可以快速通过键来查找，一个可以将数据串成一个串



    // 哈希算法的应用非常非常多，分别是安全加密、唯一标识、数据校验、散列函数、负载均衡、数据分片、分布式存储


    // 唯一标识
    // 如果要在海量的图库中，搜索一张图是否存在,给每一个图片取一个唯一标识，或者说信息摘要, 通过这个唯一标识来判定图片是否在图库中，这样就可以减少很多工作量
    // 数据校验
    // 希算法有一个特点，对数据很敏感, 只要文件块的内容有一丁点儿的改变，最后计算出的哈希值就会完全不同
    // 散列函数
    // 散列函数也是哈希算法的一种应用,散列函数中用到的散列算法，更加关注散列后的值是否能平均分布,散列函数用的散列算法一般都比较简单，比较追求效率。
    // 负载均衡
    // 如果客户端很多，映射表可能会很大，比较浪费内存空间；
    // 客户端下线、上线，服务器扩容、缩容都会导致映射失效，这样维护映射表的成本就会很大；
    // 数据分片（MapReduce），
    // 依次读出每个搜索关键词,并且通过哈希函数计算哈希值，然后再跟 n 取模，最终得到的值，就是应该被分配到的机器编号。
    // 分布式存储
    // 会出现雪崩场景，当开始以10取模，后来加进来一台机器之后，以11取模，需要重新计算哈希值


    int capitity = 16;
    /**
     * hashmap的hash算法
     * @param key
     * @return
     */
    int hash(Object key) {
        int h = key.hashCode();
        return (h ^ (h >>> 16)) & (capitity -1); //capicity 表示散列表的大小
    }


}
