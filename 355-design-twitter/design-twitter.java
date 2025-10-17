// class LinkedList=
class Twitter {
    // PriorityQueue
    Map<Integer,LinkedList<Integer>> user_tweet;
    Map<Integer,Integer> tweet_time;
    Map<Integer,HashSet<Integer>> user_following;
    List<Integer> list;
    int ts=0;
    
 
    public Twitter() {
     user_tweet=new HashMap<>();
     tweet_time=new HashMap<>();
     user_following=new HashMap<>();
     list=new ArrayList<>();
    }
    
    public void postTweet(int userId, int tweetId) {

      if(!user_tweet.containsKey(userId)){
        user_tweet.put(userId,new LinkedList<>());
      }
      user_tweet.get(userId).add(tweetId);
      tweet_time.put(tweetId,ts);
      ts+=1;
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans=new ArrayList<>();
        PriorityQueue<Integer> maxheap=new PriorityQueue<>((a,b)-> tweet_time.get(b)-tweet_time.get(a));

        if(user_tweet.containsKey(userId)){ 
            // System.out.println("hi");
            // return ans;
        

        
        maxheap.addAll(user_tweet.get(userId));
        }

        if(user_following.containsKey(userId) && user_following.get(userId).size()>0){

        for(int friend: user_following.get(userId)){
            if(!user_tweet.containsKey(friend)) continue;
            LinkedList<Integer> friendkatweet=user_tweet.get(friend);
            if(friendkatweet.size()==0) continue;
            maxheap.addAll(friendkatweet);

        }

        }

        while(!maxheap.isEmpty() && ans.size()<10){
            int recent=maxheap.poll();
             ans.add(recent);
        //   maxheap.add(recent.next().val());
        //will not work because int linked list doen not have  the enxt pointer
        }
        
        System.out.println("hi");
        return  ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!user_following.containsKey(followerId)){
            user_following.put(followerId,new HashSet<>());
        }
        user_following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(user_following.containsKey(followerId) &&  user_following.get(followerId).contains(followeeId))
        user_following.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */