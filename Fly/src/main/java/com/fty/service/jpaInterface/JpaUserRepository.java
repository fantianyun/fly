//package com.fty.service.jpaInterface;
//
//import com.fty.entity.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//@Repository
//public interface JpaUserRepository extends CrudRepository<User,Long> {
////    @Query( "from user where  like concat('%',?1, '%') ")
////    public List<User> findUsers(String userName);
//
//    /**
//     *
//     * @param userName
//     * @return
//     */
////    public List<User> findByUserName(String  userName);
////    public User getUserByNote(String  userName);
//
////    @Query("select u from User u where u.userName like %?1")
////    List<User> findByUserNameEndsWith(String userName);
//}
