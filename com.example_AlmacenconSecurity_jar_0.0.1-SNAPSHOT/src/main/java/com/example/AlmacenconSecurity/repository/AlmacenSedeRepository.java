/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.AlmacenconSecurity.repository;

import com.example.AlmacenconSecurity.entity.AlmacenSede;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

/**
 *
 * @author Sebastian
 */
@Mapper
public interface AlmacenSedeRepository {
    @Select("select * from almacensede")
    public List<AlmacenSede> findAll();
    
    @Select("select * from almacensede where idalmacensede = #{id}")
    public AlmacenSede readSede(int id);
    
    @Delete("DELETE FROM almacensede WHERE idalmacensede = #{id}")
    public int deleteById(int id);
    
    @Insert("INSERT INTO almacensede(distrito, direccion) VALUES (#{distrito}, #{direccion})")
    public int insert(AlmacenSede almacenSede);

    @Update("Update almacensede set distrito=#{distrito}, direccion=#{direccion} where idalmacensede=#{idalmacensede}")
    public int update(AlmacenSede almacenSede);
}
