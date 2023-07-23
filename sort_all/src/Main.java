import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    Solution obj = new Solution();
    int[] arr = {1, 20, 60, 2, 4, 12, 996, 81, 15, 63, 97, 12, 235, 66};

    @Test
    public void bubble_sort_Test() {
        // bubble_sort_ Test Function
        int[] sorted_arr = obj.bubble_sort(arr);
        System.out.println(Arrays.toString(sorted_arr));
    }

    @Test
    public void optimize_bubble_sort_Test() {
        // optimize_bubble_sort Test Function
        int[] sorted_arr = obj.optimize_bubble_sort(arr);
        System.out.println(Arrays.toString(sorted_arr));
    }

    @Test
    public void selection_sort_Test() {
        // selection_sort  Test Function
        int[] sorted_arr = obj.selection_sort(arr);
        System.out.println(Arrays.toString(sorted_arr));
    }

    @Test
    public void insert_sortTest() {
        // insert_sort Test Function
        int[] sorted_arr = obj.insert_sort(arr);
        System.out.println(Arrays.toString(sorted_arr));
    }

    @Test
    public void insert_sort_construct_Test() {
        // insert_sort Test Function
        int[] sorted_arr = obj.insert_sort_construct(arr);
        System.out.println(Arrays.toString(sorted_arr));
    }

    @Test
    public void shell_sort_Test() {
        // merge_sort_ Test Function
        System.out.println(Arrays.toString(arr));
        int[] sorted_arr = obj.shell_sort(arr);
        System.out.println(Arrays.toString(sorted_arr));
    }

    @Test
    public void merge_sort_Test() {
        // merge_sort_ Test Function
        System.out.println(Arrays.toString(arr));
        int[] sorted_arr = obj.merge_sort(arr);
        System.out.println(Arrays.toString(sorted_arr));
    }

    @Test
    public void quick_sort_Test() {
        // quick_sort_ Test Function
        System.out.println(Arrays.toString(arr));
        int[] sorted_arr = obj.quick_sort(arr);
        System.out.println(Arrays.toString(sorted_arr));
    }

    @Test
    public void heap_sort_Test() {
        // heap_sort_ Test Function
        System.out.println(Arrays.toString(arr));
        int[] sorted_arr = obj.heap_sort(arr);
        System.out.println(Arrays.toString(sorted_arr));
    }

    @Test
    public void counting_sort_simple_Test() {
        // counting_sort_simple_ Test Function
        System.out.println(Arrays.toString(arr));
        int[] sorted_arr = obj.counting_sort_simple(arr);
        System.out.println(Arrays.toString(sorted_arr));
    }

    @Test
    public void counting_sort_Test() {
        // counting_sort Test Function
        System.out.println(Arrays.toString(arr));
        int[] sorted_arr = obj.counting_sort(arr);
        System.out.println(Arrays.toString(sorted_arr));
    }

    @Test
    public void bucket_sort_Test() {
        // bucket_sort_ Test Function
        System.out.println(Arrays.toString(arr));
        int[] sorted_arr = obj.bucket_sort(arr, 5);
        System.out.println(Arrays.toString(sorted_arr));
    }

    @Test
    public void radix_sort_Test() {
        // radix_sort_ Test Function
        System.out.println(Arrays.toString(arr));
        int[] sorted_arr = obj.radix_sort(arr);
        System.out.println(Arrays.toString(sorted_arr));
    }
}

class Solution {

    private void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    public int[] bubble_sort(int[] arr) {  // O(n^2)
        for (int i = 0; i < arr.length; i++) { //控制的次数
            for (int j = 0; j < arr.length - i - 1; j++) {  //具体的每次比较,将最大的值放到 arr.length-i-1的位置上;
                if (arr[j] > arr[j + 1]) {
                    int temp;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public int[] optimize_bubble_sort(int[] arr) {// O(n^2)
        for (int i = 0; i < arr.length; i++) {
            boolean is_sorted = true;
            for (int j = 0; j < arr.length - i - 1; j++) {  //具体的每次比较,将最大的值放到 arr.length-i-1的位置上;
                if (arr[j] > arr[j + 1]) {
                    is_sorted = false;
                    int temp;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (is_sorted) {
                break;
            }
        }
        return arr;
    }

    public int[] selection_sort(int[] arr) {
        /* @Author YYB  || @Date 20:38 2023/07/22
         * @Description:
         * @Idea: 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置；
                  再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾；
         * @Param [arr] [ ]
         * @return int[]
         **///选择排序
        for (int i = 0; i < arr.length - 1; i++) {
            int min_value_idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_value_idx]) {
                    min_value_idx = j;
                }
                if (min_value_idx != i) {
                    int temp = arr[i];
                    arr[i] = arr[min_value_idx];
                    arr[min_value_idx] = temp;
                }
            }
        }
        return arr;
    }

    public int[] insert_sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int cur_val = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > cur_val) {  //j> 0  当前检查的val 小于 之前的值 ,则 val应该到j-1左边;
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = cur_val;
        }
        return arr;
    }

    public int[] insert_sort_construct(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int cur_val = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > cur_val) {  //j> 0  当前检查的val 小于 之前的值 ,则 val应该到j-1左边;
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = cur_val;
        }
        return arr;
    }

