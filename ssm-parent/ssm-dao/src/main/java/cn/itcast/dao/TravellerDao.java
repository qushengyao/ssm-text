package cn.itcast.dao;

import cn.itcast.domain.Traveller;

import java.util.List;

public interface TravellerDao {

    List<Traveller> findById(String oid);
}
