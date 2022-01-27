package Repository;

import Model.Subscription;
import Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findByUser(User user);

    Optional<Subscription> findByUserAndSubscriptionPlanId(User user, long subscriptionId);
}