    public int[] shell_sort(int[] arr) {
        /* @Author YYB  || @Date 21:41 2023/07/22
         * @Description: 希尔排序
         * @Idea:   选择一个增量序列{t1, t2, …, tk}；
                    按增量序列个数k，对序列进行k趟排序；
                    每趟排序，根据对应的增量t，将待排序列分割成若干长度为m的子序列，分别对各子表进行直接插入排序。仅增量因子为1时，整个序列作为一个表来处理，表长度即为整个序列的长度。
                    其中，增量gap=length/2，缩小增量继续以gap = gap/2的方式
         * @Param [arr] [ ]
         * @return int[]
         **/
        for (int gap = arr.length / 2; gap >= 1; gap /= 2) { //定义 分组间隔,并将分组间隔逐渐缩小到1;
            for (int i = gap; i < arr.length; i++) { //从所有组的第二个元素开始检查元素,使用插入排序;
                int temp = arr[i];  //定义temp 为当前要插入的值
                int j = i - gap;
                while (j >= 0 && arr[j] >= temp) {  //j>=0 且 j位置的值大于 temp   //与 insert_construct 相同
                    arr[j + gap] = arr[j]; //j位置元素右移
                    j = j - gap;
                }
                arr[j + gap] = temp;
            }
        }
        return arr;
    }

    public int[] merge_sort(int[] arr) {
        int len = arr.length;
        if (len <= 1) {
            return arr;
        }
        int mid_idx = len / 2;
        int[] left_arr = merge_sort(Arrays.copyOfRange(arr, 0, mid_idx));
        int[] right_arr = merge_sort(Arrays.copyOfRange(arr, mid_idx, len));
        return this.merge(left_arr, right_arr);
    }

    public int[] merge(int[] left_arr, int[] right_arr) {  //按顺序合并左右两个数组
        int left_len = left_arr.length;
        int right_len = right_arr.length;
        int left_idx = 0, right_idx = 0, new_arr_idx = 0;
        int[] new_arr = new int[left_len + right_len];
        while (left_idx < left_len && right_idx < right_len) {
            if (left_arr[left_idx] < right_arr[right_idx]) {
                new_arr[new_arr_idx] = left_arr[left_idx];
                left_idx++;
            } else {
                new_arr[new_arr_idx] = right_arr[right_idx];
                right_idx++;
            }
            new_arr_idx++;
        }
        while (left_idx < left_len) {
            new_arr[new_arr_idx++] = left_arr[left_idx++];
        }
        while (right_idx < right_len) {
            new_arr[new_arr_idx++] = right_arr[right_idx++];
        }
        return new_arr;
    }

    public int[] quick_sort(int[] arr) {
        /* @Author YYB  || @Date 22:50 2023/07/22
         * @Description:
         * @Idea: 快速排序算法有两个核心点，分别为 哨兵划分 和 递归 。
                  哨兵划分：
                  以数组某个元素（一般选取首元素）为 基准数 ，将所有小于基准数的元素移动至其左边，大于基准数的元素移动至其右边。
         * @Param [arr] [ ]
         * @return int[]
         **/
        this.quick_sort_step(arr, 0, arr.length);
        return arr;
    }

