/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.AlmacenconSecurity.controller;

import com.example.AlmacenconSecurity.entity.Proveedor;
import com.example.AlmacenconSecurity.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Martin
 */
@Controller
public class ProveedorController {
    @Autowired
    private ProveedorRepository proveedorRepository;
    @RequestMapping("/provs")
    public String Sedes(Model model){
        model.addAttribute("provs",proveedorRepository.findAll());
        return"/prov";
    }
    @RequestMapping("/createProv")
    public String createSedes(Model model){
        return"/addProv";
    }
    @RequestMapping("/addProv")
    public String GuardarSede(@RequestParam String nombre,@RequestParam String apellido,@RequestParam int telefono,@RequestParam int dni,Model model){
        Proveedor prov = new Proveedor();
        prov.setNombre(nombre);
        prov.setApellido(apellido);
        prov.setTelefono(telefono);
        prov.setDni(dni);
        proveedorRepository.insert(prov);
        return"redirect:/provs";
    }
    @RequestMapping("/delProv/{id}")
    public String deleteSede(@PathVariable(value="id") int id) {
        proveedorRepository.deleteById(id);
        return "redirect:/provs";
    }
    
    @RequestMapping("/editProv/{id}")
    public String editSede(@PathVariable(value="id") int id, Model model) {
        model.addAttribute("provs", proveedorRepository.readProvedor(id));
        return "/editProv";
    }
    
     @RequestMapping("/updateProv")
    public String updateSede(@RequestParam int id,@RequestParam String nombre,@RequestParam String apellido,@RequestParam int telefono,@RequestParam int dni) {
        Proveedor prov= proveedorRepository.readProvedor(id);
        prov.setNombre(nombre);
        prov.setApellido(apellido);
        prov.setTelefono(telefono);
        prov.setDni(dni);
        proveedorRepository.update(prov);
        return "redirect:/provs";
    }
}
