package repository;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class UserRepository implements IUserRepository {
    public static final String SELECT = "SELECT * FROM users";
    public static final String INSERT = "INSERT INTO users(name,email,country)" +"VALUES(?,?,?)";
    public static final String SEARCH_BY_COUNTRY = "SELECT name,email,country FROM users WHERE country LIKE ?";


    @Override
    public List<User> displayAll() {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                userList.add(new User(id,name,email,country));
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void create(User user) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getByID(int id) {

        return null;
    }

    @Override
    public void edit(int id, User user) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<User> getByCountry(String country) {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_COUNTRY);
            ResultSet resultSet = preparedStatement.executeQuery();
            String nation = "%" + country.trim() + "%";
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                userList.add(new User(id,name,email,nation));
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
