package com.site.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.site.model.Client;

import java.util.List;


public interface ClientRepository extends JpaRepository<Client, Long> {

    Client getClientById(Long id);

    @Query("SELECT client FROM Client client WHERE client.name LIKE CONCAT ('%',:search,'%')"
            + "OR client.vatId LIKE CONCAT ('%',:search,'%')"
            + "OR client.regNo LIKE CONCAT ('%',:search,'%')")
    List<Client> getClientByNameOrRegNoOrVatId(@Param("search") String search);
}
