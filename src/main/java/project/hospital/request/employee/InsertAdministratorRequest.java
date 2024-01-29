package project.hospital.request.employee;

import project.hospital.model.employee.Administrator;
import project.hospital.request.RequestData;

public class InsertAdministratorRequest extends RequestData {

    private Administrator administrator;

    public InsertAdministratorRequest(Administrator administrator) {
        this.administrator = administrator;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }
}
