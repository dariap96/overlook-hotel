package itmo.com.overlook.hotel.services;

import itmo.com.overlook.hotel.DTOs.TableDTO;
import itmo.com.overlook.hotel.entities.HotelSetting;
import itmo.com.overlook.hotel.repositories.HotelSettingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class SettingsService {

    private final HotelSettingRepository hotelSettingRepository;

    public HotelSetting getSetting() {
        return hotelSettingRepository.findFirstByOrderByIdAsc();
    }


    public Float getRate() {
        HotelSetting setting = getSetting();
        return setting.getRate();
    }

    public void updateRate(Integer rate){
        HotelSetting setting = getSetting();
        Float sum = setting.getRate();
        Long num = setting.getNumber();
        sum = (sum * num + rate) / (num + 1);
        setting.setRate(sum);
        setting.setNumber(num + 1);
        hotelSettingRepository.save(setting);
    }

    public void updateTable(TableDTO table){
        HotelSetting setting = getSetting();
        setting.setMonday(table.getMonday());
        setting.setTuesday(table.getTuesday());
        setting.setWednesday(table.getWednesday());
        setting.setThursday(table.getThursday());
        setting.setFriday(table.getFriday());
        setting.setSaturday(table.getSaturday());
        setting.setSunday(table.getSunday());
        hotelSettingRepository.save(setting);
    }
}
