package project.hospital.api;

import project.hospital.constant.ApiName;
import project.hospital.constant.StatusCode;
import project.hospital.exception.BusinessException;
import project.hospital.request.RequestData;
import project.hospital.response.ResponseData;
import project.hospital.service.SessionService;
import project.hospital.token.Token;

import static project.hospital.constant.ApiName.UNTHENTICATE_API;

public abstract class Api<T extends RequestData, V extends ResponseData> {

    private final SessionService sessionService;

    public Api(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    public void doExecute(T requestData) throws Exception {
        String apiNameString = requestData.getApiName();
        ApiName apiName = ApiName.resolve(apiNameString);
        if(!UNTHENTICATE_API.contains(apiName)) {
            Token token = requestData.getToken();
            if(!sessionService.isValid(token)) {
                throw new BusinessException(StatusCode.INVALID.getCode(), "Error in token authentication.");
            }
            sessionService.updateRecentActivity(token);
        }
    }

    public abstract V execute(T requestData);
}
