package cn.fr13nds.pojo;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author: buckler
 * @Date: 2022/6/19 12:41
 * @Describe:
 */
@Data
@Document("User")
public class User {
    @Id
    private ObjectId id;
    private String username;
    private String password;
}
