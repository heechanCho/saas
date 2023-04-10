package saas.tadpolehub.com.saas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import saas.tadpolehub.com.saas.entity.Item;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByItemName(String itemName);
}
