package org.zerock.datie_boot.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zerock.datie_boot.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.id = :id")
    Optional<User> findByUserId(@Param("id") String id); // id를 가지고 db에서 회원 조회하기위한 메서드

    @Query("SELECT u FROM User u WHERE u.id = :id AND u.pw = :password")
    Optional<User> findByIdAndPassword(@Param("id") String id, @Param("password") String password); // id와 password로 회원 조회


    Optional<User> findByUserno(int userno);



    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.cardno = :newCardno WHERE u.userno = :userno")
    void updateCardnoByUserno(@Param("newCardno") int newCardno, @Param("userno") int userno);

    boolean existsById(String id);

//    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM AccountTran a WHERE SUBSTRING(a.name, LENGTH(a.name) - 3, 4) = ?1 AND a.amount = 1")
//    boolean existsByLastFourDigits(String lastFourDigits);

//    boolean existsByAccountno(String accountno);

//    @Query("SELECT u FROM User u WHERE u.idnumber = :idnumber")
//    Optional<User> findByIdNumber(@Param("idnumber") String idnumber);

// id와 password로 회원 조회



}
