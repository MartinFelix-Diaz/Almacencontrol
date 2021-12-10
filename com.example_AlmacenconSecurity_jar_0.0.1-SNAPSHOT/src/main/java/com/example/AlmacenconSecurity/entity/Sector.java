/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.AlmacenconSecurity.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Martin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sector implements Serializable{
    private int idsector;
    private String nomSec;
}
