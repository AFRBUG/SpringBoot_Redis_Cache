package redis.test.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Invoice implements Serializable {
    private static final long serialVersionUID = -4439114469417994311L;
    @Id
    @GeneratedValue
    private Integer invId ;
    private String  invName;
    private Double  invAmount;
}
