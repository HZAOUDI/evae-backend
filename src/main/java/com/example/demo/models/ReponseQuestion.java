package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "REPONSE_QUESTION")
public class ReponseQuestion {
    @SequenceGenerator(name = "REPONSE_QUESTION_id_gen", sequenceName = "AUT_SEQ", allocationSize = 1)
    @EmbeddedId
    private ReponseQuestionId id;

    @MapsId("idReponseEvaluation")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_REPONSE_EVALUATION", nullable = false)
    private ReponseEvaluation idReponseEvaluation;

    @MapsId("idQuestionEvaluation")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_QUESTION_EVALUATION", nullable = false)
    private QuestionEvaluation idQuestionEvaluation;

    @Column(name = "POSITIONNEMENT")
    private Long positionnement;

}