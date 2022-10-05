package com.preonboarding.domain.usecase

import com.preonboarding.domain.model.Review
import com.preonboarding.domain.repository.FirebaseRepository
import javax.inject.Inject

class DeleteReviewUseCase @Inject constructor(
    private val firebaseRepository: FirebaseRepository
) {
    suspend operator fun invoke(title: String, review: Review) =
        firebaseRepository.deleteReview(title, review)
}