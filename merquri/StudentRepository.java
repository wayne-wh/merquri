package merquri;

import java.util.ArrayList;

@Repository
public class StudentRepository {

    @Autowired
    private JdbcTemplate template;

    @PostConstruct
    public void createTable() {
        template.execute("CREATE TABLE IF NOT EXISTS student (id BIGINT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50), gender VARCHAR(1))");
    }

    public void createStudent(String name, String gender) {
        template.update("INSERT INTO student (id, name, gender) VALUES (NULL, ?, ?)", name, gender);
    }

    public List<Student> findStudentByName(String nameStartsWith) {
        String sql = "SELECT name, gender FROM student WHERE name LIKE ?";

        return template.query(sql, new Object[]{nameStartsWith + "%"}, (rs, rowNum) ->
                new Student(
                        rs.getString("name"),
                        rs.getString("gender")
                )
        );
    }
}