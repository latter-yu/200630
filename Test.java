import java.util.*;

public class Test {
    public static void main1(String[] args) {

        // 对于给定的正整数 n，计算其十进制形式下所有位置数字之和，并计算其平方的各位数字之和。

        // 输入描述:
        // 每行输入数据包括一个正整数 n (0 < n < 40000)
        // 输出描述:
        // 对于每个输入数据，计算其各位数字之和，以及其平方值的数字之和
        // 输出在一行中，之间用一个空格分隔，但行末不要有空格

        // 示例:
        // 输入
        // 4
        // 12
        // 97
        // 39999
        // 输出
        // 4 7
        // 3 9
        // 16 22
        // 39 36
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int num = in.nextInt();
            // 需定义另外一个变量存放 num
            // 否则在第一次循环结束后 num 变为0, 不能进行 平方操作.
            int num1 = num * num;
            int sum = 0;
            while(num != 0) {
                sum += (num % 10);
                num = num / 10;
            }
            System.out.print(sum + " ");
            sum = 0;
            while(num1 != 0) {
                sum += (num1 % 10);
                num1 = num1 / 10;
            }
            System.out.print(sum);
        }
    }

    public static void main2(String[] args) {
        // 记票统计

        // 请实现接口：
        // unsigned int AddCandidate(char* pCandidateName);
        // 功能：设置候选人姓名
        // 输入：char* pCandidateName 候选人姓名
        // 输出：无
        // 返回：输入值非法返回 0，已经添加过返回 0 ，添加成功返回 1

        // Void Vote(char* pCandidateName);
        // 功能：投票
        // 输入： char* pCandidateName 候选人姓名
        // 输出：无
        // 返回：无

        // unsigned int  GetVoteResult (char* pCandidateName);
        // 功能：获取候选人的票数。如果传入为空指针，返回无效的票数，同时说明本次投票活动结束，释放资源
        // 输入： char* pCandidateName 候选人姓名。当输入一个空指针时，返回无效的票数

        // 输出：无
        // 返回：该候选人获取的票数

        // void Clear()
        // 功能：清除投票结果，释放所有资源
        // 输入：
        // 输出：无
        // 返回

        // 输入描述:
        // 输入候选人的人数，第二行输入候选人的名字，第三行输入投票人的人数，第四行输入投票。
        // 输出描述:
        // 每行输出候选人的名字和得票数量。

        // 示例:
        // 输入
        // 4
        // A B C D
        // 8
        // A B C D E F G H
        // 输出
        // A : 1
        // B : 1
        // C : 1
        // D : 1
        // Invalid : 4

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            // Map 设置在循环外需清除 Map 内的键值对
            Map<String, Integer> map = new LinkedHashMap<>();
            // LinkedHashMap 存放才是有序的
            int num = sc.nextInt(); // 候选人人数
            for (int i = 0; i < num; i++) {
                // 存放 候选人名字
                map.put(sc.next(), 0);
            }
            int invalid = 0;
            int voteNum = sc.nextInt(); // 投票人人数
            for (int j = 0; j < voteNum; j++) {
                String voteName = sc.next(); // 投票人名字
                if (map.get(voteName) == null) {
                    invalid++;
                }else {
                    map.put(voteName, map.get(voteName) + 1);
                }
            }
            for(Map.Entry entry : map.entrySet()) {
                // 遍历输出
                System.out.println(entry.getKey()+" : "+entry.getValue());
            }
            System.out.println("Invalid : "+ invalid);
        }
    }
}
