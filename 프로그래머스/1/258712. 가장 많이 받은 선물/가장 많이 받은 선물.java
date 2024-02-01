import java.util.*;
import java.util.stream.Collectors;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Long> indexMap = new HashMap<>();
        Map<String, Map<String, List<String>>> infoMap = new HashMap<>();
        int max = 0;
        
        Arrays.sort(friends);
        Arrays.sort(gifts);

        for (String friend : friends) {
            long giverCount = 0L;
            long takerCount = 0L;

            List<String> giverList = new ArrayList<>();
            List<String> takerList = new ArrayList<>();

            for (String gift : gifts) {
                if (gift.startsWith(friend + " ")) {
                    String taker = gift.replace(friend, "").trim();
                    takerList.add(taker);
                    giverCount++;
                } else if (gift.endsWith(" " + friend)) {
                    String giver = gift.replace(friend, "").trim();
                    giverList.add(giver);
                    takerCount++;
                }
            }

            indexMap.put(friend, giverCount - takerCount);

            Map<String, List<String>> listInfoMap = new HashMap<>();
            listInfoMap.put("giver", giverList);
            listInfoMap.put("taker", takerList);

            infoMap.put(friend, listInfoMap);
        }

        for (String friend : friends) {
            int count = 0;

            Map<String, List<String>> getInfoMap = infoMap.get(friend);

            for (String innerFriend : friends) {
                if (friend.equals(innerFriend)) continue;

                if (!getInfoMap.get("giver").contains(innerFriend) && !getInfoMap.get("taker").contains(innerFriend)) {
                    if (indexMap.get(friend) > indexMap.get(innerFriend))
                        count++;
                } else {
                    long takerCount = 0L;
                    long giverCount = 0L;

                    for (String gift : gifts) {
                        if (gift.equals(friend + " " + innerFriend))
                            takerCount++;
                        else if (gift.equals(innerFriend + " " + friend))
                            giverCount++;
                    }

                    // 받은 것 보다 준게 더 많으면 count 증가
                    if (takerCount > giverCount)
                        count++;
                    else if (takerCount == giverCount) {
                        // 선물 지수 체크
                        if (indexMap.get(friend) > indexMap.get(innerFriend))
                            count++;
                    }
                }
            }

            max = Math.max(count, max);
        }

        return max;
    }
}