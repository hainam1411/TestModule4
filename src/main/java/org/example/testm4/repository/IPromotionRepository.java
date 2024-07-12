package org.example.testm4.repository;

import org.example.testm4.model.Promotion;
import org.example.testm4.model.PromotionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IPromotionRepository extends JpaRepository {

    @Query("SELECT p FROM Promotion p WHERE " +
            "(:minRate IS NULL OR p.discount >= :minRate) AND " +
            "(:maxRate IS NULL OR p.discount <= :maxRate) AND " +
            "(:startDate IS NULL OR :startDate = '' OR p.startDate >= Date(:startDate)) AND " +
            "(:endDate IS NULL OR :endDate = '' OR p.endDate <= Date(:endDate))")
    Iterable<PromotionDTO> getPromotionsWithSearch(
            @Param("minRate") Double minRate,
            @Param("maxRate") Double maxRate,
            @Param("startDate") String startDate,
            @Param("endDate") String endDate
    );
}
