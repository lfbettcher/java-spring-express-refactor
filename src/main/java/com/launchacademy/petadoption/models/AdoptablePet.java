package com.launchacademy.petadoption.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "adoptable_pets")
@Getter
@Setter
@NoArgsConstructor
public class AdoptablePet {

  @Id
  @SequenceGenerator(name = "adoptable_pet_generator", sequenceName = "adoptable_pets_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adoptable_pet_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;

  @NotBlank
  @Column(name = "name", nullable = false)
  private String name;

  @NotBlank
  @URL
  @Column(name = "img_url", nullable = false)
  private String imgUrl;

  @Column(name = "age")
  private Integer age;

  @Column(name = "vaccination_status")
  private Boolean vaccinationStatus;

  @NotBlank
  @Column(name = "adoption_story", nullable = false)
  private String adoptionStory;

  @NotBlank
  @Column(name = "adoption_status", nullable = false)
  private String adoptionStatus;

  @ManyToOne
  @JoinColumn(name = "type_id")
  @JsonIgnoreProperties("adoptablePets")
  private PetType petType;
}