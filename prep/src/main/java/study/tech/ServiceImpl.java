package study.tech;

import java.util.HashSet;

public class ServiceImpl implements Service{
    @Override
    public boolean follow(Long followId, Long followerId) {
        //Update DB will be done
        // followId | followerId(FK) --1:M
        //happy case
        // update the  follower and follower
        return true;
    }

    @Override
    public boolean followerCount(Long followId, Long followerId) {
        return false;
    }

    @Override
    public boolean followingCount(Long followId, Long followerId) {
        return false;
    }

}
//ER relationship
//user ---connectivity---
//user--> userid----
//connectivity--> followerId(userId)(1)---followingId(userId)(M)
//Count(followingId) for followerId
//Count(followerId) for followeringId

