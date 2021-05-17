//package org.example.dao.mapper;
//
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class RatingMapper implements RowMapper<Rating> {
//    @Override
//    public Rating mapRow(ResultSet resultSet, int i) throws SQLException {
//        Rating rating = new Rating();
//        rating.setId(resultSet.getInt(1));
//        rating.setScore(resultSet.getInt(2));
//        rating.setStudent_id(resultSet.getInt(3));
//        rating.setSubject_id(resultSet.getInt(4));
//        return rating;
//    }
//}
//
//
