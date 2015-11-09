/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.dao;

import forum.entity.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ETY
 */
public interface MessageDAO extends CrudRepository<Message, Long>{
    
}
