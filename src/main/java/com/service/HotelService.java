package com.service;

import java.util.List;

import com.model.HotelInfoModel;
import com.model.HotelModel;
import com.repository.HotelRepository;

public class HotelService {

	HotelRepository hotelRepo=new HotelRepository();
	public boolean isAddHotel(HotelModel model)
	{
		return hotelRepo.isAddHotel(model);
	}
	public List<HotelModel> getAllHotels() {
		return hotelRepo.getAllHotels();
	}
	public boolean isDeleteHotel(int hotelId)
	{
		return hotelRepo.isDeleteHotel(hotelId);
	}
	public boolean isHotelUpdate(HotelModel model) {
		return hotelRepo.isHotelUpdate(model);
	}
	public boolean isAddHotelInfo(HotelInfoModel model)
	{
		return hotelRepo.isAddHotelInfo(model);
	}
	public List<HotelInfoModel> getHotelList()
	{
		return hotelRepo.getHotelInfo();
	}
}
