package com.tddtoday.tddtoday.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "collectionsOfAbcdTest", schema = "public")
public class CollectionOfAbcdTestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String collectionName;

   private  int countCorrectAnswers;

   private int countAllAnswers;

   private int score;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "abcdTests")
    private Set<AbcdTestEntity> abcdTests;


    public Set<AbcdTestEntity> getAbcdTestEntity() {
        return abcdTests;
    }

    public void setAbcdTestEntity(final Set<AbcdTestEntity> abcdTests) {
        this.abcdTests = abcdTests;
    }

}
