/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.AlmacenconSecurity.repository;

import com.example.AlmacenconSecurity.entity.Proveedor;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 *
 * @author Martin
 */
@Mapper
public interface ProveedorRepository {
    @Select("select * from proveedor")
    public List<Proveedor> findAll();
    
    @Select("select * from proveedor where idproveedor = #{id}")
    public Proveedor readProvedor(int id);
    
    @Delete("DELETE FROM proveedor WHERE idproveedor = #{id}")
    public int deleteById(int id);
    
    @Insert("INSERT INTO proveedor(nombre, apellido, telefono, dni) VALUES (#{nombre}, #{apellido}, #{telefono}, #{dni})")
    public int insert(Proveedor provedor);

    @Update("Update proveedor set nombre=#{nombre}, apellido=#{apellido}, telefono=#{telefono}, dni=#{dni} where idproveedor=#{idproveedor}")
    public int update(Proveedor provedor);
}
