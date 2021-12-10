/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.AlmacenconSecurity.controller;

import com.example.AlmacenconSecurity.entity.AlmacenSede;
import com.example.AlmacenconSecurity.repository.AlmacenSedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SedeController {
    @Autowired
    private AlmacenSedeRepository almacenSedeRepository;
    
    @RequestMapping("/sedes")
    public String Sedes(Model model){
        model.addAttribute("sedes",almacenSedeRepository.findAll());
        return"/sede";
    }
    @RequestMapping("/createSedes")
    public String createSedes(Model model){
        return"/addSede";
    }
    @RequestMapping("/addSede")
    public String GuardarSede(@RequestParam String distrito,@RequestParam String direccion,Model model){
        AlmacenSede sed = new AlmacenSede();
        sed.setDistrito(distrito);
        sed.setDireccion(direccion);
        almacenSedeRepository.insert(sed);
        return"redirect:/sedes";
    }
    @RequestMapping("/delSede/{id}")
    public String deleteSede(@PathVariable(value="id") int id) {
        almacenSedeRepository.deleteById(id);
        return "redirect:/sedes";
    }
    
    @RequestMapping("/editSede/{id}")
    public String editSede(@PathVariable(value="id") int id, Model model) {
        model.addAttribute("sedes", almacenSedeRepository.readSede(id));
        return "/editSede";
    }
    
     @RequestMapping("/updateSede")
    public String updateSede(@RequestParam int id,@RequestParam String distrito,@RequestParam String direccion) {
        AlmacenSede sed= almacenSedeRepository.readSede(id);
        sed.setDistrito(distrito);
        sed.setDireccion(direccion);
        almacenSedeRepository.update(sed);
        return "redirect:/sedes";
    }
}
