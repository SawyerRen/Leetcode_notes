import java.util.*;

public class eat {
    public static void main(String[] args) {
//        Map<String, Integer> map = new HashMap<>();
//        for (int i = 0; i < 100000; i++) {
//            String food = getFood2();
//            map.put(food, map.getOrDefault(food, 0) + 1);
//        }
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            double prob = entry.getValue() / 100000.0;
//            System.out.println("food:" + entry.getKey() + ", prob:" + prob);
//        }
        Set<String> set = new HashSet<>();
        while (set.size() < 3) {
            set.add(getFood2());
        }
        System.out.println(set);
    }

    public static String getFood() {
        final int probA = 3;
        final int probB = 2;
        final int probC = 1;
        String[] foodA = {"蜀谭记", "新白鹿", "新旺", "泰国菜", "民间菜", "必胜客"};
        String[] foodB = {"耶里夏丽", "新发现", "达美乐", "饺子", "麦当劳", "苏小柳", "东北人家"};
        String[] foodC = {"食其家"};
        Random random = new Random();
        int level = random.nextInt(probA + probB + probC);
        if (level <= 2) {
            return foodA[new Random().nextInt(foodA.length)];
        } else if (level <= 4) {
            return foodB[new Random().nextInt(foodB.length)];
        } else {
            return foodC[new Random().nextInt(foodC.length)];
        }
    }

    public static String getFood2() {
        String[] foods = {"蜀谭记", "新白鹿", "新旺", "泰国菜", "民间菜", "必胜客",
                "蜀谭记", "新白鹿", "新旺", "泰国菜", "民间菜", "必胜客",
                "蜀谭记", "新白鹿", "新旺", "泰国菜", "民间菜", "必胜客",
                "耶里夏丽", "新发现", "达美乐", "饺子", "麦当劳", "苏小柳", "东北人家",
                "耶里夏丽", "新发现", "达美乐", "饺子", "麦当劳", "苏小柳", "东北人家",
                "食其家"};
        return foods[new Random().nextInt(foods.length)];
    }
}
