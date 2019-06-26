package src.othertest.interview;

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








}