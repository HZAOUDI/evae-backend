package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "QUESTION_EVALUATION")
public class QuestionEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QUESTION_EVALUATION_id_gen")
    @SequenceGenerator(name = "QUESTION_EVALUATION_id_gen", sequenceName = "QEV_SEQ", allocationSize = 1)
    @Column(name = "ID_QUESTION_EVALUATION", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_RUBRIQUE_EVALUATION", nullable = false)
    private RubriqueEvaluation idRubriqueEvaluation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_QUESTION")
    private Question idQuestion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_QUALIFICATIF")
    private Qualificatif idQualificatif;

    @Column(name = "ORDRE", nullable = false)
    private Short ordre;

    @Column(name = "INTITULE", length = 64)
    private String intitule;

    @OneToMany(mappedBy = "idQuestionEvaluation")
    private Set<ReponseQuestion> reponseQuestions = new LinkedHashSet<>();

}