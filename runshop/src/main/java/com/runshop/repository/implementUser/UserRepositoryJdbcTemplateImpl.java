package com.runshop.repository.implementUser;


//public class UserRepositoryJdbcTemplateImpl implements UserRepository {
//
//    private final JdbcTemplate jdbcTemplate;
//
////    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//
//    private final UserRowMapper userRowMapper;
//
//    @Override
//    public Optional<User> findOne(User object) {
//        return Optional.empty();
//    }
//
//    @Override
//    public User findById(Long id) {
//        return jdbcTemplate.queryForObject("select * from users where id = " + id, userRowMapper);
//    }
//
//    @Override
//    public List<User> findAll() {
//        return jdbcTemplate.query("select * from users order by id desc", userRowMapper); //сразу сортируем
//    }
//
//    @Override
//    public User create(User object) {
//
//        final String createUserQuery =
//                "INSERT INTO user (name, surname, date_birth, weight, height)";
//        final String findById = "select * from users where id = ";
//        return null;
//    }
//
//    @Override
//    public Object create(Item item) {
//        return null;
//    }
//
//    @Override
//    public User update(User object) {
//        return null;
//    }
//
//    @Override
//    public User delete(Long id) throws EntityNotFoundException {
//        return null;
//    }
//
//    @Override
//    public List<User> searchUserByWeight(Double weight) {
//        return null;
//    }
//
//    @Override
//    public List<User> searchUserByHeight(Double height) {
//        return null;
//    }
//
//    @Override
//    public List<User> getAverageHeight(Double height) {
//        return null;
//    }
//
//    @Override
//    public List<User> getAverageWeight(Double weight) {
//        return null;
//    }
//}
