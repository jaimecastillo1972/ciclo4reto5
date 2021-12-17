package com.usa.divinacomedia.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

/**
 * @author Jaime Alonso Castillo Marin
 */

@Data //para generar los getters and setters
@NoArgsConstructor //paraa generar constructor vacio
@AllArgsConstructor //para generar constructor con todos sus parametros
@Document(collection = "usuario")
public class User {
    @Id
    private Integer id;
    private String identification;
    private String name;
    private Date birthtDay;
    private String monthBirthtDay;
    private String address;
    private String cellPhone;
    private String email;
    private String password;
    private String zone;
    private String type;
}
