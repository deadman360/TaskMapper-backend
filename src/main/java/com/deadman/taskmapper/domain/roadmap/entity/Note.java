package com.deadman.taskmapper.domain.roadmap.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String Content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Task CurrentTask;

    @ManyToOne(fetch = FetchType.LAZY)
    private Task CreatedByTask;

}
