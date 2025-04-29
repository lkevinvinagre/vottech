package com.api.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "facer", uniqueConstraints = 
        {
            @UniqueConstraint(columnNames = "face_id"),
            @UniqueConstraint(columnNames = "user_id")
        }
    )
public class Facer 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "face_data", columnDefinition = "TEXT")
    private String faceData;

    @Column(name = "image_path", length = 500)
    private String imagePath;

    @Column(name = "face_id", length = 255, unique = true)
    private String faceId;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id",unique = true)
    private User user;

    public Facer()
    {

    }
}
