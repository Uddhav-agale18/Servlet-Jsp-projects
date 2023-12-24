package com.repository;

import java.util.ArrayList;
import java.util.List;

import com.model.HotelInfoModel;
import com.model.HotelModel;

public class HotelRepository extends DBConfig{
	List <HotelModel> list=new ArrayList<HotelModel>();
	List <HotelInfoModel> hlist=new ArrayList<HotelInfoModel>();
	public boolean isAddHotel(HotelModel model)
	{
		try
		{
			stmt=conn.prepareStatement("insert into hotel values('0',?)");
			stmt.setString(1,model.getName());
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	public List<HotelModel> getAllHotels()
	{
		try
		{
			stmt=conn.prepareStatement("select *from hotel");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				HotelModel model=new HotelModel();
				model.setId(rs.getInt(1));
				model.setName(rs.getString(2));
				list.add(model);  
			}
			return list;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	public boolean isDeleteHotel(int hotelId)
	{
		try {
			stmt=conn.prepareStatement("delete from hotel where id=?");
			stmt.setInt(1, hotelId);
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
 
		}
	}
	public boolean isHotelUpdate(HotelModel hotel) {
		try {
			stmt=conn.prepareStatement("update hotel set name=? where id=?");
			stmt.setString(1, hotel.getName());
			stmt.setInt(2,hotel.getId());
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	public int getHotelId(String name)
	{
		try
		{
			stmt=conn.prepareStatement("select id from hotel where name=?");
			stmt.setString(1, name);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
			}
			else
			{
				return 0;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			return 0;
		}


	}
	public boolean isAddHotelInfo(HotelInfoModel model)
	{
		try
		{
			int hotelId=this.getHotelId(model.getName());
			stmt = conn.prepareStatement("INSERT INTO hotelinfo VALUES (?,?,?,?,?)");
			stmt.setString(1, "0");  // Assuming '0' is intended for the 'iid' column
			stmt.setString(2, model.getEmail());
			stmt.setString(3, model.getContact());
			stmt.setString(4, model.getLocation());
			stmt.setInt(5, hotelId);

			int value=stmt.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception e) 
		{
			System.out.println(e);
			return false;
		}
	}
	public List<HotelInfoModel> getHotelInfo()
	{
		try {
			stmt=conn.prepareStatement(" select h.name,hi.email,hi.contact,hi.location,hi.iid from hotel h inner join hotelinfo hi on h.id=hi.id");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				HotelInfoModel model=new HotelInfoModel();
				model.setName(rs.getString(1));
				model.setEmail(rs.getString(2));
				model.setContact(rs.getString(3));
				model.setLocation(rs.getString(4));
				model.setInfoId(rs.getInt(5));
				this.hlist.add(model);
			}
			return hlist;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;

		}

	}
}
