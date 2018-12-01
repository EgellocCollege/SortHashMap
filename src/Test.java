import java.util.*;

public class Test {

    public  static  void main(String[] args){
        HashMap<Integer,User> hashMap = new HashMap<>();
        User user1 = new User(1,"one");
        User user2 = new User(22,"two");
        User user3 = new User(3,"three");
        User user4 = new User(4,"four");
        User user5 = new User(5,"five");
        User user6 = new User(6,"six");
        User user7 = new User(7,"seven");
        User user8 = new User(8,"eight");

        hashMap.put(1,user1);
        hashMap.put(2,user2);
        hashMap.put(3,user3);
        hashMap.put(4,user4);
        hashMap.put(5,user5);
        hashMap.put(6,user6);
        hashMap.put(7,user7);
        hashMap.put(8,user8);

        //排序前
        System.out.println("排序前" + hashMap);


        //排序后
        HashMap<Integer,User> sortedHashMap = sortHashMap(hashMap);
        System.out.println("排序后" + sortedHashMap);


    }

    public static HashMap<Integer,User> sortHashMap(HashMap<Integer,User> hashMap){

        /**
            创建一个有序的HashMap数据结构，LinkedHashMap
         */
        LinkedHashMap<Integer,User> newHashMap = new LinkedHashMap<>();

        // Map转Set,Set转List
        Set<Map.Entry<Integer,User>> entrySet = hashMap.entrySet();
        ArrayList<Map.Entry<Integer,User>> list = new ArrayList<>(entrySet);

        //对集合排序，优先使用Collections的方法,对List排序


        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                return o2.getValue().getAge()- o1.getValue().getAge();
            }
        });



        //将排好序的List装换为LinkedHashMap
        for (Map.Entry<Integer, User> item:list) {
            newHashMap.put(item.getKey(),item.getValue());
        }
        return newHashMap;
    }

}
