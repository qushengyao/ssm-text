package cn.itcast.dao;

import cn.itcast.domain.Member;

public interface MemberDao {

    Member findById(String id);

}
