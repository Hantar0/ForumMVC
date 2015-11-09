/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

import forum.dao.EmailDAO;
import forum.entity.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ETY
 */
@Service
public class EmailService {
    @Autowired
    private EmailDAO emailDAO;

    @Transactional
    public <S extends Email> S save(S s) {
        return emailDAO.save(s);
    }

    public Email findOne(Long id) {
        return emailDAO.findOne(id);
    }

    public Iterable<Email> findAll() {
        return emailDAO.findAll();
    }

    @Transactional
    public void delete(Long id) {
        emailDAO.delete(id);
    }

    @Transactional
    public void delete(Email t) {
        emailDAO.delete(t);
    }

    @Transactional
    public void deleteAll() {
        emailDAO.deleteAll();
    }
}
