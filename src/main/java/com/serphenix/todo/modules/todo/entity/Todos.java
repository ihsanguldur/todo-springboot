package com.serphenix.todo.modules.todo.entity;

import com.serphenix.todo.modules.user.entity.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Todos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TODOS_ID_SEQ")
    @SequenceGenerator(name = "TODOS_ID_SEQ", sequenceName = "TODOS_ID_SEQ", allocationSize = 1)
    private int id;

    private String content;

    private boolean status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;
}
