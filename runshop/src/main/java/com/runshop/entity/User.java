package com.runshop.entity;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder

public class User {
    private Long id;
    private String name;
    private String surname;
    private Timestamp dateBirth;
    private Double weight;
    private Double height;

    @Override
    public String toString() {
       return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
