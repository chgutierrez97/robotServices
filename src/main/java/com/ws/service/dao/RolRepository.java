/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.service.dao;

import com.ws.service.dto.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Roles, Integer> {
    
}
