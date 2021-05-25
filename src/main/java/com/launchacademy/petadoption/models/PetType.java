package com.launchacademy.petadoption.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "pet_types")
@Getter
@Setter
@NoArgsConstructor
public class PetType {

  @Id
  @SequenceGenerator(name = "pet_type_generator", sequenceName = "pet_types_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_type_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;

  @NotBlank
  @Column(name = "type", nullable = false)
  private String type;

  @Column(name = "description")
  private String description;

  @NotBlank
  @URL
  @Column(name = "img_url", nullable = false)
  private String imgUrl;

  @OneToMany(mappedBy = "petType", cascade = CascadeType.ALL)
  @JsonIgnoreProperties("petType")
  private List<AdoptablePet> adoptablePets;

  public PetType(String type) {
    this.type = type;
  }

  public PetType(String type, String description, String imgUrl) {
    this.type = type;
    this.description = description;
    this.imgUrl = imgUrl;
  }
}
