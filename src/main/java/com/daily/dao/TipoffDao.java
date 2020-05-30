package com.daily.dao;


import com.daily.entity.Tipoff;

public interface TipoffDao {
    int insertTipoff(Tipoff tipoff);

    Tipoff queryTipoff(int userId,int postId);
}
