package com.hutb.community.dao;

import org.springframework.stereotype.Repository;


@Repository("hibernate")
public class AlphaDaoHibernateImpl implements AlphaDao{

    @Override
    public String select() {
        return "hibernate";
    }
}
