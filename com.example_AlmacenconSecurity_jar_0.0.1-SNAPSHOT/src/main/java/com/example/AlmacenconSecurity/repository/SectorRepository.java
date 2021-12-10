/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.AlmacenconSecurity.repository;

import com.example.AlmacenconSecurity.entity.Sector;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author Martin
 */
@Mapper
public interface SectorRepository {
    @Select("select * from sector")
    public List<Sector> findAll();
    
    
}
