package project.hospital.model.schedule;

public enum WorkingTime {
    Morning("Sáng"),
    Afternoon("Chiều"),
    FullDay("Cả ngày"),
    NightShift("Trực đêm");

    private String description;

    WorkingTime(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
