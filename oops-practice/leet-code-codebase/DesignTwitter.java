import java.util.*;
class Twitter {
    private static int timeStamp = 0;
    // Tweet class to store tweetId and time
    private class Tweet {
        int id;
        int time;
        Tweet next;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }
    // User class to store tweets and followees
    private class User {
        int id;
        Set<Integer> followed;
        Tweet tweetHead;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id); // follow self
            tweetHead = null;
        }

        public void follow(int userId) {
            followed.add(userId);
        }

        public void unfollow(int userId) {
            if (userId != this.id) {
                followed.remove(userId);
            }
        }

        public void post(int tweetId) {
            Tweet t = new Tweet(tweetId, timeStamp++);
            t.next = tweetHead;
            tweetHead = t;
        }
    }

    // Map of userId to User object
    private Map<Integer, User> userMap;

    public Twitter() {
        userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        userMap.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();
        if (!userMap.containsKey(userId)) return res;

        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);

        for (int u : users) {
            Tweet t = userMap.get(u).tweetHead;
            if (t != null) pq.add(t);
        }

        int n = 0;
        while (!pq.isEmpty() && n < 10) {
            Tweet t = pq.poll();
            res.add(t.id);
            n++;
            if (t.next != null) pq.add(t.next);
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            userMap.get(followerId).unfollow(followeeId);
        }
    }
}