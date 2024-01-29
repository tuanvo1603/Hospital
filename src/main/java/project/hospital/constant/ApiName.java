package project.hospital.constant;

import java.util.Arrays;
import java.util.List;

public enum ApiName {

    ADMIT_OUTPATIENT("admit-outpatient"),
    ADMIT_INPATIENT("admit-inpatient"),
    SHOW_PATIENT_INFO("show-patient-info"),
    SHOW_HOSPITAL_FEE("show-hospital-fee"),
    LOGIN_API("login"),
    SIGNUP_API("signup");

    public static final List<ApiName> UNTHENTICATE_API = Arrays.asList(LOGIN_API, SIGNUP_API);

    public final String name;

    ApiName(String name) {
        this.name = name;
    }

    public static ApiName resolve(String apiNameString) {
        for(ApiName apiName: values()) {
            if(apiNameString.equals(apiName.name)) {
                return apiName;
            }
        }
        return null;
    }
}
