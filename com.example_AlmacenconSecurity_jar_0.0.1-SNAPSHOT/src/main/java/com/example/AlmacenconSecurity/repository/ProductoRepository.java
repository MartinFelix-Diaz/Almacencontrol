/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.AlmacenconSecurity.repository;

import com.example.AlmacenconSecurity.entity.Producto;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 *
 * @author Martin
 */

@Mapper  
public interface ProductoRepository {
    @Select("select p.idproducto, p.nombre,p.precio,p.stock,p.fecha ,concat(t.nomTip) as tipo, s.nomSec sector ,a.distrito almacensede, pr.nombre proveedor from producto as p\n" +
    "inner join tipo as t on p.idtipo = t.idtipo\n" +
    "inner join sector as s on p.idsector = s.idsector\n"+
    "inner join almacensede as a on p.idalmacensede = a.idalmacensede\n"+
    "inner join proveedor as pr on p.idproveedor = pr.idproveedor")
    public List<Map<String,Object>> findAll();
    
    @Select("select * from producto where idproducto=#{id}")
    public Producto readProducto(int id);

    @Delete("DELETE FROM producto WHERE idproducto = #{id}")
    public int deleteById(int id);
    
    @Insert("INSERT INTO producto(nombre, precio,stock,fecha,idtipo,idsector,idalmacensede,idproveedor) VALUES (#{nombre}, #{precio},#{stock},#{fecha}, #{idtipo},#{idsector},#{idalmacensede},#{idproveedor})")
    public int insert(Producto producto);

    @Update("Update producto set nombre=#{nombre}, precio=#{precio}, stock=#{stock}, fecha=#{fecha}, idtipo=#{idtipo}, idsector=#{idsector} ,idalmacensede=#{idalmacensede},idproveedor=#{idproveedor} where idproducto=#{idproducto}")
    public int update(Producto producto);
}
