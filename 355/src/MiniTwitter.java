/**
 * Definition of Tweet:
 * public class Tweet {
 *     public int id;
 *     public int user_id;
 *     public String text;
 *     public static Tweet create(int user_id, String tweet_text) {
 *         // This will create a new tweet object,
 *         // and auto fill id
 *     }
 * }
 */
import java.util.concurrent.atomic.AtomicInteger;
import java.util.*;
public class MiniTwitter {
    private class TweetNode {
        public int timeStamp;
        public Tweet tweet;
        public TweetNode next;
        public TweetNode(int timeStamp, Tweet tweet) {
            this.timeStamp = timeStamp;
            this.tweet = tweet;
        }
    }
    private AtomicInteger timeCount;
    private HashMap<Integer, TweetNode> tweetMap;
    private HashMap<Integer, HashSet<Integer>> followMap;
    public MiniTwitter() {
        timeCount = new AtomicInteger(0);
        tweetMap = new HashMap<Integer, TweetNode>();
        followMap = new HashMap<Integer, HashSet<Integer>>();
    }

    // @param user_id an integer
    // @param tweet a string
    // return a tweet
    public Tweet postTweet(int user_id, String tweet_text) {
        TweetNode post = new TweetNode(timeCount.getAndIncrement(), Tweet.create(user_id, tweet_text));
        if (!tweetMap.containsKey(user_id)) {
            tweetMap.put(user_id, post);
        } else {
            post.next = tweetMap.get(user_id);
            tweetMap.put(user_id, post);
        }
        return post.tweet;
    }

    // @param user_id an integer
    // return a list of 10 new feeds recently
    // and sort by timeline
    public List<Tweet> getNewsFeed(int user_id) {
        List<Tweet> list = new ArrayList<>(10);
        PriorityQueue<TweetNode> queue = new PriorityQueue<TweetNode>(100, new Comparator<TweetNode>() {
            public int compare(TweetNode node1, TweetNode node2) {
                return node2.timeStamp - node1.timeStamp;
            }
        });
        if(tweetMap.containsKey(user_id)) {
            queue.add(tweetMap.get(user_id));
        }
        if (followMap.containsKey(user_id)) {
            for(int followed: followMap.get(user_id)) {
                if(tweetMap.containsKey(followed)) {
                    queue.add(tweetMap.get(followed));
                }
            }
        }
        int count = 0;
        while (!queue.isEmpty() && count < 10) {
            TweetNode node = queue.remove();
            list.add(node.tweet);
            if (node.next != null) {
                node = node.next;
                queue.add(node);
            }
            count++;
        }
        return list;
    }

    // @param user_id an integer
    // return a list of 10 new posts recently
    // and sort by timeline
    public List<Tweet>  getTimeline(int user_id) {
        List<Tweet> list = new ArrayList<>(10);
        if (tweetMap.containsKey(user_id)) {
            TweetNode node = tweetMap.get(user_id);
            int count = 0;
            while (count < 10 & node != null) {
                list.add(node.tweet);
                node = node.next;
                count++;
            }
        }
        return list;
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id follows to_user_id
    public void follow(int from_user_id, int to_user_id) {
        if (!followMap.containsKey(from_user_id)) {
            followMap.put(from_user_id, new HashSet<Integer>());
        }
        followMap.get(from_user_id).add(to_user_id);
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id unfollows to_user_id
    public void unfollow(int from_user_id, int to_user_id) {
        if(!followMap.containsKey(from_user_id)) {
            followMap.put(from_user_id, new HashSet<Integer>());
        }
        followMap.get(from_user_id).remove(to_user_id);
    }
}