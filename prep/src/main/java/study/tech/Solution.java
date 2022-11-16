package study.tech;

// As a user
// when I follow another user my following count get increased
// and another user’s follower count gets increased and vice versa

// When I post something my followers should see all my post in descending order on their timeline
// My follower’s should be able to re-post my post and when they do so, re-post count should increase
public class Solution {
    public static void main(String[] args) {
        ServiceImpl serImpl = new ServiceImpl();
        //value={"/follow"}
        boolean follow = serImpl.follow(1L, 2L);
        if (follow){
            boolean isfollowerCountUpdated = serImpl.followerCount(1l, 2l);
            boolean isFollowingCountUpdated = serImpl.followingCount(1l, 2l);
        }

    }

}
