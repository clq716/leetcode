## 记录

使用了Java自带的树排序。创建了对象存储食物所有信息。
在删除的时候先移除原来的元素，再重新添加，这一步应该是比较浪费，是最大的可优化的点

>	执行耗时:218 ms,击败了53.26% 的Java用户
>	内存消耗:74.6 MB,击败了8.69% 的Java用户

~~~java
class FoodRatings {

        Map<String, Pair> rateMap;
        Map<String, Set<Pair>> highestMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        rateMap = new HashMap<>(foods.length);
        highestMap = new HashMap<>();
        for (int i = 0; i < foods.length; i++) {
            Pair pair = new Pair(foods[i], cuisines[i], ratings[i]);
            rateMap.put(foods[i], pair);
			Set<Pair> pairs = highestMap.computeIfAbsent(cuisines[i], k -> new TreeSet<>());
            pairs.add(pair);
        }
    }


    public void changeRating(String food, int newRating) {
        Set<Pair> pairs = highestMap.get(rateMap.get(food).cuisine);
        Pair pair = rateMap.get(food);
        pairs.remove(pair);
        pair.rate = newRating;
        pairs.add(pair);
    }
    
    public String highestRated(String cuisine) {
        return highestMap.get(cuisine).iterator().next().food;
    }


    class Pair implements Comparable<Pair>{
        String food;
        String cuisine;
        Integer rate;

        public Pair(String food, String cuisine, Integer rate) {
            this.food = food;
            this.cuisine = cuisine;
            this.rate = rate;
        }

        @Override
        public int compareTo(Pair o) {
            int result = Integer.compare(o.rate, rate);
            return result == 0 ? food.compareTo(o.food) : result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return Objects.equals(food, pair.food);
        }

        @Override
        public int hashCode() {
            return Objects.hash(food);
        }
    }
}
~~~