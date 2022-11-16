package study.tech;

public interface Service {
    public boolean follow(Long followId, Long followerId);

    public boolean followerCount(Long followId, Long followerId);

    public boolean followingCount(Long followId, Long followerId);
}
