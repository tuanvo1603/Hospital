package project.hospital.model.treatment.medication;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "medication_warehouse")
public class Medication {

    @Id
    @Column(name = "medication_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medication_sequence_generator")
    @SequenceGenerator(name = "medication_sequence_generator", sequenceName = "medication_sequence", allocationSize = 1)
    private Long medicationId;

    @Column(name = "medication_name")
    private String medicationName;

    @Column(name = "alter_name")
    private String alterName;

    @Column(name = "medication_description")
    private String medicationDescription;

    @Column(name = "remaining")
    private Integer remaining;

    @Column(name = "unit_price")
    private Integer unitPrice;

    @Column(name = "html_link")
    private String htmlLink;

    public Long getMedicationId() {
        return medicationId;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public String getAlterName() {
        return alterName;
    }

    public String getMedicationDescription() {
        return medicationDescription;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public String getHtmlLink() {
        return htmlLink;
    }

    public void setMedicationId(Long medicationId) {
        this.medicationId = medicationId;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public void setAlterName(String alterName) {
        this.alterName = alterName;
    }

    public void setMedicationDescription(String medicationDescription) {
        this.medicationDescription = medicationDescription;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setHtmlLink(String htmlLink) {
        this.htmlLink = htmlLink;
    }
}