    private void quick_sort_step(int[] arr, int left, int right) {
        if (left < right) {
            int pivot_idx = this.partition(arr, left, right - 1);
            this.quick_sort_step(arr, left, pivot_idx - 1);
            this.quick_sort_step(arr, pivot_idx + 1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int i = left, j = right;
        while (i < j) {
            while (i < j && arr[j] >= arr[left])
                j--;
            while (i < j && arr[i] <= arr[left])
                i++;
            this.swap(arr, i, j);
        }
        this.swap(arr, left, i);
        return i;
    }

    public int[] heap_sort(int[] arr) {
        /* @Author YYB  || @Date 15:01 2023/07/23
         * @Description: 堆排序  https://zhuanlan.zhihu.com/p/124885051
         * @Idea: 1. 堆的性质
                    ① 是一棵完全二叉树
                    ② 每个节点的值都大于或等于其子节点的值，为最大堆；反之为最小堆。
                  2. 堆的存储
                    一般用数组来表示堆，下标为 i 的结点的父结点下标为(i-1)/2；其左右子结点分别为 (2i + 1)、(2i + 2)
                  3. 堆的操作
                    在堆的数据结构中，堆中的最大值总是位于根节点(在优先队列中使用堆的话堆中的最小值位于根节点)。堆中定义以下几种操作：
                    ① 最大堆调整（Max_Heapify）：将堆的末端子节点作调整，使得子节点永远小于父节点
                    ② 创建最大堆（Build_Max_Heap）：将堆所有数据重新排序
                    ③ 堆排序（HeapSort）：移除位在第一个数据的根节点，并做最大堆调整的递归运算
         * @Param [arr] [ ]
         * @return int[]
         **/
        for (int i = arr.length / 2 - 1; i >= 0; i--) {  //先初始化一个大根堆
            this.max_heapify(arr, i, arr.length - 1);
        }
        // this.max_heapify(arr,0, arr.length-1); 必须倒序循环初始化, 这样直接初始化, 并不能保证根节点在初始化后是最大值
        for (int i = arr.length - 1; i > 0; i--) {
            this.swap(arr, 0, i);
            this.max_heapify(arr, 0, i - 1);
        }
        return arr;
    }

    public void max_heapify(int[] arr, int start, int end) {  //递归的建立大根堆
        /* @Author YYB  || @Date 15:22 2023/07/23
         * @Description: 将一个arr存储的二叉树,从start 到end位置的元素调整为大根堆
         * @Idea:
         * @Param [arr, start, end] [ ]
         * @return void
         **/
        int dad = start;
        int son = dad * 2 + 1;
        while (son <= end) {  //判断当前son节点是否超出end
            if (son + 1 <= end && arr[son] < arr[son + 1]) { //比较一下左右son的大小
                son++;
            }
            if (arr[dad] <= arr[son]) { //如果dad节点小于等于两个孩子中大的那个 ,就交换一下位置, 这里更新后的dad必定是三个节点中最大的
                this.swap(arr, dad, son);
                dad = son;
                son = dad * 2 + 1; //递归检查一下更换位置后son节点是否是以son作为dad节点二叉树的最大
            } else {
                return; //最终退出
            }
        }
    }

    public int[] counting_sort_simple(int[] arr) {
        // counting_sort_simple:问题1 数组空间可能存在大量浪费 ; 问题2  数值不稳定;
        int max = arr[0];
        for (int i : arr) { //获取最大值
            if (i > max) {
                max = i;
            }
        }
        int[] bucket = new int[max + 1];
        for (int val : arr) {
            bucket[val]++;
        }
        int sorted_idx = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                arr[sorted_idx++] = i;
                bucket[i]--;
            }
        }
        return arr;
    }

