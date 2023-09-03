package xyz.anomatver.blps.review.service;

import org.springframework.stereotype.Service;
import xyz.anomatver.blps.exception.NotFoundException;
import xyz.anomatver.blps.review.model.Review;
import xyz.anomatver.blps.review.model.ReviewStatus;
import xyz.anomatver.blps.review.repository.ReviewRepository;
import xyz.anomatver.blps.vote.service.SpamDetectionService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ReviewService {

    private final SpamDetectionService spamDetectionService;
    private final ReviewRepository reviewRepository;

    public ReviewService(SpamDetectionService spamDetectionService, ReviewRepository reviewRepository) {
        this.spamDetectionService = spamDetectionService;
        this.reviewRepository = reviewRepository;
    }

    @Transactional
    public Review submitReview(Review review) {
        validateReviewContent(review);
        setReviewStatusBasedOnSpamDetection(review);
        return reviewRepository.save(review);
    }

    public Review findById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Review not found with id: " + id));
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    public void deleteReview(Long id) {
        Review review = findById(id);
        reviewRepository.delete(review);
    }

    public Review updateReview(Long id, Review updatedReview) {
        Review existingReview = findById(id);
        updateReviewContentAndStatus(existingReview, updatedReview);
        return reviewRepository.save(existingReview);
    }

    private void validateReviewContent(Review review) {
        if (review.getContent() == null || review.getContent().trim().isEmpty()) {
            throw new IllegalArgumentException("Review content cannot be empty");
        }
    }

    private void setReviewStatusBasedOnSpamDetection(Review review) {
        if (spamDetectionService.isSpam(review, "test", "test")) {
            review.setStatus(ReviewStatus.PENDING);
        } else {
            review.setStatus(ReviewStatus.APPROVED);
        }
    }

    private void updateReviewContentAndStatus(Review existingReview, Review updatedReview) {
        existingReview.setContent(updatedReview.getContent());
        existingReview.setStatus(updatedReview.getStatus());
    }
}
