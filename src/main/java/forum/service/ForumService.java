/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

import forum.dao.ForumDAO;
import forum.entity.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kk
 */
@Service
public class ForumService {
    
    @Autowired
    private ForumDAO forumDAO;

    public <S extends Forum> S save(S s) {
        return forumDAO.save(s);
    }

    public Forum findOne(Long id) {
        return forumDAO.findOne(id);
    }

    public Iterable<Forum> findAll() {
        return forumDAO.findAll();
    }

    public void delete(Long id) {
        forumDAO.delete(id);
    }

    public void deleteAll() {
        forumDAO.deleteAll();
    }
    
    
}
