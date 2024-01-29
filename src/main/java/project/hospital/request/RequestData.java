package project.hospital.request;

import project.hospital.token.Token;

public class RequestData {

    private String apiName;

    private Token token;

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
