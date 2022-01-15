package redis.test.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import redis.test.models.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Integer > {
}
