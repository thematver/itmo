package xyz.anomatver.blps.user.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.anomatver.blps.exception.NotFoundException;
import xyz.anomatver.blps.review.model.Review;
import xyz.anomatver.blps.review.model.ReviewStatus;
import xyz.anomatver.blps.review.repository.ReviewRepository;
import xyz.anomatver.blps.user.dto.LinkMessage;
import xyz.anomatver.blps.user.model.User;
import xyz.anomatver.blps.user.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final ReviewRepository reviewRepository;

    private final RabbitTemplate rabbitTemplate;

    public UserService(UserRepository userRepository, ReviewRepository reviewRepository, RabbitTemplate rabbitTemplate) {
        this.userRepository = userRepository;
        this.reviewRepository = reviewRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found with id: " + id));
    }

    public List<Review> getApprovedReviews(User user) {
        return reviewRepository.getReviewsByAuthor(user).stream().filter(review -> review.getStatus() == ReviewStatus.APPROVED).toList();
    }

    public boolean checkByUsername(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    public User link(User user, String uuid) {
        rabbitTemplate.convertAndSend("linking",  user.getId() + ": "  + uuid);
        return user;
    }
}
