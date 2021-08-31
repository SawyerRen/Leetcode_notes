package topics.design;

import java.util.*;

public class Q355 {
}

class Twitter {
    int timeStamp = 0;

    class Tweet {
        int id;
        int time;
        Tweet next;

        public Tweet(int id) {
            this.id = id;
            this.time = timeStamp++;
        }
    }

    class User {
        int id;
        Set<Integer> followed;
        Tweet tweetHead;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id);
            tweetHead = null;
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unFollow(int id) {
            followed.remove(id);
        }

        public void post(int id) {
            Tweet tweet = new Tweet(id);
            tweet.next = tweetHead;
            tweetHead = tweet;
        }
    }

    Map<Integer, User> userMap;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        userMap = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) userMap.put(userId, new User(userId));
        userMap.get(userId).post(tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) return res;
        Set<Integer> followed = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>(followed.size(), (a, b) -> b.time - a.time);
        for (Integer id : followed) {
            Tweet tweet = userMap.get(id).tweetHead;
            if (tweet != null) {
                pq.add(tweet);
            }
        }
        int size = 0;
        while (!pq.isEmpty() && size < 10) {
            Tweet poll = pq.poll();
            res.add(poll.id);
            size++;
            if (poll.next != null) {
                pq.add(poll.next);
            }
        }
        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) userMap.put(followerId, new User(followerId));
        if (!userMap.containsKey(followeeId)) userMap.put(followeeId, new User(followeeId));
        userMap.get(followerId).follow(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || !userMap.containsKey(followeeId) || followeeId == followerId) return;
        userMap.get(followerId).unFollow(followeeId);
    }
}