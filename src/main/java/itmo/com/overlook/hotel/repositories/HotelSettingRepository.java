package itmo.com.overlook.hotel.repositories;

import itmo.com.overlook.hotel.entities.HotelSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelSettingRepository extends JpaRepository<HotelSetting, Integer> {

    HotelSetting findFirstByOrderByIdAsc();
}