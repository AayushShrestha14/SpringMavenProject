/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aayush.web.util;

import java.util.List;

/**
 *
 * @author dell
 */
public class ResponseEntity<T> {
    List<T> data;
    
    public ResponseEntity(List<T> data){
        this.data=data;
    }
    
    public List<T> getData(){
        return data;
    }
}