    public int[] counting_sort(int[] arr) {
        /* @Author YYB  || @Date 15:36 2023/07/23
         * @Description: 统计排序, 每个元素必须大于0(可以优化 +加一个偏移让负数转为正数) ,整数;
         * @Idea:   1. 基本思想
                        计数排序使用一个额外的数组C，其中第i个元素是待排序数组A中值等于i的元素的个数。
                        计数排序的核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
                        用来计数的数组C的长度取决于待排序数组中数据的范围（等于待排序数组的最大值与最小值的差加上1），然后进行分配、收集处理：
                            ① 分配。扫描一遍原始数组，以当前值-minValue作为下标，将该下标的计数器增1。
                            ② 收集。扫描一遍计数器数组，按顺序把值收集起来。
                    2. 实现逻辑
                            ① 找出待排序的数组中最大和最小的元素
                            ② 统计数组中每个值为i的元素出现的次数，存入数组C的第i项
                            ③ 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）
                            ④ 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1
         * @Param [arr, start, end] [ ]
         * @return int[]
         **/
        int[] new_arr = new int[arr.length];  //定义新的数组 用于存储返回值
        int max = arr[0];
        int min = arr[0];
        for (int i : arr) {  //找到这组数据中的min ,max
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        int gap = max - min + 1;  //找到需要开辟record数组的长度
        int[] record = new int[gap];
        for (int i = 0; i < arr.length; i++) {   //统计arr数组中每个元素的次数 存放到 record[arr[i]-min]中
            record[arr[i] - min] += 1;
        }
        for (int i = 1; i < record.length; i++) {  //对record 数组进行 累加, 这样 每个位置上的数字就代表 idx+min 数组 应该放到new_arr的那个位置;
            record[i] = record[i] + record[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {  // 维持数值稳定性, 倒序的遍历 arr 找到每个元素应该放到新数组的那个位置;
            new_arr[--record[arr[i] - min]] = arr[i];
        }
        return new_arr;
    }

    public int[] bucket_sort(int[] arr, int bucket_size) {
        /* @Author YYB  || @Date 16:48 2023/07/23
         * @Description: 桶排序
         * @Idea: https://www.runoob.com/w3cnote/bucket-sort.html
         *        https://zhuanlan.zhihu.com/p/164992268
         *  将待排序的序列分到若干个桶中，每个桶内的元素再进行个别排序。
            时间复杂度最好可能是线性O(n)，桶排序不是基于比较的排序
            在刚刚放入桶中的时候，各个桶的大小相对可以确定，右侧都比左侧大，但桶内还是无序的，
            对各个桶内分别进行排序，再依次按照桶的顺序、桶内序列顺序得到一个最终排序的序列。
         * @Param [arr, bucket_size] [ ]
         * @return int[]
         **/
        if (arr.length == 0) {
            return arr;
        }
        int max = arr[0];
        int min = arr[0];
        for (int i : arr) {  //找到这组数据中的min ,max
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        int bucket_count = (int) Math.floor((max - min) / bucket_size) + 1;
        int[][] buckets = new int[bucket_count][0];
        for (int i = 0; i < arr.length; i++) {
            int idx = (int) Math.floor((arr[i] - min) / bucket_size);
            buckets[idx] = this.arr_append(buckets[idx], arr[i]);
        }
        int arr_idx = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            bucket = this.insert_sort_construct(bucket);
            for (int val : bucket) {
                arr[arr_idx++] = val;
            }
        }
        return arr;
    }

    private int[] arr_append(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    public int[] radix_sort(int[] arr) {
        /* @Author YYB  || @Date 16:51 2023/07/23
         * @Description: 基数排序
         * @Idea:
                基数排序是一种非比较型整数排序算法，其原理是将整数按位数切割成不同的数字，然后按每个位数分别比较。
                *   （1）通过键值得各个位的值，将要排序的元素分配至一些桶中，达到排序的作用
                    （2）基数排序法是属于稳定性的排序，基数排序法是效率高的稳定排序法
                    （3）基数排序是桶排序的扩展
                *  将所有待比较数值（自然数）统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。
                   这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。
                *实现步骤
                    （1）确定数组中的最大元素有几位（MAX）（确定执行的轮数）
                    （2）创建0~9个桶（桶的底层是队列），因为所有的数字元素都是由0~9的十个数字组成
                    （3）依次判断每个元素的个位，十位至MAX位，存入对应的桶中，出队，存入原数组；直至MAX轮结束输出数组。
         * @Param [arr] [ ]
         * @return int[]
         **/
        // 1.找 分类-收集 的轮数（最大值的长度）
        int radix = this.get_radix(arr);
        // 2.创建桶 list所有桶的集合 每一个桶是LinkedList当成队列来用
        LinkedList<Integer>[] list = new LinkedList[10];
        for (int i = 0; i < list.length; i++) {
            list[i] = new LinkedList<>();
        }
        // 3.开始 分类-收集
        for (int r = 1; r <=radix; r++) {
            for (int j = 0; j < arr.length; j++) {
                list[this.get_index(arr[j], r)].offer(arr[j]);
            }
            int idx = 0;// 遍历arr原数组
            // 收集的过程
            for (int i = 0; i < list.length; i++) {
                while (!list[i].isEmpty()) {
                    arr[idx++] = list[i].poll();
                }
            }
        }
        return arr;
    }

    private int get_index(int num, int r) {
        int ret = 0;
        for (int i = 1; i <= r; i++) {
            ret = num % 10;
            num /= 10;
        }
        return ret;
    }

    private int get_radix(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return (max + "").length();
    }
}