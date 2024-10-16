package com.polychat.polychatbe.item.domain.repository;

import com.polychat.polychatbe.item.domain.aggregate.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
