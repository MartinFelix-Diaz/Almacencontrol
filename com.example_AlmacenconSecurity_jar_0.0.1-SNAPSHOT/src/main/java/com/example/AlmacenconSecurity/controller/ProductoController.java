/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.AlmacenconSecurity.controller;

import com.example.AlmacenconSecurity.entity.Producto;
import com.example.AlmacenconSecurity.repository.AlmacenSedeRepository;
import com.example.AlmacenconSecurity.repository.ProductoRepository;
import com.example.AlmacenconSecurity.repository.ProveedorRepository;
import com.example.AlmacenconSecurity.repository.SectorRepository;
import com.example.AlmacenconSecurity.repository.TipoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Sebastian
 */
@Controller
@Slf4j
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;
    
    @Autowired
    private SectorRepository sectorRepository;
    
    @Autowired
    private TipoRepository tipoRepository;
    
    @Autowired
    private AlmacenSedeRepository almacensedeRepository;
    
    @Autowired
    private ProveedorRepository proveedorRepository;
    
     @RequestMapping("/")
    public String mensaje(Model model, @AuthenticationPrincipal User user){
         log.info("ejecutando el controlador Spring MVC");
         log.info("usuario que hizo login:" + user);
        return "index";
    }
    @RequestMapping("/prods")
    public String prods(Model model) {
        model.addAttribute("prods", productoRepository.findAll());
        return "/productos";
    }
    
    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("tips", tipoRepository.findAll());
        model.addAttribute("sects",sectorRepository.findAll());
        model.addAttribute("almas",almacensedeRepository.findAll());
        model.addAttribute("provs",proveedorRepository.findAll());
        return "/add";
    }
    
    @RequestMapping("/add")
    public String Guardar(@RequestParam String nombre,@RequestParam double precio,@RequestParam int stock,@RequestParam String fecha,@RequestParam int idtip,@RequestParam int idsec,@RequestParam int idalm,@RequestParam int idprov,Model model) {
        Producto prod = new Producto();
        prod.setNombre(nombre);
        prod.setPrecio(precio);
        prod.setStock(stock);
        prod.setFecha(fecha);
        prod.setIdtipo(idtip);
        prod.setIdsector(idsec);
        prod.setIdalmacensede(idalm);
        prod.setIdproveedor(idprov);
        productoRepository.insert(prod);
        return "redirect:/prods";
    }
    
    @RequestMapping("/del/{id}")
    public String delete(@PathVariable(value="id") int id) {
        productoRepository.deleteById(id);
        return "redirect:/prods";
    }
    
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable(value="id") int id, Model model) {
        model.addAttribute("prod", productoRepository.readProducto(id));
        model.addAttribute("tips", tipoRepository.findAll());
        model.addAttribute("sects",sectorRepository.findAll());
        model.addAttribute("almas",almacensedeRepository.findAll());
        model.addAttribute("provs",proveedorRepository.findAll());
        return "/edit";
    }
    
     @RequestMapping("/update")
    public String update(@RequestParam int id,@RequestParam String nombre,@RequestParam double precio,@RequestParam int stock,@RequestParam String fecha,@RequestParam int idtipo,@RequestParam int idsector,@RequestParam int idalmacensede,@RequestParam int idproveedor) {
        Producto prod= productoRepository.readProducto(id);
        prod.setNombre(nombre);
        prod.setPrecio(precio);
        prod.setStock(stock);
        prod.setFecha(fecha);
        prod.setIdtipo(idtipo);
        prod.setIdsector(idsector);
        prod.setIdalmacensede(idalmacensede);
        prod.setIdproveedor(idproveedor);
        productoRepository.update(prod);
        return "redirect:/prods";
    }

    
}

